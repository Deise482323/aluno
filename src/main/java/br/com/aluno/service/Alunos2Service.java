package br.com.aluno.service;

import br.com.aluno.entity.Alunos;
import br.com.aluno.repository.Alunos2Repositoryimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Alunos2Service {
    @Autowired
    private Alunos2Repositoryimpl repository;

    public void salvar(Alunos alunos) {
        repository.salvar(alunos);
    }
}
