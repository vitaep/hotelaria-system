package dev.vitaep.hotelariaSystem.infra;

import dev.vitaep.hotelariaSystem.exceptions.HotelException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(HotelException.class)
    public ProblemDetail handleHotelException(HotelException e){
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        var fieldErrors = e.getFieldErrors().stream()
                .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()))
                .toList();

        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Os parametros da sua requisição não foram validados");
        pb.setProperty("invalid-params", fieldErrors);

        return pb;
    }

    public record InvalidParam(String getField, String reason){}

}
