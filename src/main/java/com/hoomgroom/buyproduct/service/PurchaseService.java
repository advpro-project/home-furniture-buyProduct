package com.hoomgroom.buyproduct.service;

import com.hoomgroom.buyproduct.model.PurchaseTransaction;
import com.hoomgroom.buyproduct.model.UserWallet;
import com.hoomgroom.buyproduct.repository.PurchaseTransactionRepository;
import com.hoomgroom.buyproduct.repository.UserWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseTransactionRepository transactionRepository;

    @Autowired
    private UserWalletRepository userWalletRepository;

    @Autowired
    private RestTemplate restTemplate;
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Async
    public PurchaseTransaction processPurchase(PurchaseTransaction transaction) {
        // Dapatkan wallet pengguna dari database
        Optional<UserWallet> optionalWallet = userWalletRepository.findById(transaction.getUserId());
        if (optionalWallet.isEmpty()) {
            throw new RuntimeException("User wallet not found");
        }

        UserWallet userWallet = optionalWallet.get();
        double currentBalance = userWallet.getWallet();
        double finalPrice = transaction.getTotalPrice();

        // penggunaan kode promo
        if (transaction.getPromoCode() != null && !transaction.getPromoCode().isEmpty()) {
            // Misalnya: finalPrice *= 0.9;
        }

        if (currentBalance >= finalPrice) {
            // Kurangi saldo pengguna
            userWallet.setWallet(currentBalance - finalPrice);
            userWalletRepository.save(userWallet);

            // Simpan transaksi ke database
            return transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Insufficient balance");
        }
    }

    // Metode untuk menambahkan saldo ke wallet pengguna
    public void topUp(String userId, double amount) {
        Optional<UserWallet> optionalWallet = userWalletRepository.findById(userId);
        if (optionalWallet.isEmpty()) {
            throw new RuntimeException("User wallet not found");
        }

        UserWallet userWallet = optionalWallet.get();
        double currentBalance = userWallet.getWallet();
        userWallet.setWallet(currentBalance + amount);
        userWalletRepository.save(userWallet);
    }

    // Metode untuk mendapatkan saldo saat ini
    public double getBalance(String userId) {
        Optional<UserWallet> optionalWallet = userWalletRepository.findById(userId);
        if (optionalWallet.isEmpty()) {
            throw new RuntimeException("User wallet not found");
        }

        return optionalWallet.get().getWallet();
    }

    // Metode untuk mengambil semua transaksi
    public List<PurchaseTransaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Metode untuk mendapatkan data produk dari endpoint eksternal
    public Product getProductById(String idFurniture) {
        String url = "http://35.226.59.207/furniture/get/" + idFurniture;
        return restTemplate.getForObject(url, Product.class);
    }

    // Kelas model untuk data produk
    public static class Product {
        private String id;
        private String name;
        private double price;
        // Getters and setters

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}

