package com.break1st.crudangular.models;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {
  public interface CreateUser {}
  public interface UpdateUser {}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;

  @Column(name = "nome", nullable = false, length = 100)
  @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
  private String nome;

  @Column(name = "apelido", nullable = false, length = 100)
  @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
  private String apelido;

  @Column(name = "time", nullable = false, length = 100)
  @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
  private String time;

  @Column(name = "cpf", nullable = false, length = 11)
  @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
  @CPF(groups = {CreateUser.class, UpdateUser.class})
  private String cpf;

  @Column(name = "hobbie", nullable = false, length = 100)
  @NotEmpty(groups = {CreateUser.class, UpdateUser.class})
  private String hobbie;

  @ManyToOne
  @JoinColumn(name = "cidade_id", nullable = false, updatable = false)
  private Cidade cidade;
}
