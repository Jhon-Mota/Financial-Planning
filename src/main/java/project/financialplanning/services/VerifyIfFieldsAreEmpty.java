package project.financialplanning.services;

import java.util.Optional;

import project.financialplanning.dtos.GoalDtoUpdate;
import project.financialplanning.models.Goal;

public class VerifyIfFieldsAreEmpty {
    
    private GoalService service;

    
    public VerifyIfFieldsAreEmpty(GoalDtoUpdate dto) {
        Goal goal = new Goal();

        if(!dto.goal().isBlank()) goal.setGoal(dto.goal());

        if(!dto.description().isBlank()) goal.setGoal(dto.description());

        //Blank doens't work in BigDecimal.
        if(!dto.goalValue().isBlank()) goal.setGoalValue(dto.goalValue());

        if(!dto.presentValue().isBlank()) goal.setPresentValue(dto.presentValue());


    }


}
