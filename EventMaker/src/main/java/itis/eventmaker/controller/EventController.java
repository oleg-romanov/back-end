package itis.eventmaker.controller;

import itis.eventmaker.dto.in.EventDto;
import itis.eventmaker.dto.out.EventOutDto;
import itis.eventmaker.services.EventService;
import itis.eventmaker.utils.ResponseCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.util.List;


@RestController
@RequestMapping(path = "/event")
@AllArgsConstructor
public class EventController extends ResponseCreator {

    private final EventService eventService;

    @PostMapping
    ResponseEntity createEvent(@RequestHeader String authorization, @Validated @RequestBody EventDto eventDto) throws ParseException {
        return eventService.createEvent(authorization, eventDto);
    }

    @PutMapping(path = "/{id}")
    ResponseEntity updateEventById(@RequestHeader String authorization, @RequestBody EventDto eventDto, @PathVariable long id) {
        return eventService.updateEventById(authorization, eventDto, id);
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

    @GetMapping("/list/search")
    @ResponseBody
    ResponseEntity<List<EventOutDto>> search(@RequestParam("page") Integer page,
                                                 @RequestParam("size") Integer size,
                                                 @RequestParam(value = "q", required = false) String query,
                                                 @RequestParam(value = "sort", required = false) String sort,
                                                 @RequestParam(value = "direction", required = false) String direction) {
        return ResponseEntity.ok(eventService.search(size, page, query, sort, direction));
    }
}