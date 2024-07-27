package com.qublex.Challenge.Service;

import com.qublex.Challenge.Entity.InventoryItem;

import java.util.List;

public interface InventoryService {
    int getInventoryStock(String designation) throws Exception;

    List<InventoryItem> getInventoryItems();

    List<InventoryItem> createInventoryItem(List<InventoryItem> inventoryItems);
}
