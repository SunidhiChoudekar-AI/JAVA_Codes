package com.employee;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<Employee> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                Employee e = new Employee();
                e.setEmpId(rs.getString("emp_id"));
                e.setName(rs.getString("name"));
                e.setEmail(rs.getString("email"));
                e.setDepartment(rs.getString("department"));
                e.setSalary(rs.getString("salary"));
                list.add(e);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("list", list);
        req.getRequestDispatcher("view.jsp").forward(req, res);
    }
}
