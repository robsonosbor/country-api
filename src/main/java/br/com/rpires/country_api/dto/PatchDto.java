package br.com.rpires.country_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PatchDto {

    @Schema(description = "OPERATION OF PATCH (UPDATE)")
    private String op;

    @Schema(description = "PROPERTY OF OBJECT")
    private String key;

    @Schema(description = "NEW VALUE FOR UPDATE")
    private String value;
}
