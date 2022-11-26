package com.algaworks.comercial.controller;

import com.algaworks.comercial.model.Oportunidade;
import com.algaworks.comercial.service.OportunidadeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Leandro Menezes
 */
@CrossOrigin
@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    @Autowired
    private OportunidadeService service;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Oportunidade>> listar() {
        return this.service.listar();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Oportunidade> buscar(@PathVariable(name = "id") Long id) {
        return this.service.buscar(id);
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Oportunidade adicionarOportunidade(@Valid @RequestBody Oportunidade oportunidade) {
        return this.service.adicionarOportunidade(oportunidade);
    }

    @PutMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Oportunidade alterarOportunidade(@Valid @RequestBody Oportunidade oportunidade) {
        return this.service.alterarOportunidade(oportunidade);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removerOportunidade(@PathVariable Long id) {
        this.service.removerOportunidade(id);
    }
}
