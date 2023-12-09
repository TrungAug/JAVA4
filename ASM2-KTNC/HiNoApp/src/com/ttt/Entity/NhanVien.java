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
public class NhanVien {
    private String maNV;
    private String matKhau;
    private String hoTen;
    private Date ngaySinh;
    private String gioiTinh;
    private String diaChi;
    private String email;
    private String chucVu;
    private String maPhong;
    private String hinh;

    public NhanVien() {
    }

    public NhanVien(String maNV, String matKhau, String hoTen, Date ngaySinh, String gioiTinh, String diaChi, String email, String chucVu, String maPhong, String hinh) {
        this.maNV = maNV;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.email = email;
        this.chucVu = chucVu;
        this.maPhong = maPhong;
        this.hinh = hinh;
    }

    public NhanVien(String maNV, String matKhau) {
        this.maNV = maNV;
        this.matKhau = matKhau;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

   
    public String totoString() {
        return "NhanVien{" + "maNV=" + maNV + ", matKhau=" + matKhau + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", email=" + email + ", chucVu=" + chucVu + ", maPhong=" + maPhong + ", hinh=" + hinh + '}';
    }
    
    @Override
    public String toString() {
        return this.hoTen;
    }

    @Override
    public boolean equals(Object obj) {
        NhanVien other = (NhanVien) obj;
        return other.getMaNV().equals(this.getMaNV());
    }
    
}
