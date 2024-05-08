package com.hoomgroom.buyproduct.controller;

import com.hoomgroom.buyproduct.model.Furniture;
import com.hoomgroom.buyproduct.service.FurnitureDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/furniture")
public class FurnitureDetailsController {

    @Autowired
    private FurnitureDetailsService furnitureDetailsService;

    @GetMapping("/{furnitureInternalId}")
    public ResponseEntity<Furniture> getItemDetails(@PathVariable Long furnitureInternalId) {
        Furniture furniture = furnitureDetailsService.getFurnitureByInternalId(furnitureInternalId);
        if (furniture != null) {
            return ResponseEntity.ok(furniture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/seed")
    public ResponseEntity<Furniture> seed() {
        Furniture furniture = furnitureDetailsService.seed();
        if (furniture != null) {
            return ResponseEntity.ok(furniture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
