package com.ada.order.service;

import com.ada.order.controller.dto.user.UserRequest;
import com.ada.order.controller.dto.user.UserResponse;
import com.ada.order.controller.exception.CpfValidationError;
import com.ada.order.controller.exception.PasswordValidationError;
import com.ada.order.model.User;
import com.ada.order.repository.IUserRepository;
import com.ada.order.utils.UserConvert;
import com.ada.order.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<UserResponse> getUser(){
        return UserConvert.toResponseList(userRepository.findAll());
    }

    public UserResponse saveUser(UserRequest userDTO) throws PasswordValidationError, CpfValidationError {
       User user = UserConvert.toEntity(userDTO);

      if(!Validator.passwordValidate(user.getSenha())) throw new PasswordValidationError("senha deve seguir padrão");
      if(!Validator.cpfValidate(user.getCpf())) throw new CpfValidationError("Cpf inválido");

      String encodePassword = passwordEncoder.encode(user.getSenha());
      user.setSenha(encodePassword);

      return UserConvert.toResponse(userRepository.save(user));
    }

    public UserResponse getUserById(Integer id){
        Optional<User> userResponse = userRepository.findById(id);

        if (userResponse.isPresent()) {
            return UserConvert.toResponse(userResponse.get());
        }else{
            throw new RuntimeException("nao encontrado");
        }
    }

    public UserResponse getUserByCpf(String cpf){
        User user = userRepository.findByCpf(cpf);

        if (user != null) {
            return UserConvert.toResponse(user);
        }else{
            throw new NoSuchElementException("Cliente nao encontrado");
        }
    }

    public List<UserResponse> getAllByName (String nome){
        return UserConvert.toResponseList(userRepository.findAllByName(nome));
    }


    public void deleteUserById(Integer id){
        if(id != null){
            userRepository.deleteById(id);
        }else{
            throw new NoSuchElementException("Cliente nao encontrado");
        }
    }
}
