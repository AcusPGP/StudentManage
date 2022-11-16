package vn.com.student.controller;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebServlet(name = "studentInsert", value = "/student-insert")
public class StudentInsert extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the content type
        response.setContentType("text/html");
        // Get the print writer
        PrintWriter out = response.getWriter();
        out.println("<h3>You are in insert.jsp!</h3>");
    }
}
