package com.hoomgroom.buyproduct.controller;

import com.hoomgroom.buyproduct.model.PurchaseTransaction;
import com.hoomgroom.buyproduct.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    // Endpoint untuk melakukan pembelian produk
    @PostMapping("/buy")
    public PurchaseTransaction buyProduct(@RequestBody PurchaseRequest request) {

        // Simulasi pembelian produk
        PurchaseTransaction transaction = new PurchaseTransaction.PurchaseTransactionBuilder()
                .userId(request.getUserId())
                .productId(request.getProductId())
                .totalPrice(request.getTotalPrice())
                .paymentMethod(request.getPaymentMethod())
                .promoCode(request.getPromoCode())
                .build();

        // Panggil service asynchronous untuk memproses pembelian
        purchaseService.processPurchase(transaction);

        return transaction;
    }

    // Endpoint untuk melihat daftar transaksi produk
    @GetMapping("/transactions")
    public List<PurchaseTransaction> getAllTransactions() {
        return purchaseService.getAllTransactions();
    }

    // Endpoint untuk melakukan top-up saldo
    @PostMapping("/top-up")
    public String topUpBalance(@RequestBody TopUpRequest request) {
        purchaseService.topUp(request.getUserId(), request.getAmount());
        return "Top-up successful";
    }

    // Endpoint untuk melihat saldo saat ini
    @GetMapping("/balance")
    public double getBalance(@RequestParam String userId) {
        return purchaseService.getBalance(userId);
    }

    // Kelas model untuk request pembelian
    public static class PurchaseRequest {
        private String userId;
        private String productId;
        private double totalPrice;
        private String paymentMethod;
        private String promoCode;

        // Constructor, getters, and setters
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public String getPromoCode() {
            return promoCode;
        }

        public void setPromoCode(String promoCode) {
            this.promoCode = promoCode;
        }
    }

    // Kelas model untuk request top-up saldo
    public static class TopUpRequest {
        private String userId;
        private double amount;

        // Constructor, getters, and setters
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}



