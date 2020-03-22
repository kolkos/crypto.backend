package nl.kolkos.crypto.telegram.bot.backend.repository;

import nl.kolkos.crypto.telegram.bot.backend.entities.Portfolio;
import nl.kolkos.crypto.telegram.bot.backend.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    List<Wallet> findByPortfolio(Portfolio portfolio);
    Optional<Wallet> findByPortfolioAndAddress(Portfolio portfolio, String address);
    Optional<Wallet> findByPortfolioAndName(Portfolio portfolio, String name);

}
