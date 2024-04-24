package com.hoomgroom.buyproduct.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FurnitureTest {
    Furniture furniture;

    @BeforeEach
    void setUp() {
        this.furniture = new Furniture();
        this.furniture.setId(UUID.fromString("eb672e9f-1c39-460e-8860-71af6af63bd6"));
        this.furniture.setName("Furniture");
        this.furniture.setType("B");
        this.furniture.setDescription("Italian Maple");
        this.furniture.setImageUrl("example.url");
        this.furniture.setOriginalPrice(1000);
        this.furniture.setDiscountedPrice(750);
        this.furniture.setHasDiscount(true);
    }

    @Test
    void testGetFurnitureId() {
        assertEquals(UUID.fromString("eb672e9f-1c39-460e-8860-71af6af63bd6"), this.furniture.getId());
    }

    @Test
    void testGetFurnitureName() {
        assertEquals("Furniture", this.furniture.getName());
    }

    @Test
    void testGetFurnitureType() {
        assertEquals("B", this.furniture.getType());
    }

    @Test
    void testGetFurnitureDescription() {
        assertEquals("Italian Maple", this.furniture.getDescription());
    }

    @Test
    void testGetFurnitureOriginalPrice() {
        assertEquals(1000, this.furniture.getOriginalPrice());
    }

    @Test
    void testGetDiscountedPrice() {
        assertEquals(750, this.furniture.getDiscountedPrice());
    }

    @Test
    void testGetFurnitureHasDiscount() {
        assertEquals(true, this.furniture.isHasDiscount());
    }
}