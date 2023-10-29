package com.ada.order.utils;

import com.ada.order.controller.dto.user.UserResponse;
import com.ada.order.controller.dto.user.UserRequest;
import com.ada.order.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserConvert {

    public static User toEntity(UserRequest userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setDataDeNascimento(userDTO.getDataDeNascimento());
        user.setEstadoCivil(userDTO.getEstadoCivil());
        user.setCpf(userDTO.getCpf());
        user.setSexo(userDTO.getSexo());
        user.setSenha(userDTO.getSenha());

        return user;
    }

    public static UserResponse toResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setNome(user.getName());
        userResponse.setCpf(user.getCpf());

        return userResponse;
    }


    public static List<UserResponse> toResponseList(List<User> users){
        List<UserResponse> userResponses =  new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = UserConvert.toResponse(user);
            userResponses.add(userResponse);
        }
            return userResponses;
        }
}
