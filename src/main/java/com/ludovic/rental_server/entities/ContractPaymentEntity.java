package com.ludovic.rental_server.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "contract_payments")
public class ContractPaymentEntity {
    @JsonProperty("contractPaymentId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID contractPaymentId;

    @JsonProperty("status")
    private String status; // Completed, Advanced, Debt

    @JsonProperty("amountToPayInXAF")
    private double amountToPayInXAF;

    @JsonProperty("paymentDate")
    private Date paymentDate;

    @JsonProperty("completeAt")
    private OffsetDateTime completeAt;

    @JsonProperty("createdAt")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime updatedAt;

    @JsonProperty("contract")
    @ManyToOne
    @JoinColumn(name = "contract_id", nullable = false)
    private ContractEntity contract;

    @OneToMany(mappedBy = "contractPayment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContractPaymentAdvanceEntity> contractPaymentAdvances = new ArrayList<>();

    @OneToMany(mappedBy = "contractPayment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContractPaymentDebtEntity> contractPaymentDebts = new ArrayList<>();

}
