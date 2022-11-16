package vn.com.student.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
@WebServlet(name = "studentServlet", value = "/student-servlet")
public class StudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void init() {
        String message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the content type
        response.setContentType("text/html");
        // Get the print writer
        PrintWriter out = response.getWriter();
        showList(out);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void destroy() {
    }

    private void showList(PrintWriter out) {
        // Connect to database
        Connection connection = StudentApp.getConnection();
        // Statement statement
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SINHVIEN;");
            out.println("<html><body>");
            out.println("<table border=1 width=100%>");
            out.println("<tr><th>ID</th><th>NAME</th><th>CLASS ID</th><th>GENDER</th><th>BIRTH</th><th>ADDRESS</th><tr>");
            while (resultSet.next()) {
                // Variables
                String id = resultSet.getString("masv");
                String name = resultSet.getString("hoten");
                String class_id = resultSet.getString("maLop");
                String gender = resultSet.getString("gioitinh");
                Date birth = resultSet.getDate("ngaysinh");
                String address = resultSet.getString("diachi");
                // Output the database in console
                System.out.printf("%20s %20s %20s %20s %20s %20s%n", id, name, class_id, gender, birth.toString(), address);
                // Display the database in web
                out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + class_id + "</td><td>" + gender + "</td><td>" + birth + "</td><td>" + address + "</td></tr>");
            }
            out.println("</table>");
            out.println("</html></body>");
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Operation is executed successfully!");
        } catch (SQLException e) {
            log.info(e.getMessage());
        }
    }
}
