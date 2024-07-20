package com.macielviana.creditanalysis.domain.services.impl;

import com.macielviana.creditanalysis.domain.entities.Proposal;
import com.macielviana.creditanalysis.domain.exceptions.StrategyException;
import com.macielviana.creditanalysis.domain.services.AnalysisCreditService;
import com.macielviana.creditanalysis.domain.services.NotificationRabbitService;
import com.macielviana.creditanalysis.domain.services.strategy.CalculatePoint;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalysisCreditServiceImpl implements AnalysisCreditService {

    public static final String SUCCESSFULLY = "Proposal approved successfully";
    private final List<CalculatePoint> calculatePointList;
    private final NotificationRabbitService notificationRabbitService;

    @Value("${rabbitmq.proposal-concluded.exchange}")
    private String exchangeConcluded;

    @Override
    public void analysis(Proposal proposal) {
        try {
            int points = calculatePointList.stream()
                    .mapToInt(impl -> impl.calculate(proposal)).sum();
            setProposalApprovedAndObservation(proposal, points > 350, SUCCESSFULLY);
        } catch (StrategyException exception) {
            setProposalApprovedAndObservation(proposal, false, exception.getMessage());
        }
        notificationRabbitService.notification(exchangeConcluded, proposal);
    }

    private void setProposalApprovedAndObservation(Proposal proposal, boolean approved, String message) {
        proposal.setApproved(approved);
        proposal.setObservation(message);
    }
}
