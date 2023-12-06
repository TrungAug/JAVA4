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
public class PhieuXuat {
    private String maPhieuXuat;
    private int soLuong;
    private double giaXuat;
    private String nguoiXuat;
    private Date ngayXuat;
    private String nguoiSua;
    private Date ngaySua;
    private String dienGiai;

    public PhieuXuat() {
    }

    public PhieuXuat(String maPhieuXuat, int soLuong, double giaXuat, String nguoiXuat, Date ngayXuat, String nguoiSua, Date ngaySua, String dienGiai) {
        this.maPhieuXuat = maPhieuXuat;
        this.soLuong = soLuong;
        this.giaXuat = giaXuat;
        this.nguoiXuat = nguoiXuat;
        this.ngayXuat = ngayXuat;
        this.nguoiSua = nguoiSua;
        this.ngaySua = ngaySua;
        this.dienGiai = dienGiai;
    }

    

    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

   

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(double giaXuat) {
        this.giaXuat = giaXuat;
    }

    public String getNguoiXuat() {
        return nguoiXuat;
    }

    public void setNguoiXuat(String nguoiXuat) {
        this.nguoiXuat = nguoiXuat;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(String nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getDienGiai() {
        return dienGiai;
    }

    public void setDienGiai(String dienGiai) {
        this.dienGiai = dienGiai;
    }


    public String totoString() {
        return "PhieuXuat{" + "maPhieuXuat=" + maPhieuXuat + ", soLuong=" + soLuong + ", giaXuat=" + giaXuat + ", nguoiXuat=" + nguoiXuat + ", ngayXuat=" + ngayXuat + ", nguoiSua=" + nguoiSua + ", ngaySua=" + ngaySua + ", dienGiai=" + dienGiai + '}';
    }
@Override
    public String toString() {
        return this.maPhieuXuat;
    }

    @Override
    public boolean equals(Object obj) {
        PhieuXuat other = (PhieuXuat) obj;
        return other.getMaPhieuXuat().equals(this.getMaPhieuXuat());
    }
  
    
}
