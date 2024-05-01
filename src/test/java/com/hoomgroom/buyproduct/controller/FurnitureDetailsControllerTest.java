package com.hoomgroom.buyproduct.controller;

import com.hoomgroom.buyproduct.model.Furniture;
import com.hoomgroom.buyproduct.repository.FurnitureDetailsRepository;
import com.hoomgroom.buyproduct.service.FurnitureDetailsService;
import com.hoomgroom.buyproduct.service.FurnitureDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(FurnitureDetailsController.class)
public class FurnitureDetailsControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Mock
    private FurnitureDetailsServiceImpl furnitureDetailsServiceImpl;
    @InjectMocks
    private FurnitureDetailsController furnitureDetailsController;

    @Test
    public void testGetItemDetails() throws Exception {
        Furniture furniture;
        furniture = new Furniture();
        furniture.setInternalId(1L);
        furniture.setId(UUID.fromString("eb558e9f-1c39-460e-8860-71af6af63bd6"));
        furniture.setName("Furniture 1");
        furniture.setType("Type A");
        furniture.setDescription("lorem ipsum");
        furniture.setImageUrl("example.url");
        furniture.setOriginalPrice(1000);
        furniture.setDiscountedPrice(500);
        furniture.setHasDiscount(true);

        Long furnitureInternalId = 1L; // Assuming the item ID to test with is 1L

        // Mock the behavior of the itemService.getItemById method
        when(furnitureDetailsServiceImpl.getFurnitureByInternalId(furnitureInternalId)).thenReturn(furniture);

        // Perform GET request to the endpoint and verify the response
        mockMvc.perform(MockMvcRequestBuilders.get("/furniture/{furnitureInternalId}", furnitureInternalId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.internalId").value(furnitureInternalId.intValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Furniture 1"));

    }


}
