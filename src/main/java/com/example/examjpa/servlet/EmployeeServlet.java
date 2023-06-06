package com.example.examjpa.servlet;

import com.example.examjpa.dao.EmployeeDAO;
import com.example.examjpa.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "EmployeeServlet", value = {"/employeeServlet"})

public class EmployeeServlet extends HttpServlet {

    EmployeeDAO employeeDAO = new EmployeeDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Employee> listUser = employeeDAO.getAllEmployee();
        req.setAttribute("list", listUser);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            String fullName = req.getParameter("fullName");
            String birthday = req.getParameter("birthday");
            String address = req.getParameter("address");
            String position = req.getParameter("position");
            String department = req.getParameter("department");

            Employee employee = new Employee(fullName, Date.valueOf(birthday), address, position, department);
            if (employee.getId() == null) {
                employeeDAO.insertEmployee(employee);
            }
            employee = employeeDAO.getEmployeeById(id);
            employee.setFullName(fullName);
            employee.setBirthday(Date.valueOf(birthday));
            employee.setAddress(address);
            employee.setPosition(position);
            employee.setDepartment(department);

            List<Employee> listUser = EmployeeDAO.getAllEmployee();
            req.setAttribute("list", listUser);

            req.getRequestDispatcher("/User/list.jsp").forward(req,resp);
        }catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
