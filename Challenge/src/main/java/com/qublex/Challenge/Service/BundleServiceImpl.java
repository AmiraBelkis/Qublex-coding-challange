package com.qublex.Challenge.Service;


import com.qublex.Challenge.Entity.Bundle;
import com.qublex.Challenge.Entity.InventoryItem;
import com.qublex.Challenge.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BundleServiceImpl implements BundleService {

    @Autowired
    private InventoryService inventoryService;

    public static int updateFinishedBundlesNumber(int stock, int nbSpareParts, int prevBundleMax) {
        if (prevBundleMax != -1) {
            return Math.min((int) stock / nbSpareParts, prevBundleMax);
        } else {
            return (int) stock / nbSpareParts;
        }
    }

    @Override
    public int calculateMaxBundleNumber(Bundle bundle, List<InventoryItem> inventory) throws Exception {
        inventoryService.fillInventoryFrom(inventory);
        HashMap<String, Integer> spareParts = TreeUtils.getSpareParts(bundle.getRoot());
        int maxBundle = -1;
        for (Map.Entry<String, Integer> entry : spareParts.entrySet()) {
            int stock = inventoryService.getInventoryStock(entry.getKey());
            maxBundle = updateFinishedBundlesNumber(stock, entry.getValue(), maxBundle);
        }
        return maxBundle;
    }

}
