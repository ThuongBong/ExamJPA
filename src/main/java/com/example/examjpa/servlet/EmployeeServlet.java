package com.example.examjpa.servlet;

import com.example.examjpa.dao.EmployeeDAO;
import com.example.examjpa.entity.EmployeeEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "employeeServlet", value = {"/employeeServlet"})

public class EmployeeServlet extends HttpServlet {

    EmployeeDAO employeeDAO = new EmployeeDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<EmployeeEntity> listEmployee = employeeDAO.getAllEmployees();
        req.setAttribute("listEmployee", listEmployee);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("fullName");
        String birthday = req.getParameter("birthday");
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String department = req.getParameter("department");

        EmployeeEntity employeeEntity = new EmployeeEntity(fullName, Date.valueOf(birthday), address, position, department);
        employeeDAO.insertEmployee(employeeEntity);

        req.setAttribute("message", "Create new employee successfully");

        List<EmployeeEntity> listEmployee = employeeDAO.getAllEmployees();

        req.setAttribute("listEmployee", listEmployee);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
