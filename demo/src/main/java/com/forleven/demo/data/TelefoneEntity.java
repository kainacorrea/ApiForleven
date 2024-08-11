package com.forleven.demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "telefone")
public class TelefoneEntity {
    
    //banco de dados responsável pela implementação de ID
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    //Anotação: Campo obrigatório
    @NotBlank(message = "Número obrigatório")
    private String numero;
    
    //Anotação: Relacionamento (foreign key)
    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private AlunoEntity aluno;
}
