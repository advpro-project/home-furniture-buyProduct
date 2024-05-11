package com.hoomgroom.buyproduct.service.filter;

import com.hoomgroom.buyproduct.model.Furniture;
import com.hoomgroom.buyproduct.service.filter.Criteria;

import java.util.List;

public class TypeCriteria implements Criteria {
    public List<Furniture> meetCriteria(List<Furniture> furnitures, String type) {
        List<Furniture> typeFilteredFurnitures = furnitures.stream()
                .filter(product -> product.getType().equalsIgnoreCase(type))
                .toList();
        return typeFilteredFurnitures;
    }
}
