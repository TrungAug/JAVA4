/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.DAO;

import com.ttt.Entity.KhachHang;
import com.ttt.LibaryHelper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class KhachHangDAO extends HiNoDAO<KhachHang, String> {

    String insert_sql = "INSERT INTO KhachHang VALUES(?,?,?,?,?,?)";
    String update_sql = "UPDATE KhachHang SET ten_khach_hang=?, dia_chi=?, email=?,sdt=?,ma_so_thue=? WHERE ma_khach_hang=?";
    String delete_sql = "DELETE FROM KhachHang WHERE ma_khach_hang=?";
    String select_all_sql = "SELECT * FROM KhachHang";
    String select_by_id_sql = "SELECT * FROM KhachHang WHERE ma_khach_hang=?";
    
    public static KhachHangDAO getNewKhachHangDAO() {
        return new KhachHangDAO();
    }
    
    @Override
    public void insert(KhachHang e) {
         try {
            JdbcHelper.update(insert_sql, e.getMaKhachHang(), e.getTenKhanhHang(), e.getDiaChi(), e.getEmail(),e.getSoDienThoai(),e.getMaSoThue());
        } catch (SQLException ex) {
              System.out.println("Loi~ KhachHang Insert : "+ex.getMessage());
       
        }
    
    }

    @Override
    public void update(KhachHang e) {
         try {
            JdbcHelper.update(update_sql,  e.getTenKhanhHang(), e.getDiaChi(), e.getEmail(),e.getSoDienThoai(),e.getMaSoThue(),e.getMaKhachHang());
        } catch (SQLException ex) {
              System.out.println("Loi~ KhachHang Update : "+ex.getMessage());
       
        }
    
    
    }

    @Override
    public void delete(String id) {
         try {
            JdbcHelper.update(delete_sql, id);
        } catch (SQLException ex) {
             System.out.println("Loi~ KhachHang Delete : "+ex.getMessage());
       
        
        }
        
    
    }

    @Override
    public KhachHang selectById(String id) {
         List<KhachHang> listCn = this.selectBySql(select_by_id_sql, id);
        if (listCn.isEmpty()) {
            return null;
        }
        return listCn.get(0);
    
    }

    @Override
    public List<KhachHang> selectAll() {
        return this.selectBySql(select_all_sql);
    }

    @Override
    protected List<KhachHang> selectBySql(String sql, Object... args) {
       List<KhachHang> listCn = new ArrayList<>();

        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                KhachHang nh = new KhachHang();
                nh.setMaKhachHang(rs.getString(1));
                nh.setTenKhanhHang(rs.getString(2));
                nh.setDiaChi(rs.getString(3));
                nh.setEmail(rs.getString(4));
                nh.setSoDienThoai(rs.getString(5));
                nh.setMaSoThue(rs.getString(6));
                listCn.add(nh);
            }
            rs.getStatement().getConnection().close();
            return listCn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }    
    
    }
    
    public List<KhachHang> selectByKeyword(String keyword) {
        String sql = "select * from KhachHang where ten_khach_hang like ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
}
