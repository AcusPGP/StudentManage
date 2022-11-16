package vn.com.student.controller.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SinhVienBE {

    private String masv;

    private String hoten;

    private String maLop;

    private String gioiTinh;

    private String ngaySinh;

    private String ngayTao;

    private String diachi;
}
