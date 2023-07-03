package com.meli.genprojetos.repository;

import com.meli.genprojetos.model.Descricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface DescricaoRepository extends JpaRepository<DescricaoRepository, Long> {
    public List<DescricaoRepository> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);

}
