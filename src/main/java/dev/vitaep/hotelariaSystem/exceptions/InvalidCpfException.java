package dev.vitaep.hotelariaSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class InvalidCpfException extends HotelException{

    private final String detail;

    public InvalidCpfException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Cpf inválido");
        pb.setDetail(detail);

        return pb;
    }
}
