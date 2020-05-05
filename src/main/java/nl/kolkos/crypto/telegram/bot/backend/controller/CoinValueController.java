package nl.kolkos.crypto.telegram.bot.backend.controller;

import lombok.RequiredArgsConstructor;
import nl.kolkos.crypto.telegram.bot.backend.entities.Coin;
import nl.kolkos.crypto.telegram.bot.backend.entities.CoinValue;
import nl.kolkos.crypto.telegram.bot.backend.service.CoinService;
import nl.kolkos.crypto.telegram.bot.backend.service.CoinValueService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@RestController
@RequestMapping("/coinvalues")
@RequiredArgsConstructor
public class CoinValueController {
    private final CoinValueService coinValueService;
    private final CoinService coinService;

    @GetMapping("/list/last25")
    public List<CoinValue> getCoinValues() {
        return coinValueService.listCoinValues();
    }


    @GetMapping("/get/{symbol}")
    public List<CoinValue> getValuesBySymbol(@PathVariable String symbol) {
        Coin coin = coinService.findBySymbol(symbol);
        return coinValueService.findAllByCoin(coin);
    }

    @GetMapping("/request/{symbol}")
    public CoinValue requestNewCoinValueForCoin(@PathVariable String symbol) {
        Coin coin = coinService.findBySymbol(symbol);
        return coinValueService.getCoinValueForCoin(coin);
    }

    @GetMapping("/register")
    public CoinValue register(@RequestParam String symbol,
                              @RequestParam double high,
                              @RequestParam double low,
                              @RequestParam double last,
                              @RequestParam @DateTimeFormat(iso = DATE_TIME) Date date) {
        Coin coin = coinService.findBySymbol(symbol);
        CoinValue coinValue = CoinValue.builder()
                .coin(coin)
                .high(high)
                .low(low)
                .last(last)
                .requestDate(date)
                .build();

        return coinValueService.save(coinValue);
    }

    @GetMapping("/update")
    public List<CoinValue> getLatestValues() {
        return coinValueService.getLatestCoinValuesForAllCoins();
    }


}
