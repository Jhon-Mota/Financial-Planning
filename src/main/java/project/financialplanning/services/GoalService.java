package project.financialplanning.services;

import org.springframework.stereotype.Service;
import project.financialplanning.dtos.GoalDto;
import project.financialplanning.dtos.GoalDtoUpdate;
import project.financialplanning.exceptions.GoalNotFindException;
import project.financialplanning.models.Goal;
import project.financialplanning.repositories.GoalRepository;

import java.util.List;
import java.util.Optional;


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

        if(goal.isEmpty()) throw new GoalNotFindException();

        return goal;
    }

    public Goal updateGoal(Long goalId, GoalDtoUpdate dto) {
        Optional<Goal> goalData = this.repository.findById(goalId);
        VerifyIfFieldsAreEmpty verify = new VerifyIfFieldsAreEmpty();

        if(goalData.isEmpty()) throw new GoalNotFindException();

        verify.VerifyFields(dto);

        Goal goalInfo = verify.VerifyFields(dto);

        return this.repository.save(goalInfo);


    }

}

