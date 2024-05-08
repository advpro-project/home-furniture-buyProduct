package com.hoomgroom.buyproduct.service;

import com.hoomgroom.buyproduct.model.Furniture;
import com.hoomgroom.buyproduct.repository.FurnitureDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FurnitureDetailsServiceImpl implements FurnitureDetailsService {

    @Autowired
    private FurnitureDetailsRepository furnitureDetailsRepository;
    public Furniture getFurnitureByInternalId(Long id) {
        Furniture furniture = furnitureDetailsRepository.findByInternalId(id);
        return furniture;
    }

    public Furniture seed() {
        Furniture furniture = new Furniture();
        furniture.setName("Furniture 3");
        furniture.setDescription("lorem ipsum");
        furniture.setType("Type B");
        furniture.setHasDiscount(true);
        furniture.setImageUrl("random.co.id");
        furniture.setSoldQuantity(1000);
        furniture.setOriginalPrice(20000);
        furniture.setDiscountedPrice(10000);
        furnitureDetailsRepository.save(furniture);
        return furniture;
    }
}