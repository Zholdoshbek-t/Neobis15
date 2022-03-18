package com.tilek.spring.neobis.rest;

import com.tilek.spring.neobis.exception.ResourceNotFoundException;
import com.tilek.spring.neobis.model.Warehouse;
import com.tilek.spring.neobis.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/warehouses")
public class WarehouseController {

    final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseController(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('warehouse:read')")
    List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('warehouse:read')")
    ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No warehouse found with id: " + id));
        return ResponseEntity.ok(warehouse);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('warehouse:write')")
    Warehouse createWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('warehouse:write')")
    ResponseEntity<Warehouse> updateWarehouse(@PathVariable Long id, @RequestBody Warehouse warehouseDetails) {
        Warehouse updateWarehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No warehouse found with id: " + id));
        updateWarehouse.setCountry(warehouseDetails.getCountry());
        updateWarehouse.setCity(warehouseDetails.getCity());
        updateWarehouse.setAddress(warehouseDetails.getAddress());

        warehouseRepository.save(updateWarehouse);

        return ResponseEntity.ok(updateWarehouse);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('warehouse:write')")
    ResponseEntity<Warehouse> deleteWarehouse(@PathVariable Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No warehouse found with id: " + id));

        warehouseRepository.deleteById(id);

        return ResponseEntity.ok(warehouse);
    }
}
