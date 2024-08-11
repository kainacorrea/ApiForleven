package com.forleven.demo.controller;

import com.forleven.demo.data.AlunoDTO;
import com.forleven.demo.data.AlunoEntity;
import com.forleven.demo.service.AlunoService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    
    @Autowired
    AlunoService alunoService;
    
    //Obtém dados para cadastrar novo aluno
    @PostMapping("/adicionar")
    public ResponseEntity<AlunoEntity> addAluno(@Valid @RequestBody AlunoEntity a) {
        var novoAluno = alunoService.cadastrarAluno(a);
        return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
    }
    
    //Lista todos os alunos cadastrados
    @GetMapping("/listar")
    public ResponseEntity<List<AlunoEntity>> getAllAlunos() {
        List<AlunoEntity> alunos = alunoService.listarTodosAlunos();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }
    
    //Pesquisa aluno por ID
    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<AlunoEntity> getAlunoById(@PathVariable Integer id) {
        AlunoEntity aluno = alunoService.getAlunoId(id);
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }
    
    //Obtém dados para atualizar aluno
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<AlunoEntity> atualizarAluno(@PathVariable Integer id, @RequestBody AlunoDTO aluno) {
        var alunoAtualizado = alunoService.atualizarAluno(id, aluno);
        return new ResponseEntity<>(alunoAtualizado, HttpStatus.OK);
    }
    
    //Verifica e deleta aluno
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Integer id) {
        alunoService.deletarAluno(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
