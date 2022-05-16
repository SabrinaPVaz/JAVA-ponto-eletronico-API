package com.atmapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    @NotBlank
    @Size(min = 3, max = 70)
    private String name;
    @NotBlank
    @Size(min = 8, max = 15)
    private Integer number;
    @NotBlank
    private Double balance;
    @NotBlank
    private LocalDateTime createdAt;

}
