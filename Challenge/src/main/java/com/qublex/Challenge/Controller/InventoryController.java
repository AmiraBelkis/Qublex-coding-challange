package com.qublex.Challenge.Controller;

import com.qublex.Challenge.Entity.InventoryItem;
import com.qublex.Challenge.Service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("api/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping("inventoryItems")
    public ResponseEntity<List<InventoryItem>> getInventoryItems() {
        return ResponseEntity.status(HttpStatus.OK).body(inventoryService.getInventoryItems());
    }

    @PostMapping("addInventoryItems")
    public ResponseEntity<List<InventoryItem>> addInventoryItems(@RequestBody List<InventoryItem> inventoryItems) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventoryService.createInventoryItem(inventoryItems));
    }

}
