package com.ada.order.repository;

import com.ada.order.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer>{

    List<User> findAllByName (String nome);

    User findByCpf (String cpf);
}
