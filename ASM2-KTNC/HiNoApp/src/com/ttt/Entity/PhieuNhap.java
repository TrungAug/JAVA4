/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.Entity;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class PhieuNhap {
    private String maPhieuNhap;
    private String maNhanVien;
    private Date ngayNhap;
    private Date ngaySua;
    private String nguoiSua;   
    private String dienGiai;
   // private int idChiTietPhieuNhap;

    public PhieuNhap() {
    }

    public PhieuNhap(String maPhieuNhap, String maNhanVien, Date ngayNhap, Date ngaySua, String nguoiSua, String dienGiai) {
        this.maPhieuNhap = maPhieuNhap;
        this.maNhanVien = maNhanVien;
        this.ngayNhap = ngayNhap;
        this.ngaySua = ngaySua;
        this.nguoiSua = nguoiSua;
        this.dienGiai = dienGiai;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(String nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public String getDienGiai() {
        return dienGiai;
    }

    public void setDienGiai(String dienGiai) {
        this.dienGiai = dienGiai;
    }

   @Override
    public String toString() {
        return this.maPhieuNhap;
    }

    @Override
    public boolean equals(Object obj) {
        PhieuNhap other = (PhieuNhap) obj;
        return other.getMaPhieuNhap().equals(this.getMaPhieuNhap());
    }

    public String totoString() {
        return "PhieuNhap{" + "maPhieuNhap=" + maPhieuNhap + ", maNhanVien=" + maNhanVien + ", ngayNhap=" + ngayNhap + ", ngaySua=" + ngaySua + ", nguoiSua=" + nguoiSua + ", dienGiai=" + dienGiai + '}';
    }
    
}
