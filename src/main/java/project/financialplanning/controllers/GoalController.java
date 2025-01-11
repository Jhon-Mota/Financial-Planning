package project.financialplanning.controllers;

import org.springframework.web.bind.annotation.*;
import project.financialplanning.dtos.GoalDto;
import project.financialplanning.models.Goal;
import project.financialplanning.services.GoalService;

import java.util.List;

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
        return "Your goal was been created.";
    }

    @GetMapping
    private List<Goal> showAll() {
        return this.service.showAllGoals();
    }

    @GetMapping("/{goal}")
    private List<Goal> findOne(@PathVariable(value = "goal") String goalTitle) {

        return this.service.findGoal(goalTitle);
    }

}
