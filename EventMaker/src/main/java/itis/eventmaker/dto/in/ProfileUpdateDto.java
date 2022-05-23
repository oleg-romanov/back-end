package itis.eventmaker.dto.in;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileUpdateDto {
    private String name;
    private String password;
}
