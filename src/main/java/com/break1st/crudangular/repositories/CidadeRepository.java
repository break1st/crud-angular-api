package com.break1st.crudangular.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.break1st.crudangular.models.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
  
}
