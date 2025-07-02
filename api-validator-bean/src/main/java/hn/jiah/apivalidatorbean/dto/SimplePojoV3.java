package hn.jiah.apivalidatorbean.dto;

import hn.jiah.apivalidatorbean.annotation.ValidCurrency;
import hn.jiah.apivalidatorbean.annotation.ValidUsername;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimplePojoV3 {
    @ValidUsername
    private String username;

    @NotBlank(message = "{email.notempty}")
    @Email(message = "{email.notvalid}")
    private String email;

    @NotNull(message = "{amount.notempty}")
    @Digits(integer = 6, fraction = 2, message = "{amount.notvalid}")
    @DecimalMin(value = "1.00", message = "{amount.decimalmin}")
    @DecimalMax(value = "1000.00", message = "{amount.decimalmax}")
    private BigDecimal amount;

    @ValidCurrency
    private String currency;
}
