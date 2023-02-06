package neoris.api.dtos.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@lombok.Data
public class Users {
    private Integer id;
    private Date createdAt;
}
