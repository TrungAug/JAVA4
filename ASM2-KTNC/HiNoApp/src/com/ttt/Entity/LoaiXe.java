/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.Entity;

/**
 *
 * @author ASUS
 */
public class LoaiXe {
    private String maLoaiXe;
    private String dongXe;
    private String tenLoaiXe;

    public LoaiXe() {
    }

    public LoaiXe(String maLoaiXe, String dongXe, String tenLoaiXe) {
        this.maLoaiXe = maLoaiXe;
        this.dongXe = dongXe;
        this.tenLoaiXe = tenLoaiXe;
    }

    public String getMaLoaiXe() {
        return maLoaiXe;
    }

    public void setMaLoaiXe(String maLoaiXe) {
        this.maLoaiXe = maLoaiXe;
    }

    public String getDongXe() {
        return dongXe;
    }

    public void setDongXe(String dongXe) {
        this.dongXe = dongXe;
    }

    public String getTenLoaiXe() {
        return tenLoaiXe;
    }

    public void setTenLoaiXe(String tenLoaiXe) {
        this.tenLoaiXe = tenLoaiXe;
    }

//    @Override
//    public String toString() {
//        return "LoaiXe{" + "maLoaiXe=" + maLoaiXe + ", dongXe=" + dongXe + ", tenLoaiXe=" + tenLoaiXe + '}';
//    }
      @Override
    public String toString() {
        return this.maLoaiXe;
    }

    @Override
    public boolean equals(Object obj) {
        LoaiXe other = (LoaiXe) obj;
        return other.getMaLoaiXe().equals(this.getMaLoaiXe());
    }
    

}
