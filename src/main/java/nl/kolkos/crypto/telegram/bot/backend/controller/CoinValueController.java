package nl.kolkos.crypto.telegram.bot.backend.controller;

import lombok.RequiredArgsConstructor;
import nl.kolkos.crypto.telegram.bot.backend.entities.CoinValue;
import nl.kolkos.crypto.telegram.bot.backend.service.CoinValueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/coinvalues")
@RequiredArgsConstructor
public class CoinValueController {
    private final CoinValueService coinValueService;

    @GetMapping("/list/all")
    public List<CoinValue> getCoinValues() {
        return coinValueService.listCoinValues();
    }



}
