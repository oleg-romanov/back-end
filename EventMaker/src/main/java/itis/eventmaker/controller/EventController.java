package itis.eventmaker.controller;

import itis.eventmaker.dto.in.EventDto;
import itis.eventmaker.services.EventService;
import itis.eventmaker.utils.ResponseCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;


@RestController
@RequestMapping(path = "/event")
@AllArgsConstructor
public class EventController extends ResponseCreator {

    private final EventService eventService;

    @PostMapping
    ResponseEntity createEvent(@RequestHeader String authorization, @Validated @RequestBody EventDto eventDto) throws ParseException {
        return eventService.createEvent(authorization, eventDto);
    }

    @GetMapping
    ResponseEntity getAllEvents(@RequestHeader String authorization) {
        return eventService.getAllEvents(authorization);
   }

    @GetMapping(path = "/{id}")
    ResponseEntity getEventById(@RequestHeader String authorization, @PathVariable long id) {
        return eventService.getEventById(authorization, id);
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity deleteEventById(@RequestHeader String authorization, @PathVariable long id) {
        return eventService.deleteEventById(authorization, id);
    }
}