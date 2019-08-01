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

@WebServlet("/userAdmin")
public class UserAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userId = request.getParameter("userId");
        if (userId != null){
            UsersDAO usersDAO = new UsersDAO();
            User user = usersDAO.read(Integer.parseInt(userId));
            user.setUserName(request.getParameter("userName"));
            user.setEmail(request.getParameter("email"));
            user.setGroup_id(Integer.parseInt(request.getParameter("groupId")));
            usersDAO.update(user);
        }else {
            String userName = request.getParameter("userName");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = new User(userName, email, password);
            user.setGroup_id(Integer.parseInt(request.getParameter("groupId")));

            UsersDAO usersDAO = new UsersDAO();
            usersDAO.create(user);
        }

//        System.out.println("User Name: " + request.getParameter("userName"));
//        System.out.println("User ID: " + request.getParameter("userId"));
//        System.out.println("Email: " + request.getParameter("email"));
//        System.out.println("Group ID: " + request.getParameter("groupId"));

        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("userId");

        if (id != null){
            int userId = Integer.parseInt(id);
            UsersDAO usersDAO = new UsersDAO();
            User user = usersDAO.read(userId);
            GroupsDAO groupsDAO = new GroupsDAO();
            Group group = groupsDAO.read(user.getGroup_id());
            request.setAttribute("user", user);
            request.setAttribute("group", group);
        }

        GroupsDAO groupsDAO = new GroupsDAO();
        List<Group> allGroups = groupsDAO.findAllGroups();
        request.setAttribute("allGroups", allGroups);

        request.getRequestDispatcher("/WEB-INF/usersAdmin.jsp").forward(request, response);
    }
}
