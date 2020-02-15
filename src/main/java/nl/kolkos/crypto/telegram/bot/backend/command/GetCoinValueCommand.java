package nl.kolkos.crypto.telegram.bot.backend.command;

import nl.kolkos.crypto.telegram.bot.backend.configuration.ApplicationSettings;
import nl.kolkos.crypto.telegram.bot.backend.entities.Coin;
import org.springframework.beans.factory.annotation.Autowired;

public class GetCoinValueCommand implements Command {

    @Autowired
    private ApplicationSettings applicationSettings;

    private Coin coin;

    public GetCoinValueCommand(Coin coin) {
        this.coin = coin;
    }


    @Override
    public String execute() {
        return applicationSettings.getUrlTemplateCoinValueApi()
                .replaceAll("\\{\\{coin.symbol\\}\\}", coin.getSymbol())
                .replaceAll("\\{\\{app.currency\\}\\}", applicationSettings.getCurrency());
    }
}
