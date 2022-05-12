package itis.eventmaker.services;

import itis.eventmaker.dto.in.EventDto;
import itis.eventmaker.model.Category;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;

public interface EventService {
    ResponseEntity createEvent(String authorization, EventDto eventDto) throws ParseException;
    ResponseEntity updateEventById(String authorization, EventDto eventDto, long id);
    ResponseEntity getAllEvents(String authorization);
    ResponseEntity getEventById(String authorization, long id);
    ResponseEntity deleteEventById(String authorization, long id);
    List<EventDto> search(Integer size, Integer page, String query, String sort, String direction);
}