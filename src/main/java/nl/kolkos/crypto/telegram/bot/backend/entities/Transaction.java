package nl.kolkos.crypto.telegram.bot.backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
@ToString
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime transactionDate;

    @NonNull
    @Enumerated(EnumType.ORDINAL)
    private TransactionType transactionType;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    @JsonBackReference
    private Wallet wallet;

    @NonNull
    private double amount;

    @NonNull
    private double valueOnTransactionDate;

    @Transient
    private double valueRightNow;


}
