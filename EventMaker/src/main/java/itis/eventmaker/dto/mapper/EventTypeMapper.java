package itis.eventmaker.dto.mapper;

import itis.eventmaker.dto.in.EventTypeDto;
import itis.eventmaker.dto.out.EventTypeOutDto;
import itis.eventmaker.model.EventType;
import itis.eventmaker.security.JwtHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventTypeMapper {

    @Autowired
    itis.eventmaker.dto.mapper.EventMapper eventMapper;

    @Autowired
    JwtHelper jwtHelper;

    @Autowired
    UserMapper userMapper;

    public EventType toEventTypeConverter(EventTypeDto eventTypeDto) {
        return toEventTypeConverter(eventTypeDto, new EventType());
    }

    public EventType toEventTypeConverter(EventTypeDto eventTypeDto, EventType eventType) {
        eventType.setId(eventType.getId());
        eventType.setName(eventType.getName());
        return eventType;
    }

    public EventTypeOutDto toEventTypeOutDtoConvert(EventType eventType) {
        EventTypeOutDto eventTypeOutDto = new EventTypeOutDto();
        eventTypeOutDto.setId(eventType.getId());
        eventTypeOutDto.setName(eventType.getName());
        eventTypeOutDto.setUser(userMapper.toUserDtoOut(eventType.getUser()));
        eventTypeOutDto.setEvents(
                eventType.getEvents()
                        .stream()
                        .map(event -> event.getName() + "#" + event.getId())
                        .collect(Collectors.toList())
        );
        return eventTypeOutDto;

    }

    public EventTypeDto toEventTypeDtoConvert(EventType eventType) {
        EventTypeDto eventTypeDto = new EventTypeDto();
        eventTypeDto.setId(eventType.getId());
        eventTypeDto.setName(eventType.getName());
        return eventTypeDto;
    }

    public List<EventType> toEventTypeList(List<EventTypeDto> eventTypeDtos) {
        return eventTypeDtos
                .stream()
                .map(this::toEventTypeConverter)
                .collect(Collectors.toList());
    }

    public List<EventTypeOutDto> toEventTypeDtoList(List<EventType> eventTypes) {
        return eventTypes
                .stream()
                .map(this::toEventTypeOutDtoConvert)
                .collect(Collectors.toList());
    }
}
