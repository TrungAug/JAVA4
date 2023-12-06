/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.Entity;

import com.ttt.DAO.ChiNhanhDAO;
import com.ttt.DAO.ChiTietPhieuNhapDAO;
import com.ttt.DAO.KhachHangDAO;
import com.ttt.DAO.LoaiXeDAO;
import com.ttt.DAO.NhanVienDAO;
import com.ttt.DAO.PhieuNhapDAO;
import com.ttt.DAO.PhieuXuatDAO;
import com.ttt.DAO.PhongBanDAO;
import com.ttt.DAO.ThongKeDAO;
import com.ttt.DAO.ViTriDAO;
import com.ttt.LibaryHelper.Auth;
import com.ttt.LibaryHelper.DateHelper;
import com.ttt.LibaryHelper.ExcelExporter;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFileChooser;

/**
 *
 * @author ASUS
 */
public class TestJDBC {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        //ChiNhanh cn = new ChiNhanh("CN05","Chi Nhánh An Giang","1600988789","Tân Châu, An Giang");
        //ChiNhanhDAO.getNewChiNhanhDAO().insert(cn);
        // ChiNhanhDAO.getNewChiNhanhDAO().delete("CN06");
        //ChiNhanhDAO.getNewChiNhanhDAO().update(cn);
//        List<ChiNhanh> listNv5 = ChiNhanhDAO.getNewChiNhanhDAO().selectAll();
//        for(ChiNhanh n :listNv5){
//            System.out.println(n.toString());
//        }

        //  PhieuNhap pn = new PhieuNhap("Test1", "NV2023072100002", DateHelper.toDate("22-07-2023", "dd-MM-yyy"), DateHelper.toDate("22-07-2023", "dd-MM-yyy"), "NV2023072100002", "Test db");
        //PhieuNhapDAO.getNewPhieuNhapDAO().insert(pn);
        // PhieuNhapDAO.getNewPhieuNhapDAO().update(pn);
//        PhieuNhapDAO.getNewPhieuNhapDAO().delete("Test1");
//        List<PhieuNhap> listNv5 = PhieuNhapDAO.getNewPhieuNhapDAO().selectAll();
//        for(PhieuNhap n :listNv5){
//            System.out.println(n.toString());
//        }
        // PhieuXuat px = new PhieuXuat("Test1", "KH02",  1, 800, "NV2023072100001", DateHelper.toDate("22-07-2023", "dd-MM-yyy"), "NV2023072100003", DateHelper.toDate("22-07-2023", "dd-MM-yyy"), "dienGiai");
        //PhieuXuatDAO.getNewPhieuXuatDAO().insert(px);
        //PhieuXuatDAO.getNewPhieuXuatDAO().update(px);
//       PhieuXuatDAO.getNewPhieuXuatDAO().delete("Test1");
//        List<PhieuXuat> listNv5 = PhieuXuatDAO.getNewPhieuXuatDAO().selectAll();
//        for (PhieuXuat n : listNv5) {
//            System.out.println(n.toString());
//        }
        //  ChiTietPhieuNhap ct = new ChiTietPhieuNhap(11,"NV2023072100001",null,"PX2023072200001","VT01","FCJLMB","SK 788","SM 123",1,500,800,1,1,"NV2023072100001",null,null,null,null,null,null,null);
        //  ChiTietPhieuNhap ct = new ChiTietPhieuNhap("NV2023072100003", null, "PX2023072200001", "VT01", "FCJLMB", "SK 788", "SM 123", 1, 500, 800, 1, 1, "NV2023072100001", null, null, null, null, null, null, null);
        //   ChiTietPhieuNhap ct = new ChiTietPhieuNhap("NV2023072100002",null,"PX2023072200001","VT01","FCJLMB","SK 788","SM 123",1,500,800,1,1,"NV2023072100001",null,null,null);
        //ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().insert(ct);
        //ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().update(ct);
        // ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().delete("11");
//        List<ChiTietPhieuNhap> listNv5 = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll();
//        for (ChiTietPhieuNhap n : listNv5) {
//            System.out.println(n.toString());
//        }
        // LoaiXe lx = new LoaiXe("TEST","etsttt","XE TẢI CẨU XZU730L");
        // LoaiXeDAO.getNewLoaiXeDAO().insert(lx);
        //LoaiXeDAO.getNewLoaiXeDAO().update(lx);
        //LoaiXeDAO.getNewLoaiXeDAO().delete("TEST");
//        List<LoaiXe> listNv5 = LoaiXeDAO.getNewLoaiXeDAO().selectAll();
//        for (LoaiXe n : listNv5) {
//            System.out.println(n.toString());
//        }
        //KhachHang kh = new KhachHang("KH06","TAAAA","Trà Vinh",null,null,null);
        //KhachHangDAO.getNewKhachHangDAO().insert(kh);
        //KhachHangDAO.getNewKhachHangDAO().update(kh);
        //KhachHangDAO.getNewKhachHangDAO().delete("KH06");
//        List<KhachHang> listNv5 = KhachHangDAO.getNewKhachHangDAO().selectAll();
//        for (KhachHang n : listNv5) {
//            System.out.println(n.toString());
//        }
        //  ViTri vt = new ViTri("TEST","CN01","Kho 0111111111111111111111111");
        //  ViTriDAO.getNewViTriDAO().insert(vt);
        //ViTriDAO.getNewViTriDAO().update(vt);
        // ViTriDAO.getNewViTriDAO().delete("TEST");
//        List<ViTri> listNv5 = ViTriDAO.getNewViTriDAO().selectAll();
//        for (ViTri n : listNv5) {
//            System.out.println(n.toString());
//        }
        //PhongBan pb = new PhongBan("NS02", "AAAAAAAAAAA", "CN01");
        //  PhongBanDAO.getNewPhongBanDAO().insert(pb);
        // PhongBanDAO.getNewPhongBanDAO().update(pb);
        // PhongBanDAO.getNewPhongBanDAO().delete("NS02");
//        List<PhongBan> listNv5 = PhongBanDAO.getNewPhongBanDAO().selectAll();
//        for (PhongBan n : listNv5) {
//            System.out.println(n.toString());
//        }
        //NhanVien nv = new NhanVien("TEST", "12345678", "Nguyễn Phúc Thái", DateHelper.toDate("22-07-1999", "dd-MM-yyy"), "Nam", "An Giang", "thai@gmail.com", "Nhân Viên", "KD01", "thai.jpg");
        // NhanVienDAO.getNewNhanVienDAO().insert(nv);
        // NhanVienDAO.getNewNhanVienDAO().update(nv);
        //NhanVienDAO.getNewNhanVienDAO().delete("TEST");
//        List<NhanVien> listNv5 = NhanVienDAO.getNewNhanVienDAO().selectAll();
//        for (NhanVien n : listNv5) {
//            System.out.println(n.toString());
//        }
//        String ma = ThongKeDAO.getNewThongKeDAO().getMaPhieuNhapKho();
//        System.out.println(ma);
//
//    List<ChiTietPhieuNhap> list = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_MaPhieuNhap("PN2023072100002");
//    for(ChiTietPhieuNhap ct : list){
//        int idChitiet=ct.getIdChiTietPhieuNhap();
//        System.out.println(idChitiet);
//    }
//        String ma = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().getMaPNBySoKhung("SK 7888");
//        System.out.println(ma);
//            List<NhanVien> list = NhanVienDAO.getNewNhanVienDAO().selectAll_NhanVienKD();
//            for(NhanVien nv:list){
//                System.out.println(nv.totoString());
//            }
//        ChiTietPhieuNhap ct = new ChiTietPhieuNhap("SK 711");
//        ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().update_xuat_kho(ct);
//        List<ChiTietPhieuNhap> list = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_daXuatKho();
//        for(ChiTietPhieuNhap c: list){
//            System.out.println(c.totoString());
////        }
//        LocalDate currentDate = LocalDate.now();
//        String pattern = "dd-MM-yyyy";
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern); 
//       String fm =currentDate.format(dtf);
//        
//       Date a = DateHelper.toDate(fm,"dd-MM-yyyy");
//       
ChiTietPhieuNhap ct = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectById(7+"");
  System.out.println(DateHelper.toStringFormat(ct.getNgayNhap(), "dd-MM-yyyy"));
        
//        Date currentDate = new Date();
//        String pattern = "dd-MM-yyyy";
//        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//        String formattedDate = sdf.format(currentDate);
//        System.out.println(formattedDate);
    }
}
