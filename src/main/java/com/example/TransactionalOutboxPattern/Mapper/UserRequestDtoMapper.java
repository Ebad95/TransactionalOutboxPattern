package com.example.TransactionalOutboxPattern.Mapper;

import com.example.TransactionalOutboxPattern.Dto.UserRequestDto;
import com.example.TransactionalOutboxPattern.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRequestDtoMapper {

    public User mapToUserEntity(UserRequestDto userRequestDto) {
        return new User(
                userRequestDto.getFirstName(),
                userRequestDto.getLastName(),
                userRequestDto.getDob(),
                userRequestDto.getAddress(),
                userRequestDto.getEmail()
        );
    }

}
