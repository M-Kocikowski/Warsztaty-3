package pl.coderslab.warsztaty3.controller;

import pl.coderslab.warsztaty3.JoinedSolution;
import pl.coderslab.warsztaty3.dao.ExercisesDAO;
import pl.coderslab.warsztaty3.dao.SolutionsDAO;
import pl.coderslab.warsztaty3.dao.UsersDAO;
import pl.coderslab.warsztaty3.model.Exercise;
import pl.coderslab.warsztaty3.model.Solution;
import pl.coderslab.warsztaty3.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/userdetails")
public class UserDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int userId = Integer.parseInt(request.getParameter("userId"));
        List<JoinedSolution> joinedSolutions = new ArrayList<>();

        UsersDAO usersDAO = new UsersDAO();
        User user = usersDAO.read(userId);

        SolutionsDAO solutionsDAO = new SolutionsDAO();
        List<Solution> solutionsByUser = solutionsDAO.findSolutionsByUser(userId);

        for (Solution s : solutionsByUser){
            ExercisesDAO exercisesDAO = new ExercisesDAO();
            Exercise exercise = exercisesDAO.read(s.getExercise_id());
            joinedSolutions.add(new JoinedSolution(exercise, s, user));
        }

        request.setAttribute("solutions", joinedSolutions);
        request.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/WEB-INF/userDetails.jsp").forward(request,response);
    }
}
