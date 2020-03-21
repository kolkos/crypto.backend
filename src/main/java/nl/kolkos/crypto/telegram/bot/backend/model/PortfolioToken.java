package nl.kolkos.crypto.telegram.bot.backend.model;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Data
@Log4j2
public class PortfolioToken {
    private String token;
}
