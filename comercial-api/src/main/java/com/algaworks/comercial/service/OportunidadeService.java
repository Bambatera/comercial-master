package com.algaworks.comercial.service;

import com.algaworks.comercial.model.Oportunidade;
import com.algaworks.comercial.repository.OportunidadeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Leandro Menezes
 */
@Service
public class OportunidadeService {

    @Autowired
    private OportunidadeRepository repository;

    public ResponseEntity<List<Oportunidade>> listar() {
        List<Oportunidade> oportunidades = repository.findAll();
        if (oportunidades.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oportunidades);
    }

    public ResponseEntity<Oportunidade> buscar(Long id) {
        Optional<Oportunidade> opt = repository.findById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(opt.get());
    }

    @Transactional
    public Oportunidade adicionarOportunidade(Oportunidade oportunidade) {
        Optional<Oportunidade> optional = this.repository.findByDescricaoAndNomeProspecto(oportunidade.getDescricao(), oportunidade.getNomeProspecto());
        if (optional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma Oportunidade para este Prospecto com a mesma descrição.");
        }
        return this.repository.save(oportunidade);
    }

    @Transactional
    public Oportunidade alterarOportunidade(Oportunidade oportunidade) {
        Optional<Oportunidade> optional = this.repository.findByDescricaoAndNomeProspecto(oportunidade.getDescricao(), oportunidade.getNomeProspecto());
        if (optional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma Oportunidade para este Prospecto com a mesma descrição.");
        }
        return this.repository.save(oportunidade);
    }

    @Transactional
    public void removerOportunidade(Long id) {
        Optional<Oportunidade> optional = this.repository.findById(id);
        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A Oportunidade informada não existe.");
        }
        this.repository.deleteById(id);
    }
}
