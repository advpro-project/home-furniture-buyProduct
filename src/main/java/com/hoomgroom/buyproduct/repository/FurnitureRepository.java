package com.hoomgroom.buyproduct.repository;

import com.hoomgroom.buyproduct.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
    List<Furniture> findAllByOrderByDiscountedPriceAsc();
    List<Furniture> findAllByOrderByDiscountedPriceDesc();
    List<Furniture> findAllByHasDiscount(boolean hasDiscount);
    List<Furniture> findAllByType(String type);
    Furniture findByInternalId(Long id);


}
