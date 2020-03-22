package nl.kolkos.crypto.telegram.bot.backend.service;

import lombok.RequiredArgsConstructor;
import nl.kolkos.crypto.telegram.bot.backend.entities.Coin;
import nl.kolkos.crypto.telegram.bot.backend.entities.Portfolio;
import nl.kolkos.crypto.telegram.bot.backend.entities.Wallet;
import nl.kolkos.crypto.telegram.bot.backend.repository.WalletRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;
    private final InterceptedPortfolioService interceptedPortfolioService;
    private final CoinService coinService;

    public Wallet registerNewWallet(String coinSymbol, String address, String name, String description) {
        Coin coin = coinService.findBySymbol(coinSymbol);
        Portfolio portfolio = interceptedPortfolioService.getPortfolio();

        Wallet wallet = Wallet.builder()
                .address(address)
                .coin(coin)
                .portfolio(portfolio)
                .name(name)
                .description(description)
                .build();

        return walletRepository.save(wallet);
    }


    public List<Wallet> getMyWallets() {
        Portfolio portfolio = interceptedPortfolioService.getPortfolio();
        return this.findWalletsByPortfolio(portfolio);
    }

    public Wallet findByAddress(String address) {
        Portfolio portfolio = interceptedPortfolioService.getPortfolio();
        return this.findWalletByPortfolioAndAddress(portfolio, address);
    }

    public Wallet findByName(String name) {
        Portfolio portfolio = interceptedPortfolioService.getPortfolio();
        return this.findWalletByPortfolioAndName(portfolio, name);
    }


    private List<Wallet> findWalletsByPortfolio(Portfolio portfolio) {
        return walletRepository.findByPortfolio(portfolio);
    }

    private Wallet findWalletByPortfolioAndAddress(Portfolio portfolio, String address) {
        return walletRepository
                .findByPortfolioAndAddress(portfolio, address)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("There is no wallet with the address '%s' in portfolio '%s'",
                                address,
                                portfolio.getName()
                        )
                ));
    }

    private Wallet findWalletByPortfolioAndName(Portfolio portfolio, String name) {
        return walletRepository
                .findByPortfolioAndName(portfolio, name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        String.format("There is no wallet with the name '%s' in portfolio '%s'",
                                name,
                                portfolio.getName()
                        )
                ));
    }


}
