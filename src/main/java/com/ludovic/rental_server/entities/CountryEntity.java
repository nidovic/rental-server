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
@Table(name = "countries")
public class CountryEntity {
    @JsonProperty("countryId")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID countryId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("code")
    private String code;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CityEntity> cities = new ArrayList<>();
}
