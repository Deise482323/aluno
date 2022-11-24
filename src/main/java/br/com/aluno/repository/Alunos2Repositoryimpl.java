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

    public static Alunos findById(long id) {
        return null;
    }

    public void salvar(Alunos alunos) {
        //escrever a query
        String sql = "INSERT INTO tb_alunos(nome_aluno, numero_matricula) VALUES ( '" + alunos.getNomeAluno() + "'," + alunos.getNumeroMatricula() + ");";
        System.out.println(sql);
        Map<String, Object> params = new HashMap<>();
        //executar a query
        jdbcTemplate.update(sql, params);
    }

    public void update(String nomeAluno, Long id) {
        String sql = "UPDATE tb_alunos SET nome_aluno = '" + nomeAluno + "'  WHERE id = " + id + ";";
        System.out.println(sql);
        Map<String, Object> params = new HashMap<>();
        //executar a query
        jdbcTemplate.update(sql, params);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM tb_alunos WHERE id = " + id + ";";
        System.out.println(sql);
        Map<String, Object> params = new HashMap<>();
        //executar a query
        jdbcTemplate.update(sql, params);
    }

    public void select(Alunos alunos,Long id){
        String sql = "SELECT COUNT(*) FROM tb_alunos WHERE id = " + id + ";";
        System.out.println(sql);
        //executar a query
        jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
