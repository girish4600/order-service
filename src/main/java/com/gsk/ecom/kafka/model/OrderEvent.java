package com.gsk.ecom.kafka.model;

import java.time.Instant;

public record OrderEvent(
        String eventType,
        Integer eventVersion,
        String eventId,
        Instant timestamp,
        OrderNotificationRequest data
) {
}