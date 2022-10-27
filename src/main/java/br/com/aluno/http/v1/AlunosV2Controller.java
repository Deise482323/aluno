package br.com.aluno.http.v1;

import br.com.aluno.entity.Alunos;
import br.com.aluno.service.Alunos2Service;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public void Salvar(@RequestBody Alunos alunos) {
        service.salvar((alunos));
    }
}