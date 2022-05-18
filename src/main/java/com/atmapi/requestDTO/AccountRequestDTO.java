package com.atmapi.requestDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
public class AccountRequestDTO {

    @ApiModelProperty(value = "name", example = "name", required = true)
    private String name;
    @ApiModelProperty(value = "number", example = "12345678", required = true)
    private Integer number;
    @ApiModelProperty(value = "balance", example = "100.00", required = true)
    private Double balance;
}
