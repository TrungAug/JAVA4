package com.ttt.TEST;

import org.testng.annotations.Test;
import org.testng.Assert;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ttt.Entity.PhieuNhap;

public class PhieuNhapTest {
	PhieuNhap pn;

	@BeforeMethod
	public void getPhieuNhap() {
		pn = new PhieuNhap("TestMaPN01", "PC05132", new Date(), new Date(), "NV0001", "Trung Nguyen Tesing");
	}

	@AfterMethod
	public void setPhieuNhap() {
		pn = null;
	}

	@Test(groups = "phieunhap")
	public void testPhieuNhapConstructor() {
		System.out.println("testPhieuNhapConstructor");

		
		String maPhieuNhap = "PN0001";
		String maNhanVien = "NV123";
		Date ngayNhap = new Date();
		Date ngaySua = new Date();
		String nguoiSua = "NV0002";
		String dienGiai = "Trung Nguyen Testing";

		PhieuNhap pn = new PhieuNhap(maPhieuNhap, maNhanVien, ngayNhap, ngaySua, nguoiSua, dienGiai);

		Assert.assertEquals(maPhieuNhap, pn.getMaPhieuNhap());
		Assert.assertEquals(maNhanVien, pn.getMaNhanVien());
		Assert.assertEquals(ngayNhap, pn.getNgayNhap());
		Assert.assertEquals(ngaySua, pn.getNgaySua());
		Assert.assertEquals(nguoiSua, pn.getNguoiSua());
		Assert.assertEquals(dienGiai, pn.getDienGiai());
	}

	@Test(groups = "phieunhap")
	public void getDienGiaiTest() {
		System.out.println("getDienGiai()");
		String expected = "Trung Nguyen Tesing";
		String actual = pn.getDienGiai();
		Assert.assertEquals(expected, actual);
	}

	@Test(groups = "phieunhap")
	public void getMaNhanVienTest() {
		System.out.println("getMaNhanVienTest");
		String expected = "PC05132";
		String actual = pn.getMaNhanVien();
		Assert.assertEquals(expected, actual);
	}

	@Test(groups = "phieunhap")
	public void getMaPhieuNhapTest() {
		System.out.println("getMaPhieuNhapTest");
		String expected = "TestMaPN01";
		String actual = pn.getMaPhieuNhap();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void getNgayNhapTest() {
		System.out.println("getNgayNhapTest");
		Date expected = new Date();
		Date actual = pn.getNgayNhap();
		Assert.assertEquals(expected.getTime(), actual.getTime());
	}

	@Test(groups = "phieunhap")
	public void getNgaySuaTest() {
		System.out.println("getNgaySuaTest");
		Date expected = new Date();
		Date actual = pn.getNgaySua();
		Assert.assertEquals(expected.getTime(), actual.getTime());
	}

	@Test(groups = "phieunhap")
	public void getNguoiSuaTest() {
		System.out.println("getNguoiSuaTest");
		String expected = "NV0001";
		String actual = pn.getNguoiSua();
		Assert.assertEquals(expected, actual);
	}

	@Test(groups = "phieunhap")
	public void setDienGiaiTest() {
		System.out.println("setDienGiaiTest");
		String dienGiai = "Trung Set dien giai moi";
		pn.setDienGiai(dienGiai);

		String expected = "Trung Set dien giai moi";
		String actual = pn.getDienGiai();
		Assert.assertEquals(expected, actual);
	}

	@Test(groups = "phieunhap")
	public void setMaNhanVienTest() {
		System.out.println("setMaNhanVienTest");
		String maNV = "MaNVMOI";
		pn.setMaNhanVien(maNV);

		String expected = "MaNVMOI";
		String actual = pn.getMaNhanVien();
		Assert.assertEquals(expected, actual);
	}

	@Test(groups = "phieunhap")
	public void setMaPhieuNhapTest() {
		System.out.println("setMaPhieuNhapTest");
		String maNV = "MaPNMOI";
		pn.setMaPhieuNhap(maNV);

		String expected = "MaPNMOI";
		String actual = pn.getMaPhieuNhap();
		Assert.assertEquals(expected, actual);
	}

	@Test(groups = "phieunhap")
	public void setNgayNhapTest() {
		System.out.println("setNgayNhapTest");
		String ngayNhapString = "12/04/2023";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date ngayNhap = dateFormat.parse(ngayNhapString);
			pn.setNgayNhap(ngayNhap);

			Assert.assertEquals(ngayNhap.getTime(), pn.getNgayNhap().getTime());
		} catch (java.text.ParseException e) {

			e.printStackTrace();
		}

	}

	@Test(groups = "phieunhap")
	public void setNgaySuaTest() {
		System.out.println("setNgaySuaTest");
		String ngaySuaString = "12/04/2023";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			Date ngaySua = dateFormat.parse(ngaySuaString);
			pn.setNgaySua(ngaySua);

			Assert.assertEquals(ngaySua.getTime(), pn.getNgaySua().getTime());
		} catch (java.text.ParseException e) {

			e.printStackTrace();
		}
	}

	@Test(groups = "phieunhap")
	public void setNguoiSuaTest() {
		System.out.println("setNguoiSuaTest");
		String maNV = "MASUAMOI";
		pn.setNguoiSua(maNV);

		String expected = "MASUAMOI";
		String actual = pn.getNguoiSua();
		Assert.assertEquals(expected, actual);
	}

}
