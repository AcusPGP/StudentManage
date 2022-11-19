package vn.com.student.controller.service;

import vn.com.student.controller.pojo.SinhVienBE;

import java.util.List;

public interface StudentService {


    public int delSinhVien(String id) ;


    public List<SinhVienBE> getList();
}
