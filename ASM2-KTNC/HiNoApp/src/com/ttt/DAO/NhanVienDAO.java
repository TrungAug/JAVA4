/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.DAO;

import com.ttt.Entity.ChiNhanh;
import com.ttt.Entity.ChiTietPhieuNhap;
import com.ttt.Entity.NhanVien;
import com.ttt.LibaryHelper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class NhanVienDAO extends HiNoDAO<NhanVien, String> {

    String insert_sql = "INSERT INTO NhanVien VALUES(?,?,?,?,?,?,?,?,?,?)";
    String update_sql = "UPDATE NhanVien SET  mat_khau=?,ten_nhanh_nien=?, ngay_sinh=?, gioi_tinh=?, dia_chi=?, email=?, chucVu=?, ma_phong_ban=?, hinh=? WHERE ma_nhan_vien=?";
    String delete_sql = "DELETE FROM NhanVien WHERE ma_nhan_vien=?";
    String select_all_sql = "SELECT * FROM NhanVien";
    String select_by_id_sql = "SELECT * FROM NhanVien WHERE ma_nhan_vien=?";
    String select_by_PKD_sql="select * from NhanVien where ma_phong_ban like 'KD%'";
    
    
    public static NhanVienDAO getNewNhanVienDAO() {
        return new NhanVienDAO();
    }

    @Override
    public void insert(NhanVien e) {
        try {
            JdbcHelper.update(insert_sql, e.getMaNV(), e.getMatKhau(), e.getHoTen(), e.getNgaySinh(), e.getGioiTinh(), e.getDiaChi(), e.getEmail(), e.getChucVu(), e.getMaPhong(), e.getHinh());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NhanVien e) {
        try {
            JdbcHelper.update(update_sql, e.getMatKhau(), e.getHoTen(), e.getNgaySinh(), e.getGioiTinh(), e.getDiaChi(), e.getEmail(), e.getChucVu(), e.getMaPhong(), e.getHinh(), e.getMaNV());
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.update(delete_sql, id);
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public NhanVien selectById(String id) {
        List<NhanVien> list = this.selectBySql(select_by_id_sql, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectAll() {
        return this.selectBySql(select_all_sql);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString(1));
                nv.setMatKhau(rs.getString(2));
                nv.setHoTen(rs.getString(3));
                nv.setNgaySinh(rs.getDate(4));
                nv.setGioiTinh(rs.getString(5));
                nv.setDiaChi(rs.getString(6));
                nv.setEmail(rs.getString(7));
                nv.setChucVu(rs.getString(8));
                nv.setMaPhong(rs.getString(9));
                nv.setHinh(rs.getString(10));

                list.add(nv);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<NhanVien> selectAll_NhanVienKD() {
        return this.selectBySql(select_by_PKD_sql);
    }
    
    public List<NhanVien> selectByKeyword(String keyword) {
        String sql = "select * from NhanVien where ten_nhanh_nien like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
    
    public NhanVien findEmployeeByEmployeeCodeAndEmail(String employeeCode, String email) {
        String sql = "SELECT * FROM NhanVien WHERE ma_nhan_vien = ? AND email = ?";
        List<NhanVien> employees = this.selectBySql(sql, employeeCode, email);
        
        if (!employees.isEmpty()) {
            return employees.get(0);
        } else {
            return null;
        }
    }
}
