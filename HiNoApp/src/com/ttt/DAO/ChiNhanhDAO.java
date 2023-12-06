/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.DAO;

import com.ttt.Entity.ChiNhanh;
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
public class ChiNhanhDAO extends HiNoDAO<ChiNhanh, String> {

    String insert_sql = "INSERT INTO ChiNhanh VALUES(?,?,?,?)";
    String update_sql = "UPDATE ChiNhanh SET ten_chi_nhanh=?, ma_so_thue=?, dia_chi=? WHERE ma_chi_nhanh=?";
    String delete_sql = "DELETE FROM ChiNhanh WHERE ma_chi_nhanh=?";
    String select_all_sql = "SELECT * FROM ChiNhanh";
    String select_by_id_sql = "SELECT * FROM ChiNhanh WHERE ma_chi_nhanh=?";

    public static ChiNhanhDAO getNewChiNhanhDAO() {
        return new ChiNhanhDAO();
    }

    @Override
    public void insert(ChiNhanh e) {
        try {
            JdbcHelper.update(insert_sql, e.getMaChiNhanh(), e.getTenChiNhanh(), e.getMaSoThue(), e.getDiaChi());
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(ChiNhanh e) {
        try {
            JdbcHelper.update(update_sql, e.getTenChiNhanh(), e.getMaSoThue(), e.getDiaChi(), e.getMaChiNhanh());
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.update(delete_sql, id);
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanh.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ChiNhanh selectById(String id) {
        List<ChiNhanh> listCn = this.selectBySql(select_by_id_sql, id);
        if (listCn.isEmpty()) {
            return null;
        }
        return listCn.get(0);
    }

    @Override
    public List<ChiNhanh> selectAll() {
        return this.selectBySql(select_all_sql);
    }

    @Override
    protected List<ChiNhanh> selectBySql(String sql, Object... args) {
        List<ChiNhanh> listCn = new ArrayList<>();

        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ChiNhanh nh = new ChiNhanh();
                nh.setMaChiNhanh(rs.getString(1));
                nh.setTenChiNhanh(rs.getString(2));
                nh.setMaSoThue(rs.getString(3));
                nh.setDiaChi(rs.getString(4));
                listCn.add(nh);
            }
            rs.getStatement().getConnection().close();
            return listCn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ChiNhanh> selectByKeyword(String keyword) {
        String sql = "select * from ChiNhanh where ten_chi_nhanh like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
}
