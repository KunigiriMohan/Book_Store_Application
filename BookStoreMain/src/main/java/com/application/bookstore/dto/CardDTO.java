package com.application.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardDTO {

    @Pattern(regexp = "^4[0-9]{12}(?:[0-9]{3})?$")
    private String cardNumber;

    @JsonFormat(pattern = "MM yyyy")
    @NotNull(message = "StartDate should not Empty")
    private LocalDate expiryDate;

    @Pattern(regexp = "^[0-9]{3}$")
    private String cvvNumber;
}
