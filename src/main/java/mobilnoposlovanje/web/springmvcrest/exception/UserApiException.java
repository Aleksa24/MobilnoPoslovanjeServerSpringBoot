package mobilnoposlovanje.web.springmvcrest.exception;

public class UserApiException extends RuntimeException{
    public UserApiException(String message) {
        super(message);
    }
}
