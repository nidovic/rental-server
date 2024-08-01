package com.ludovic.rental_server.infrastructures;

import com.ludovic.rental_server.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository  extends JpaRepository<AddressEntity, UUID> {
}
