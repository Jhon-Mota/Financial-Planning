package project.financialplanning.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.financialplanning.dtos.GoalDto;
import project.financialplanning.services.GoalService;

@RestController
@RequestMapping("/goal")
public class GoalController {

    private GoalService service;

    public GoalController(GoalService service) {
        this.service = service;
    }

    @PostMapping
    private String createGoal(@RequestBody GoalDto dto) {
        this.service.createGoal(dto);
        return "Your goal was been created!";
    }



}
