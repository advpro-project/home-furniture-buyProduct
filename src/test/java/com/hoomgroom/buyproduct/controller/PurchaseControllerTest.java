package com.hoomgroom.buyproduct.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoomgroom.buyproduct.model.PurchaseTransaction;
import com.hoomgroom.buyproduct.repository.PurchaseTransactionRepository;
import com.hoomgroom.buyproduct.service.PurchaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(PurchaseController.class)
public class PurchaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PurchaseService purchaseService;

    @MockBean
    private PurchaseTransactionRepository purchaseTransactionRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private PurchaseController.PurchaseRequest purchaseRequest;
    private PurchaseTransaction purchaseTransaction;

    @BeforeEach
    void setUp() {
        purchaseRequest = new PurchaseController.PurchaseRequest();
        purchaseRequest.setUserId("user1");
        purchaseRequest.setProductId("product1");
        purchaseRequest.setTotalPrice(100.0);
        purchaseRequest.setPaymentMethod("credit card");
        purchaseRequest.setPromoCode("PROMO10");

        purchaseTransaction = new PurchaseTransaction.PurchaseTransactionBuilder()
                .userId(purchaseRequest.getUserId())
                .productId(purchaseRequest.getProductId())
                .totalPrice(purchaseRequest.getTotalPrice())
                .paymentMethod(purchaseRequest.getPaymentMethod())
                .promoCode(purchaseRequest.getPromoCode())
                .build();
    }

    @Test
    void testBuyProduct() throws Exception {
        // Simulate the behavior of the service
        when(purchaseService.processPurchase(purchaseTransaction)).thenReturn(purchaseTransaction);

        mockMvc.perform(post("/api/purchase/buy")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(purchaseRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(purchaseRequest.getUserId()))
                .andExpect(jsonPath("$.productId").value(purchaseRequest.getProductId()))
                .andExpect(jsonPath("$.totalPrice").value(purchaseRequest.getTotalPrice()))
                .andExpect(jsonPath("$.paymentMethod").value(purchaseRequest.getPaymentMethod()))
                .andExpect(jsonPath("$.promoCode").value(purchaseRequest.getPromoCode()));
    }
}
