package com.hoomgroom.buyproduct.service;

import com.hoomgroom.buyproduct.model.Furniture;

public interface FurnitureDetailsService {
    Furniture getFurnitureByInternalId(Long id);
}
