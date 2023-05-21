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
    private String close_price;
    private String enter_price;
    private String exit_price;
    private String pnl_ratio_v1;
    private int trade_no;
    private String pnl_value;
    private String currency;
    private String base_currency;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private String trade_time;
    @PrePersist
    private void onCreate() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SSS");
        trade_time = dateFormat.format(date);
    }
}
