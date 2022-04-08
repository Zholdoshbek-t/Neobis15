package com.tilek.spring.neobis.rest;

import com.tilek.spring.neobis.entity.Warehouse;
import com.tilek.spring.neobis.model.WarehouseModel;
import com.tilek.spring.neobis.service.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouses")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @GetMapping("{id}")
    ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        return warehouseService.getWarehouseById(id);
    }

    @PostMapping
    Warehouse createWarehouse(@RequestBody WarehouseModel warehouseModel) {
        return warehouseService.createWarehouse(warehouseModel);
    }

    @PutMapping("{id}")
    ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody WarehouseModel warehouseDetails) {
        return warehouseService.updateWarehouse(id, warehouseDetails);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Warehouse> deleteWarehouse(@PathVariable Long id) {
        return warehouseService.deleteWarehouse(id);
    }
}
