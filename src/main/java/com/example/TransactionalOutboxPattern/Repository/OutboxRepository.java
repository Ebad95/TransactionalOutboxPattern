package com.example.TransactionalOutboxPattern.Repository;

import com.example.TransactionalOutboxPattern.Entity.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboxRepository extends JpaRepository<Outbox, Long> {

}
