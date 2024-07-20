package com.macielviana.creditanalysis.domain.services.impl;

import com.macielviana.creditanalysis.domain.entities.Proposal;
import com.macielviana.creditanalysis.domain.services.NotificationRabbitService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationRabbitServiceImpl implements NotificationRabbitService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void notification(String exchange, Proposal proposal) {
        rabbitTemplate.convertAndSend(exchange, "", proposal);

    }
}
