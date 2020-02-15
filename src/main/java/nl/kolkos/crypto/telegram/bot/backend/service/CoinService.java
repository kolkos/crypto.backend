package nl.kolkos.crypto.telegram.bot.backend.service;

import lombok.RequiredArgsConstructor;
import nl.kolkos.crypto.telegram.bot.backend.entities.Coin;
import nl.kolkos.crypto.telegram.bot.backend.repository.CoinRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoinService {
    private final CoinRepository coinRepository;

    public List<Coin> listAll() {
        return coinRepository.findAll();
    }

}
