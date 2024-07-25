package com.qublex.Challenge.utils;

import com.qublex.Challenge.Entity.BundleItem;
import com.qublex.Challenge.Entity.TreeNode;

import java.util.HashMap;

public class TreeUtils {

    public static HashMap<String, Integer> getSpareParts(TreeNode<BundleItem> node) {
        HashMap<String, Integer> results = new HashMap<String, Integer>();
        multiplyHelper(node, 1, results);
        return results;
    }

    private static void multiplyHelper(TreeNode<BundleItem> node, int product, HashMap<String, Integer> results) {
        if (node == null) {
            return;
        }

        product *= node.getData().getItemNumber();

        if (node.getChildren().isEmpty()) {
            results.put(node.getData().getDesignation(), product);
        } else {
            for (TreeNode<BundleItem> child : node.getChildren()) {
                multiplyHelper(child, product, results);
            }
        }
    }

}
