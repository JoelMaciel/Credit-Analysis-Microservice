package com.macielviana.creditanalysis.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Proposal {

    private UUID proposalId;
    private Double amountRequested;
    private int paymentDeadline;
    private Boolean approved;
    private boolean integrated;
    private String observation;
    private User user;
}
