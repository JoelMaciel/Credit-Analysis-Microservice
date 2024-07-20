package com.macielviana.creditanalysis.api.config.listeners;

import com.macielviana.creditanalysis.domain.entities.Proposal;
import com.macielviana.creditanalysis.domain.services.AnalysisCreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class ProposalInAnalysisListener {

    private final AnalysisCreditService analysisCreditService;

    @RabbitListener(queues = "${rabbitmq.queue.proposal.pending}")
    public void proposalInAnalysis(Proposal proposal) {
        analysisCreditService.analysis(proposal);
    }
}
