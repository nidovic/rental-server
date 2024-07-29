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
@Table(name = "contracts")
public class ContractEntity{
    @JsonProperty("contractId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID leaseContractId;

    @JsonProperty("startDate")
    private Date startDate;

    @JsonProperty("endDate")
    private Date endDate;

    @JsonProperty("paymentType")
    private String paymentType; // PerDay, PerMonth,

    @JsonProperty("status")
    private String status; // Running, End,

    @JsonProperty("paymentDay")
    private Integer paymentDay;

    @JsonProperty("createdAt")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime createdAt;

    @JsonProperty("updatedAt")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime updatedAt;

    @JsonProperty("tenant")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity tenant;

    @JsonProperty("property")
    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private PropertyEntity property;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContractPaymentEntity> contractPayments = new ArrayList<>();
}