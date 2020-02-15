package nl.kolkos.crypto.telegram.bot.backend.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class ApplicationSettings {
    @Value("${apis.coin-value-api}")
    private String urlTemplateCoinValueApi;

    // https://www.bitstamp.net/api/v2/ticker/{{coin.symbol}}{{app.currency}}/
    @Value("${apis.wallet-value-api}")
    private String urlTemplateWalletValueApi;

    @Value("${app.currency}")
    private String currency;


}
