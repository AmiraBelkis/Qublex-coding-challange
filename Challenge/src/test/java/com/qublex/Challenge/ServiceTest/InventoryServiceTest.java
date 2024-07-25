package com.qublex.Challenge.ServiceTest;

import com.qublex.Challenge.Entity.InventoryItem;
import com.qublex.Challenge.Exception.ItemNotExistException;
import com.qublex.Challenge.Service.InventoryService;
import com.qublex.Challenge.Service.InventoryServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static com.qublex.Challenge.Utils.readInventoryItemList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class InventoryServiceTest {

    private static InventoryService inventoryService;
    private static ArrayList<InventoryItem> inventory;

    @BeforeAll
    static void setup() throws Exception {
        inventory = readInventoryItemList("01/Inventory.json");
        inventoryService = new InventoryServiceImpl(inventory);
    }

    @Test
    void getInventoryStockSuccessTest() throws Exception {
        InventoryItem item = inventory.get(0);
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
