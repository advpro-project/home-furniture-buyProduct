package com.hoomgroom.buyproduct.service.filter;
import com.hoomgroom.buyproduct.model.Furniture;

import java.util.List;

public interface Criteria {
    public List<Furniture> meetCriteria(List<Furniture> furnitures, String criteria);
}
