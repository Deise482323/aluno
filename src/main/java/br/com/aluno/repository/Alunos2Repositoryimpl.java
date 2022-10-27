package br.com.aluno.repository;

import br.com.aluno.entity.Alunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Alunos2Repositoryimpl {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void salvar(Alunos alunos) {
        //escrever a query
        String sql = "INSERT INTO tb_alunos(nome_aluno, numero_matricula) VALUES ( '" + alunos.getNomeAluno() + "'," + alunos.getNumeroMatricula() + ");";
        System.out.println(sql);
        Map<String, Object> params = new HashMap<>();
        //executar a query
        jdbcTemplate.update(sql, params);
    }
}
