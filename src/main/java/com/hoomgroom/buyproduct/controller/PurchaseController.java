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

    @PostMapping("/buy")
    public PurchaseTransaction buyProduct(@RequestBody PurchaseRequest request) {

        // Dapatkan data produk dari endpoint eksternal
        PurchaseService.Product product = purchaseService.getProductById(request.getProductId());

        // Simulasi pembelian produk
        PurchaseTransaction transaction = new PurchaseTransaction.PurchaseTransactionBuilder()
                .userId(request.getUserId())
                .productId(product.getId())
                .totalPrice(request.getTotalPrice())
                .paymentMethod(request.getPaymentMethod())
                .promoCode(request.getPromoCode())
                .build();

        // Panggil service asynchronous untuk memproses pembelian
        purchaseService.processPurchase(transaction);

        return transaction;
    }

    @GetMapping("/transactions")
    public List<PurchaseTransaction> getAllTransactions() {
        return purchaseService.getAllTransactions();
    }

    @PostMapping("/top-up")
    public String topUpBalance(@RequestBody TopUpRequest request) {
        purchaseService.topUp(request.getUserId(), request.getAmount());
        return "Top-up successful";
    }

    @GetMapping("/balance")
    public double getBalance(@RequestParam String userId) {
        return purchaseService.getBalance(userId);
    }

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

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double newTotal) {
            this.totalPrice = newTotal;
        }
    }

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

