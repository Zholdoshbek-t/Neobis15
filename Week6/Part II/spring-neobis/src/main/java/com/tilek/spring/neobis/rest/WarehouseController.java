package com.tilek.spring.neobis.rest;

import com.tilek.spring.neobis.entity.Warehouse;
import com.tilek.spring.neobis.model.WarehouseModel;
import com.tilek.spring.neobis.service.WarehouseService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('warehouse:read')")
    List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('warehouse:read')")
    ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        return warehouseService.getWarehouseById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('warehouse:write')")
    Warehouse createWarehouse(WarehouseModel warehouseModel) {
        return warehouseService.createWarehouse(warehouseModel);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('warehouse:write')")
    ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody WarehouseModel warehouseDetails) {
        return warehouseService.updateWarehouse(id, warehouseDetails);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('warehouse:write')")
    ResponseEntity<Warehouse> deleteWarehouse(@PathVariable Long id) {
        return warehouseService.deleteWarehouse(id);
    }
}
