package nl.kolkos.crypto.telegram.bot.backend.command;

import nl.kolkos.crypto.telegram.bot.backend.configuration.ApplicationSettings;
import nl.kolkos.crypto.telegram.bot.backend.entities.Wallet;
import org.springframework.beans.factory.annotation.Autowired;

public class GetWalletValueCommand implements Command {
    @Autowired
    private ApplicationSettings applicationSettings;

    private Wallet wallet;

    public GetWalletValueCommand(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String execute() {
        return applicationSettings.getUrlTemplateWalletValueApi()
                .replaceAll("\\{\\{coin.symbol\\}\\}", wallet.getCoin().getSymbol())
                .replaceAll("\\{\\{wallet.address\\}\\}", wallet.getAddress());
    }
}
