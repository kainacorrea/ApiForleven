package com.forleven.demo.service;

import com.forleven.demo.data.AlunoDTO;
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
    
    //Atualizar dados de aluno
    public AlunoEntity atualizarAluno(Integer alunoId, AlunoDTO alunoRequest) {
        AlunoEntity aluno = getAlunoId(alunoId);
        
        //Verifica campo vazio; se não, atualiza nome
        if(alunoRequest.getNome() != null && !alunoRequest.getNome().isBlank()){
            aluno.setNome(alunoRequest.getNome());
        }
        
        //Verifica campo vazio; se não, atualiza sobrenome
        if (alunoRequest.getSobrenome() != null && !alunoRequest.getSobrenome().isBlank()){
            aluno.setSobrenome(alunoRequest.getSobrenome());
        }
        
        //Verifica campo vazio; se não, atualiza matrícula
        if (alunoRequest.getMatricula() != null && !alunoRequest.getMatricula().isBlank()){
            aluno.setMatricula(alunoRequest.getMatricula());
        }
        
        alunoRepository.save(aluno);
        
        return aluno;
    }
}
