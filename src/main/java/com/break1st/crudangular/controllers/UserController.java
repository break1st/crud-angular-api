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

import com.break1st.crudangular.models.User;
import com.break1st.crudangular.services.CidadeService;
import com.break1st.crudangular.services.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
  
  @Autowired
  private UserService userService;

  @Autowired
  private CidadeService cidadeService;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> users = this.userService.findAll();
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    User user = this.userService.findById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping
  @Validated
  public ResponseEntity<User> create(@Valid @RequestBody User user) {
    this.cidadeService.findById(user.getCidade().getId());
    User newUser = this.userService.create(user);
    return ResponseEntity.ok(newUser);
  }

  @PutMapping("/{id}")
  @Validated
  public ResponseEntity<User> update(@Valid @RequestBody User user, @PathVariable Long id) {
    user.setId(id);
    User updateUser = this.userService.update(user);
    return ResponseEntity.ok(updateUser);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    this.userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
