package com.hoomgroom.buyproduct.repository;

import com.hoomgroom.buyproduct.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FurnitureSearchAndFilterRepository extends JpaRepository<Furniture, Long> {
    List<Furniture> findAllByNameContainingIgnoreCase(String keyword);
}
