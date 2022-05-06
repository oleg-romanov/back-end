package itis.eventmaker.services;

import itis.eventmaker.dto.in.EventDto;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface EventService {
    ResponseEntity createEvent(String authorization, EventDto eventDto) throws ParseException;
    ResponseEntity getAllEvents(String authorization);
    ResponseEntity getEventById(String authorization, long id);
    ResponseEntity deleteEventById(String authorization, long id);
}