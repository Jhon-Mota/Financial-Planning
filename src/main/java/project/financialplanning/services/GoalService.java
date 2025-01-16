package project.financialplanning.services;

import org.springframework.stereotype.Service;
import project.financialplanning.dtos.GoalDto;
import project.financialplanning.dtos.GoalDtoUpdate;
import project.financialplanning.exceptions.GoalNotFoundException;
import project.financialplanning.models.Goal;
import project.financialplanning.repositories.GoalRepository;

import java.math.BigDecimal;
import java.util.List;


@Service
public class GoalService {

    private final GoalRepository repository;

    public GoalService(GoalRepository repository) {
        this.repository = repository;
    }

    public Goal createGoal(GoalDto dto) {
        Goal goal = new Goal();

        goal.setGoal(dto.goal());
        goal.setDescription(dto.description());
        goal.setGoalValue(dto.goalValue());
        goal.setPresentValue(dto.presentValue());

        if(dto.presentValue().compareTo(dto.goalValue()) < 0) goal.setGoalCompleted(false);
        else goal.setGoalCompleted(true);

        return repository.save(goal);
    }

    public List<Goal> showAllGoals() {
        return this.repository.findAll();
    }

    public List<Goal> findGoal(String goalTitle) {
        List<Goal> goal = this.repository.findByGoal(goalTitle);

        if(goal.isEmpty()) throw new GoalNotFoundException();

        return goal;
    }

    public Goal updateGoal(Long goalId, GoalDtoUpdate dto) {
        
        Goal goal = this.repository.findById(goalId).orElseThrow(() -> new GoalNotFoundException());
    
        if(!dto.goal().isBlank()) goal.setGoal(dto.goal());

        if(!dto.description().isBlank()) goal.setDescription(dto.description());

        if(dto.goalValue().compareTo(BigDecimal.ZERO) > 0) goal.setGoalValue(dto.goalValue());

        if(dto.presentValue() != null) goal.setPresentValue(dto.presentValue());

        return this.repository.save(goal);
    }

    public void deleteGoal(Long id) {
        this.repository.findById(id).orElseThrow(() -> new GoalNotFoundException());
        
        this.repository.deleteById(id);
    }

}

