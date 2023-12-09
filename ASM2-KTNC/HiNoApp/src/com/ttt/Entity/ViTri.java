/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.Entity;

/**
 *
 * @author ASUS
 */
public class ViTri {
    private String maViTri;
    private String maChiNhanh;
    private String tenViTri;

    public ViTri() {
    }

    public ViTri(String maViTri, String maChiNhanh, String tenViTri) {
        this.maViTri = maViTri;
        this.maChiNhanh = maChiNhanh;
        this.tenViTri = tenViTri;
    }

    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String maViTri) {
        this.maViTri = maViTri;
    }

    public String getMaChiNhanh() {
        return maChiNhanh;
    }

    public void setMaChiNhanh(String maChiNhanh) {
        this.maChiNhanh = maChiNhanh;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    
    public String totoString() {
        return "ViTri{" + "maViTri=" + maViTri + ", maChiNhanh=" + maChiNhanh + ", tenViTri=" + tenViTri + '}';
    }
    
    @Override
    public String toString() {
        return this.tenViTri;
    }

    @Override
    public boolean equals(Object obj) {
        ViTri other = (ViTri) obj;
        return other.getMaViTri().equals(this.getMaViTri());
    }
    
}
