package com.break1st.crudangular.models;

import java.util.ArrayList;
import java.util.List;

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
  @NotEmpty(groups = {CreateCity.class, UpdateCity.class})
  private String cidade;

  @Column(name = "estado", nullable = false, length = 100)
  @NotEmpty(groups = {CreateCity.class, UpdateCity.class})
  private String estado;

  @OneToMany(mappedBy = "cidade")
  private List<User> users = new ArrayList<User>();
}
