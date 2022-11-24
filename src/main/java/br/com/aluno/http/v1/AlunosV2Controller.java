package br.com.aluno.http.v1;

import br.com.aluno.entity.Aluno;
import br.com.aluno.service.Alunos2Service;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@Slf4j
@RequestMapping(path = "/api/v2/alunos")
@Api(tags = "alunos", produces = APPLICATION_JSON_VALUE)
@CrossOrigin
public class AlunosV2Controller {
    @Autowired
    private Alunos2Service service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void Salvar(@RequestBody Aluno aluno) {
        service.salvar((aluno));
    }

    @PutMapping("/{id}/{nomeAluno}")
    @ResponseStatus(HttpStatus.OK)
    public void update(
            @PathVariable("id") long id,
            @PathVariable("nomeAluno") String nomeAluno) {
        service.update(nomeAluno, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("id") long id) {
        service.delete(id);
    }

    @GetMapping("/findById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> findById(@PathVariable("id") long id) {
        return service.findById(id);
    }
    @GetMapping("/findAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> findAll() {
        return service.findAll();
    }
}