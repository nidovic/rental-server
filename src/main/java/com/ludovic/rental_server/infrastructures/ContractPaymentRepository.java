package com.ludovic.rental_server.infrastructures;

import com.ludovic.rental_server.entities.ContractPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContractPaymentRepository extends JpaRepository<ContractPaymentEntity, UUID> {
}
