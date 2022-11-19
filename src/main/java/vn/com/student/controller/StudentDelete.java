package vn.com.student.controller;

import vn.com.student.controller.pojo.SinhVienBE;
import vn.com.student.controller.pojo.dao.SinhVienDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "studentDelete", value = "/student-delete")
public class StudentDelete extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the content type
        response.setContentType("text/html");
        // Get the print writer
        PrintWriter out = response.getWriter();
        if (request.getParameter("delete") != null) {
            delete(request);
        } else {
            System.out.println("Failed");
        }
    }

    private void delete(HttpServletRequest request) {
        String id = request.getParameter("id");
        SinhVienBE sinhVienBE = SinhVienBE.builder().masv(id).build();
        int result = SinhVienDAO.delete(sinhVienBE);
        System.out.println("Number: " + result);
    }
}
