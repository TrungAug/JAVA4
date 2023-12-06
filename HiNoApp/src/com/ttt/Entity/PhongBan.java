/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.Entity;

/**
 *
 * @author ASUS
 */
public class PhongBan {
    private String maPhongBan;
    private String tenPhongBan;
    private String maChiNhanh;

    public PhongBan() {
    }

    public PhongBan(String maPhongBan, String tenPhongBan, String maChiNhanh) {
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.maChiNhanh = maChiNhanh;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    
    public String totoString() {
        return "PhongBan{" + "maPhongBan=" + maPhongBan + ", tenPhongBan=" + tenPhongBan + ", maChiNhanh=" + maChiNhanh + '}';
    }
    
     @Override
    public String toString() {
        return this.tenPhongBan;
    }
    
     @Override
    public boolean equals(Object obj) {
        PhongBan other = (PhongBan) obj;
        return other.getMaPhongBan().equals(this.getMaPhongBan());
    }
    
}
