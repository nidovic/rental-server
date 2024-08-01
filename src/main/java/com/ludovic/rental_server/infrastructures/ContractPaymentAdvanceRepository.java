package com.ludovic.rental_server.infrastructures;

import com.ludovic.rental_server.entities.ContractPaymentAdvanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContractPaymentAdvanceRepository extends JpaRepository<ContractPaymentAdvanceEntity, UUID> {
}
