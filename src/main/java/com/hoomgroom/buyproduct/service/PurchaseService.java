package com.hoomgroom.buyproduct.service;

import com.hoomgroom.buyproduct.model.PurchaseTransaction;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Async
    public void processPurchase(PurchaseTransaction transaction) {
        System.out.println("User ID: " + transaction.getUserId());
        System.out.println("Product ID: " + transaction.getProductId());
        // To be added
    }
}