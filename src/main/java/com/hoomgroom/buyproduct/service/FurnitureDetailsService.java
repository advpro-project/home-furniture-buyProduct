package com.hoomgroom.buyproduct.service;

import com.hoomgroom.buyproduct.model.Furniture;

public interface FurnitureDetailsService {
    public Furniture getFurnitureByInternalId(Long id);
    public Furniture seed();
}
