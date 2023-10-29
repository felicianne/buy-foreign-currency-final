package com.ada.order.controller;

import com.ada.order.controller.dto.user.UserResponse;
import com.ada.order.controller.exception.CpfValidationError;
import com.ada.order.controller.exception.PasswordValidationError;
import com.ada.order.controller.dto.user.UserRequest;
import com.ada.order.utils.UserConvert;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ada.order.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping
    public ResponseEntity<List<UserResponse>> getUser() {
        return ResponseEntity.ok(userService.getUser());
    }

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(
            @Valid @RequestBody UserRequest userDTO
    ) throws PasswordValidationError, CpfValidationError {
        UserResponse userResponse = userService.saveUser(userDTO);

        return ResponseEntity
                .created(URI.create("/" +userResponse.getId()))
                .body(userResponse);
    }

    @GetMapping("/{id})")
    public ResponseEntity<UserResponse> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<UserResponse> getUserByCpf(@PathVariable String cpf)      {
        return ResponseEntity.ok(userService.getUserByCpf(cpf));
    }

    @GetMapping("/nome{nome}")
    public ResponseEntity<UserResponse> getAllCustomerByName(@PathVariable String nome) {
        return ResponseEntity.ok((UserResponse) userService.getAllByName(nome));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }

}
