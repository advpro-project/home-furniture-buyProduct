package com.hoomgroom.buyproduct.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
public class FurnitureTest {
    Furniture furniture;

    @BeforeEach
    void setUp() {
        this.furniture = new Furniture();
        this.furniture.setId(UUID.fromString("eb558e9f-1c39-460e-8860-71af6af63bd6"));
        this.furniture.setName("Furniture 1");
        this.furniture.setType("Type A");
        this.furniture.setDescription("lorem ipsum");
        this.furniture.setImageUrl("example.url");
        this.furniture.setOriginalPrice(1000);
        this.furniture.setDiscountedPrice(500);
        this.furniture.setHasDiscount(true);
    }

    @Test
    void testGetFurnitureId() {
        assertEquals(UUID.fromString("eb558e9f-1c39-460e-8860-71af6af63bd6"), this.furniture.getId());
    }

    @Test
    void testGetFurnitureName() {
        assertEquals("Furniture 1", this.furniture.getName());
    }

    @Test
    void testGetFurnitureType() {
        assertEquals("Type A", this.furniture.getType());
    }

    @Test
    void testGetFurnitureDescription() {
        assertEquals("lorem ipsum", this.furniture.getDescription());
    }

    @Test
    void testGetFurnitureOriginalPrice() {
        assertEquals(1000, this.furniture.getOriginalPrice());
    }

    @Test
    void testGetDiscountedPrice() {
        assertEquals(500, this.furniture.getDiscountedPrice());
    }

    @Test
    void testGetFurnitureHasDiscount() {
        assertEquals(true, this.furniture.isHasDiscount());
    }
}



