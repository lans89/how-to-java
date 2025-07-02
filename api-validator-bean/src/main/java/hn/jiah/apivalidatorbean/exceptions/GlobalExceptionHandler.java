package hn.jiah.apivalidatorbean.exceptions;

import hn.jiah.apivalidatorbean.dto.ResultPojo;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultPojo handleValidationExceptions(MethodArgumentNotValidException ex){
        String message = "";
        var errors = ex.getBindingResult().getAllErrors();
        if(!errors.isEmpty())
            message = errors.getFirst().getDefaultMessage();
        return ResultPojo.builder()
                .code(99)
                .message(message).build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UnexpectedTypeException.class)
    public ResultPojo handleUnexpectedTypeExceptions(UnexpectedTypeException ex){
        return ResultPojo.builder()
                .code(98)
                .message(ex.getMessage()).build();
    }

}
