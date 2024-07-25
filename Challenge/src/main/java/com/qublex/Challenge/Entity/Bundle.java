package com.qublex.Challenge.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Bundle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BundleId;

    @Column(name = "designation", nullable = false)
    private String designation;

    @OneToOne
    @JoinColumn(name = "root_id", referencedColumnName = "treeNodeId")
    private TreeNode root;

    public Bundle(String designation) {
        this.designation = designation;
        this.root = new TreeNode(
                new BundleItem(designation, 1)
        );
    }
}
