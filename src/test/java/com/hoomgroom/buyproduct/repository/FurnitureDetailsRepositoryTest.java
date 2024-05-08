package com.hoomgroom.buyproduct.repository;

import com.hoomgroom.buyproduct.model.Furniture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
public class FurnitureDetailsRepositoryTest {
    @Autowired
    private FurnitureDetailsRepository furnitureDetailsRepository;

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
        furnitureDetailsRepository.save(furniture);
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
        furnitureDetailsRepository.save(furniture2);
    }

    @AfterEach
    public void tearDown() {
        // Clean up test data
        furnitureDetailsRepository.deleteAll(); // Delete all entities
    }

    @Test
    public void whenFindByInternalId_thenReturnFurniture() {
        // given
        Long furnitureInternalId = 1L;
        // when
        Furniture found = furnitureDetailsRepository.findByInternalId(furnitureInternalId);
        System.out.println("this is the INTERNAL ID for debugging: " + found.getInternalId());

        // then
        assertEquals(furnitureInternalId, found.getInternalId());
    }

    @Test
    public void whenFindByNotFoundInternalId_thenReturnNull() {
        // given
        Long notFoundFurnitureInternalId = 10L;
        // when
        Furniture found = furnitureDetailsRepository.findByInternalId(notFoundFurnitureInternalId);

        // then
        assertNull(found);
    }

}
