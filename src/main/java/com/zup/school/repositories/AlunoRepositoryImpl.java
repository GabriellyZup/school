package com.zup.school.repositories;

import com.zup.school.models.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Aluno> findAlunosByCustomQuery(String nome) {
        String jpql = "SELECT a FROM Aluno a WHERE a.nome LIKE :nome";
        TypedQuery<Aluno> query = entityManager.createQuery(jpql, Aluno.class);
        query.setParameter("nome", "%" + nome + "%");
        return query.getResultList();
    }
}