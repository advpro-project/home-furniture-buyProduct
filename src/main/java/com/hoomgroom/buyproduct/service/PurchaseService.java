package com.hoomgroom.buyproduct.service;

import com.hoomgroom.buyproduct.model.PurchaseTransaction;
import com.hoomgroom.buyproduct.repository.PurchaseTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseTransactionRepository transactionRepository;

    // Dummy wallet untuk menyimpan saldo pengguna
    private Map<String, Double> userWallet = new HashMap<>();

    @Async
    public PurchaseTransaction processPurchase(PurchaseTransaction transaction) {

        // Cek saldo pengguna
        double currentBalance = userWallet.getOrDefault(transaction.getUserId(), 0.0);
        double finalPrice = transaction.getTotalPrice();

        // penggunaan kode promo
        if (transaction.getPromoCode() != null && !transaction.getPromoCode().isEmpty()) {
            //finalPrice *= 0.9;
        }

        if (currentBalance >= finalPrice) {
            // Kurangi saldo pengguna
            userWallet.put(transaction.getUserId(), currentBalance - finalPrice);

            // Simpan transaksi ke database
            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Insufficient balance");
        }
    }

    // Metode untuk menambahkan saldo ke dummy wallet
    public void topUp(String userId, double amount) {
        double currentBalance = userWallet.getOrDefault(userId, 0.0);
        userWallet.put(userId, currentBalance + amount);
    }

    // Metode untuk mendapatkan saldo saat ini
    public double getBalance(String userId) {
        return userWallet.getOrDefault(userId, 0.0);
    }

    // Metode untuk mengambil semua transaksi
    public List<PurchaseTransaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
}

