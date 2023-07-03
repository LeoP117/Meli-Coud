package com.meli.genprojetos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Entity
@Table(name = "tb_descricao")
public class Descricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "O Atributo ID é Obrigatório!")
    private Long id;

    @NotBlank(message = "O Atributo título é Obrigatório!")
    @Size(min = 5, max = 100, message = "O Atributo título deve conter no mínimo 02 e no máximo 100 caracteres")
    private String titulo;

    @NotBlank(message = "O Atributo texto é Obrigatório!")
    @Size(min = 1, max = 1000, message = "O Atributo texto deve conter no mínimo 1 e no máximo 1000 caracteres")
    private String texto;

    @UpdateTimestamp
    private LocalDateTime data;

    @ManyToOne
    @JsonIgnoreProperties("descricao")
    private ProjetosModel Projeto;

    @ManyToOne
    @JsonIgnoreProperties("descricao")
    private UsuarioModel usuario;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public ProjetosModel getDescricao() {
        return descricao;
    }

    public void setDescricao(ProjetosModel descricao) {
        this.tema = tema;
    }

   
    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
