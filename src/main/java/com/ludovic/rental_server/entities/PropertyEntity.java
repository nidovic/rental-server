package com.ludovic.rental_server.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "properties")
public class PropertyEntity {
    @JsonProperty("propertyId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID propertyId;

    @JsonProperty("type")
    private String type; // Apartment, Bedroom, Studio

    @JsonProperty("description")
    private String description;

    @JsonProperty("rentAmountInXAF")
    private double rentAmountInXAF;

    @JsonProperty("site")
    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false)
    private SiteEntity site;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContractEntity> contracts = new ArrayList<>();
}