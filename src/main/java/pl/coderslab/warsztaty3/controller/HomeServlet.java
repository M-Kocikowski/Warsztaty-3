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

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<JoinedSolution> joinedSolutions = new ArrayList<>();
        SolutionsDAO solutionsDAO = new SolutionsDAO();
        UsersDAO usersDAO = new UsersDAO();
        ExercisesDAO exercisesDAO = new ExercisesDAO();
//        Zamiast używać stałej wartości można wczytać parametr z web.xml
//        List<Solution> lastSolutions = solutionsDAO.findLastSolutions(5);
        List<Solution> lastSolutions = solutionsDAO.findLastSolutions(getParameterContext());
        for (Solution s : lastSolutions){
            Exercise e  = exercisesDAO.read(s.getExercise_id());
            User u = usersDAO.read(s.getUser_id());
            joinedSolutions.add(new JoinedSolution(e, s, u));
        }
        request.setAttribute("solutions", joinedSolutions);
        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

    }

    private int getParameterContext(){
        return Integer.parseInt(getServletContext().getInitParameter("number-solutions"));
    }
}
