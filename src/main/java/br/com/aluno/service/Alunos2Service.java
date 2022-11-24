package br.com.aluno.service;

import br.com.aluno.entity.Aluno;
import br.com.aluno.repository.Alunos2Repositoryimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Alunos2Service {
    @Autowired
    private Alunos2Repositoryimpl repository;

    public void salvar(Aluno aluno) {
        repository.salvar(aluno);
    }

    public void update(String nomeAluno, Long id) {
        repository.update(nomeAluno, id);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public List<Aluno> findById(Long id) {
        return repository.findById(id);
    }

    public List<Aluno> findAll() {
        return repository.findAll();
    }
}
