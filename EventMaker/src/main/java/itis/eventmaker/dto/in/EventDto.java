package itis.eventmaker.dto.in;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
