package br.com.aluno.repository;

import br.com.aluno.entity.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Alunos2Repositoryimpl {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void salvar(Aluno aluno) {
        //escrever a query
        String sql = "INSERT INTO tb_alunos(nome_aluno, numero_matricula) VALUES ( '" + aluno.getNomeAluno() + "'," + aluno.getNumeroMatricula() + ");";
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

    public List<Aluno> findById(Long id) {
        String sql = "SELECT * FROM tb_alunos WHERE id = " + id + ";";
        System.out.println(sql);
        //executar a query
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Aluno.class));
    }

    public List<Aluno> findAll() {
        String sql = "SELECT * FROM tb_alunos";
        System.out.println(sql);
        //executar a query
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Aluno.class));
    }
}
