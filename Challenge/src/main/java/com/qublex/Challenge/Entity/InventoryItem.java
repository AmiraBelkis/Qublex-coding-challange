package com.qublex.Challenge.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long InventoryItemId;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Column(name = "stock_units", nullable = false)
    private int stockUnits;

}
