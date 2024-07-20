package com.macielviana.creditanalysis.domain.services.impl;

import com.macielviana.creditanalysis.domain.entities.Proposal;
import com.macielviana.creditanalysis.domain.services.strategy.CalculatePoint;
import org.springframework.stereotype.Component;

@Component
public class LessThanTenYearsImpl implements CalculatePoint {

    @Override
    public int calculate(Proposal proposal) {
        return proposal.getPaymentDeadline() < 120 ? 80 : 0;
    }
}
