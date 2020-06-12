package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Transaction {

    private Long id;

    private Double amount;

    private String reasons;

    private Long userId;

}
