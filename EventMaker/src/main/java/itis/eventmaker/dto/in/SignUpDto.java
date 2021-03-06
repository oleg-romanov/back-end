package itis.eventmaker.dto.in;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpDto {
    private String name;
    private String email;
    private String password;
}
