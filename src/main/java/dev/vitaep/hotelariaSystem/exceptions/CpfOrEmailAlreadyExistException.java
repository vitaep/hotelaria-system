package dev.vitaep.hotelariaSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CpfOrEmailAlreadyExistException extends HotelException{

    private final String detail;

    public CpfOrEmailAlreadyExistException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("O cpf ou email duplicado");
        pb.setDetail(detail);

        return pb;
    }
}
