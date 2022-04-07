package com.tilek.spring.neobis.service;

import com.tilek.spring.neobis.entity.Warehouse;
import com.tilek.spring.neobis.exception.ResourceNotFoundException;
import com.tilek.spring.neobis.model.WarehouseModel;
import com.tilek.spring.neobis.repository.WarehouseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("warehouseServiceImpl")
public class WarehouseServiceImpl implements WarehouseService{

    private final WarehouseRepository warehouseRepository;

    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    @Override
    public ResponseEntity<Warehouse> getWarehouseById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse was not found"));

        return ResponseEntity.ok(warehouse);
    }

    @Override
    public Warehouse createWarehouse(WarehouseModel warehouseModel) {
        Warehouse warehouse = new Warehouse();

        mergeWarehouses(warehouse, warehouseModel);

        return warehouseRepository.save(warehouse);
    }

    @Override
    public ResponseEntity<Warehouse> updateWarehouse(Long id, WarehouseModel warehouseDetails) {
        Warehouse updateWarehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse was not found"));

        mergeWarehouses(updateWarehouse, warehouseDetails);

        warehouseRepository.save(updateWarehouse);

        return ResponseEntity.ok(updateWarehouse);
    }

    @Override
    public ResponseEntity<Warehouse> deleteWarehouse(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Warehouse was not found"));

        warehouseRepository.deleteById(id);

        return ResponseEntity.ok(warehouse);
    }

    private void mergeWarehouses(Warehouse warehouse, WarehouseModel warehouseModel) {
        warehouse.setCountry(warehouseModel.getCountry());
        warehouse.setCity(warehouseModel.getCity());
        warehouse.setAddress(warehouseModel.getAddress());
    }
}
