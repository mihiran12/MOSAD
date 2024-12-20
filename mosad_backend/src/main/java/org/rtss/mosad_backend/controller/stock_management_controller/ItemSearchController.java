package org.rtss.mosad_backend.controller.stock_management_controller;

import org.rtss.mosad_backend.service.stock_management_service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
public class ItemSearchController {

    private final ItemSearchService itemSearchService;

    @Autowired
    public ItemSearchController(ItemSearchService itemSearchService) {
        this.itemSearchService = itemSearchService;
    }

    @GetMapping("/brand")
    public ResponseEntity<?> searchByBrandAndSize(
            @RequestParam String brand,
            @RequestParam(required = false) String size) {
        try {
            List<?> results = itemSearchService.searchByBrandAndSize(brand, size);
            return results.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(results);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
