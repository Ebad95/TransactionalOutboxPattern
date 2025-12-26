package com.example.TransactionalOutboxPattern.Mapper;

import com.example.TransactionalOutboxPattern.Constants.Aggregate;
import com.example.TransactionalOutboxPattern.Entity.Outbox;
import com.example.TransactionalOutboxPattern.Entity.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ObjectMapper objectMapper;

    public UserMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Outbox mapToOutBoxEntity(User user) throws JsonProcessingException {
        return new Outbox(
                Aggregate.USER,
                objectMapper.writeValueAsString(user),
                0
        );
    }
}
