package hn.jiah.apivalidatorbean.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimplePojoV2 {
    private String username;
    private String email;
    private BigDecimal amount;
    private String currency;
}
