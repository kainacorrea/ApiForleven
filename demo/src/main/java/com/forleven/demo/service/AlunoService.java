package com.forleven.demo.service;

import com.forleven.demo.data.AlunoEntity;
import com.forleven.demo.data.AlunoRepository;
import com.forleven.demo.exception.MatriculaExistsException;
import com.forleven.demo.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    //Cadastrar novo aluno
    public AlunoEntity cadastrarAluno(AlunoEntity a) {
        
        //Validação de matrícula existente
        if (existeMatricula(a.getMatricula())) {
            throw new MatriculaExistsException("Número de matrícula já existe");
        } else {
            a.setId(null);
            alunoRepository.save(a);
            return a;
        }
    }
    
    //Verificar se matrícula já existe no banco
    public boolean existeMatricula(String matricula) {
        return alunoRepository.existsByMatricula(matricula);
    }
    
    //Obter aluno por ID
    public AlunoEntity getAlunoId(Integer alunoId) {
        return alunoRepository.findById(alunoId).orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado: " + alunoId));
    }
    
    //Obter todos os alunos
    public List<AlunoEntity> listarTodosAlunos(){
        return alunoRepository.findAll();
    }
}
