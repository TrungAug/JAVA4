/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.Entity;

/**
 *
 * @author ASUS
 */
public class ChiNhanh {
    private String maChiNhanh;
    private String tenChiNhanh;
    private String maSoThue;
    private String diaChi;

    public ChiNhanh() {
    }

    public ChiNhanh(String maChiNhanh, String tenChiNhanh, String maSoThue, String diaChi) {
        this.maChiNhanh = maChiNhanh;
        this.tenChiNhanh = tenChiNhanh;
        this.maSoThue = maSoThue;
        this.diaChi = diaChi;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getTenChiNhanh() {
        return tenChiNhanh;
    }

    public void setTenChiNhanh(String tenChiNhanh) {
        this.tenChiNhanh = tenChiNhanh;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }


    public String totoString() {
        return "ChiNhanh{" + "maChiNhanh=" + maChiNhanh + ", tenChiNhanh=" + tenChiNhanh + ", maSoThue=" + maSoThue + ", diaChi=" + diaChi + '}';
    }

    @Override
    public String toString() {
        return this.maChiNhanh;
    }
    
     @Override
    public boolean equals(Object obj) {
        ChiNhanh other = (ChiNhanh) obj;
        return other.getMaChiNhanh().equals(this.getMaChiNhanh());
    }
}
