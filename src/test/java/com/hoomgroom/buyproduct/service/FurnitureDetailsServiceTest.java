package com.hoomgroom.buyproduct.service;

import com.hoomgroom.buyproduct.model.Furniture;
import com.hoomgroom.buyproduct.repository.FurnitureDetailsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;
import org.mockito.InjectMocks;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FurnitureDetailsServiceTest {
    @Mock
    private FurnitureDetailsRepository furnitureDetailsRepository;

    @InjectMocks
    private FurnitureDetailsServiceImpl furnitureDetailsServiceImpl;


    @Test
    public void testGetItemByInternalId() {
        Furniture furniture = new Furniture();
        furniture.setInternalId(1L);
        furniture.setId(UUID.fromString("eb558e9f-1c39-460e-8860-71af6af63bd6"));
        furniture.setName("Furniture 1");
        furniture.setType("Type A");
        furniture.setDescription("lorem ipsum");
        furniture.setImageUrl("example.url");
        furniture.setOriginalPrice(1000);
        furniture.setDiscountedPrice(500);
        furniture.setHasDiscount(true);

        Long furnitureInternalId = 1L;

        when(furnitureDetailsRepository.findByInternalId(furnitureInternalId)).
                thenReturn(furniture);

        Furniture result = furnitureDetailsServiceImpl.getFurnitureByInternalId(furnitureInternalId);
        assertNotNull(result);
        assertEquals(furnitureInternalId, result.getInternalId());
    }

}
