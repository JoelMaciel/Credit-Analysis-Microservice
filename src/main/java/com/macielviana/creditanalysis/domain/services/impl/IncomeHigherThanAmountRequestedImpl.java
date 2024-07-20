package com.macielviana.creditanalysis.domain.services.impl;

import com.macielviana.creditanalysis.domain.entities.Proposal;
import com.macielviana.creditanalysis.domain.services.strategy.CalculatePoint;
import org.springframework.stereotype.Component;

@Component
public class IncomeHigherThanAmountRequestedImpl implements CalculatePoint {

    @Override
    public int calculate(Proposal proposal) {
        return incomeHigherThanAmountRequested(proposal) ? 100 : 0;
    }

    private boolean incomeHigherThanAmountRequested(Proposal proposal) {
        return  proposal.getUser().getIncome() > proposal.getAmountRequested();
    }
}
