package com.gtsrd.chainview.service;

import com.gtsrd.chainview.model.Event;
import com.gtsrd.chainview.repository.EventRepository;
import com.gtsrd.chainview.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return eventRepository.findAll();
    }
}
