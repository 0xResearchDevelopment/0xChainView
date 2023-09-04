package com.gtsrd.chainview.service;

import com.gtsrd.chainview.model.Event;
import com.gtsrd.chainview.repository.EventRepository;
import com.gtsrd.chainview.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public ApiResponse saveChainEvent(Event event) {
        eventRepository.save(event);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Chain Event data saved successfully!");
        return apiResponse;
    }

    public List<Event> getEvents() {
        //return eventRepository.findAll();

        Event eventData;
        Event eventDataModified = new Event();
        List<Event> eventListModified = new ArrayList<>();
        List<Event> eventList = eventRepository.findAll();

        for(int i=0;i<eventList.size();i++){
            eventData = eventList.get(i);
            eventDataModified.setEvent_id(eventData.getEvent_id());
            eventDataModified.setPlatform(eventData.getPlatform());
            eventDataModified.setSymbol(eventData.getSymbol());
            eventDataModified.setTimeframe(eventData.getTimeframe());
            eventDataModified.setAction_type(eventData.getAction_type());
            if(eventData.getClose_price() != null)
                eventDataModified.setClose_price(new BigDecimal(eventData.getClose_price()).stripTrailingZeros().toPlainString());
            else
                eventDataModified.setClose_price(eventData.getClose_price());

            if(eventData.getEnter_price() != null)
                eventDataModified.setEnter_price(new BigDecimal(eventData.getEnter_price()).stripTrailingZeros().toPlainString());
            else
                eventDataModified.setEnter_price(eventData.getEnter_price());

            if(eventData.getExit_price() != null)
                eventDataModified.setExit_price(new BigDecimal(eventData.getExit_price()).stripTrailingZeros().toPlainString());
            else
                eventDataModified.setExit_price(eventData.getExit_price());

            if(eventData.getPnl_ratio_v1() != null)
                eventDataModified.setPnl_ratio_v1(new BigDecimal(eventData.getPnl_ratio_v1()).stripTrailingZeros().toPlainString());
            else
                eventDataModified.setPnl_ratio_v1(eventData.getPnl_ratio_v1());

            eventDataModified.setTrade_no(eventData.getTrade_no());
            eventDataModified.setTrade_time(eventData.getTrade_time());

            if(eventData.getPnl_value() != null)
                eventDataModified.setPnl_value(new BigDecimal(eventData.getPnl_value()).stripTrailingZeros().toPlainString());
            else
                eventDataModified.setPnl_value(eventData.getPnl_value());

            eventDataModified.setCurrency(eventData.getCurrency());
            eventDataModified.setBase_currency(eventData.getBase_currency());
            eventListModified.add(eventDataModified);
            eventDataModified = new Event();
        }
        return eventListModified;
    }
}
