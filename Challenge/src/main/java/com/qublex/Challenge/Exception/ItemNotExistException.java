package com.qublex.Challenge.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ItemNotExistException extends Exception {
    private String message;
    private String wrongDesignation;
}
