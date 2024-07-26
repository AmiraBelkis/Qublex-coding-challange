package com.qublex.Challenge.Service;


import com.qublex.Challenge.Entity.Bundle;
import com.qublex.Challenge.Entity.TreeNode;
import com.qublex.Challenge.Exception.ItemNotExistException;
import com.qublex.Challenge.Repository.BundleItemRepository;
import com.qublex.Challenge.Repository.BundleRepository;
import com.qublex.Challenge.Repository.TreeNodeRepository;
import com.qublex.Challenge.utils.TreeUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BundleServiceImpl implements BundleService {

    @Autowired
    private BundleRepository bundleRepository;

    @Autowired
    private BundleItemRepository bundleItemRepository;
    @Autowired
    private TreeNodeRepository treeNodeRepository;

    @Autowired
    private InventoryService inventoryService;

    public static int updateFinishedBundlesNumber(int stock, int nbSpareParts, int prevBundleMax) {
        if (prevBundleMax != -1) {
            return Math.min((int) stock / nbSpareParts, prevBundleMax);
        } else {
            return (int) stock / nbSpareParts;
        }
    }

    //@Override
    @Transactional
    public int calculateMaxBundleNumber(String designation) throws Exception {
        Bundle bundle = bundleRepository.findByDesignation(designation).orElseThrow(
                () -> new ItemNotExistException("No bundle with the specified designation were found in the database.", designation)
        );
        HashMap<String, Integer> spareParts = TreeUtils.getSpareParts(
                bundle.getRoot()
        );
        int maxBundle = -1;
        for (Map.Entry<String, Integer> entry : spareParts.entrySet()) {
            int stock = inventoryService.getInventoryStock(entry.getKey());
            maxBundle = updateFinishedBundlesNumber(stock, entry.getValue(), maxBundle);
        }
        return maxBundle;
    }

    public Bundle createBundle(Bundle bundle) {
        createBundleItems(bundle.getRoot());
        return bundleRepository.save(bundle);
    }

    private void createBundleItems(TreeNode treeNode) {
        if (treeNode != null) {
            bundleItemRepository.save(treeNode.getData());
            treeNode.getChildren().forEach(this::createBundleItems);
            treeNodeRepository.save(treeNode);
        }
    }
}
