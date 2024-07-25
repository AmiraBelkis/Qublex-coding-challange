package com.qublex.Challenge.Entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryItem {
    private String designation;
    private int stockUnits;

}
