package dev.vitaep.hotelariaSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.vitaep.hotelariaSystem.entity.specialClasses.Cpf;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tb_guest")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf", unique = true)
    private Cpf cpf;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "nascimento")
    private LocalDateTime nascimento;

    @Column(name = "endereco")
    private String endereco;

    @OneToMany(mappedBy = "guest")
    @JsonIgnore
    private List<Reserva> reservas = new ArrayList<>();

    public Guest(Long id, String nome, Cpf cpf, String telefone, String email, LocalDateTime nascimento, String endereco, List<Reserva> reservas) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.nascimento = nascimento;
        this.endereco = endereco;
        this.reservas = reservas;
    }

    public Guest() {
    }

    public Guest(String nome, Cpf cpf, String telefone, String email, LocalDateTime nascimento, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.nascimento = nascimento;
        this.endereco = endereco;
    }



}
