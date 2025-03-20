package br.com.rpires.country_api.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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
