package nl.kolkos.crypto.telegram.bot.backend.repository;

import nl.kolkos.crypto.telegram.bot.backend.entities.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoinRepository extends JpaRepository<Coin, Long> {

    Optional<Coin> findBySymbol(String symbol);

}
