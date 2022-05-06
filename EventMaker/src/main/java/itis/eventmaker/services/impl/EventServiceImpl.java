package itis.eventmaker.services.impl;

import itis.eventmaker.dto.in.EventDto;
import itis.eventmaker.dto.mapper.EventMapper;
import itis.eventmaker.dto.mapper.EventTypeMapper;
import itis.eventmaker.exceptions.NotFoundException;
import itis.eventmaker.model.Category;
import itis.eventmaker.model.Event;
import itis.eventmaker.model.EventType;
import itis.eventmaker.model.User;
import itis.eventmaker.repositories.CategoryRepository;
import itis.eventmaker.repositories.EventRepository;
import itis.eventmaker.repositories.EventTypeRepository;
import itis.eventmaker.security.JwtHelper;
import itis.eventmaker.services.EventService;
import itis.eventmaker.utils.ErrorEntity;
import itis.eventmaker.utils.ResponseCreator;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class EventServiceImpl extends ResponseCreator implements EventService {

    private final EventRepository eventRepository;
    private final JwtHelper jwtHelper;
    private final CategoryRepository categoryRepository;
    private final EventTypeRepository eventTypeRepository;
    private final EventMapper eventMapper;
    private final EventTypeMapper eventTypeMapper;

    @Override
    public ResponseEntity createEvent(String authorization, EventDto eventDto) throws ParseException {
        User user = jwtHelper.getUserFromHeader(authorization);
        String eventNameDto = eventDto.getName();
        String convertedEventName = eventNameDto.substring(0, 1).toUpperCase() + eventNameDto.substring(1).toLowerCase();
        Optional<Event> optionalUserEvent = eventRepository.findByNameAndUserId(convertedEventName, user);
        if (optionalUserEvent.isPresent()) {
            return createErrorResponse(ErrorEntity.EVENT_ALREADY_CREATED);
        }

        Category category = categoryRepository.findById(eventDto.getCategoryId()).orElseThrow(NotFoundException::new);

        EventType eventType = eventTypeRepository.findById(eventDto.getEventTypeId()).orElseThrow(NotFoundException::new);

        Event event = Event.builder()
                .name(convertedEventName)
                .description(eventDto.getDescription())
                .date(eventDto.getDate())
                .category(category)
                .eventType(eventType)
                .user(user)
                .users(Collections.emptyList())
                .build();
        eventRepository.save(event);
        return createGoodResponse(eventMapper.toEventOutDtoConvert(event));
    }

    @Override
    public ResponseEntity getAllEvents(String authorization) {
        Long userId = jwtHelper.getUserFromHeader(authorization).getId();
        List<Event> events = eventRepository.findAllByUserId(userId);
        return createGoodResponse(eventMapper.toEventDtoList(events));
    }

    @Override
    public ResponseEntity getEventById(String authorization, long id) {
        Long userId = jwtHelper.getUserFromHeader(authorization).getId();
        return createGoodResponse(eventMapper.toEventOutDtoConvert(eventRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new NotFoundException("Event with id " + id + " not found"))));
    }

    @Override
    public ResponseEntity deleteEventById(String authorization, long id) {
        Long userId = jwtHelper.getUserFromHeader(authorization).getId();
        eventRepository.delete(eventRepository.findByIdAndUserId(id, userId)
                .orElseThrow(() -> new NotFoundException("Event with id " + id + " not found")));
        return createGoodResponse("Deleted");
    }
}
