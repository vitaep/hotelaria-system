package dev.vitaep.hotelariaSystem.entity.specialClasses;

import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.regex.Pattern;

@Embeddable
@Data
public class Cpf {

    private String numero;

    private static final Pattern CPF_PATTERN = Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}|\\d{11}");

    public Cpf(String numero){
        if(!validarCpf(numero)){
            throw new IllegalArgumentException("CPF Inválido.");
        }
        if(numero == null){
            throw new IllegalArgumentException("BAGULHO TA NULL MANO");
        }

        this.numero = numero.replaceAll("\\D", "");

    }

    public Cpf() {}

    public String getNumeroSemFormatacao(){
        return (numero != null) ? numero.replaceAll("\\D", "") : "";
    }

    // VALIDAR CPF


    private boolean validarCpf(String cpf){
        // Remover todos os caracteres não numéricos
        cpf = cpf.replaceAll("\\D", "");  // \\D para remover qualquer caractere não numérico

        // Verifica se o CPF tem exatamente 11 caracteres e não é uma sequência repetida de números
        if(cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")){
            return false;  // Retorna falso se o CPF for inválido
        }

        // Verifica se os dígitos calculados são iguais aos dígitos informados no CPF
        return calcularDigito(cpf, 9) == Character.getNumericValue(cpf.charAt(9))
                && calcularDigito(cpf, 10) == Character.getNumericValue(cpf.charAt(10));
    }


    // CALCULAR DIGITO CPF

    private int calcularDigito(String cpf, int pos){

        int soma = 0, peso = pos + 1;
        for(int i = 0; i < pos; i++){
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }

        int resto = soma % 11;

        return (resto < 2) ? 0 : (11 - resto);
    }

    private String formatar(String cpf){
        cpf = cpf.replaceAll("\\D", "");
        return String.format("%s.%s.%s-%s",
                cpf.substring(0, 3),
                cpf.substring(3, 6),
                cpf.substring(6, 9),
                cpf.substring(9, 11));
    }

    @Override
    @JsonValue
    public String toString() {
        return formatar(this.numero);
    }
}
