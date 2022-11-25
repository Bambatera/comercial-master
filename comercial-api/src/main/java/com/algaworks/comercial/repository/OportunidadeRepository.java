package com.algaworks.comercial.repository;

import com.algaworks.comercial.model.Oportunidade;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Leandro Menezes
 */
@Repository
public interface OportunidadeRepository extends JpaRepository<Oportunidade, Long> {

    public Optional<Oportunidade> findByDescricaoAndNomeProspecto(String descricao, String nomeProspecto);

}
