package itis.eventmaker.dto.out;

import itis.eventmaker.dto.in.CategoryDto;
import itis.eventmaker.dto.in.EventDto;
import itis.eventmaker.dto.in.EventTypeDto;
import itis.eventmaker.model.Event;
import itis.eventmaker.services.EventService;
import itis.eventmaker.services.impl.EventServiceImpl;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventOutDto {
    private long id;
    private String name;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
    private EventTypeDto eventType;
    private CategoryDto category;
    private UserDtoOut user;
    private List<UserDtoOut> participants;

    public static EventOutDto of(Event event) {
        return EventOutDto.builder()
                .id(event.getId())
                .name(event.getName())
                .description(event.getDescription())
                .date(String.valueOf(event.getDate()))
                .eventType(EventTypeDto.builder()
                        .id(event.getEventType().getId())
                        .name(event.getEventType().getName())
                        .build())
                .category(CategoryDto.builder()
                        .id(event.getCategory().getId())
                        .name(event.getCategory().getName())
                        .build())
                .user(UserDtoOut.builder()
                        .name(event.getUser().getName())
                        .build())
                .participants(null)
                .build();
    }

    public static List<EventOutDto> from(List<Event> services) {
        return services.stream()
                .map(EventOutDto::of)
                .collect(Collectors.toList());
    }
}