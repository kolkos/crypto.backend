package nl.kolkos.crypto.telegram.bot.backend.service;

import lombok.RequiredArgsConstructor;
import nl.kolkos.crypto.telegram.bot.backend.entities.Coin;
import nl.kolkos.crypto.telegram.bot.backend.entities.Portfolio;
import nl.kolkos.crypto.telegram.bot.backend.entities.Wallet;
import nl.kolkos.crypto.telegram.bot.backend.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRepository;
    private final PortfolioService portfolioService;
    private final CoinService coinService;

    public Wallet registerNewWallet(String coinSymbol, String address, String description) {
        Coin coin = coinService.findBySymbol(coinSymbol);
        Portfolio portfolio = portfolioService.getPortfolioWithToken();

        Wallet wallet = Wallet.builder()
                .address(address)
                .coin(coin)
                .portfolio(portfolio)
                .description(description)
                .build();

        return walletRepository.save(wallet);
    }


    public List<Wallet> getMyWallets() {
        Portfolio portfolio = portfolioService.getPortfolioWithToken();
        return walletRepository.findByPortfolio(portfolio);
    }


}
