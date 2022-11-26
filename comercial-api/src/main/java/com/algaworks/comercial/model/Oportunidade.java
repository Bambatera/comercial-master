package com.algaworks.comercial.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Leandro Menezes
 */
@Entity
public class Oportunidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Size(max = 80)
    @Column(name = "nome_prospecto", length = 80)
    private String nomeProspecto;

    @NotEmpty
    @Size(max = 200)
    @Column(name = "descricao", length = 200)
    private String descricao;

    @Min(value = 0)
    @Column(name = "valor")
    private BigDecimal valor;

    public Oportunidade() {
    }

    public Oportunidade(Long id) {
        this.id = id;
    }

    public Oportunidade(String nomeProspecto, String descricao, BigDecimal valor) {
        this.nomeProspecto = nomeProspecto;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Oportunidade(Long id, String nomeProspecto, String descricao, BigDecimal valor) {
        this.id = id;
        this.nomeProspecto = nomeProspecto;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProspecto() {
        return nomeProspecto;
    }

    public void setNomeProspecto(String nomeProspecto) {
        this.nomeProspecto = nomeProspecto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Oportunidade other = (Oportunidade) obj;
        return Objects.equals(this.id, other.id);
    }

}
