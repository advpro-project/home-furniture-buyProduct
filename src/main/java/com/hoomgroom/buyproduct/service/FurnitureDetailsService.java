package com.hoomgroom.buyproduct.service;

import com.hoomgroom.buyproduct.model.Furniture;
import org.springframework.stereotype.Service;

public interface FurnitureDetailsService {
    public Furniture getFurnitureByInternalId(Long id);
}
