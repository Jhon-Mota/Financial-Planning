package project.financialplanning.models;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "goals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 20)
    private String goal;

    @Column(nullable = true, length = 80)
    private String description;

    @Digits(integer = 12, fraction = 2)
    @Positive
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal goalValue;

    @Digits(integer = 12, fraction = 2)
    @PositiveOrZero
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal presentValue;

    private Boolean goalCompleted;

}
