package com.qublex.Challenge.ServiceTest;

import com.qublex.Challenge.Entity.InventoryItem;
import com.qublex.Challenge.Exception.ItemNotExistException;
import com.qublex.Challenge.Service.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class InventoryServiceTest {

    @Autowired
    private InventoryService inventoryService;

    @Test
    void getInventoryStockSuccessTest() throws Exception {
        InventoryItem item = new InventoryItem(1L, "Seat", 50);
        int stock = inventoryService.getInventoryStock(item.getDesignation());
        assertEquals(item.getStockUnits(), stock);
    }

    @Test
    void getInventoryStockItemNotExistTest() {
        String designation = "Wrong Designation";
        ItemNotExistException itemNotExistException = assertThrows(ItemNotExistException.class,
                () -> {
                    inventoryService.getInventoryStock(designation);
                }
        );
        assertEquals("Spare part does not exist in the inventory", itemNotExistException.getMessage());
        assertEquals(designation, itemNotExistException.getWrongDesignation());
    }

}
