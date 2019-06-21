package pl.coderslab.warsztaty3.controller;

import pl.coderslab.warsztaty3.dao.GroupsDAO;
import pl.coderslab.warsztaty3.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/groups")
public class GroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GroupsDAO groupsDAO = new GroupsDAO();
        List<Group> allGroups = groupsDAO.findAllGroups();
        request.setAttribute("groups", allGroups);
        getServletContext().getRequestDispatcher("/WEB-INF/groups.jsp").forward(request, response);

    }
}
