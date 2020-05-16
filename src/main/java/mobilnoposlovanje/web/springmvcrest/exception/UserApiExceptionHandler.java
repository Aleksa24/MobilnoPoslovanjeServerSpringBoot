package mobilnoposlovanje.web.springmvcrest.exception;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class UserApiExceptionHandler {

    @ExceptionHandler(value = {UserApiException.class})
    public ResponseEntity<Object> handleApiRequestException(UserApiException e){
        //create payload containing exceptiuon details
        UserException userException = new UserException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        //return response entity
        return new ResponseEntity<>(userException,HttpStatus.BAD_REQUEST);
    }
}
