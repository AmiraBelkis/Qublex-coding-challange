package com.qublex.Challenge;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qublex.Challenge.Entity.BundleItem;
import com.qublex.Challenge.Entity.InventoryItem;
import com.qublex.Challenge.Entity.TreeNode;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Utils {

    public static HashMap<String, Object> readItemList(String filename) throws IOException {
        ClassPathResource resource = new ClassPathResource(filename);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(resource.getFile(), new TypeReference<HashMap<String, Object>>() {
        });
    }

    public static ArrayList<InventoryItem> readInventoryItemList(String filename) throws IOException {
        ClassPathResource resource = new ClassPathResource(filename);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(resource.getFile(), new TypeReference<ArrayList<InventoryItem>>() {
        });
    }

    public static TreeNode<BundleItem> readBundleTree(String filename) throws IOException {
        ClassPathResource resource = new ClassPathResource(filename);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(resource.getFile(), new TypeReference<TreeNode<BundleItem>>() {
        });

    }
}
