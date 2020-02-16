package nl.kolkos.crypto.telegram.bot.backend.controller;

import lombok.RequiredArgsConstructor;
import nl.kolkos.crypto.telegram.bot.backend.entities.Coin;
import nl.kolkos.crypto.telegram.bot.backend.service.CoinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coins")
@RequiredArgsConstructor
public class CoinController {

    private final CoinService coinService;

    @GetMapping("/create")
    public Coin createCoin(@RequestParam String symbol, @RequestParam String name) {
        Coin coin = Coin.builder()
                .name(name)
                .symbol(symbol)
                .build();
        return coinService.save(coin);
    }

    @GetMapping("/get/{symbol}")
    public Coin getCoinBySymbol(@PathVariable String symbol) {
        return coinService.findBySymbol(symbol);
    }

    @GetMapping("/list")
    public List<Coin> listCoins() {
        return coinService.listAll();
    }




}
