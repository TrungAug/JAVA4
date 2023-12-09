package com.ttt.TEST;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ttt.Entity.NhanVien;

public class TestDoiMatKhau {

	String maNvCu;
	String passNvCu;
	String maHienTai;
	String passHienTai;

	@Test(dataProvider = "dataCheck")
	public void checkNullTest(String txtmaNhanVien, String txtPassHienTai, String txtPassMoi, String txtXacNhanPassMoi,
			String expected) {
		NhanVien nv = new NhanVien("NV20230712", "nv1234", "Nguyen Trung", null, "nam", "An Giang",
				"trung123@gmail.com", "TruongPhong", "KT01", null);

		maHienTai = txtmaNhanVien;
		passHienTai = txtPassHienTai;
		String actual = "";
		String passMoi = txtPassMoi;
		String xacNhanPassMoi = txtXacNhanPassMoi;
		if (nv != null) {
			maNvCu = nv.getMaNV();
			passNvCu = nv.getMatKhau();
		}
		int flag_maht = 0;
		int flag_passht = 0;
		int flag_passmoi = 0;
		int flag_xacnhan = 0;
		int flag_check = 0;
		if (maHienTai == null || maHienTai.equalsIgnoreCase("")) {
			flag_maht = 1;
		}
		if (passHienTai == null || passHienTai.equalsIgnoreCase("") || passHienTai.equalsIgnoreCase("matkhau")) {
			flag_passht = 1;
		}
		if (passMoi == null || passMoi.equalsIgnoreCase("") || passMoi.equalsIgnoreCase("matkhaumoi")) {
			flag_passmoi = 1;
		}
		if (passMoi.length() < 8) {
			flag_passmoi = 2;
		}
		if (!passMoi.equalsIgnoreCase(xacNhanPassMoi)) {
			flag_xacnhan = 1;
		}
		if (!maNvCu.equalsIgnoreCase(maHienTai) || !passNvCu.equalsIgnoreCase(passHienTai)) {
			flag_check = 1;

		}
		if (flag_maht == 1 && flag_passht == 1 && (flag_passmoi == 1 || flag_passmoi == 2) && flag_xacnhan == 1
				&& flag_check == 1) {
			actual = "Vui lòng nhập đầy đủ thông tin";

		} else if (flag_passht == 1 && (flag_passmoi == 1 || flag_passmoi == 2) && flag_xacnhan == 1
				&& flag_check == 1) {
			actual = "Chưa nhập đủ thông tin";

		} else if ((flag_passmoi == 1 || flag_passmoi == 2) && flag_xacnhan == 1 && flag_check == 1) {
			actual = "Chưa nhập đủ thông tin";

		} else if (flag_passmoi == 2 && flag_xacnhan == 1 && flag_check == 1) {
			actual = "Thông tin nhập chưa đúng";

		} else if (flag_xacnhan == 1 && flag_check == 1) {
			actual = "Thông tin nhập chưa đúng";

		} else if (flag_check == 1) {
			actual = "Thông tin đăng nhập không đúng";

		} else if (flag_xacnhan == 1) {
			actual = "Xác nhận mật khẩu không đúng";

		} else if (flag_passmoi == 2) {
			actual = "Mật khẩu phải có ít nhất 8 ký tự";

		} else if (flag_passmoi == 1) {
			actual = "Vui lòng nhập mật khẩu mới";

		} else if (flag_passht == 1) {
			actual = "Vui lòng nhập mật khẩu hiện tại";

		} else if (flag_maht == 1) {
			actual = "Vui lòng nhập mã nhân viên";

		} else {
			actual = "Đổi mật khẩu thành công";
		}
		Assert.assertEquals(actual, expected);
	}

//	String txtmaNhanVien, String txtPassHienTai, String txtPassMoi, String txtXacNhanPassMoi, String expected
	@DataProvider
	private Object[][] dataCheck() {
		return new Object[][] { { "", "", "", "", "Vui lòng nhập đầy đủ thông tin" },
				{ "", "matkhau", "matkhaumoi", "", "Vui lòng nhập đầy đủ thông tin" }, // Đổi mật khẩu thất bại với các
																						// thông tin để trống
				{ "", "", "mk134567", "mk43128", "Vui lòng nhập đầy đủ thông tin" }, // Đổi mật khẩu thất bại với mã
																						// nhân viên và mật khẩu hiện
																						// tại, xác nhận mật khẩu không
																						// đúng
				{ "NV20230713", "", "", "mkxn112233", "Chưa nhập đủ thông tin" }, // Đổi mật khẩu thất bại với mã nhân
																					// viên không đúng, mật khẩu hiện
																					// tại và mật khẩu mới để trống, xác
																					// nhận mật khẩu không đúng
				{ "NV20230715", "", "mk32", "mk332211", "Chưa nhập đủ thông tin" }, // Đổi mật khẩu thất bại với mã nhân
																					// viên không đúng, để trống mật
																					// khẩu hiện tại và xác nhận mật
																					// khẩu không khớp, mật khẩu mới ít
																					// hơn 8 ký tự
				{ "NV20230719", "nv1234", "", "mkxn", "Chưa nhập đủ thông tin" }, // Đổ mật khẩu thất bại với mật khẩu
																					// mới để trống,
				{ "NV20230718", "nv1234", "mk56", "mk65", "Thông tin nhập chưa đúng" }, // Đổi mật khẩu thất bại với mật
																						// khẩu nhỏ hơn 8 ký tự và xác
																						// nhận mật khẩu không đúng
				// và mã nhân viên không tồn tại

				{ "NV20230710", "nv1234", "mk7891230", "", "Chưa nhập đủ thông tin" }, // Đổi mật khẩu thất bại với xác
																						// nhận mật khẩu để trống
				{ "NV20230710", "nv1234", "mk7891230", "mk123450", "Thông tin nhập chưa đúng" }, // Đổi mật khẩu thất
																									// bại với xác nhận
																									// MK không đúng, Mã
																									// nhân viên không
																									// đúng
				{ "NV20230712", "nv12", "mk7891230", "mk123450", "Thông tin nhập chưa đúng" }, // Đổi mật khẩu thất bại
																								// với xác nhận MK không
																								// đúng, mật khẩu hiện
																								// tại không đúng
				{ "NV20230717", "nv123", "mk7891230", "mk7891230", "Thông tin đăng nhập không đúng" }, // Đổi mật khẩu
																										// thất bại với
																										// mã nhân viên
																										// nhập sai
				{ "NV20230712", "nv1234", "mk7891230", "mk789123000", "Xác nhận mật khẩu không đúng" }, //// Đổi mật
																										//// khẩu thất
																										//// bại với xác
																										//// nhận mật
																										//// khẩu không
																										//// khớp
				{ "NV20230712", "nv1234", "mk789", "mk789", "Mật khẩu phải có ít nhất 8 ký tự" }, //// Đổi mật khẩu thất
																									//// bại với mật
																									//// khẩu nhỏ hơn 8
																									//// ký tự
				{ "NV20230712", "nv1234", "", "mk7891230", "Vui lòng nhập mật khẩu mới" }, //// Đổi mật khẩu thất bại
																							//// với mật khẩu mới để
																							//// trống

				{ "NV20230712", "", "mk7891230", "mk7891230", "Vui lòng nhập mật khẩu hiện tại" }, // Đổi mật khẩu thất
																									// bại với mật khẩu
																									// hiện tại trống
				{ "NV20230712", "matkhau", "mk7891230", "mk7891230", "Vui lòng nhập mật khẩu hiện tại" },
				{ "", "nv1234", "mk7891230", "mk7891230", "Vui lòng nhập mã nhân viên" }, // Đổi mật khẩu thất bại với
																							// mã nhân viên trống
				{ "NV20230712", "nv1234", "mk7891230", "mk7891230", "Đổi mật khẩu thành công" },// Đổi mật khẩu thành
																								// công
		};
	}

//	public static void main(String[] args) {
//		NhanVien nv = new NhanVien("NV20230712", "nv1234", "Nguyen Trung", null, "nam", "An Giang",
//				"trung123@gmail.com", "TruongPhong", "KT01", null);
//		System.out.println(nv.getMaNV());
//	}

}
