package com.qublex.Challenge.Service;

import com.qublex.Challenge.Entity.InventoryItem;
import com.qublex.Challenge.Exception.ItemNotExistException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {
    private List<InventoryItem> inventory;

    public void fillInventoryFrom(List<InventoryItem> inventory) {
        this.inventory = inventory;
    }

    public int getInventoryStock(String designation) throws Exception {
        Optional<InventoryItem> item = getItemByDesignation(designation);
        if (item.isPresent()) {
            return item.get().getStockUnits();
        } else {
            throw new ItemNotExistException("Spare part does not exist in the inventory", designation);
        }
    }

    private Optional<InventoryItem> getItemByDesignation(String designation) {
        return inventory.stream()
                .filter(item -> designation.equals(item.getDesignation()))
                .findFirst();
    }
}
