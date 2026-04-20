package com.employee;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class EmployeeServlet extends HttpServlet {

    // called when form is submitted
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String empId      = req.getParameter("empId");
        String name       = req.getParameter("name");
        String email      = req.getParameter("email");
        String department = req.getParameter("department");
        String salary     = req.getParameter("salary");

        // insert into database
        try {
            Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO employee VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, empId);
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, department);
            ps.setString(5, salary);
            ps.executeUpdate();
            con.close();

            // redirect to success page
            res.sendRedirect("success.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Error: " + e.getMessage());
            req.getRequestDispatcher("index.jsp").forward(req, res);
        }
    }
}
