package com.hoomgroom.buyproduct.controller;

import com.hoomgroom.buyproduct.model.Furniture;
import com.hoomgroom.buyproduct.service.FurnitureDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/furniture")
public class FurnitureDetailsController {

    @Autowired
    private FurnitureDetailsService furnitureDetailsService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{furnitureInternalId}")
    public ResponseEntity<Furniture> getItemDetails(@PathVariable Long furnitureInternalId) {
        Furniture furniture = furnitureDetailsService.getFurnitureByInternalId(furnitureInternalId);
        if (furniture != null) {
            return ResponseEntity.ok(furniture);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
