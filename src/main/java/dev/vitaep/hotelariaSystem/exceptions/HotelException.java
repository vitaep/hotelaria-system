package dev.vitaep.hotelariaSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class HotelException extends RuntimeException{

    public ProblemDetail toProblemDetail(){
        var pb = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pb.setTitle("Hotel internal server error");

        return pb;
    }

}
