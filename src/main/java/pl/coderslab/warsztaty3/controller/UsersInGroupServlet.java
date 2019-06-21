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

@WebServlet("/showusersbygroup")
public class UsersInGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int groupId = Integer.parseInt(request.getParameter("groupId"));
        GroupsDAO groupsDAO = new GroupsDAO();
        Group read = groupsDAO.read(groupId);
        UsersDAO usersDAO = new UsersDAO();
        List<User> allByGroupId = usersDAO.findAllByGroupId(read.getId());

        request.setAttribute("groupName", read.getName());
        request.setAttribute("usersInGroup", allByGroupId);

        getServletContext().getRequestDispatcher("/WEB-INF/usersInGroup.jsp").forward(request, response);
    }
}
