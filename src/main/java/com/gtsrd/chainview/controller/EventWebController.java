package com.gtsrd.chainview.controller;

import com.gtsrd.chainview.model.Event;
import com.gtsrd.chainview.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventWebController {
    @Autowired
    private EventService eventService;

    @GetMapping("/events")
    public String listEvents(Model model) {
        model.addAttribute("events", eventService.getEvents());
        return "events";
    }

    @GetMapping("/addEvent")
    public String showAddEventForm(Model model) {

        // create event object to hold event form data
        Event event = new Event();
        model.addAttribute("event", event);
        return "create_event";
    }

    @PostMapping("/createEvent")
    public String saveEvent(@ModelAttribute("event") Event event) {
        eventService.saveChainEvent(event);
        return "redirect:/events";
    }
}
