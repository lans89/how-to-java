package hn.jiah.apivalidatorbean.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimplePojo {
    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "invalid email value")
    private String email;

    @NotNull(message = "Amount is required")
    @Digits(integer = 6, fraction = 2, message = "invalid Amount value")
    @DecimalMin(value = "1.00", message = "Amount must be greater than 0.00")
    @DecimalMax(value = "1000.00", message = "Amount must be less than 1000.00")
    private BigDecimal amount;

    @NotBlank(message = "Currency is required")
    @Length(min = 3, max = 3, message = "Currency length must be exactly 3 characters")
    @Pattern(regexp = "\\w+", message = "invalid currency value")
    private String currency;

}
