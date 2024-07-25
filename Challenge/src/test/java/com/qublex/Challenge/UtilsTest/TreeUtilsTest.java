package com.qublex.Challenge.UtilsTest;

import com.qublex.Challenge.Entity.BundleItem;
import com.qublex.Challenge.Entity.TreeNode;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static com.qublex.Challenge.Utils.readBundleTree;
import static com.qublex.Challenge.utils.TreeUtils.getSpareParts;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TreeUtilsTest {
    @Test
    void getSparePartsTest() throws Exception {
        TreeNode<BundleItem> bundleTree = readBundleTree("01/BundleTree.json");

        HashMap<String, Integer> spareParts = getSpareParts(bundleTree);

        assertNotNull(spareParts);
        assertEquals(4, spareParts.size());
        assertEquals(1, spareParts.get("Seat"));
    }


}
