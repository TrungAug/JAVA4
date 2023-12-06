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
public class ChiTietPhieuNhap {

    private int idChiTietPhieuNhap;
    private String maNhanVienKD;
    private String maKhachHang;
    private String maPhieuNhap;
    private String maPhieuXuat;
    private String maViTri;
    private String maLoaiXe;
    private String soKhung;
    private String soMay;
    private int soLuongNhap;
    private double giaNhap;
    private double giaXuat;
    private int soLuongXuat;
    private int chkXuatKho;
    private String maNhanVienNhap;
    private Date ngayNhap;
    private String nguoiSuaPN;
    private Date ngaySuaPN;

    private String maNhanVienXuat;
    private Date ngayXuat;
    private String nguoiSuaPX;
    private Date ngaySuaPX;

    public ChiTietPhieuNhap() {
    }

    public ChiTietPhieuNhap(int idChiTietPhieuNhap, String maNhanVienKD, String maKhachHang, String maPhieuNhap, String maPhieuXuat, String maViTri, String maLoaiXe, String soKhung, String soMay, int soLuongNhap, double giaNhap, double giaXuat, int soLuongXuat, int chkXuatKho, String maNhanVienNhap, Date ngayNhap, String nguoiSuaPN, Date ngaySuaPN, String maNhanVienXuat, Date ngayXuat, String nguoiSuaPX, Date ngaySuaPX) {
        this.idChiTietPhieuNhap = idChiTietPhieuNhap;
        this.maNhanVienKD = maNhanVienKD;
        this.maKhachHang = maKhachHang;
        this.maPhieuNhap = maPhieuNhap;
        this.maPhieuXuat = maPhieuXuat;
        this.maViTri = maViTri;
        this.maLoaiXe = maLoaiXe;
        this.soKhung = soKhung;
        this.soMay = soMay;
        this.soLuongNhap = soLuongNhap;
        this.giaNhap = giaNhap;
        this.giaXuat = giaXuat;
        this.soLuongXuat = soLuongXuat;
        this.chkXuatKho = chkXuatKho;
        this.maNhanVienNhap = maNhanVienNhap;
        this.ngayNhap = ngayNhap;
        this.nguoiSuaPN = nguoiSuaPN;
        this.ngaySuaPN = ngaySuaPN;
        this.maNhanVienXuat = maNhanVienXuat;
        this.ngayXuat = ngayXuat;
        this.nguoiSuaPX = nguoiSuaPX;
        this.ngaySuaPX = ngaySuaPX;
    }

    public ChiTietPhieuNhap(String maNhanVienKD, String maKhachHang, String maPhieuNhap, String maPhieuXuat, String maViTri, String maLoaiXe, String soKhung, String soMay, int soLuongNhap, double giaNhap, double giaXuat, int soLuongXuat, int chkXuatKho, String maNhanVienNhap, Date ngayNhap, String nguoiSuaPN, Date ngaySuaPN, String maNhanVienXuat, Date ngayXuat, String nguoiSuaPX, Date ngaySuaPX) {
        this.maNhanVienKD = maNhanVienKD;
        this.maKhachHang = maKhachHang;
        this.maPhieuNhap = maPhieuNhap;
        this.maPhieuXuat = maPhieuXuat;
        this.maViTri = maViTri;
        this.maLoaiXe = maLoaiXe;
        this.soKhung = soKhung;
        this.soMay = soMay;
        this.soLuongNhap = soLuongNhap;
        this.giaNhap = giaNhap;
        this.giaXuat = giaXuat;
        this.soLuongXuat = soLuongXuat;
        this.chkXuatKho = chkXuatKho;
        this.maNhanVienNhap = maNhanVienNhap;
        this.ngayNhap = ngayNhap;
        this.nguoiSuaPN = nguoiSuaPN;
        this.ngaySuaPN = ngaySuaPN;
        this.maNhanVienXuat = maNhanVienXuat;
        this.ngayXuat = ngayXuat;
        this.nguoiSuaPX = nguoiSuaPX;
        this.ngaySuaPX = ngaySuaPX;
    }

    public ChiTietPhieuNhap(String soKhung) {
        this.soKhung = soKhung;
    }

    public int getIdChiTietPhieuNhap() {
        return idChiTietPhieuNhap;
    }

    public void setIdChiTietPhieuNhap(int idChiTietPhieuNhap) {
        this.idChiTietPhieuNhap = idChiTietPhieuNhap;
    }

    public String getMaNhanVienKD() {
        return maNhanVienKD;
    }

    public void setMaNhanVienKD(String maNhanVienKD) {
        this.maNhanVienKD = maNhanVienKD;
    }

    public String getMaPhieuNhap() {
        return maPhieuNhap;
    }

    public void setMaPhieuNhap(String maPhieuNhap) {
        this.maPhieuNhap = maPhieuNhap;
    }

    public String getMaPhieuXuat() {
        return maPhieuXuat;
    }

    public void setMaPhieuXuat(String maPhieuXuat) {
        this.maPhieuXuat = maPhieuXuat;
    }

    public String getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(String maViTri) {
        this.maViTri = maViTri;
    }

    public String getMaLoaiXe() {
        return maLoaiXe;
    }

    public void setMaLoaiXe(String maLoaiXe) {
        this.maLoaiXe = maLoaiXe;
    }

    public String getSoKhung() {
        return soKhung;
    }

    public void setSoKhung(String soKhung) {
        this.soKhung = soKhung;
    }

    public String getSoMay() {
        return soMay;
    }

    public void setSoMay(String soMay) {
        this.soMay = soMay;
    }

    public int getSoLuongNhap() {
        return soLuongNhap;
    }

    public void setSoLuongNhap(int soLuongNhap) {
        this.soLuongNhap = soLuongNhap;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaXuat() {
        return giaXuat;
    }

    public void setGiaXuat(double giaXuat) {
        this.giaXuat = giaXuat;
    }

    public int getSoLuongXuat() {
        return soLuongXuat;
    }

    public void setSoLuongXuat(int soLuongXuat) {
        this.soLuongXuat = soLuongXuat;
    }

    public int getChkXuatKho() {
        return chkXuatKho;
    }

    public void setChkXuatKho(int chkXuatKho) {
        this.chkXuatKho = chkXuatKho;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMaNhanVienNhap() {
        return maNhanVienNhap;
    }

    public void setMaNhanVienNhap(String maNhanVienNhap) {
        this.maNhanVienNhap = maNhanVienNhap;
    }

    public String getNguoiSuaPN() {
        return nguoiSuaPN;
    }

    public void setNguoiSuaPN(String nguoiSuaPN) {
        this.nguoiSuaPN = nguoiSuaPN;
    }

    public Date getNgaySuaPN() {
        return ngaySuaPN;
    }

    public void setNgaySuaPN(Date ngaySuaPN) {
        this.ngaySuaPN = ngaySuaPN;
    }

    public String getMaNhanVienXuat() {
        return maNhanVienXuat;
    }

    public void setMaNhanVienXuat(String maNhanVienXuat) {
        this.maNhanVienXuat = maNhanVienXuat;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public String getNguoiSuaPX() {
        return nguoiSuaPX;
    }

    public void setNguoiSuaPX(String nguoiSuaPX) {
        this.nguoiSuaPX = nguoiSuaPX;
    }

    public Date getNgaySuaPX() {
        return ngaySuaPX;
    }

    public void setNgaySuaPX(Date ngaySuaPX) {
        this.ngaySuaPX = ngaySuaPX;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    @Override
    public String toString() {
        return this.maLoaiXe +" - " + this.soKhung ;
    }

    public String totoString() {
        return "ChiTietPhieuNhap{" + "idChiTietPhieuNhap=" + idChiTietPhieuNhap + ", maNhanVienKD=" + maNhanVienKD + ", maKhachHang=" + maKhachHang + ", maPhieuNhap=" + maPhieuNhap + ", maPhieuXuat=" + maPhieuXuat + ", maViTri=" + maViTri + ", maLoaiXe=" + maLoaiXe + ", soKhung=" + soKhung + ", soMay=" + soMay + ", soLuongNhap=" + soLuongNhap + ", giaNhap=" + giaNhap + ", giaXuat=" + giaXuat + ", soLuongXuat=" + soLuongXuat + ", chkXuatKho=" + chkXuatKho + ", maNhanVienNhap=" + maNhanVienNhap + ", ngayNhap=" + ngayNhap + ", nguoiSuaPN=" + nguoiSuaPN + ", ngaySuaPN=" + ngaySuaPN + ", maNhanVienXuat=" + maNhanVienXuat + ", ngayXuat=" + ngayXuat + ", nguoiSuaPX=" + nguoiSuaPX + ", ngaySuaPX=" + ngaySuaPX + '}';
    }

//    @Override
//    public boolean equals(Object obj) {
//        ChiTietPhieuNhap other = (ChiTietPhieuNhap) obj;
//        return other.getMaNhanVienKD() .equals(this.getMaNhanVienKD());
//    }
}
