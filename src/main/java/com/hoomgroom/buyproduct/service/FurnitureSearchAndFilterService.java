package com.hoomgroom.buyproduct.service;

import com.hoomgroom.buyproduct.model.Furniture;

import java.util.List;

public interface FurnitureSearchAndFilterService {
    List<Furniture> filterFurnituresByKeyword(String keyword);



}
