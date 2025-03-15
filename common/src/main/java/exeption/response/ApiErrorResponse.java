package exeption.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;

import java.util.Map;

@Builder
public record ApiErrorResponse(
        int status,
        String code,
        String message,
        @JsonInclude(Include.NON_EMPTY)
        Map<String, Object> payload
) {}
