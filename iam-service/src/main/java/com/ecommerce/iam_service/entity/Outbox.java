package com.ecommerce.iam_service.entity;

import com.ecommerce.iam_service.constant.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table("outbox")
public class Outbox {

    @Id
    private UUID id;

    @Column("aggregate_type")
    private String aggregateType;

    @Column("aggregate_id")
    private String aggregateId;

    @Column("event_type")
    private String eventType;

    private String payload;

    private String status;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("locked_at")
    private LocalDateTime lockedAt;

    @Column("published_at")
    private LocalDateTime publishedAt;

    @Column("retry_count")
    private int retryCount;

    private String error;

    public static Outbox getOutboxWithDefaults() {
        return Outbox.builder()
                .id(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .retryCount(0)
                .build();
    }

}
