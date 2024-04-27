package com.break1st.crudangular.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.break1st.crudangular.models.Cidade;
import com.break1st.crudangular.models.User;
import com.break1st.crudangular.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CidadeService cidadeService;

  public User findById(Long id) {
    Optional<User> user = this.userRepository.findById(id);
    return user.orElseThrow(() -> new RuntimeException(
        "Usuário não encontrado! ID: " + id));
  }

  public List<User> findAll() {
    return this.userRepository.findAll();
  }

  @Transactional
  public User create(User user) {
    Cidade cidade = this.cidadeService.findById(user.getCidade().getId());
    User newUser = user;
    newUser.setId(null);
    newUser.setCidade(cidade);
    newUser = this.userRepository.save(newUser);
    return newUser;
  }

  @Transactional
  public User update(User user) {
    this.findById(user.getId());
    Cidade cidade = this.cidadeService.findById(user.getCidade().getId());
    User updateUser = user;
    updateUser.setCidade(cidade);
    updateUser = this.userRepository.save(updateUser);
    return updateUser;
  }

  public void delete(Long id) {
    this.findById(id);
    try {
      this.userRepository.deleteById(id);
    } catch (Exception e) {
      throw new RuntimeException(
        "Erro ao excluir usuário! ID: " + id
      );
    }
  }
}
