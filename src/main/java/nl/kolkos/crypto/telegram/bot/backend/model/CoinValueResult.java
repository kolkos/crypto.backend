package nl.kolkos.crypto.telegram.bot.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoinValueResult {
    private double last;
    private double high;
    private double low;
}
