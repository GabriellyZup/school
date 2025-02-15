package com.zup.school.dtos;

import com.zup.school.models.Aluno;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class AlunoDto {

    private Long id;

    @NotNull(message = "O nome não pode ser nulo.")
    private String nome;

    @NotNull(message = "A idade não pode ser nula.")
    @Min(value = 0, message = "A idade não pode ser menor que 0.")
    private Integer idade;

    public AlunoDto() {
    }

    public AlunoDto(Long id, String nome, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Aluno toEntity() {
        return new Aluno(this.id, this.nome, this.idade);
    }

    public static AlunoDto fromEntity(Aluno aluno) {
        return new AlunoDto(aluno.getId(), aluno.getNome(), aluno.getIdade());
    }
}