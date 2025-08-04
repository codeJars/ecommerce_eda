package com.ecommerce.iam_service.repository;


import com.ecommerce.iam_service.entity.Outbox;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OutBoxRepository extends ReactiveCrudRepository<Outbox, UUID> {
}
