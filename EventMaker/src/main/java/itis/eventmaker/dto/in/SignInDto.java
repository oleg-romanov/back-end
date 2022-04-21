package itis.eventmaker.dto.in;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
    private String email;
    private String password;
}
