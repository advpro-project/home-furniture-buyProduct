package com.hoomgroom.buyproduct;

import com.hoomgroom.buyproduct.model.Furniture;
import com.hoomgroom.buyproduct.repository.FurnitureSearchAndFilterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class BuyProductApplicationTests {

    @Autowired
    private FurnitureSearchAndFilterRepository furnitureRepository;

    @BeforeEach
    public void setUp() {
        Furniture furniture = new Furniture();
        furniture = new Furniture();
        furniture.setId(UUID.fromString("eb558e9f-1c39-460e-8860-71af6af63bd6"));
        furniture.setName("Furniture 1");
        furniture.setType("Type A");
        furniture.setDescription("lorem ipsum");
        furniture.setImageUrl("example.url");
        furniture.setOriginalPrice(1000);
        furniture.setDiscountedPrice(500);
        furniture.setHasDiscount(true);
        furnitureRepository.save(furniture);
        Furniture furniture2 = new Furniture();
        furniture2 = new Furniture();
        furniture2.setId(UUID.fromString("eb558e9f-1c39-460e-8860-71af6af63bd7"));
        furniture2.setName("Furniture 2");
        furniture2.setType("Type A");
        furniture2.setDescription("lorem ipsum");
        furniture2.setImageUrl("example.url");
        furniture2.setOriginalPrice(1000);
        furniture2.setDiscountedPrice(1000);
        furniture2.setHasDiscount(false);
        furnitureRepository.save(furniture2);
    }

}
