package com.hoomgroom.buyproduct.service.filter;

import com.hoomgroom.buyproduct.model.Furniture;

import java.util.List;
import java.util.Comparator;

public class PriceCriteria implements Criteria {
    public List<Furniture> meetCriteria(List<Furniture> furnitures, String price) {
        List<Furniture> priceFilteredFurnitures;

        if (price.equals("Max")) {
            priceFilteredFurnitures = furnitures.stream()
                    .sorted(Comparator.comparing(Furniture::getDiscountedPrice).reversed()).toList();
        }
        else {
            priceFilteredFurnitures = furnitures.stream()
                    .sorted(Comparator.comparing(Furniture::getDiscountedPrice)).toList();
        }

        return priceFilteredFurnitures;
    }
}
