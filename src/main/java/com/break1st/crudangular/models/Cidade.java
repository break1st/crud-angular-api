package com.break1st.crudangular.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.scheduling.config.Task;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "cidades")
public class Cidade {
  public interface CreateCity {}
  public interface UpdateCity {}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true)
  private Long id;

  @Column(name = "cidade", nullable = false, length = 100)
  @NotEmpty()
  private String cidade;

  @Column(name = "estado", nullable = false, length = 100)
  @NotEmpty()
  private String estado;

  @OneToMany(mappedBy = "cidade")
  @JsonProperty(access = Access.WRITE_ONLY)
  private List<User> users = new ArrayList<User>();

  public Cidade() {
  }

  public Cidade(Long id, String cidade, String estado) {
    this.id = id;
    this.cidade = cidade;
    this.estado = estado;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this)
      return true;
    if (o == null)
      return false;
    if (!(o instanceof Task)) {
      return false;
    }
    Cidade cidade = (Cidade) o;
    if (this.id == null)
      if (cidade.id == null)
        return false;
      else if (!this.id.equals(cidade.id))
        return false;
    return Objects.equals(this.id, cidade.id)
        && Objects.equals(this.cidade, cidade.cidade)
        && Objects.equals(this.estado, cidade.estado)
        && Objects.equals(this.users, cidade.users);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.id == null) ? 0 : id.hashCode());
    return result;
  }
}
