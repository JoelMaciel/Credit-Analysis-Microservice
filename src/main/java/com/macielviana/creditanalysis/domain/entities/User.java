package com.macielviana.creditanalysis.domain.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class User {

    private UUID userId;

    private String name;
    private String lastName;
    private String cpf;
    private String phoneNumber;
    private Double income;
}
