package com.break1st.crudangular.services;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.break1st.crudangular.models.Cidade;
import com.break1st.crudangular.repositories.CidadeRepository;

import jakarta.transaction.Transactional;

@Service
public class CidadeService {
  
  @Autowired
  private CidadeRepository cidadeRepository;

  public Cidade findById(Long id) {
    Optional<Cidade> cidade = this.cidadeRepository.findById(id);
    return cidade.orElseThrow(() -> new RuntimeException(
        "Tarefa não encontrada! ID: " + id));
  }

  public List<Cidade> findAll() {
    return this.cidadeRepository.findAll();
  }

  @Transactional
  public Cidade create(Cidade cidade) {
    Cidade newCidade = cidade;
    newCidade.setId(null);
    newCidade = this.cidadeRepository.save(newCidade);
    return newCidade;
  }

  @Transactional
  public Cidade update(Cidade cidade) {
    this.findById(cidade.getId());
    return this.cidadeRepository.save(cidade);
  }

  public void delete(Long id) {
    this.findById(id);
    try {
      this.cidadeRepository.deleteById(id);
    } catch (Exception e) {
      throw new RuntimeException(
        "Erro ao excluir cidade! ID: " + id
      );
    }  }
}
