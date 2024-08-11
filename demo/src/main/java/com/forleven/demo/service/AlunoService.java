package com.forleven.demo.service;

import com.forleven.demo.data.AlunoEntity;
import com.forleven.demo.data.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    //Cadastrar novo aluno
    public AlunoEntity cadastrarAluno(AlunoEntity a) {
        a.setId(null);
        alunoRepository.save(a);
        return a;
    }
}
