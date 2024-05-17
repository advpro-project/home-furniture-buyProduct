package com.hoomgroom.buyproduct.service;

import com.hoomgroom.buyproduct.model.PurchaseTransaction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PurchaseService {

    // Dummy wallet untuk menyimpan saldo pengguna
    private Map<String, Double> userWallet = new HashMap<>();

    @Async
    public void processPurchase(PurchaseTransaction transaction) {
        // Simulasi proses pembelian
        System.out.println("Processing purchase for User ID: " + transaction.getUserId());
        System.out.println("Product ID: " + transaction.getProductId());
        System.out.println("Total Price: " + transaction.getTotalPrice());
        System.out.println("Payment Method: " + transaction.getPaymentMethod());
        System.out.println("Promo Code: " + transaction.getPromoCode());

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
            System.out.println("Purchase processed successfully for User ID: " + transaction.getUserId());
        } else {
            System.out.println("Insufficient balance for User ID: " + transaction.getUserId());
            throw new RuntimeException("Insufficient balance");
        }
    }

    // Metode untuk menambahkan saldo ke dummy wallet
    public void topUp(String userId, double amount) {
        double currentBalance = userWallet.getOrDefault(userId, 0.0);
        userWallet.put(userId, currentBalance + amount);
        System.out.println("User ID: " + userId + " topped up with amount: " + amount);
    }

    // Metode untuk mendapatkan saldo saat ini
    public double getBalance(String userId) {
        return userWallet.getOrDefault(userId, 0.0);
    }
}
