package br.com.aluno.service;

import br.com.aluno.entity.Aluno;
import br.com.aluno.exeption.AlunoNaoEncontradoException;
import br.com.aluno.http.domain.response.AlunosResponse;
import br.com.aluno.repository.AlunosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunosService {

    @Autowired
    private AlunosRepository repository;

    public void salvar(Aluno aluno) {
        repository.save(aluno);
    }

    public List<AlunosResponse> findAll() {
        List<Aluno> entity = repository.findAll();
        List<AlunosResponse> response = new ArrayList<>();

        for (Aluno e : entity) {
            AlunosResponse aluno = new AlunosResponse();
            aluno.setNomeAluno(e.getNomeAluno());
            aluno.setNumeroMatricula(e.getNumeroMatricula());
        }
        return response;
    }

    public AlunosResponse findById(Long id) {
        Optional<Aluno> entity = repository.findById(id);
        if (entity.isPresent()) {
            Aluno e = entity.get();
            AlunosResponse aluno = new AlunosResponse();
            aluno.setNomeAluno(e.getNomeAluno());
            aluno.setNumeroMatricula(e.getNumeroMatricula());
            return aluno;
        } else {
            throw new AlunoNaoEncontradoException();
        }
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void atualizar(Long id, Aluno alunos) {
        Optional<Aluno> res = repository.findById(id);
        if (res.isPresent()) {
            Aluno alunoDb = res.get();
            alunoDb.setNomeAluno(alunos.getNomeAluno());
            alunoDb.setNumeroMatricula(alunos.getNumeroMatricula());

            repository.save(alunoDb);
        } else {
            throw new AlunoNaoEncontradoException();
        }
    }
}
