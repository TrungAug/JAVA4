/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.DAO;

import com.ttt.Entity.LoaiXe;
import com.ttt.LibaryHelper.JdbcHelper;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class LoaiXeDAO extends HiNoDAO<LoaiXe, String> {

    String insert_sql = "INSERT into LoaiXe values (?,?,?)";
    String update_sql = "UPDATE LoaiXe SET dong_xe=?, ten_loai_xe=? WHERE ma_loai_xe=?";
    String delete_sql = "DELETE FROM LoaiXe WHERE ma_loai_xe=?";
    String select_all_sql = "SELECT * FROM LoaiXe";
    String select_by_id_sql = "SELECT * FROM LoaiXe WHERE ma_loai_xe=?";

    public static LoaiXeDAO getNewLoaiXeDAO() {
        return new LoaiXeDAO();
    }

    @Override
    public void insert(LoaiXe e) {
        try {
            JdbcHelper.update(insert_sql, e.getMaLoaiXe(), e.getDongXe(), e.getTenLoaiXe());
        } catch (SQLException ex) {
            System.out.println("Loi~ Loai Xe Insert : " + ex.getMessage());
        }

    }

    @Override
    public void update(LoaiXe e) {
        try {
            JdbcHelper.update(update_sql, e.getDongXe(), e.getTenLoaiXe(), e.getMaLoaiXe());
        } catch (SQLException ex) {
            System.out.println("Loi~ Loai Xe Update : " + ex.getMessage());

        }

    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.update(delete_sql, id);
        } catch (SQLException ex) {
            System.out.println("Loi~ Loai Xe delete : " + ex.getMessage());

        }
    }

    @Override
    public LoaiXe selectById(String id) {
        List<LoaiXe> listlx = selectBySql(select_by_id_sql, id);
        if (listlx.isEmpty()) {
            return null;
        }
        return listlx.get(0);
    }

    @Override
    public List<LoaiXe> selectAll() {
        return this.selectBySql(select_all_sql);
    }

    @Override
    protected List<LoaiXe> selectBySql(String sql, Object... args) {
        List<LoaiXe> listCn = new ArrayList<>();

        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                LoaiXe l = new LoaiXe();
                l.setMaLoaiXe(rs.getString(1));
                l.setDongXe(rs.getString(2));
                l.setTenLoaiXe(rs.getString(3));

                listCn.add(l);
            }
            rs.getStatement().getConnection().close();
            return listCn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<LoaiXe> selectByKeyword(String keyword) {
        String sql = "select * from LoaiXe where ten_loai_xe like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

}
