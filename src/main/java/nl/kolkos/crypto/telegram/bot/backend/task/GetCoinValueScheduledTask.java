package nl.kolkos.crypto.telegram.bot.backend.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.crypto.telegram.bot.backend.service.CoinService;
import nl.kolkos.crypto.telegram.bot.backend.service.CoinValueService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class GetCoinValueScheduledTask {

    private final CoinService coinService;
    private final CoinValueService coinValueService;

    @Scheduled(fixedRate = 600000)
    public void getCoinValues() {
        log.info("getting coin value");
        coinService.listAll()
                .forEach(coinValueService::getCoinValueForCoin);
    }


}
