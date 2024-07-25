package com.qublex.Challenge.Service;

import com.qublex.Challenge.Entity.Bundle;
import com.qublex.Challenge.Entity.InventoryItem;

import java.util.List;

public interface BundleService {
    int calculateMaxBundleNumber(Bundle bundle, List<InventoryItem> inventory) throws Exception;
}
