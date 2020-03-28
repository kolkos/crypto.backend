package nl.kolkos.crypto.telegram.bot.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@ToString
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coin_id")
    private Coin coin;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    @JsonBackReference
    private Portfolio portfolio;

    @NonNull
    private String address;

    @NonNull
    private String name;

    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "wallet")
    private Set<Transaction> transactions;


}
