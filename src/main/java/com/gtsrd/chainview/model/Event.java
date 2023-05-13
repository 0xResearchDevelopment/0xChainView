package com.gtsrd.chainview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    private BigDecimal close_price;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private String event_timestamp;

    @PrePersist
    private void onCreate() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS");
        event_timestamp = dateFormat.format(date);
    }
}
