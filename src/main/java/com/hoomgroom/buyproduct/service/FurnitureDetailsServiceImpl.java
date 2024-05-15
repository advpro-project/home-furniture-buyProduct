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
}
