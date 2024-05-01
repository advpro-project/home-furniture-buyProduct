package com.hoomgroom.buyproduct.controller;

import com.hoomgroom.buyproduct.model.PurchaseTransaction;
import com.hoomgroom.buyproduct.model.PurchaseTransaction.PurchaseTransactionBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    private List<PurchaseTransaction> transactionList = new ArrayList<>();

    // Endpoint untuk melakukan pembelian produk
    @PostMapping("/buy")
    public PurchaseTransaction buyProduct(@RequestBody PurchaseRequest request) {
        // Validasi request, misalnya apakah user ID valid, apakah produk ID valid, dsb.

        // Simulasi pembelian produk
        PurchaseTransaction transaction = new PurchaseTransactionBuilder()
                .userId(request.getUserId())
                .productId(request.getProductId())
                .totalPrice(request.getTotalPrice())
                .paymentMethod(request.getPaymentMethod())
                .promoCode(request.getPromoCode())
                .build();

        // Tambahkan transaksi ke dalam daftar transaksi
        transactionList.add(transaction);

        return transaction;
    }

    // Endpoint untuk melihat daftar transaksi produk
    @GetMapping("/transactions")
    public List<PurchaseTransaction> getAllTransactions() {
        return transactionList;
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
}

