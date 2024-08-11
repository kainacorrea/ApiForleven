package com.forleven.demo.service;

import com.forleven.demo.data.AlunoEntity;
import com.forleven.demo.data.TelefoneEntity;
import com.forleven.demo.data.TelefoneRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefoneService {
    
    @Autowired
    TelefoneRepository telefoneRepository;

    public List<TelefoneEntity> cadastrarTelefone(AlunoEntity aluno, List<TelefoneEntity> t) {
        
        for (TelefoneEntity telefone : t) {
            telefone.setId(null);
            telefone.setAluno(aluno);
            telefoneRepository.save(telefone);
        }
        return t;
    }
}
