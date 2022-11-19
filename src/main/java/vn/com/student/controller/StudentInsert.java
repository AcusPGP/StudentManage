package vn.com.student.controller;

import lombok.extern.slf4j.Slf4j;
import vn.com.student.controller.pojo.SinhVienBE;
import vn.com.student.controller.pojo.dao.SinhVienDAO;

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
        if (request.getParameter("event") != null) {
            onInsertButton(request);
            out.println("<h3>You are in insert.jsp!</h3>");
        } else {
            System.out.println("Failed!");
        }
    }

    public void onInsertButton(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String class_id = request.getParameter("class_id");
        String birth = request.getParameter("birth");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        SinhVienBE newSinhVien = SinhVienBE.builder()
                .masv(id)
                .hoten(name)
                .maLop(class_id)
                .ngaySinh(birth)
                .gioiTinh(gender)
                .diachi(address)
                .build();
        int result = SinhVienDAO.insert(newSinhVien);
        System.out.println("Number: " + result);
    }
}
