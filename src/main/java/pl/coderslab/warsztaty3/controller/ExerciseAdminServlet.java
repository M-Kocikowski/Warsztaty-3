package pl.coderslab.warsztaty3.controller;

import pl.coderslab.warsztaty3.dao.ExercisesDAO;
import pl.coderslab.warsztaty3.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exerciseAdmin")
public class ExerciseAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String exerciseDescription = request.getParameter("exerciseDescription");
        String exerciseTitle = request.getParameter("exerciseTitle");

        String exerciseId = request.getParameter("exerciseId");
        if (exerciseId != null){
            ExercisesDAO exercisesDAO = new ExercisesDAO();
            Exercise exercise = exercisesDAO.read(Integer.parseInt(exerciseId));
            exercise.setTitle(exerciseTitle);
            exercise.setDescription(exerciseDescription);
            exercisesDAO.update(exercise);
        }else {
            Exercise exercise = new Exercise(exerciseTitle, exerciseDescription);
            ExercisesDAO exercisesDAO = new ExercisesDAO();
            exercisesDAO.create(exercise);
        }
        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String exerciseId = request.getParameter("exerciseId");
        if (exerciseId != null){
            ExercisesDAO exercisesDAO = new ExercisesDAO();
            Exercise exercise = exercisesDAO.read(Integer.parseInt(exerciseId));
            request.setAttribute("exercise", exercise);
        }
        request.getRequestDispatcher("/WEB-INF/exercisesAdmin.jsp").forward(request, response);
    }
}
