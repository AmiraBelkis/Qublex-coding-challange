package com.qublex.Challenge.Service;

import com.qublex.Challenge.Entity.InventoryItem;
import com.qublex.Challenge.Exception.ItemNotExistException;
import com.qublex.Challenge.Repository.InventoryItemRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryItemRepository inventoryItemRepository;

    public int getInventoryStock(String designation) throws Exception {
        Optional<InventoryItem> item = inventoryItemRepository.findByDesignation(designation);
        if (item.isPresent()) {
            return item.get().getStockUnits();
        } else {
            throw new ItemNotExistException("Spare part does not exist in the inventory", designation);
        }
    }

    @Transactional
    public List<InventoryItem> createInventoryItem(List<InventoryItem> inventoryItems) {
        return inventoryItemRepository.saveAll(inventoryItems);
    }

    public List<InventoryItem> getInventoryItems() {
        return inventoryItemRepository.findAll();
    }
}
