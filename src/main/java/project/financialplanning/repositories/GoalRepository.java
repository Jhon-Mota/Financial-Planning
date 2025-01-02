package project.financialplanning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.financialplanning.models.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long>{
}
