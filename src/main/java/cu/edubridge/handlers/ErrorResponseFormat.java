package cu.edubridge.handlers;

import cu.edubridge.validations.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponseFormat {
    private ErrorCode errorCode;
    private String errorMessage;
    private Instant timestamp;
}
