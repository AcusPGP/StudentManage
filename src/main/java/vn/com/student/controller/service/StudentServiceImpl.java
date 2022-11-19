package vn.com.student.controller.service;

import vn.com.student.controller.pojo.SinhVienBE;
import vn.com.student.controller.pojo.dao.SinhVienDAO;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    @Override
    public int delSinhVien(String id) {
        String sCondition = "where " + SinhVienDAO.COLUMN_MASV + "=" + SinhVienDAO.toSqlValue(id);
        return 0;
    }

    @Override
    public List<SinhVienBE> getList() {
        return SinhVienDAO.getListSinhVien();
    }
}
