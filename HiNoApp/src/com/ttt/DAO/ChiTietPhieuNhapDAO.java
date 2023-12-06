/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.DAO;

import com.ttt.Entity.ChiTietPhieuNhap;
import com.ttt.Entity.LoaiXe;
import com.ttt.LibaryHelper.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class ChiTietPhieuNhapDAO extends HiNoDAO<ChiTietPhieuNhap, String> {

    String insert_sql = "INSERT into ChiTietPhieuNhap values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    String update_sql = "UPDATE ChiTietPhieuNhap SET ma_nhan_vien_kd=?,ma_khach_hang=?, ma_phieu_nhap=?,ma_phieu_xuat=?,ma_vi_tri=?,ma_loai_xe=?,so_khung=?,so_may=?,so_luong_nhap=?,gia_nhap=?,gia_xuat=?,so_luong_xuat=?,xuat_kho=?,ma_nhan_vien_nhap=?,ngay_nhap=?,ngay_sua_doi_pn=?,nguoi_sua_doi_pn=?,ma_nhan_vien_xuat=?,ngay_xuat=?,ngay_sua_doi_px=?,nguoi_sua_doi_px=? WHERE id_chi_tiet_phieu_nhap=?";
    String delete_sql = "DELETE FROM ChiTietPhieuNhap WHERE id_chi_tiet_phieu_nhap=?";
    String select_all_sql = "SELECT * FROM ChiTietPhieuNhap";
    String select_by_id_sql = "SELECT * FROM ChiTietPhieuNhap WHERE id_chi_tiet_phieu_nhap=?";
    String select_all_sql_pn = "SELECT * FROM ChiTietPhieuNhap Where xuat_kho=0";
    String select_all_sql_px = "SELECT * FROM ChiTietPhieuNhap Where xuat_kho=1";
    String select_by_maPN_sql = "Select * from ChiTietPhieuNhap where ma_phieu_nhap=?";
    String select_by_maPX_sql = "Select * from ChiTietPhieuNhap where ma_phieu_xuat=?";
    String select_by_soKhung_sql = "Select * from ChiTietPhieuNhap where so_khung=?";
    String update_xuat_kho_sql = "UPDATE ChiTietPhieuNhap SET xuat_kho=0 where so_khung=?";
   
    public static ChiTietPhieuNhapDAO getNewChiTietPhieuNhapDAO() {
        return new ChiTietPhieuNhapDAO();
    }

    @Override
    public void insert(ChiTietPhieuNhap e) {
        try {
            JdbcHelper.update(insert_sql, e.getMaNhanVienKD(), e.getMaKhachHang(), e.getMaPhieuNhap(), e.getMaPhieuXuat(), e.getMaViTri(), e.getMaLoaiXe(), e.getSoKhung(), e.getSoMay(), e.getSoLuongNhap(), e.getGiaNhap(), e.getGiaXuat(), e.getSoLuongXuat(), e.getChkXuatKho(), e.getMaNhanVienNhap(), e.getNgayNhap(), e.getNgaySuaPN(), e.getNguoiSuaPN(), e.getMaNhanVienXuat(), e.getNgayXuat(), e.getNgaySuaPX(), e.getNguoiSuaPX());
        } catch (SQLException ex) {
            System.out.println("Loi~ ChiTietPhieuNhap Insert : " + ex.getMessage());
        }
    }

    @Override
    public void update(ChiTietPhieuNhap e) {
        try {
            JdbcHelper.update(update_sql, e.getMaNhanVienKD(), e.getMaKhachHang(), e.getMaPhieuNhap(), e.getMaPhieuXuat(), e.getMaViTri(), e.getMaLoaiXe(), e.getSoKhung(), e.getSoMay(), e.getSoLuongNhap(), e.getGiaNhap(), e.getGiaXuat(), e.getSoLuongXuat(), e.getChkXuatKho(), e.getMaNhanVienNhap(), e.getNgayNhap(), e.getNgaySuaPN(), e.getNguoiSuaPN(), e.getMaNhanVienXuat(), e.getNgayXuat(), e.getNgaySuaPX(), e.getNguoiSuaPX(), e.getIdChiTietPhieuNhap());
        } catch (SQLException ex) {
            System.out.println("Loi~ ChiTietPhieuNhap Update : " + ex.getMessage());

        }

    }

    @Override
    public void delete(String id) {
        try {
            JdbcHelper.update(delete_sql, id);
        } catch (SQLException ex) {
            System.out.println("Loi~ ChiTietPhieuNhap delete : " + ex.getMessage());

        }

    }

    @Override
    public ChiTietPhieuNhap selectById(String id) {
        List<ChiTietPhieuNhap> listlx = selectBySql(select_by_id_sql, id);
        if (listlx.isEmpty()) {
            return null;
        }
        return listlx.get(0);

    }

    @Override
    public List<ChiTietPhieuNhap> selectAll() {
        return this.selectBySql(select_all_sql);
    }

    public List<ChiTietPhieuNhap> selectAll_chuaXuatKho() {
        return this.selectBySql(select_all_sql_pn);
    }

   
    public List<ChiTietPhieuNhap> selectAll_daXuatKho() {
        return this.selectBySql(select_all_sql_px);
    }

    public List<ChiTietPhieuNhap> selectAll_MaPhieuNhap(String maPN) {
        List<ChiTietPhieuNhap> listlx = selectBySql(select_by_maPN_sql, maPN);
        if (listlx.isEmpty()) {
            return null;
        }
        return listlx;
    }

    public List<ChiTietPhieuNhap> selectAll_MaPhieuXuat(String maPX) {
        List<ChiTietPhieuNhap> listlx = selectBySql(select_by_maPX_sql, maPX);
        if (listlx.isEmpty()) {
            return null;
        }
        return listlx;
    }

    public ChiTietPhieuNhap selectBySoKhung(String soKhung) {
        List<ChiTietPhieuNhap> listlx = selectBySql(select_by_soKhung_sql, soKhung);
        if (listlx.isEmpty()) {
            return null;
        }
        return listlx.get(0);

    }

    @Override
    protected List<ChiTietPhieuNhap> selectBySql(String sql, Object... args) {
        List<ChiTietPhieuNhap> listCn = new ArrayList<>();

        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ChiTietPhieuNhap l = new ChiTietPhieuNhap();
                l.setIdChiTietPhieuNhap(rs.getInt(1));
                l.setMaNhanVienKD(rs.getString(2));
                l.setMaKhachHang(rs.getString(3));
                l.setMaPhieuNhap(rs.getString(4));
                l.setMaPhieuXuat(rs.getString(5));
                l.setMaViTri(rs.getString(6));
                l.setMaLoaiXe(rs.getString(7));
                l.setSoKhung(rs.getString(8));
                l.setSoMay(rs.getString(9));
                l.setSoLuongNhap(rs.getInt(10));
                l.setGiaNhap(rs.getDouble(11));
                l.setGiaXuat(rs.getDouble(12));
                l.setSoLuongXuat(rs.getInt(13));
                l.setChkXuatKho(rs.getInt(14));
                l.setMaNhanVienNhap(rs.getString(15));
                l.setNgayNhap(rs.getDate(16));
                l.setNgaySuaPN(rs.getDate(17));
                l.setNguoiSuaPN(rs.getString(18));
                l.setMaNhanVienXuat(rs.getString(19));
                l.setNgayXuat(rs.getDate(20));
                l.setNgaySuaPX(rs.getDate(21));
                l.setNguoiSuaPX(rs.getString(22));
                listCn.add(l);
            }
            rs.getStatement().getConnection().close();
            return listCn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<ChiTietPhieuNhap> selectByKeyword(String keyword) {
        String sql = "select * from ChiTietPhieuNhap where xuat_kho=0 and ma_loai_xe like  ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    public List<ChiTietPhieuNhap> selectByKeyword_PhieuXuat(String keyword) {
        String sql = "select * from ChiTietPhieuNhap where xuat_kho=1 and ma_loai_xe like  ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    public String getMaPNBySoKhung(String keyword) {
        String sql = "select * from ChiTietPhieuNhap where so_khung = ?";
        List<ChiTietPhieuNhap> listlx = selectBySql(sql, keyword);
        if (listlx.isEmpty()) {
            return null;
        }
        return listlx.get(0).getMaPhieuNhap();
    }

    public String getMaPXBySoKhung(String keyword) {
        String sql = "select * from ChiTietPhieuNhap where so_khung = ?";
        List<ChiTietPhieuNhap> listlx = selectBySql(sql, keyword);
        if (listlx.isEmpty()) {
            return null;
        }
        return listlx.get(0).getMaPhieuXuat();
    }

    public void update_xuat_kho(ChiTietPhieuNhap e) {
        try {
            JdbcHelper.update(update_xuat_kho_sql, e.getSoKhung());
        } catch (SQLException ex) {
            System.out.println("Loi~ ChiTietPhieuNhap Update : " + ex.getMessage());

        }

    }

    public List<ChiTietPhieuNhap> selectByNVKD(String maNVKD) {
        String sql = "select * from ChiTietPhieuNhap where ma_nhan_vien_kd=?";
        return this.selectBySql(sql, maNVKD);
    }
}
