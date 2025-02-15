package com.zup.school.controllers;

import com.zup.school.dtos.AlunoDto;
import com.zup.school.models.Aluno;
import com.zup.school.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;


    @GetMapping
    public ResponseEntity<List<AlunoDto>> getAllAlunos() {
        List<AlunoDto> alunos = alunoService.getAllAlunos()
                .stream()
                .map(aluno -> new AlunoDto(aluno.getId(), aluno.getNome(), aluno.getIdade()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(alunos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDto> getAlunoById(@PathVariable Long id) {
        Aluno aluno = alunoService.getAlunoById(id);
        AlunoDto alunoDto = new AlunoDto(aluno.getId(), aluno.getNome(), aluno.getIdade());
        return ResponseEntity.ok(alunoDto);
    }

    @PostMapping
    public ResponseEntity<AlunoDto> createAluno(@Valid @RequestBody AlunoDto alunoDto) {
        Aluno aluno = alunoService.createAluno(alunoDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(AlunoDto.fromEntity(aluno));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDto> updateAluno(@PathVariable Long id, @Valid @RequestBody AlunoDto alunoDto) {
        Aluno aluno = alunoService.updateAluno(id, alunoDto.toEntity());
        return ResponseEntity.ok(AlunoDto.fromEntity(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.noContent().build();
    }
}
