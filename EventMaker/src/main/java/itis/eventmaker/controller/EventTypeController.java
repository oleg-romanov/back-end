package itis.eventmaker.controller;

import itis.eventmaker.dto.in.EventTypeDto;
import itis.eventmaker.services.EventTypeService;
import itis.eventmaker.utils.ResponseCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/type")
@AllArgsConstructor
public class EventTypeController extends ResponseCreator {

    private final EventTypeService eventTypeService;

    @PostMapping
    ResponseEntity createEventType(@RequestHeader String authorization, @RequestBody EventTypeDto eventTypeDto) {
        return eventTypeService.createEventType(authorization, eventTypeDto);
    }

    @GetMapping
    ResponseEntity getAllEventTypes(@RequestHeader String authorization) {
        return eventTypeService.getAllEventTypes(authorization);
    }

    @GetMapping(path = "/{id}")
    ResponseEntity getEventTypeById(@RequestHeader String authorization, @PathVariable long id) {
        return eventTypeService.getEventTypeById(authorization, id);
    }


    @PutMapping(path = "/{id}")
    ResponseEntity updateEventTypeById(@RequestHeader String authorization, @PathVariable long id, @RequestBody EventTypeDto eventTypeDto) {
        return eventTypeService.updateEventTypeById(authorization, id, eventTypeDto);
    }


    @DeleteMapping(path = "/{id}")
    ResponseEntity deleteEventTypeById(@RequestHeader String authorization, @PathVariable long id) {
        return eventTypeService.deleteEventTypeById(authorization, id);
    }
}