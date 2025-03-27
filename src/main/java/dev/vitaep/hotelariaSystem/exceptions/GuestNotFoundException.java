package dev.vitaep.hotelariaSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class GuestNotFoundException extends HotelException{

    private final String detail;

    public GuestNotFoundException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
         var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
         pb.setTitle("Entity not found");
         pb.setDetail(detail);

         return pb;
    }
}
