package project.financialplanning.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import project.financialplanning.models.Goal;
import project.financialplanning.repositories.GoalRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class GoalServiceTest {

    @Mock
    GoalRepository repository;

    @InjectMocks
    GoalService service;

    @Test
    void findGoal() {
        List<Goal> goal = Arrays.asList(new Goal(1L, "Apartament", "Reserve", new BigDecimal("100000.00"), new BigDecimal("1200.00"), false));

        when(repository.findAll()).thenReturn(goal);

        List<Goal> result = service.showAllGoals();

        assertEquals(1, result.size());

    }
}