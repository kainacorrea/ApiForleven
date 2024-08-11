package com.forleven.demo.data;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {

    @Size(min = 4, message = "O nome deve ter pelo menos 4 caracteres.")
    private String nome;

    @Size(min = 4, message = "O sobrenome deve ter pelo menos 4 caracteres.")
    private String sobrenome;

    @Size(min = 4, max = 10, message = "A matrícula deve ter entre 4 e 10 caracteres.")
    private String matricula;
}
