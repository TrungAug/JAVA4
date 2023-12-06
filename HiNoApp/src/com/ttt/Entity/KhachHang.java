/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.Entity;

/**
 *
 * @author ASUS
 */
public class KhachHang {
    private String maKhachHang;
    private String tenKhanhHang;
    private String diaChi;
    private String email;
    private String soDienThoai;
    private String maSoThue;

    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String tenKhanhHang, String diaChi, String email, String soDienThoai, String maSoThue) {
        this.maKhachHang = maKhachHang;
        this.tenKhanhHang = tenKhanhHang;
        this.diaChi = diaChi;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.maSoThue = maSoThue;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhanhHang() {
        return tenKhanhHang;
    }

    public void setTenKhanhHang(String tenKhanhHang) {
        this.tenKhanhHang = tenKhanhHang;
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    
    public String totoString() {
        return "KhachHang{" + "maKhachHang=" + maKhachHang + ", tenKhanhHang=" + tenKhanhHang + ", diaChi=" + diaChi + ", email=" + email + ", soDienThoai=" + soDienThoai + ", maSoThue=" + maSoThue + '}';
    }
    @Override
    public String toString() {
        return this.tenKhanhHang;
    }

    @Override
    public boolean equals(Object obj) {
        KhachHang other = (KhachHang) obj;
        return other.getMaKhachHang().equals(this.getMaKhachHang());
    }
    
    
}
