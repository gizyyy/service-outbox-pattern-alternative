package com.example.gizem.yilmaz.domain.event;

import java.time.Instant;

public record StudentAddedEvent(long studentId, String studentName, Instant occurredAt) {
}
