package com.hoomgroom.buyproduct.repository;

import com.hoomgroom.buyproduct.model.Furniture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
public class FurnitureSearchAndFilterRepositoryTest {
    @Autowired
    private FurnitureSearchAndFilterRepository furnitureSearchAndFilterRepository;

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
        furnitureSearchAndFilterRepository.save(furniture);
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
        furnitureSearchAndFilterRepository.save(furniture2);
    }

    @AfterEach
    public void tearDown() {
        // Clean up test data
        furnitureSearchAndFilterRepository.deleteAll(); // Delete all entities
    }

    @Test
    public void whenFindAllByType_thenReturnListOfFurniture() {
        // given
        String furnitureType = "Type A";
        // when
        List<Furniture> found = furnitureSearchAndFilterRepository.findAllByType(furnitureType);
        Iterator<Furniture> iterator = found.iterator();

        // then
        Furniture furniture1 = iterator.next();
        Furniture furniture2 = iterator.next();

        assertEquals("Type A", furniture1.getType());
        assertEquals("Type A", furniture2.getType());
    }

    @Test
    public void whenFindAllByNotFoundType_thenReturnEmptyList() {
        // given
        String furnitureType = "Type B";
        // when
        List<Furniture> found = furnitureSearchAndFilterRepository.findAllByType(furnitureType);
        Iterator<Furniture> iterator = found.iterator();

        // then
        assertTrue(found.isEmpty());
    }

    @Test
    public void whenFindAllByHasDiscountTrue_thenReturnListOfProductHasDiscount() {
        // given
        boolean furnitureHasDiscount = true;
        // when
        List<Furniture> found = furnitureSearchAndFilterRepository.findAllByHasDiscount(furnitureHasDiscount);
        Iterator<Furniture> iterator = found.iterator();

        // then
        Furniture furniture1 = iterator.next();
        assertNotEquals(furniture1.getOriginalPrice(), furniture1.getDiscountedPrice());
    }

    @Test
    public void whenFindAllByHasDiscountFalse_thenReturnListOfProductNotDiscount() {
        // given
        boolean furnitureHasDiscount = false;
        // when
        List<Furniture> found = furnitureSearchAndFilterRepository.findAllByHasDiscount(furnitureHasDiscount);
        Iterator<Furniture> iterator = found.iterator();

        // then
        Furniture furniture1 = iterator.next();
        assertEquals(furniture1.getOriginalPrice(), furniture1.getDiscountedPrice());
    }

    @Test
    public void whenFindAllByPriceDesc_thenReturnListOfProductWithMaxPrice() {
        // when
        List<Furniture> found = furnitureSearchAndFilterRepository.findAllByOrderByDiscountedPriceDesc();
        Iterator<Furniture> iterator = found.iterator();

        // then
        Furniture furniture1 = iterator.next();
        Furniture furniture2 = iterator.next();
        assertTrue(furniture1.getDiscountedPrice() > furniture2.getDiscountedPrice());
    }

    @Test
    public void whenFindAllByPriceAsc_thenReturnListOfProductWithMinPrice() {
        // when
        List<Furniture> found = furnitureSearchAndFilterRepository.findAllByOrderByDiscountedPriceAsc();
        Iterator<Furniture> iterator = found.iterator();

        // then
        Furniture furniture1 = iterator.next();
        Furniture furniture2 = iterator.next();
        assertTrue(furniture1.getDiscountedPrice() < furniture2.getDiscountedPrice());
    }
}
