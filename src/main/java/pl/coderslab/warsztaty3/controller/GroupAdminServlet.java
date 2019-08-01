package pl.coderslab.warsztaty3.controller;

import pl.coderslab.warsztaty3.dao.GroupsDAO;
import pl.coderslab.warsztaty3.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/groupAdmin")
public class GroupAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("groupId");
        String groupName = request.getParameter("groupName");

        if (id != null){
            int groupId = Integer.parseInt(id);
            Group group = new Group(groupName);
            group.setId(groupId);
            GroupsDAO groupsDAO = new GroupsDAO();
            groupsDAO.update(group);
        }
        else {
            Group group = new Group(groupName);
            GroupsDAO groupsDAO = new GroupsDAO();
            groupsDAO.create(group);
        }
        response.sendRedirect("/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Id = request.getParameter("groupId");
        if (Id != null){
            int groupId = Integer.parseInt(Id);
            GroupsDAO groupsDAO = new GroupsDAO();
            Group group = groupsDAO.read(groupId);
            request.setAttribute("group", group);
        }
        request.getRequestDispatcher("/WEB-INF/groupsAdmin.jsp").forward(request, response);
    }
}
