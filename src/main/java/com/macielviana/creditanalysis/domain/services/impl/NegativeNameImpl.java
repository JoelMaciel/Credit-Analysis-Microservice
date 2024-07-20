package com.macielviana.creditanalysis.domain.services.impl;

import com.macielviana.creditanalysis.domain.constants.MessageConstant;
import com.macielviana.creditanalysis.domain.entities.Proposal;
import com.macielviana.creditanalysis.domain.exceptions.StrategyException;
import com.macielviana.creditanalysis.domain.services.strategy.CalculatePoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(1)
@Component
public class NegativeNameImpl implements CalculatePoint {

    @Override
    public int calculate(Proposal proposal) {
        if (negativeName()) {
            throw new StrategyException(String.format(
                    MessageConstant.CLIENT_NEGATIVE, proposal.getUser().getName())
            );
        }
        return 100;
    }

    private boolean negativeName() {
        return new Random().nextBoolean();
    }
}
