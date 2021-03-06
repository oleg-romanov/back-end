package itis.eventmaker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class FileSavingException extends RuntimeException {
    public FileSavingException(String message) {
        super(message);
    }
}