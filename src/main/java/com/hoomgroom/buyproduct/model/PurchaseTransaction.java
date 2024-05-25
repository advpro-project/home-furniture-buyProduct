package com.hoomgroom.buyproduct.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "transactions")
public class PurchaseTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String userId;
    private String productId;
    private double totalPrice;
    private String paymentMethod;
    private String promoCode;

    private PurchaseTransaction(PurchaseTransactionBuilder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.productId = builder.productId;
        this.totalPrice = builder.totalPrice;
        this.paymentMethod = builder.paymentMethod;
        this.promoCode = builder.promoCode;
    }

    public PurchaseTransaction() {

    }


    public static class PurchaseTransactionBuilder {
        private UUID id;
        private String userId;
        private String productId;
        private double totalPrice;
        private String paymentMethod;
        private String promoCode;

        public PurchaseTransactionBuilder() {
            this.id = UUID.randomUUID(); // Generate UUID for id
        }

        public PurchaseTransactionBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public PurchaseTransactionBuilder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public PurchaseTransactionBuilder totalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public PurchaseTransactionBuilder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public PurchaseTransactionBuilder promoCode(String promoCode) {
            this.promoCode = promoCode;
            return this;
        }

        public PurchaseTransaction build() {
            return new PurchaseTransaction(this);
        }
    }
}

