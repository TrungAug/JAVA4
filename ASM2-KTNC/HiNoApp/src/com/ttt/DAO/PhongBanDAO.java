/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.DAO;

import com.ttt.Entity.ChiNhanh;
import com.ttt.Entity.PhongBan;
import com.ttt.Entity.ViTri;
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
public class PhongBanDAO extends HiNoDAO<PhongBan, String>{
    String insert_sql = "INSERT INTO PhongBan VALUES(?,?,?)";
    String update_sql = "UPDATE PhongBan SET ten_phong_ban=?, ma_chi_nhanh=? WHERE ma_phong_ban=?";
    String delete_sql = "DELETE FROM PhongBan WHERE ma_phong_ban=?";
    String select_all_sql = "SELECT * FROM PhongBan";
    String select_by_id_sql = "SELECT * FROM PhongBan WHERE ma_phong_ban=?";

    public static PhongBanDAO getNewPhongBanDAO() {
        return new PhongBanDAO();
    }

    @Override
    public void insert(PhongBan e) {
        try {
            JdbcHelper.update(insert_sql, e.getMaPhongBan(), e.getTenPhongBan(), e.getMaChiNhanh());
        } catch (SQLException ex) {
            Logger.getLogger(PhongBan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(PhongBan e) {
        try {
            JdbcHelper.update(update_sql, e.getTenPhongBan(),e.getMaChiNhanh(), e.getMaPhongBan());
        } catch (SQLException ex) {
            Logger.getLogger(PhongBan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.update(delete_sql, id);
        } catch (SQLException ex) {
            Logger.getLogger(PhongBan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public PhongBan selectById(String id) {
        List<PhongBan> listCn = this.selectBySql(select_by_id_sql, id);
        if (listCn.isEmpty()) {
            return null;
        }
        return listCn.get(0);
    }

    @Override
    public List<PhongBan> selectAll() {
        return this.selectBySql(select_all_sql);
    }

    @Override
    protected List<PhongBan> selectBySql(String sql, Object... args) {
        List<PhongBan> listCn = new ArrayList<>();

        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                PhongBan nh = new PhongBan();
                nh.setMaPhongBan(rs.getString(1));             
                nh.setTenPhongBan(rs.getString(2));
                nh.setMaChiNhanh(rs.getString(3));
                listCn.add(nh);
            }
            rs.getStatement().getConnection().close();
            return listCn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
public List<PhongBan> selectByKeyword(String keyword) {
        String sql = "select * from PhongBan where ten_phong_ban like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
    
}
