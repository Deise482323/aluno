package br.com.aluno.http.v1;

import br.com.aluno.entity.Alunos;
import br.com.aluno.http.domain.response.AlunosResponse;
import br.com.aluno.service.AlunosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/v1/alunos")
@CrossOrigin
public class AlunosController {

    @Autowired
    private AlunosService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void salvar(@RequestBody Alunos alunos) {
        service.salvar(alunos);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunosResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AlunosResponse findById(@RequestParam("id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(Long id) {
        service.deleteById(id);
    }

    @PutMapping("/update-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void atualizar(@RequestParam("id") Long id, @RequestBody Alunos alunos) {
        service.atualizar(id, alunos);
    }
}
