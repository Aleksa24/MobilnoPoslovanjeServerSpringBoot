package mobilnoposlovanje.web.springmvcrest.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class UserException {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime time;

    public UserException(String message, HttpStatus httpStatus, ZonedDateTime time) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTime() {
        return time;
    }
}
