package pl.coderslab.warsztaty3.controller;

import pl.coderslab.warsztaty3.dao.SolutionsDAO;
import pl.coderslab.warsztaty3.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solution")
public class SolutionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        SolutionsDAO solutionsDAO = new SolutionsDAO();
        Solution read = solutionsDAO.read(id);

        request.setAttribute("solutionDescription", read);
        getServletContext().getRequestDispatcher("/WEB-INF/solutionDetails.jsp").forward(request,response);

    }
}
