package com.meli.genprojetos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tb_descricao")
public class ProjetosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "O Atributo ID é Obrigatório!")
    private Long id;

    @NotBlank(message = "O Atributo título é Obrigatório!")
    private String descricao;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("projeto")
    private List<Descricao> descricao;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Descricao> getDescricao() {
        return this.descricao;
    }

    public void setDescricao(List<Descricao> postagem) {
        this.descricao = descricao;
    }
}
