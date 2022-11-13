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

    public String masv;

    public String hoten;

    public String maLop;

    public String gioiTinh;

    public String ngaySinh;

    public String ngayTao;
}
