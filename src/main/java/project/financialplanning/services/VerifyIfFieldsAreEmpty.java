package project.financialplanning.services;


import project.financialplanning.dtos.GoalDtoUpdate;
import project.financialplanning.models.Goal;

public class VerifyIfFieldsAreEmpty {
    
    private GoalService service;

    
    public Goal VerifyFields(GoalDtoUpdate dto) {
        Goal goal = new Goal();

        if(!dto.goal().isBlank()) goal.setGoal(dto.goal());

        if(!dto.description().isBlank()) goal.setDescription(dto.description());

        //Blank doens't work in BigDecimal.
        if(dto.goalValue().compareTo(dto.goalValue()) > 0) goal.setGoalValue(dto.goalValue());

        if(dto.presentValue().compareTo(dto.presentValue()) >= 0) goal.setPresentValue(dto.presentValue());

        return goal;

    }


}
