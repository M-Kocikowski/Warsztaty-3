package pl.coderslab.warsztaty3.controller;

import pl.coderslab.warsztaty3.dao.GroupsDAO;
import pl.coderslab.warsztaty3.dao.UsersDAO;
import pl.coderslab.warsztaty3.model.Group;
import pl.coderslab.warsztaty3.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showUsers")
public class UsersInGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("groupId");

        if (id != null){
            int groupId = Integer.parseInt(id);
            GroupsDAO groupsDAO = new GroupsDAO();
            Group read = groupsDAO.read(groupId);
            UsersDAO usersDAO = new UsersDAO();
            List<User> allByGroupId = usersDAO.findAllByGroupId(read.getId());

            request.setAttribute("groupName", read.getName());
            request.setAttribute("users", allByGroupId);
        }
        else {
            UsersDAO usersDAO = new UsersDAO();
            List<User> allUsers = usersDAO.findAllUsers();

            request.setAttribute("users", allUsers);
        }


        getServletContext().getRequestDispatcher("/WEB-INF/usersInGroup.jsp").forward(request, response);
    }
}
