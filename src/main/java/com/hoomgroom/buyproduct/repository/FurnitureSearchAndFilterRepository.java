package com.hoomgroom.buyproduct.repository;

import com.hoomgroom.buyproduct.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
    List<Furniture> findAllByOrderByDiscountedPriceAsc();
    List<Furniture> findAllByOrderByDiscountedPriceDesc();
    List<Furniture> findAllByHasDiscount(boolean hasDiscount);
    List<Furniture> findAllByType(String type);
    Furniture findByInternalId(Long id);


}
