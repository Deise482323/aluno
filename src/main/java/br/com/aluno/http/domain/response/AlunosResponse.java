package br.com.aluno.http.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunosResponse {

    private String nomeAluno;
    private int numeroMatricula;
}
