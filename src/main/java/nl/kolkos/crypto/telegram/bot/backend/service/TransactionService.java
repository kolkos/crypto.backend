package nl.kolkos.crypto.telegram.bot.backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import nl.kolkos.crypto.telegram.bot.backend.entities.Transaction;
import nl.kolkos.crypto.telegram.bot.backend.entities.TransactionType;
import nl.kolkos.crypto.telegram.bot.backend.entities.Wallet;
import nl.kolkos.crypto.telegram.bot.backend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final WalletService walletService;

    public Transaction registerTransaction(TransactionType transactionType, LocalDateTime transactionDate, String walletAddress, double amount, double valueOnTransactionDate) {
        Wallet wallet = walletService.findByAddress(walletAddress);
        Transaction transaction = Transaction.builder()
                .transactionType(transactionType)
                .transactionDate(transactionDate)
                .wallet(wallet)
                .amount(amount)
                .valueOnTransactionDate(valueOnTransactionDate)
                .build();

        return this.save(transaction);
    }

    public List<Transaction> findByWallet(String walletAddress) {
        Wallet wallet = walletService.findByAddress(walletAddress);
        return transactionRepository.findByWalletOrderByTransactionDateDesc(wallet);
    }

    public double getTotalAmountDepositedIn(String walletAddress) {
        Wallet wallet = walletService.findByAddress(walletAddress);
        return transactionRepository.getTotalDepositsForWallet(TransactionType.DEPOSIT, wallet.getId());
    }


    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }


}
