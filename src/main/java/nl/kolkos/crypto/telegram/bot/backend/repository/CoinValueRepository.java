package nl.kolkos.crypto.telegram.bot.backend.repository;

import nl.kolkos.crypto.telegram.bot.backend.entities.CoinValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoinValueRepository extends JpaRepository<CoinValue, Long> {

    List<CoinValue> findTop25ByOrderByRequestDateDesc();

}
