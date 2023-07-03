package com.meli.genprojetosApplicationTests.repository;

import com.meli.genprojetos.model.ProjetosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetosRepository extends JpaRepository<ProjetosModel, Long> {

    public List<ProjetosModel> findAllByDescricaoContainingIgnoreCase (@Param("descricao") String descricao);

}
