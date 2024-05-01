package com.hoomgroom.buyproduct.service;

import com.hoomgroom.buyproduct.model.Furniture;

import java.util.List;

public interface FurnitureSearchAndFilterService {
    List<Furniture> filterFurnituresByMaxPrice();
    List<Furniture> filterFurnituresByMinPrice();
    List<Furniture> filterFurnituresByHasDiscount(boolean hasDiscount);
    List<Furniture> filterFurnituresByType(String type);
    Furniture findByInternalId(Long id);


}
