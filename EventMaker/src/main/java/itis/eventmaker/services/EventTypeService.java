package itis.eventmaker.services;

import itis.eventmaker.dto.in.EventTypeDto;
import org.springframework.http.ResponseEntity;

public interface EventTypeService {
    ResponseEntity createEventType(String authorization, EventTypeDto eventTypeDto);
    ResponseEntity getAllEventTypes(String authorization);
    ResponseEntity getEventTypeById(String authorization, long id);
    ResponseEntity updateEventTypeById(String authorization, long id, EventTypeDto eventTypeDto);
    ResponseEntity deleteEventTypeById(String authorization, long id);
}