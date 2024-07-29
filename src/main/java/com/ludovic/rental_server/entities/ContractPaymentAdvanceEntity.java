package com.ludovic.rental_server.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "contract_payment_advances")
public class ContractPaymentAdvanceEntity {
    @JsonProperty("contractPaymentAdvanceId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID contractPaymentAdvanceId;

    @JsonProperty("amountInXAF")
    private double amountInXAF;

    @JsonProperty("createdAt")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime updatedAt;

    @JsonProperty("contractPayment")
    @ManyToOne
    @JoinColumn(name = "contract_payment_id", referencedColumnName = "contractPaymentId", nullable = false)
    private ContractPaymentEntity contractPayment;

}
