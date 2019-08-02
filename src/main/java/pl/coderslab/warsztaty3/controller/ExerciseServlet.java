package pl.coderslab.warsztaty3.controller;

import pl.coderslab.warsztaty3.dao.ExercisesDAO;
import pl.coderslab.warsztaty3.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/exercises")
public class ExerciseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ExercisesDAO exercisesDAO = new ExercisesDAO();
        List<Exercise> allExercises = exercisesDAO.findAllExercises();
        request.setAttribute("exercises", allExercises);
        request.getRequestDispatcher("/WEB-INF/exercises.jsp").forward(request, response);

    }
}
