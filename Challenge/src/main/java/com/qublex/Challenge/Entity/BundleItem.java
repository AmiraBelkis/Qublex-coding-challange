package com.qublex.Challenge.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BundleItem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BundleItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long BundleItemId;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Column(name = "item_number", nullable = false)
    private int itemNumber;

    public BundleItem(String designation, int itemNumber) {
        this.designation = designation;
        this.itemNumber = itemNumber;
    }


}
