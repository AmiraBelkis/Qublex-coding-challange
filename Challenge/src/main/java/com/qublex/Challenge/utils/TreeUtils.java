package com.qublex.Challenge.utils;

import com.qublex.Challenge.Entity.TreeNode;

import java.util.HashMap;

public class TreeUtils {

    public static HashMap<String, Integer> getSpareParts(TreeNode node) {
        HashMap<String, Integer> results = new HashMap<String, Integer>();
        multiplyHelper(node, 1, results);
        return results;
    }

    private static void multiplyHelper(TreeNode node, int product, HashMap<String, Integer> results) {
        if (node == null) {
            return;
        }

        product *= node.getData().getItemNumber();

        if (node.getChildren().isEmpty()) {
            results.put(node.getData().getDesignation(), product);
        } else {
            for (TreeNode child : node.getChildren()) {
                multiplyHelper(child, product, results);
            }
        }
    }

}
