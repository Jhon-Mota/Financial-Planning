package project.financialplanning.dtos;

import java.math.BigDecimal;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Transactional
public record GoalDtoUpdate(
        String goal, String description,    
        @Digits(integer = 12, fraction = 2) @Positive BigDecimal goalValue, //Lauch a exception if value is 0.
        @Digits(integer = 12, fraction = 2) @PositiveOrZero BigDecimal presentValue) {
    
}
