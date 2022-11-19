package vn.com.student.controller.pojo.dao;

import vn.com.student.controller.StudentApp;
import vn.com.student.controller.pojo.SinhVienBE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {

    public static final String TABLE_NAME = "SINHVIEN";

    public static final String COLUMN_MASV = "MASV";

    public static final String COLUMN_HOTEN = "HOTEN";

    public static final String COLUMN_MALOP = "MALOP";

    public static final String COLUMN_GIOITINH = "GIOITINH";

    public static final String COLUMN_NGAYSINH = "NGAYSINH";

    public static final String COLUMN_ADDRESS = "DIACHI";

    private List<SinhVienBE> list() {
        List<SinhVienBE> list = new ArrayList<>();
        String sql = "select ";
        sql += COLUMN_MASV + "," + COLUMN_HOTEN;
        sql += "," + COLUMN_MALOP + "," + COLUMN_GIOITINH + "," + COLUMN_NGAYSINH + ","  + COLUMN_ADDRESS;
        sql += " from " + TABLE_NAME;
        Connection connection = null;
        try {
            connection = StudentApp.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                SinhVienBE sv = SinhVienBE.builder()
                        .masv(resultSet.getString(COLUMN_MASV))
                        .hoten(resultSet.getString(COLUMN_HOTEN))
                        .maLop(resultSet.getString(COLUMN_HOTEN))
                        .gioiTinh(resultSet.getString(COLUMN_GIOITINH))
                        .ngaySinh(resultSet.getDate(COLUMN_NGAYSINH).toString())
                        .diachi(resultSet.getString(COLUMN_ADDRESS))
                        .build();
                list.add(sv);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

    public static final List<SinhVienBE> getListSinhVien() {
        return new SinhVienDAO().list();
    }

    public static final String toSqlValue(Object obj) {
        if(obj instanceof String) {
            return "'" + obj + "'";
        } else if(obj instanceof Integer)
            return obj + "";
        return "'" + obj + "'";
    }

    private int doInsert(SinhVienBE sinhvien) {

        Connection con = null;
        String sql = "insert into " + TABLE_NAME + "(";
        sql += COLUMN_MASV + ", " + COLUMN_HOTEN + ", " + COLUMN_MALOP  + ", ";
        sql += COLUMN_GIOITINH + ", " + COLUMN_NGAYSINH + ", " + COLUMN_ADDRESS;
        sql += ") values(";
        sql += toSqlValue(sinhvien.getMasv()) + "," + toSqlValue(sinhvien.getHoten()) + "," + toSqlValue(sinhvien.getMaLop()) + ",";
        sql += toSqlValue(sinhvien.getGioiTinh()) + "," + toSqlValue(sinhvien.getNgaySinh()) + "," + toSqlValue(sinhvien.getDiachi());
        sql += ")";

        try {
            con = StudentApp.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            return statement.executeUpdate();
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

    private int doDelete(SinhVienBE sinhvien) {

        Connection connection = null;
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_MASV + "=" + toSqlValue(sinhvien.getMasv()) + ";";

        try {
            connection = StudentApp.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void doDelete(String sCondition) {
        Connection connection = null;
        String sql = "DELETE FROM " + TABLE_NAME + sCondition;
        try {

        } catch(Exception e) {

        }

    }


    public static final int delete(String sCondtion) {
        return 0;
    }

    public static final int insert(SinhVienBE sinhvien) {
        SinhVienDAO dao = new SinhVienDAO() ;
        return dao.doInsert(sinhvien);
    }

    public static final int delete(SinhVienBE sinhvien) {
        SinhVienDAO dao = new SinhVienDAO();
        return dao.doDelete(sinhvien);
    }
}
