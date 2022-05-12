package itis.eventmaker.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import itis.eventmaker.model.Event;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private String name;
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Long eventTypeId;
    private Long categoryId;

    public static EventDto of(Event event) {
        return EventDto.builder()
                .name(event.getName())
                .description(event.getDescription())
                .date(event.getDate())
                .eventTypeId(event.getEventType().getId())
                .categoryId(event.getCategory().getId())
                .build();
    }

    public static List<EventDto> from(List<Event> services) {
        return services.stream()
                .map(EventDto::of)
                .collect(Collectors.toList());
    }
}
