package pl.coderslab.warsztaty3;

import pl.coderslab.warsztaty3.model.Exercise;
import pl.coderslab.warsztaty3.model.Solution;
import pl.coderslab.warsztaty3.model.User;

public class JoinedSolution {

    private Exercise exercise;
    private Solution solution;
    private User user;

    public JoinedSolution(Exercise exercise, Solution solution, User user) {
        this.exercise = exercise;
        this.solution = solution;
        this.user = user;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
