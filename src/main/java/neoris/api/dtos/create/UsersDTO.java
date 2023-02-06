package neoris.api.dtos.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuppressWarnings("java:S1068")
public class UsersDTO {
    private String names;
    private String job;
}
