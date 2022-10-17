package br.com.aluno.service;

import br.com.aluno.entity.Alunos;
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

    public void salvar(Alunos alunos) {
        repository.save(alunos);
    }

    public List<AlunosResponse> findAll() {
        List<Alunos> entity = repository.findAll();
        List<AlunosResponse> response = new ArrayList<>();

        for (Alunos e : entity) {
            AlunosResponse aluno = new AlunosResponse();
            aluno.setNomeAluno(e.getNomeAluno());
            aluno.setNumeroMatricula(e.getNumeroMatricula());
        }
        return response;
    }

    public AlunosResponse findById(Long id) {
        Optional<Alunos> entity = repository.findById(id);
        if (entity.isPresent()) {
            Alunos e = entity.get();
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

    public void atualizar(Long id, Alunos alunos) {
        Optional<Alunos> res = repository.findById(id);
        if (res.isPresent()) {
            Alunos AlunosDb = res.get();
            AlunosDb.setNomeAluno(alunos.getNomeAluno());
            AlunosDb.setNumeroMatricula(alunos.getNumeroMatricula());

            repository.save(AlunosDb);
        } else {
            throw new AlunoNaoEncontradoException();
        }
    }
}
