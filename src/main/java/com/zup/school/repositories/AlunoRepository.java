package com.zup.school.repositories;

import com.zup.school.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByIdade(Integer idade);
    List<Aluno> findByNome(String nome);
}
