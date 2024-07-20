package com.macielviana.creditanalysis.api.config.listeners;

import com.macielviana.creditanalysis.domain.entities.Proposal;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProposalInAnalysisListener {

    @RabbitListener(queues = "${rabbitmq.queue.proposal.pending}")
    public void proposalInAnalysis(Proposal proposal) {

    }
}
