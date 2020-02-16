package nl.kolkos.crypto.telegram.bot.backend.service;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.crypto.telegram.bot.backend.command.CommandRunner;
import nl.kolkos.crypto.telegram.bot.backend.command.GetCoinValueCommand;
import nl.kolkos.crypto.telegram.bot.backend.configuration.ApplicationSettings;
import nl.kolkos.crypto.telegram.bot.backend.entities.Coin;
import nl.kolkos.crypto.telegram.bot.backend.entities.CoinValue;
import nl.kolkos.crypto.telegram.bot.backend.model.CoinValueResult;
import nl.kolkos.crypto.telegram.bot.backend.repository.CoinValueRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Log4j2
public class CoinValueService {
    private final CommandRunner commandRunner;
    private final CoinValueRepository coinValueRepository;
    private final ApplicationSettings applicationSettings;


    public CoinValue getCoinValueForCoin(Coin coin) {
        GetCoinValueCommand getCoinValueCommand = createCoinValueCommand(coin);

        String response = runCommand(getCoinValueCommand);

        CoinValueResult coinValueResult = createCoinValueResultFromString(response);

        CoinValue coinValueFromResponse = createCoinValueFromResponse(coinValueResult);
        return save(coinValueFromResponse);
    }

    public CoinValue save(CoinValue coinValue) {
        return coinValueRepository.save(coinValue);
    }

    private GetCoinValueCommand createCoinValueCommand(Coin coin) {
        // create command
        return new GetCoinValueCommand(coin, applicationSettings);
    }

    private CoinValueResult createCoinValueResultFromString(String response) {
        log.info("Transforming response:\n{}", response);

        Gson gson = new Gson();
        return gson.fromJson(response, CoinValueResult.class);
    }

    private String runCommand(GetCoinValueCommand getCoinValueCommand) {
        // run command
        commandRunner.setCommand(getCoinValueCommand);
        return commandRunner.run();
    }

    private CoinValue createCoinValueFromResponse(CoinValueResult coinValueResult) {
        return CoinValue.builder()
                .requestDate(new Date())
                .high(coinValueResult.getHigh())
                .low(coinValueResult.getLow())
                .last(coinValueResult.getLast())
                .build();
    }


}
