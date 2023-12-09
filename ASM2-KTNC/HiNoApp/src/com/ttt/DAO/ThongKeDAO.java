/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.DAO;

import com.ttt.LibaryHelper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ThongKeDAO {

    public static ThongKeDAO getNewThongKeDAO() {
        return new ThongKeDAO();
    }

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String getMaAuto(String sql) {
        String getMa = null;
        try {
            ResultSet rs = JdbcHelper.query(sql);
            while (rs.next()) {
                getMa = rs.getString(1);
            }
            rs.getStatement().getConnection().close();
            //return getMa;
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getMa;
    }

    public List<Object[]> getSoLuongBan(String maNVKD, String maLoaiXe) {
        String sql = "{CALL SP_doanh_so(?,?)}";
        String[] cols = {"ma_loai_xe", "dong_xe", "ten_loai_xe", "so_luong_xuat", "ten_khach_hang", "ten_nhanh_nien"};
        return this.getListOfArray(sql, cols, maNVKD, maLoaiXe);
    }

    public List<Object[]> getXuatFileSoLuongBan() {
        String sql = "{CALL SP_doanh_so_xuatFile}";
        String[] cols = {"ma_loai_xe", "dong_xe", "ten_loai_xe", "so_luong_xuat", "ten_khach_hang", "ten_nhanh_nien"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getSoLuongTonKho(String maLoaiXe, String maViTri) {
        String sql = "{CALL SP_so_luong_ton_kho(?,?)}";
        String[] cols = {"ma_loai_xe", "dong_xe", "ten_loai_xe", "so_luong_nhap", "ten_vi_tri"};
        return this.getListOfArray(sql, cols, maLoaiXe, maViTri);
    }

    public List<Object[]> getSLTonKho() {
        String sql = "{CALL SP_SL_ton_kho}";
        String[] cols = {"ma_loai_xe", "dong_xe", "ten_loai_xe", "so_luong_nhap", "ten_vi_tri"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getDoanhThu() {
        String sql = "{CALL SP_doanh_thu}";
        String[] cols = {"ma_loai_xe", "ten_loai_xe", "so_luong_xuat", "doanh_thu"};
        return this.getListOfArray(sql, cols);
    }

    public List<Object[]> getDoanhThuTheoNgay(String date1, String date2) {
        String sql = "{CALL SP_doanh_thu_theo_ngay(?,?)}";
        String[] cols = {"ma_loai_xe", "ten_loai_xe", "so_luong_xuat", "doanh_thu"};
        return this.getListOfArray(sql, cols, date1, date2);
    }

    public List<Object[]> getSoLuongCuaNhanVienKD() {
        String sql = "{CALL SP_doanh_so_nvkd}";
        String[] cols = {"ma_nhan_vien_kd", "ten_nhanh_nien", "so_luong_xuat"};
        return this.getListOfArray(sql, cols);
    }

    public String getMaPhieuNhapKho() {
        String sql = "{CALL SP_phieu_nhap_auto_id}";
        return this.getMaAuto(sql);
    }

    public String getMaPhieuXuatKho() {
        String sql = "{CALL SP_phieu_xuat_auto_id}";
        return this.getMaAuto(sql);
    }

    public String getMaKhachHang() {
        String sql = "{CALL SP_khach_hang_auto_id}";
        return this.getMaAuto(sql);
    }

    public String getMaViTri() {
        String sql = "{CALL SP_vi_tri_auto_id}";
        return this.getMaAuto(sql);
    }

    public String getMaNhanVien() {
        String sql = "{CALL SP_nhan_vien_auto_id}";
        return this.getMaAuto(sql);
    }

}
