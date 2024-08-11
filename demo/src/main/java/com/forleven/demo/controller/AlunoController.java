package com.forleven.demo.controller;

import com.forleven.demo.data.AlunoEntity;
import com.forleven.demo.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
