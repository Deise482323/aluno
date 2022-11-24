package br.com.aluno.repository;

import br.com.aluno.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<Aluno, Long> {
}
