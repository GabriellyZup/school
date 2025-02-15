package com.zup.school.repositories;

import com.zup.school.models.Aluno;

import java.util.List;

public interface AlunoRepositoryCustom {
    List<Aluno> findAlunosByCustomQuery(String nome);
}
