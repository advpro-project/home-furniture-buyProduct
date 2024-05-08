package com.hoomgroom.buyproduct.repository;

import com.hoomgroom.buyproduct.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureDetailsRepository extends JpaRepository<Furniture, Long> {
    Furniture findByInternalId(Long id);
}
