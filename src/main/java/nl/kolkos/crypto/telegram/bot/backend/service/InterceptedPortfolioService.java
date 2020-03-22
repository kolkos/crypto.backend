package nl.kolkos.crypto.telegram.bot.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.crypto.telegram.bot.backend.entities.Portfolio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@Log4j2
@RequiredArgsConstructor
public class InterceptedPortfolioService {
    private final PortfolioService portfolioService;

    @Setter
    private String token;

    private Portfolio portfolio;

    public Portfolio getPortfolio() {
        if (portfolio == null) {
            this.portfolio = portfolioService.getPortfolioWithToken(this.getToken());
        }
        return this.portfolio;
    }

    public String getToken() {
        if (token == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "TOKEN not set in request header");
        }
        return this.token;
    }

}
