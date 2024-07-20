package com.macielviana.creditanalysis.domain.services.strategy;

import com.macielviana.creditanalysis.domain.entities.Proposal;

public interface CalculatePoint {

    int calculate(Proposal proposal);
}
