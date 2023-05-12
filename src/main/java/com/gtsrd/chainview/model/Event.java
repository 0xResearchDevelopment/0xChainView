package com.gtsrd.chainview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chain_event_data")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;

    private String platform;
    private String symbol;
    private String timeframe;
    private String action_type;
    private Float close_price;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date event_timestamp;

    @PrePersist
    private void onCreate() {
        event_timestamp = new Date();
    }
}
