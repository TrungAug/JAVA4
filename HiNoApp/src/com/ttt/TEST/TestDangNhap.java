package com.ttt.TEST;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ttt.DAO.NhanVienDAO;
import com.ttt.Entity.NhanVien;


public class TestDangNhap {
	@Test(dataProvider ="dataLogin")
	public void loginTest(String username, String password, String expected) {
		String actual = "";
		String maNV = username;
		String matKhau = password;
		NhanVien nhanVien = NhanVienDAO.getNewNhanVienDAO().selectById(maNV);

		if (nhanVien == null) {
			actual = "Sai tên đăng nhập";
		} else if (!matKhau.equals(nhanVien.getMatKhau())) {
			actual = "Sai mật khẩu";
		} else {
			actual = "Hiển thị giao diện làm việc";
		}
		Assert.assertEquals(actual, expected);
	}
	@DataProvider
	private Object[][] dataLogin(){
		return new Object[][] {
			{"","1234","Vui lòng nhập mã nhân viên"},
			{"PC05132","1234","Sai tên đăng nhập"},
			{"NV2023072100001","","Vui lòng nhập mật khẩu"},
			{"NV2023072100001","saimk","Sai mật khẩu"},
			{"PC05132","saimk","Đăng nhập sai tài khoản"},
			{"NV2023072100001","1234","Hiển thị giao diện làm việc"},
		};
	}
}
