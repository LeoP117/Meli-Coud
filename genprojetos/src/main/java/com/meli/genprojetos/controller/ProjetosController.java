package com.meli.genprojetos.controller;


import com.meli.genprojetos.model.Descricao;
import com.meli.genprojetos.model.ProjetosModel;
import com.meli.genprojetos.repository.ProjetosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projetos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjetosController {

    @Autowired
    private ProjetosRepository ProjetosRepository;

    @GetMapping
    public ResponseEntity<List<ProjetosModel>> getAll(){
        return ResponseEntity.ok(ProjetosRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetosModel> getById(@PathVariable Long id){
        return ProjetosRepository.findById(id)
                .map(retorno -> ResponseEntity.ok(retorno))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<ProjetosModel>> getByTitle(@PathVariable String descricao){
        return ResponseEntity.ok(ProjetosRepository)
                .findAllByDescricaoContainingIgnoreCase(descricao));
    }

    @PostMapping
    public ResponseEntity<ProjetosModel> post(@Valid @RequestBody ProjetosModel projeto){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProjetosRepository.save(projetos));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    public ResponseEntity<ProjetosModel> putTema(@Valid @RequestBody ProjetosModel tema){
       return projetosRepository.findById(tema.getId())
                .map(retorno -> ResponseEntity.status(HttpStatus.CREATED)
                       .body(projetosRepository.save(projetos)))
               .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
   }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Optional<ProjetosModel> projetos = projetosRepository.findById(id);
        if(projetos.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        projetosRepository.deleteById(id);
    }

}
