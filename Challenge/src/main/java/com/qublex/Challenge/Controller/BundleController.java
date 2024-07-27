package com.qublex.Challenge.Controller;

import com.qublex.Challenge.Entity.Bundle;
import com.qublex.Challenge.Service.BundleService;
import com.qublex.Challenge.Service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("api/")
public class BundleController {
    @Autowired
    BundleService bundleService;

    @Autowired
    InventoryService inventoryService;

    @GetMapping("calculateBundleNumber")
    public ResponseEntity<Integer> calculateMaxBundle(@RequestParam("designation") String designation) throws Exception {
        int maxBundleNumber = bundleService.calculateMaxBundleNumber(designation);
        return ResponseEntity.ok(maxBundleNumber);
    }


    @PostMapping("addBundleStructure")
    public ResponseEntity<Bundle> addBundleStructure(@RequestBody Bundle bundle) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bundleService.createBundle(bundle));
    }
}
