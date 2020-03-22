package nl.kolkos.crypto.telegram.bot.backend.controller;

import lombok.RequiredArgsConstructor;
import nl.kolkos.crypto.telegram.bot.backend.entities.Wallet;
import nl.kolkos.crypto.telegram.bot.backend.service.WalletService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wallets")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @GetMapping("/getmywallets")
    public List<Wallet> getMyWallets() {
        return walletService.getMyWallets();
    }

    @GetMapping("/register")
    public Wallet registerNewWallet(@RequestParam String coinSymbol,
                                    @RequestParam String address,
                                    @RequestParam String name,
                                    @RequestParam String description) {
        return walletService.registerNewWallet(coinSymbol, address, name, description);
    }

}
