package nl.kolkos.crypto.telegram.bot.backend.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletResult {

    @SerializedName(value = "address")
    private String address;
    @SerializedName(value = "balance")
    private long balance;
    @SerializedName(value = "final_balance")
    private long finalBalance;

}
