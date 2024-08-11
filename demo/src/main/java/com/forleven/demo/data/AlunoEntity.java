package com.forleven.demo.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aluno")
public class AlunoEntity {
    
    //banco de dados responsável pela implementação de ID
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    // Anotações: Campo obrigatório; informar mais de 3 caracteres
    @NotBlank(message="Nome obrigatório")
    @Size(min=4, message="Informe ao menos 4 caracteres para o campo nome")
    private String nome;
    
    // Anotações: Campo obrigatório; informar mais de 3 caracteres
    @NotBlank(message="Sobrenome obrigatório")
    @Size(min=4, message="Informe ao menos 4 caracteres para o campo sobrenome")
    private String sobrenome;
    
    // Anotações: Campo obrigatório; informar mais de 3 caracteres e menos de 11
    @NotBlank(message="Número de matrícula obrigatório")
    @Size(min=4, max=10, message="O campo de matrícula deve ter entre 4 e 10 caracteres")
    private String matricula;
}
