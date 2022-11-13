package vn.com.student.controller.pojo.dao;

import vn.com.student.controller.StudentApp;
import vn.com.student.controller.pojo.SinhVienBE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SinhVienDAO {

    public static final String TABLE_NAME = "SINHVIEN";

    public static final String COLUMN_MASV = "MASV";

    public static final String COLUMN_HOTEN = "HOTEN";

    public static final String COLUMN_MALOP = "MALOP";

    public static final String COLUMN_GIOITINH = "GIOITINH";

    public static final String COLUMN_NGAYSINH = "NGAYSINH";

    public static final String COLUMN_NGAYTAO = "NGAYTAO";

    private int doInsert(SinhVienBE sinhvien) {

        Connection con = null;
        String sql = "insert into " + TABLE_NAME + "(";
        sql += COLUMN_MASV + ", " + COLUMN_HOTEN + ", " + COLUMN_MALOP  + ", ";
        sql += COLUMN_GIOITINH + ", " + COLUMN_NGAYSINH + ", " + COLUMN_NGAYTAO;
        sql += ") values(";
        sql += sinhvien.getMasv() + "," + sinhvien.getHoten() + "," + sinhvien.getMaLop() + ",";
        sql += sinhvien.getGioiTinh() + "," + sinhvien.getNgaySinh() + "," + sinhvien.getNgayTao();
        sql += ")";

        try {
            con = StudentApp.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            int result = statement.executeUpdate();
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static final int insert(SinhVienBE sinhvien) {
        SinhVienDAO dao = new SinhVienDAO() ;
        return dao.doInsert(sinhvien);
    }
}
