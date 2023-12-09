/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.DAO;

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
public class ViTriDAO extends HiNoDAO<ViTri, String> {

    String insert_sql = "INSERT INTO ViTri VALUES(?,?,?)";
    String update_sql = "UPDATE ViTri SET ma_chi_nhanh=?, ten_vi_tri=? WHERE ma_vi_tri=?";
    String delete_sql = "DELETE FROM ViTri WHERE ma_vi_tri=?";
    String select_all_sql = "SELECT * FROM ViTri";
    String select_by_id_sql = "SELECT * FROM ViTri WHERE ma_vi_tri=?";

    public static ViTriDAO getNewViTriDAO() {
        return new ViTriDAO();
    }

    @Override
    public void insert(ViTri e) {
        try {
            JdbcHelper.update(insert_sql, e.getMaViTri(), e.getMaChiNhanh(), e.getTenViTri());
        } catch (SQLException ex) {
            Logger.getLogger(ViTri.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ViTri e) {
        try {
            JdbcHelper.update(update_sql, e.getMaChiNhanh(), e.getTenViTri(), e.getMaViTri());
        } catch (SQLException ex) {
            Logger.getLogger(ViTri.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.update(delete_sql, id);
        } catch (SQLException ex) {
            Logger.getLogger(ViTri.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public ViTri selectById(String id) {
        List<ViTri> listCn = this.selectBySql(select_by_id_sql, id);
        if (listCn.isEmpty()) {
            return null;
        }
        return listCn.get(0);
    }

    @Override
    public List<ViTri> selectAll() {
        return this.selectBySql(select_all_sql);
    }

    @Override
    protected List<ViTri> selectBySql(String sql, Object... args) {
        List<ViTri> listCn = new ArrayList<>();

        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ViTri nh = new ViTri();
                nh.setMaViTri(rs.getString(1));
                nh.setMaChiNhanh(rs.getString(2));
                nh.setTenViTri(rs.getString(3));
                listCn.add(nh);
            }
            rs.getStatement().getConnection().close();
            return listCn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
  public List<ViTri> selectByKeyword(String keyword) {
        String sql = "select * from ViTri where ten_vi_tri like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
}
