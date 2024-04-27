package com.break1st.crudangular.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.break1st.crudangular.models.Cidade;
import com.break1st.crudangular.services.CidadeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cidades")
@Validated
public class CidadeController {
  
  @Autowired
  private CidadeService cidadeService;

  @GetMapping
  public ResponseEntity<List<Cidade>> findAll() {
    List<Cidade> cidades = this.cidadeService.findAll();
    return ResponseEntity.ok(cidades);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cidade> findById(@PathVariable Long id) {
    Cidade cidade = this.cidadeService.findById(id);
    return ResponseEntity.ok(cidade);
  }
  
  @PostMapping
  @Validated
  public ResponseEntity<Cidade> create(@Valid @RequestBody Cidade cidade) {
    Cidade newCidade = this.cidadeService.create(cidade);
    return ResponseEntity.ok(newCidade);
  }

  @PutMapping("/{id}")
  @Validated
  public ResponseEntity<Cidade> update(@Valid @RequestBody Cidade cidade, @PathVariable Long id) {
    cidade.setId(id);
    Cidade updateCidade = this.cidadeService.update(cidade);
    return ResponseEntity.ok(updateCidade);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    this.cidadeService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
