package nl.kolkos.crypto.telegram.bot.backend.command;

import nl.kolkos.crypto.telegram.bot.backend.configuration.ApplicationSettings;
import nl.kolkos.crypto.telegram.bot.backend.entities.Coin;

public class GetCoinValueCommand implements Command {

    private ApplicationSettings applicationSettings;

    private Coin coin;

    public GetCoinValueCommand(Coin coin, ApplicationSettings applicationSettings) {
        this.coin = coin;
        this.applicationSettings = applicationSettings;
    }


    @Override
    public String execute() {
        return applicationSettings.getUrlTemplateCoinValueApi()
                .replaceAll("\\{\\{coin.symbol\\}\\}", coin.getSymbol())
                .replaceAll("\\{\\{app.currency\\}\\}", applicationSettings.getCurrency());
    }
}
