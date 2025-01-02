package project.financialplanning.dtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record GoalDto(
        @NotBlank String goal, String description,
        @Digits(integer = 12, fraction = 2) @Positive BigDecimal goalValue,
        @NotBlank @Digits(integer = 12, fraction = 2) @PositiveOrZero BigDecimal presentValue
) {}
