package com.example.TransactionalOutboxPattern.Repository;

import com.example.TransactionalOutboxPattern.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
