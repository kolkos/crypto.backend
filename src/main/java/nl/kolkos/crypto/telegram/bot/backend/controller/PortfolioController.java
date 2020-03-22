package nl.kolkos.crypto.telegram.bot.backend.controller;

import lombok.RequiredArgsConstructor;
import nl.kolkos.crypto.telegram.bot.backend.entities.Portfolio;
import nl.kolkos.crypto.telegram.bot.backend.service.InterceptedPortfolioService;
import nl.kolkos.crypto.telegram.bot.backend.service.PortfolioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/portfolios")
public class PortfolioController {
    private final PortfolioService portfolioService;
    private final InterceptedPortfolioService interceptedPortfolioService;

    @GetMapping("/register")
    public Portfolio requestNew(String name) {
        return portfolioService.requestNewPortfolio(name);
    }

    @GetMapping("/check")
    public Portfolio getPortfolio() {
        return interceptedPortfolioService.getPortfolio();
    }

}
