package com.tilek.spring.neobis.service;

import com.tilek.spring.neobis.entity.Warehouse;
import com.tilek.spring.neobis.model.WarehouseModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WarehouseService {

    List<Warehouse> getAllWarehouses();
    ResponseEntity<Warehouse> getWarehouseById(Long id);
    Warehouse createWarehouse(WarehouseModel warehouseModel);
    ResponseEntity<Warehouse> updateWarehouse(Long id, WarehouseModel warehouseDetails);
    ResponseEntity<Warehouse> deleteWarehouse(Long id);

}
