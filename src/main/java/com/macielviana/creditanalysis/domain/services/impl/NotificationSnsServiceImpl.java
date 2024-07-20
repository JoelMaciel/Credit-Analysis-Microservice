package com.macielviana.creditanalysis.domain.services.impl;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.macielviana.notification.domain.services.NotificationSnsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NotificationSnsServiceImpl implements NotificationSnsService {

    private final AmazonSNS amazonSNS;

    @Override
    public void notification(String phoneNumber, String message) {
        PublishRequest publishRequest = new PublishRequest().withMessage(message).withPhoneNumber(phoneNumber);
        amazonSNS.publish(publishRequest);
    }
}
