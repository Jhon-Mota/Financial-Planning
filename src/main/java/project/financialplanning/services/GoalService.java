package project.financialplanning.services;

import org.springframework.stereotype.Service;
import project.financialplanning.dtos.GoalDto;
import project.financialplanning.exceptions.GoalNotFindException;
import project.financialplanning.models.Goal;
import project.financialplanning.repositories.GoalRepository;

import java.util.List;
import java.util.Optional;


@Service
public class GoalService {

    private GoalRepository repository;

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

    public Optional<Goal> findGoal(String goalTitle) {
        Optional<Goal> goal = this.repository.findByGoal(goalTitle);

        if(goal.isEmpty()) throw new GoalNotFindException();

        return goal;

    }

}

