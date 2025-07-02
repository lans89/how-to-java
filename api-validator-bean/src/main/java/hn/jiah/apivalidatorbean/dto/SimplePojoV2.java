package hn.jiah.apivalidatorbean.dto;

import hn.jiah.apivalidatorbean.annotation.CustomValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@CustomValidator
public class SimplePojoV2 {
    private String username;
    private String email;
    private BigDecimal amount;
    private String currency;
}
