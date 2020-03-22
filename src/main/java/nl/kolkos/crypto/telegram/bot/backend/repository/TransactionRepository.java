package nl.kolkos.crypto.telegram.bot.backend.repository;

import nl.kolkos.crypto.telegram.bot.backend.entities.Transaction;
import nl.kolkos.crypto.telegram.bot.backend.entities.TransactionType;
import nl.kolkos.crypto.telegram.bot.backend.entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByWalletOrderByTransactionDateDesc(Wallet wallet);
    List<Transaction> findByWalletAndTransactionTypeOrderByTransactionDateDesc(Wallet wallet, TransactionType transactionType);

    @Query(value = "SELECT SUM(amount) FROM transaction WHERE transaction_type = ?1 AND wallet_id = ?2", nativeQuery = true)
    double getTotalDepositsForWallet(TransactionType transactionType, long walletId);
}
