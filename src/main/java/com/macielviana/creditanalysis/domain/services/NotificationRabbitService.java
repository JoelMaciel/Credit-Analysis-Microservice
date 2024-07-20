package com.macielviana.creditanalysis.domain.services;

import com.macielviana.creditanalysis.domain.entities.Proposal;

public interface NotificationRabbitService {

    void notification(String exchange, Proposal proposal);
}
