package nl.kolkos.crypto.telegram.bot.backend.service;

import lombok.RequiredArgsConstructor;
import nl.kolkos.crypto.telegram.bot.backend.entities.Portfolio;
import nl.kolkos.crypto.telegram.bot.backend.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;

    public Portfolio requestNewPortfolio(String name) {
        String token = UUID.randomUUID().toString();

        Portfolio portfolio = Portfolio.builder()
                .name(name)
                .token(token)
                .build();

        return portfolioRepository.save(portfolio);
    }


}
