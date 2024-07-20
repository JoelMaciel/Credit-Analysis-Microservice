package com.macielviana.creditanalysis.domain.services.impl;

import com.macielviana.creditanalysis.domain.entities.Proposal;
import com.macielviana.creditanalysis.domain.services.strategy.CalculatePoint;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OngoingLoansImpl implements CalculatePoint {

    @Override
    public int calculate(Proposal proposal) {
        return findOngoingLoans() ? 0 : 80;
    }

    private boolean findOngoingLoans() {
        return new Random().nextBoolean();
    }
}
