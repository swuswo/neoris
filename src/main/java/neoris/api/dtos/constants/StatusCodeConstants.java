package neoris.api.dtos.constants;

import org.apache.http.HttpStatus;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum StatusCodeConstants {
    BAD_REQUEST("bad Request", HttpStatus.SC_BAD_REQUEST),
    CONFLICT("conflicting request", HttpStatus.SC_CONFLICT),
    CREATED("successful creation", HttpStatus.SC_CREATED),
    INTERNAL_SERVER_ERROR("server error", HttpStatus.SC_INTERNAL_SERVER_ERROR),
    OK_ENG("success response", HttpStatus.SC_OK),
    BAD_REQUEST_ENG("unsuccessful response", HttpStatus.SC_BAD_REQUEST);


    private final String key;
    private final int idValue;

    StatusCodeConstants(String key, int idValue) {
        this.key = key;
        this.idValue = idValue;
    }

    public static StatusCodeConstants getStatusCodeConstantKeys(String key) {
        return Arrays.stream(StatusCodeConstants.values()).filter(
                type -> type.getKey().equals(key)

        ).collect(Collectors.toList()).get(0);
    }

    public Object getKey() {
        return key;
    }

    public Integer getValue() {
        return idValue;
    }
}
