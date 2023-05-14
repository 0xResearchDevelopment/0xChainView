package com.gtsrd.chainview.controller;

import com.gtsrd.chainview.model.Event;
import com.gtsrd.chainview.response.ApiResponse;
import com.gtsrd.chainview.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping("/eventCapture")
    public ApiResponse eventCapture(@RequestBody Event event) {
        return eventService.saveChainEvent(event);
    }

    @GetMapping("/eventsRetrive")
    public List<Event> retriveEvents() {
        return eventService.getEvents();
    }

}
