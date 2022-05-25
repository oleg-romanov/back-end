package itis.eventmaker.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import itis.eventmaker.dto.out.UserDtoOut;
import itis.eventmaker.model.Event;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
}
