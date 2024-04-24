package com.hoomgroom.buyproduct.repository;

import com.hoomgroom.buyproduct.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
    List<Furniture> findAllByOrderByPriceAsc();
    List<Furniture> findAllByOrderByPriceDesc();
    List<Furniture> filterFurnituresByHasDiscount(boolean hasDiscount);
    List<Furniture> filterFurnituresByType(String type);

    Furniture findByInternalId(Long id);

}
