package com.example.TransactionalOutboxPattern.Service;

import com.example.TransactionalOutboxPattern.Dto.UserRequestDto;
import com.example.TransactionalOutboxPattern.Entity.Outbox;
import com.example.TransactionalOutboxPattern.Entity.User;
import com.example.TransactionalOutboxPattern.Mapper.UserMapper;
import com.example.TransactionalOutboxPattern.Mapper.UserRequestDtoMapper;
import com.example.TransactionalOutboxPattern.Repository.OutboxRepository;
import com.example.TransactionalOutboxPattern.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final OutboxRepository outboxRepository;
    private final UserRequestDtoMapper userRequestDtoMapper;
    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, OutboxRepository outboxRepository,
                       UserRequestDtoMapper userRequestDtoMapper, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.outboxRepository = outboxRepository;
        this.userRequestDtoMapper = userRequestDtoMapper;
        this.userMapper = userMapper;
    }

    @Transactional
    public User createUser(UserRequestDto userRequestDto) {
        try {
            User user = userRequestDtoMapper.mapToUserEntity(userRequestDto);

            user = userRepository.save(user);

            Outbox outbox = userMapper.mapToOutBoxEntity(user);

            outboxRepository.save(outbox); // This time saving message in a table instead of directly publishing

            return user;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}