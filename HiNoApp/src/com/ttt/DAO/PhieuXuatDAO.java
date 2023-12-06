/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.DAO;

import com.ttt.Entity.ChiNhanh;
import com.ttt.Entity.PhieuXuat;
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
public class PhieuXuatDAO extends HiNoDAO< PhieuXuat, String> {

    String insert_sql = "INSERT INTO PhieuXuat VALUES(?,?,?,?,?,?,?,?)";
    String update_sql = "UPDATE PhieuXuat SET so_luong=?,gia_xuat=?,nguoi_xuat_kho=?,ngay_xuat=?,nguoi_sua_doi=?,ngay_sua_doi=?,dien_giai=? WHERE ma_phieu_xuat=?";
    //nguoi_xuat_kho là người lập phiếu đầu tiên => ko đc thay đổi    
    String delete_sql = "DELETE FROM PhieuXuat WHERE ma_phieu_xuat=?";
    String select_all_sql = "SELECT * FROM PhieuXuat";
    String select_by_id_sql = "SELECT * FROM PhieuXuat WHERE ma_phieu_xuat=?";

    public static PhieuXuatDAO getNewPhieuXuatDAO() {
        return new PhieuXuatDAO();
    }

    @Override
    public void insert(PhieuXuat e) {
        try {
            JdbcHelper.update(insert_sql, e.getMaPhieuXuat(),e.getSoLuong(),e.getGiaXuat(),e.getNguoiXuat(),e.getNgayXuat(),e.getNguoiSua(),e.getNgaySua(),e.getDienGiai());
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(PhieuXuat e) {
        try {
            JdbcHelper.update(update_sql,e.getSoLuong(),e.getGiaXuat(),e.getNguoiXuat(),e.getNgayXuat(),e.getNguoiSua(),e.getNgaySua(),e.getDienGiai(), e.getMaPhieuXuat());
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.update(delete_sql, id);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public PhieuXuat selectById(String id) {
        List<PhieuXuat> listCn = this.selectBySql(select_by_id_sql, id);
        if (listCn.isEmpty()) {
            return null;
        }
        return listCn.get(0);
    }

    @Override
    public List<PhieuXuat> selectAll() {
        return this.selectBySql(select_all_sql);
    }

    @Override
    protected List<PhieuXuat> selectBySql(String sql, Object... args) {
        List<PhieuXuat> listCn = new ArrayList<>();

        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                PhieuXuat nh = new PhieuXuat();
                nh.setMaPhieuXuat(rs.getString(1));                              
                nh.setSoLuong(rs.getInt(2));
                nh.setGiaXuat(rs.getDouble(3));
                nh.setNguoiXuat(rs.getString(4));
                nh.setNgayXuat(rs.getDate(5));
                nh.setNguoiSua(rs.getString(6));
                nh.setNgaySua(rs.getDate(7));
                nh.setDienGiai(rs.getString(8));                         
                listCn.add(nh);
            }
            rs.getStatement().getConnection().close();
            return listCn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
