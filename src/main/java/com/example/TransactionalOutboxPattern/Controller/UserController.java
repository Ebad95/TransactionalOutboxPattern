package com.example.TransactionalOutboxPattern.Controller;

import com.example.TransactionalOutboxPattern.Dto.UserRequestDto;
import com.example.TransactionalOutboxPattern.Entity.User;
import com.example.TransactionalOutboxPattern.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        return userService.createUser(userRequestDto);
    }

}
