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
  public interface CreateUser {
  }

  public interface UpdateUser {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;

  @Column(name = "nome", nullable = false, length = 100)
  @NotEmpty()
  private String nome;

  @Column(name = "apelido", nullable = false, length = 100)
  @NotEmpty()
  private String apelido;

  @Column(name = "time", nullable = false, length = 100)
  @NotEmpty()
  private String time;

  @Column(name = "cpf", nullable = false, length = 11)
  @NotEmpty()
  @CPF()
  private String cpf;

  @Column(name = "hobbie", nullable = false, length = 100)
  @NotEmpty()
  private String hobbie;

  @ManyToOne
  @JoinColumn(name = "cidade_id", nullable = false, updatable = false)
  private Cidade cidade;

  public User() {
  }

  public User(Long id, String nome, String apelido, String time, String cpf, String hobbie, Cidade cidade) {
    this.id = id;
    this.nome = nome;
    this.apelido = apelido;
    this.time = time;
    this.cpf = cpf;
    this.hobbie = hobbie;
    this.cidade = cidade;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getApelido() {
    return apelido;
  }

  public void setApelido(String apelido) {
    this.apelido = apelido;
  }

  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getHobbie() {
    return hobbie;
  }

  public void setHobbie(String hobbie) {
    this.hobbie = hobbie;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public void setCidade(Cidade cidade) {
    this.cidade = cidade;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (o == null)
      return false;
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    if (this.id == null)
      if (user.id == null)
        return false;
      else if (!this.id.equals(user.id))
        return false;
    return this.id.equals(user.id) && this.nome.equals(user.nome) && this.apelido.equals(user.apelido)
        && this.time.equals(user.time) && this.cpf.equals(user.cpf) && this.hobbie.equals(user.hobbie)
        && this.cidade.equals(user.cidade);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id == null) ? 0 : id.hashCode());
    return result;
  }
}
