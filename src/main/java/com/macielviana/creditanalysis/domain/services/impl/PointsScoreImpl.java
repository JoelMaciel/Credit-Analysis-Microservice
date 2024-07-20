package com.macielviana.creditanalysis.domain.services.impl;

import com.macielviana.creditanalysis.domain.constants.MessageConstant;
import com.macielviana.creditanalysis.domain.entities.Proposal;
import com.macielviana.creditanalysis.domain.services.strategy.CalculatePoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Random;

@Order(2)
@Component
public class PointsScoreImpl implements CalculatePoint {

    @Override
    public int calculate(Proposal proposal) {
        int score = findScore();
        if (score <= 200) {
            throw new SecurityException(String.format(
                    MessageConstant.POINT_SCORE_DOWN , proposal.getUser().getName()));
        }

        return switch (score / 200) {
            case 1 -> 150;
            case 2, 3 -> 180;
            default -> 200;
        };
    }

    private int findScore() {
        return new Random().nextInt(1000);
    }
}
