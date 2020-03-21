package nl.kolkos.crypto.telegram.bot.backend.repository;

import nl.kolkos.crypto.telegram.bot.backend.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    Optional<Portfolio> findByToken(String token);
}
