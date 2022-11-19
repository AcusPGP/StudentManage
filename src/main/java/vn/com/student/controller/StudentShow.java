package vn.com.student.controller;

import lombok.extern.slf4j.Slf4j;
import vn.com.student.controller.pojo.SinhVienBE;
import vn.com.student.controller.service.StudentService;
import vn.com.student.controller.service.StudentServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Slf4j
@WebServlet(name = "studentServlet", value = "/student-show")
public class StudentShow extends HttpServlet {
    private static final long serialVersionUID = 1L;

    StudentService studentService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set the content type
        response.setContentType("text/html");
        // Get the print writer
        PrintWriter out = response.getWriter();
        showList(out);
    }

    private void showList(PrintWriter out) {
        studentService = new StudentServiceImpl();
        List<SinhVienBE> list = studentService.getList();
        out.println("<html><body>");
        out.println("<table border=1 width=100%>");
        out.println("<tr><th>ID</th><th>NAME</th><th>CLASS ID</th><th>GENDER</th><th>BIRTH</th><th>ADDRESS</th><tr>");
        for (SinhVienBE sv : list) {
            System.out.printf("%20s %20s %20s %20s %20s %20s%n", sv.getMasv(), sv.getHoten(),
                    sv.getMaLop(), sv.getGioiTinh(), sv.getNgaySinh(), sv.getDiachi());
            out.println("<tr><td>" + sv.getMasv() + "</td><td>" + sv.getHoten() + "</td><td>" + sv.getMaLop()
                    + "</td><td>" + sv.getGioiTinh() + "</td><td>" + sv.getNgaySinh() + "</td><td>" + sv.getDiachi() + "</td></tr>");
        }
        out.println("</table>");
        out.println("</html></body>");
    }
}
