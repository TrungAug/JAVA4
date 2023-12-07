package com.ttt.TEST;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ttt.DAO.NhanVienDAO;
import com.ttt.Entity.NhanVien;
import com.ttt.LibaryHelper.DialogHelper;

public class TestNhanVien {

	NhanVienDAO dao = new NhanVienDAO();
	NhanVien nv = new NhanVien();

	

	@Test(dataProvider = "nhanVienData")
	public void themnvPass(String maNV, String hoTen, String diaChi, String email, String matKhau,
			String ngaySinhString ,String expected) {
		String actual = "";
	
		try {
			if (hoTen == null || hoTen.equalsIgnoreCase("")) {

				actual = "Vui lòng nhập họ tên";
			} else if (diaChi == null || diaChi.equalsIgnoreCase("")) {

				actual = "Vui lòng nhập địa chỉ";
			} else if (email == null || email.equalsIgnoreCase("")) {

				actual = "Vui lòng nhập email";
			} else if (matKhau == null || matKhau.equalsIgnoreCase("")) {

				actual = "Vui lòng nhập mật khẩu";
			} else if (matKhau.length() < 8) {

				actual = "Mật khẩu không đúng định dạng";
			} else if (ngaySinhString == null || ngaySinhString.equalsIgnoreCase("")) {

				actual = "Vui lòng nhập ngày sinh";
			}else {
				actual = "Thành công";
				
			}
		} catch (Exception e) {
			if (hoTen == null || hoTen.equalsIgnoreCase("") && diaChi == null
					|| diaChi.equalsIgnoreCase("") && email == null || email.equalsIgnoreCase("") && matKhau == null
					|| matKhau.equalsIgnoreCase("")

			) {
				actual = "Vui lòng nhập dữ liệu";
			} else {

				actual = "Sai định dạng";
			}
			e.printStackTrace();
		}

		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	public Object[][] nhanVienData() {
		return new Object[][] { { "NV2023101500017", "Hồ Trọng Tường", "Hậu Giang", "tuong@gmail.com", "12345678",
				"01-01-2003", "Thành công" } };

	}
	
	
	

	@Test(dataProvider = "nhanVienDataUpdate")
	public void UpdateNhanVien(String maNV, String hoTen, String diaChi, String email, String matKhau,
			String ngaySinhString, String expected) {
		String actual = "";

		try {
			if (hoTen == null || hoTen.equalsIgnoreCase("")) {

				actual = "Vui lòng nhập họ tên";
			} else if (diaChi == null || diaChi.equalsIgnoreCase("")) {

				actual = "Vui lòng nhập địa chỉ";
			} else if (email == null || email.equalsIgnoreCase("")) {

				actual = "Vui lòng nhập email";
			} else if (matKhau == null || matKhau.equalsIgnoreCase("")) {

				actual = "Vui lòng nhập mật khẩu";
			} else if (matKhau.length() < 8) {

				actual = "Mật khẩu không đúng định dạng";
			} else if (ngaySinhString == null || ngaySinhString.equalsIgnoreCase("")) {

				actual = "Vui lòng nhập ngày sinh";
			}else {
				actual = "Cập nhật thành công";
				
			}
			// dao.update(nv);
		} catch (Exception e) {
			if (hoTen == null || hoTen.equalsIgnoreCase("") && diaChi == null
					|| diaChi.equalsIgnoreCase("") && email == null || email.equalsIgnoreCase("") && matKhau == null
					|| matKhau.equalsIgnoreCase("")

			) {

				actual = "Vui lòng nhập dữ liệu";
			} else {

				actual = "Sai định dạng";
			}
			e.printStackTrace();
		}

		Assert.assertEquals(actual, expected);
	}


	@DataProvider
	public Object[][] nhanVienDataUpdate() {
		return new Object[][] {
				{ "NV2023072100002", "", "Hậu Giang", "tuong@gmail.com@gmail.com", "11111111",
						"1999-01-08", "Vui lòng nhập họ tên" },
				{ "NV2023072100003", "Đỗ Tấn Tài", "Hậu Giang", "tai@gmail.com", "11111111", "1999-01-08", "Cập nhật thành công" } };

	}
	
	
	
	
	
	
	
	@DataProvider
	public Object[][] DeletenhanVienDataProvider() {
		return new Object[][] {
				{ "NV2023072100002", "Hồ Trọng Tường", "Hậu Giang", "tuong@gmail.com@gmail.com", "11111111",
						"1999-01-08", "Thành công" },
				{ "NV2023072100003", "Đỗ Tấn Tài", "Hậu Giang", "tai@gmail.com", "11111111", "1999-01-08", true } };
	}

	@Test(groups = "testNhanVien")
	public void XoaNhanVien_ThanhCong() {
		System.out.println("Xóa nhân viên Thành công");
		String actual = "";

		String manv = "NV2023072100002";
		NhanVienDAO dao = new NhanVienDAO();
		NhanVien nv = dao.selectById(manv);

		if (nv == null) {

			try {
				dao.delete(manv);
				actual = "Xóa thành công";
			} catch (Exception e) {
				actual = "Xóa thất bại";
			}
		} else {
			actual = "Nhân viên không tồn tại, không thể xóa";
		}

		String expected = "Xóa thành công";
		Assert.assertEquals(actual, expected);
	}
	
	@DataProvider
	public Object[][] ChecknhanVienDataProvider() {
		return new Object[][] {
				{ "Nguyễn Thành Trung", "trung@gmail.com", "1999-01-08", "11111111","11111111"
						, "Thành công" },
				{"Đỗ Tấn Tài", "tai@gmail.com", "1999-01-08", "11111111","11111111", "Thành Công" } };
	}

	@Test(dataProvider = "ChecknhanVienDataProvider" )
	public void checkNullTest(String ten, String email, int checkTuoi, String passMoi, String xacNhanPassMoi,
			String expected) {
		String patternDate = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";
		String patternName = "^[\\p{L}\\s]+$";
//      int checkTuoi = getAge(txtNgaysinh.getText());
//      String passMoi = new String(txtMk.getPassword());
//      String xacNhanPassMoi = new String(txtMkx.getPassword());
		int flag_ten = 0;
		int flag_email = 0;
		int flag_mk = 0;
		int flag_xnmk = 0;
		int flag_tuoi = 0;
		int flag_gt = 0;
		int flag_chucvu = 0;

		String actual = "";
		if (ten.equals("") || ten == null) {
			flag_ten = 1;
		}

		if (!ten.matches(patternName)) {
			flag_ten = 2;
		}
		if (email.equals("") || email == null) {
			flag_email = 1;
		}
		if (passMoi == null || passMoi.equalsIgnoreCase("") || passMoi.equalsIgnoreCase("matkhaumoi")) {
			flag_mk = 1;
		}

		if (passMoi.length() < 8) {
			flag_mk = 2;
		}
		if (!passMoi.equalsIgnoreCase(xacNhanPassMoi)) {
			flag_xnmk = 1;
		}
		if (checkTuoi < 18) {
			flag_tuoi = 1;
		}

		if (flag_email == 1 && (flag_ten == 1 || flag_ten == 2) && (flag_mk == 1 || flag_mk == 2) && flag_xnmk == 1
				&& flag_tuoi == 1 && flag_chucvu == 1 && flag_gt == 1) {

			actual = "Vui lòng nhập thông tin";
		} else if ((flag_ten == 1 || flag_ten == 2) && (flag_mk == 1 || flag_mk == 2) && flag_xnmk == 1
				&& flag_tuoi == 1 && flag_chucvu == 1 && flag_gt == 1) {

			actual = "Chưa nhập đủ thông tin";
		} else if ((flag_mk == 1 || flag_mk == 2) && flag_xnmk == 1 && flag_tuoi == 1 && flag_chucvu == 1
				&& flag_gt == 1) {
			actual = "Chưa nhập đủ thông tin";
		} else if (flag_xnmk == 1 && flag_tuoi == 1 && flag_chucvu == 1 && flag_gt == 1) {
			actual = "Chưa nhập đủ thông tin";
		} else if (flag_tuoi == 1 && flag_chucvu == 1 && flag_gt == 1) {
			actual = "Chưa nhập đủ thông tin";
		} else if (flag_chucvu == 1 && flag_gt == 1) {
			actual = "Chưa nhập đủ thông tin";
		} else if (flag_email == 1 && (flag_ten == 1 || flag_ten == 1)) {
			actual = "Chưa nhập đủ thông tin";
		} else if (flag_ten == 2 && flag_mk == 2 && flag_tuoi == 1) {
			actual = "Thông tin nhập chưa đúng";
		} else if (flag_mk == 2 && flag_tuoi == 1) {
			actual = "Thông tin nhập chưa đúng";
		} else if (flag_tuoi == 1) {

			actual = "Ngày sinh không hợp lệ. Nhân viên phải đủ 18 tuổi";
		} else if (flag_mk == 2) {

			actual = "Mật khẩu phải có ít nhất 8 ký tự";
		} else if (flag_ten == 2) {

			actual = "Tên nhân viên không hợp lệ";
		} else if (flag_gt == 1) {

			actual = "Vui lòng chọn giới tính";
		} else if (flag_chucvu == 1) {

			actual = "Vui lòng chọn chức vụ";
		} else if (flag_xnmk == 1) {

			actual = "Xác nhận mật khẩu không đúng";
		} else if (flag_mk == 1) {

			actual = "Vui lòng nhập mật khẩu";
		} else if (flag_ten == 1) {

			actual = "Vui lòng nhập tên nhân viên";
		} else if (flag_email == 1) {

			actual = "Vui lòng nhập email";
		}

		Assert.assertEquals(actual, expected);
	}

	
	
	
	
	
	
	
	
	
	@Test(dataProvider = "nhanVienDataDelete")
	public void deleteTest(String ma) {
		System.out.println("Xóa nhân viên Thành công");
		String actual = "";

		String manv = "NV2023072100003";
		NhanVienDAO dao = new NhanVienDAO();
		NhanVien nv = dao.selectById(manv);

		try {
			dao.delete(manv);
			List<NhanVien> list = dao.selectByKeyword(manv);
			if (nv == null) {
				
				actual = "Xóa thành công";
			} else {
				actual = "Nhân viên không tồn tại, không thể xóa";

			}
			String expected = "Xóa thành công";
			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			actual = "Xóa thất bại";
		}

		
		
	}

	

	@Test
	public void checkTrungMaNV(String maNV, boolean expected) {
		boolean actual = false;
		List<NhanVien> list = NhanVienDAO.getNewNhanVienDAO().selectAll();
		for (NhanVien nv : list) {
			if (nv.getMaNV().equalsIgnoreCase(maNV)) {
				actual = false;
			}

		}
		Assert.assertEquals(actual, expected);
	}

}
