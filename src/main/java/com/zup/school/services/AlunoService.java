package com.zup.school.services;

import com.zup.school.models.Aluno;
import com.zup.school.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> getAllAlunos() {
        return alunoRepository.findAll();
    }

    public Aluno getAlunoById(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
    }

    public Aluno createAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Aluno updateAluno(Long id, Aluno updatedAluno) {
        Aluno existingAluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));

        existingAluno.setNome(updatedAluno.getNome());
        existingAluno.setIdade(updatedAluno.getIdade());

        return alunoRepository.save(existingAluno);
    }

    public void deleteAluno(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new RuntimeException("Aluno não encontrado com o ID: " + id);
        }

        alunoRepository.deleteById(id);
    }
}