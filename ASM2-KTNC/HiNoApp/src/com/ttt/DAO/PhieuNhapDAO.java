/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.DAO;

import com.ttt.Entity.ChiNhanh;
import com.ttt.Entity.PhieuNhap;
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
public class PhieuNhapDAO extends HiNoDAO<PhieuNhap, String> {

    String insert_sql = "INSERT INTO PhieuNhap VALUES(?,?,?,?,?,?)";
    String update_sql = "UPDATE PhieuNhap SET ma_nhan_vien=?,ngay_nhap=?,ngay_sua_doi=?,nguoi_sua_doi=?, dien_giai=? WHERE ma_phieu_nhap=?";
    //ma_nhan_vien là nhân viên đầu tiên lập phiếu ko được sửa. chỉ thay đối mã chỗ nguoi_sua_doi
    String delete_sql = "DELETE FROM PhieuNhap WHERE ma_phieu_nhap=?";
    String select_all_sql = "SELECT * FROM PhieuNhap";
    String select_by_id_sql = "SELECT * FROM PhieuNhap WHERE ma_phieu_nhap=?";

    public static PhieuNhapDAO getNewPhieuNhapDAO() {
        return new PhieuNhapDAO();
    }

    @Override
    public void insert(PhieuNhap e) {
        try {
            JdbcHelper.update(insert_sql, e.getMaPhieuNhap(), e.getMaNhanVien(), e.getNgayNhap(), e.getNgaySua(), e.getNguoiSua(), e.getDienGiai());
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(PhieuNhap e) {
        try {
            JdbcHelper.update(update_sql,e.getMaNhanVien() ,e.getNgayNhap(),e.getNgaySua() ,e.getNguoiSua(), e.getDienGiai(),e.getMaPhieuNhap());
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.update(delete_sql, id);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public PhieuNhap selectById(String id) {
        List<PhieuNhap> listCn = this.selectBySql(select_by_id_sql, id);
        if (listCn.isEmpty()) {
            return null;
        }
        return listCn.get(0);
    }

    @Override
    public List<PhieuNhap> selectAll() {
        return this.selectBySql(select_all_sql);
    }

    @Override
    protected List<PhieuNhap> selectBySql(String sql, Object... args) {
        List<PhieuNhap> listCn = new ArrayList<>();

        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuNhap nh = new PhieuNhap();                       
                nh.setMaPhieuNhap(rs.getString(1));
                nh.setMaNhanVien(rs.getString(2));
                nh.setNgayNhap(rs.getDate(3));
                nh.setNgaySua(rs.getDate(4));
                nh.setNguoiSua(rs.getString(5));
                nh.setDienGiai(rs.getString(6));            
                listCn.add(nh);
            }
            rs.getStatement().getConnection().close();
            return listCn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    
    }

}
