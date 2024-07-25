package com.qublex.Challenge.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bundle {
    private String designation;
    private TreeNode<BundleItem> root;

    public Bundle(String designation){
        this.designation = designation;
        this.root = new TreeNode<BundleItem>(
                new BundleItem(designation,1)
        );
    }
}
