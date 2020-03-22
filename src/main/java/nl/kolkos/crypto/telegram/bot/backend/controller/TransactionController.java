package nl.kolkos.crypto.telegram.bot.backend.controller;

import lombok.RequiredArgsConstructor;
import nl.kolkos.crypto.telegram.bot.backend.entities.Transaction;
import nl.kolkos.crypto.telegram.bot.backend.entities.TransactionType;
import nl.kolkos.crypto.telegram.bot.backend.service.TransactionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    @GetMapping("/register/deposit")
    public Transaction registerDepositTransaction(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam Date transactionDate,
            @RequestParam String walletAddress,
            @RequestParam double amount,
            @RequestParam double valueOnTransactionDate) {
        return transactionService.registerTransaction(TransactionType.DEPOSIT, transactionDate, walletAddress, amount, valueOnTransactionDate);
    }

    @GetMapping("/register/withdrawal")
    public Transaction registerWithdrawalTransaction(
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam Date transactionDate,
            @RequestParam String walletAddress,
            @RequestParam double amount,
            @RequestParam double valueOnTransactionDate) {
        return transactionService.registerTransaction(TransactionType.WITHDRAWAL, transactionDate, walletAddress, amount, valueOnTransactionDate);
    }

    @GetMapping("/get/bywallet")
    public List<Transaction> findByWalletAddress(
            @RequestParam String walletAddress) {
        return transactionService.findByWallet(walletAddress);
    }


}
