package nl.kolkos.crypto.telegram.bot.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.crypto.telegram.bot.backend.entities.Coin;
import nl.kolkos.crypto.telegram.bot.backend.repository.CoinRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class CoinService {
    private final CoinRepository coinRepository;

    public List<Coin> listAll() {
        log.info("Generating coin list");
        return coinRepository.findAll();
    }

    public Coin save(Coin coin) {
        log.info("Saving coin: {}", coin);
        return coinRepository.save(coin);
    }

}
