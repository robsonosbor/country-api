package br.com.rpires.country_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Table(name = "countries")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Country {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

}
