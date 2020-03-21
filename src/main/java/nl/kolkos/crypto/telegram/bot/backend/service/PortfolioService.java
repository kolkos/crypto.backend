package nl.kolkos.crypto.telegram.bot.backend.service;

import lombok.RequiredArgsConstructor;
import nl.kolkos.crypto.telegram.bot.backend.entities.Portfolio;
import nl.kolkos.crypto.telegram.bot.backend.model.PortfolioToken;
import nl.kolkos.crypto.telegram.bot.backend.repository.PortfolioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final PortfolioToken portfolioToken;

    public Portfolio requestNewPortfolio(String name) {
        String token = UUID.randomUUID().toString();

        Portfolio portfolio = Portfolio.builder()
                .name(name)
                .token(token)
                .build();

        return portfolioRepository.save(portfolio);
    }

    public Portfolio getPortfolioWithToken() {
        return portfolioRepository.findByToken(portfolioToken.getToken())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("Cannot find portfolio with token '%s'", portfolioToken.getToken())));
    }


}
