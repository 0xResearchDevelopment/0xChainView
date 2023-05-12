CREATE TABLE chainviewdb.`chain_event_data` (
  `event_id` int NOT NULL AUTO_INCREMENT,
  `platform` varchar(50) DEFAULT NULL,
  `symbol` varchar(50) DEFAULT NULL,
  `timeframe` varchar(50) DEFAULT NULL,
  `action_type` varchar(50) DEFAULT NULL,
  `close_price` decimal(10,10) DEFAULT NULL,
  `event_timestamp` datetime(3) DEFAULT NULL,
  PRIMARY KEY (`event_id`)
)

