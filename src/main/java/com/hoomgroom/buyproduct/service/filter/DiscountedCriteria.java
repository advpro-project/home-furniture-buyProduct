package com.hoomgroom.buyproduct.service.filter;

import com.hoomgroom.buyproduct.model.Furniture;

import java.util.List;

public class DiscountedCriteria implements Criteria {
    public List<Furniture> meetCriteria(List<Furniture> furnitures, String discount) {
        List<Furniture> discountFilteredFurnitures = furnitures.stream()
                .filter(Furniture::isHasDiscount)
                .toList();
        return discountFilteredFurnitures;
    }
}
