package com.ttt.TEST;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.Assert;
import java.util.Date;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ttt.DAO.ChiTietPhieuNhapDAO;
import com.ttt.DAO.PhieuNhapDAO;
import com.ttt.Entity.ChiTietPhieuNhap;
import com.ttt.Entity.PhieuNhap;
import com.ttt.form.NhapKho_Form;

public class TestPhieuNhap {

	@Test(dataProvider = "dataCheckSK")
	public void checkExistSoKhungTest(String soKhung, String maPN, String expected) {
		//boolean flagCheckExistEmail = true;
		String actual ="";
		if (!maPN.equalsIgnoreCase(ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().getMaPNBySoKhung(soKhung))) {
			List<ChiTietPhieuNhap> listNH = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_chuaXuatKho();
			for (ChiTietPhieuNhap nh : listNH) {
				if (nh.getSoKhung().equalsIgnoreCase(soKhung)) {
					// DialogHelper.alert(this, "Đã tồn tại số khung " + soKhung);
					//flagCheckExistEmail = false;
					actual="Đã tồn tại số khung";
					break;
				}
			}
		}else {
			actual="Số khung chưa tồn tại";
		}
		Assert.assertEquals(actual,expected);
	}

	// theo đoạn code: những số khung trùng => false, không trùng => true
	@DataProvider
	private Object[][] dataCheckSK() {
		return new Object[][] { { "SK 788", "PN2023072100001", "Đã tồn tại số khung" }, // số khung đã có
				{ "SK 3377", "PX2023072800004", false }, // số khung nhập vào đã tồn tại nhưng thuộc phiếu nhập khác
				{ "SK 12456", "PN2023072100001", "Số khung chưa tồn tại" }, // số khung nhập vào chưa có
		};
	}

	@Test(dataProvider = "checkNullDataProvider")
	public void checkNullTest(String txtSoKhung, String txtSoMay, String txtGiaNhap, String expected) {

		double giaNhap;
		String actual = "";
		try {
			giaNhap = Double.parseDouble(txtGiaNhap);
			if (txtSoKhung == null || txtSoKhung.equalsIgnoreCase("")) {
				// DialogHelper.alert(this, "Vui lòng nhập số khung");
				actual = "Vui lòng nhập số khung";
			} else if (txtSoMay == null || txtSoMay.equalsIgnoreCase("")) {
				// DialogHelper.alert(this, "Vui lòng nhập số máy");
				actual = "Vui lòng nhập số máy";
			} else if (giaNhap < 0) {
				// DialogHelper.alert(this, "Không được nhập âm giá");
				actual = "Không được nhập âm giá";
			}
		} catch (NumberFormatException e) {
			if (txtGiaNhap == null || txtGiaNhap.equalsIgnoreCase("") && txtSoMay == null
					|| txtSoMay.equalsIgnoreCase("") && txtSoKhung == null || txtSoKhung.equalsIgnoreCase("")) {
				// DialogHelper.alert(this, "Vui lòng nhập dữ liệu");
				actual = "Vui lòng nhập dữ liệu";
			} else {
				// DialogHelper.alert(this, "Giá nhập sai kiểu dữ liệu");
				actual = "Giá nhập sai kiểu dữ liệu";
			}
		}

		Assert.assertEquals(actual, expected);
		
	}

	@DataProvider
	private Object[][] checkNullDataProvider() {
		return new Object[][] { { "SK123456789123456", "SM456", "1000", "" }, // Hợp lệ
				{ "SK123456789123456", "SM456", "-1000", "Không được nhập âm giá" }, // Giá nhập âm
				{ "", "SM456", "1000", "Vui lòng nhập số khung" }, // Số khung rỗng
				{ "SK123456789123456", "", "1000", "Vui lòng nhập số máy" }, // Số máy rỗng
				{ "SK123456789123456", "SM456", "", "Giá nhập sai kiểu dữ liệu" }, // Giá nhập rỗng
				{ "", "", "", "Vui lòng nhập dữ liệu" }, // Tất cả đều ""
				{ "SK123456789123456", "SM456", "abc", "Giá nhập sai kiểu dữ liệu" }, // Giá nhập không phải số
				{ "SK123", "SM456", "1000", "Số khung phải có 17 ký tự" },
				{ "SK123456789123456SK", "SM456", "1000", "Số khung phải có 17 ký tự" },
				
		};
	}

	@Test(dataProvider = "getFormChiTietPhieuNhapThem")
	public void getFormChiTietPhieuNhapThemTest(String maPhieuNhap, String maNhanVien, Date ngayNhap,
			String vt_getMaViTri, String lx_getMaLoaiXe, String SoKhung, String SoMay, String GiaNhap,
			boolean expected) {
		boolean actual = false;
		ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
		if (true) {
			// PhieuNhap pn = this.getFormPN("them");
			PhieuNhap pn = new PhieuNhap(maPhieuNhap, maNhanVien, new Date(), null, null, null);
			ct.setMaNhanVienKD(null);
			ct.setMaPhieuNhap(pn.getMaPhieuNhap());
			ct.setMaPhieuXuat(null);
			// ViTri vt = (ViTri) cboViTri.getSelectedItem();
			ct.setMaViTri(vt_getMaViTri);
			// LoaiXe lx = (LoaiXe) cboLoaiXe.getSelectedItem();
			ct.setMaLoaiXe(lx_getMaLoaiXe);
			ct.setSoKhung(SoKhung);
			ct.setSoMay(SoMay);
			ct.setSoLuongNhap(1);
			ct.setGiaNhap(Double.parseDouble(GiaNhap));
			ct.setGiaXuat(0);
			ct.setSoLuongXuat(0);
			ct.setChkXuatKho(0);
			ct.setMaNhanVienNhap(maNhanVien);
			ct.setNgayNhap(new Date());
			ct.setNgaySuaPN(null);
			ct.setNguoiSuaPN(null);
			ct.setMaNhanVienXuat(null);
			ct.setNgayXuat(null);
			ct.setNgaySuaPX(null);
			ct.setNguoiSuaPX(null);
			actual = (ct != null);

		}
		actual = false;
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	private Object[][] getFormChiTietPhieuNhapThem() {
		return new Object[][] { { "PN2023120500007", "NV2023073000009", new Date(), "VT04", "XZU730LMB", "SK 12345678",
				"SM987654", "900", true },

		};
	}

	@Test(dataProvider = "getFormChiTietPhieuNhapSua")
	public void getFormChiTietPhieuNhapSuaTest(String maPhieuNhap, String maNhanVien, Date ngayNhap, Date ngaySua,
			String nguoiSua, String vt_getMaViTri, String lx_getMaLoaiXe, String SoKhung, String SoMay, String GiaNhap,
			int idCT, boolean expected) {
		ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
		boolean actual = false;
		// checkNull()
		if (true) {
			// int idCT = (int) tblChiTiet.getValueAt(this.row, 0);
			ChiTietPhieuNhap ctc = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectById(idCT + "");
			// PhieuNhap pn = this.getFormPN("sua");
			PhieuNhap pn = new PhieuNhap(maPhieuNhap, maNhanVien, ngayNhap, new Date(), nguoiSua, null);
			ct.setIdChiTietPhieuNhap(idCT);
			ct.setMaNhanVienKD(null);
			ct.setMaPhieuNhap(pn.getMaPhieuNhap());
			ct.setMaPhieuXuat(null);
			// ViTri vt = (ViTri) cboViTri.getSelectedItem();
			ct.setMaViTri(vt_getMaViTri);
			// LoaiXe lx = (LoaiXe) cboLoaiXe.getSelectedItem();
			ct.setMaLoaiXe(lx_getMaLoaiXe);
			ct.setSoKhung(SoKhung);
			ct.setSoMay(SoMay);
			ct.setSoLuongNhap(1);
			ct.setGiaNhap(Double.parseDouble(GiaNhap));
			ct.setGiaXuat(0);
			ct.setSoLuongXuat(0);
			ct.setChkXuatKho(0);
			ct.setMaNhanVienNhap(ctc.getMaNhanVienNhap());
			ct.setNgayNhap(ctc.getNgayNhap());
			ct.setNgaySuaPN(new Date());
			ct.setNguoiSuaPN(ctc.getNguoiSuaPN());
			ct.setMaNhanVienXuat(null);
			ct.setNgayXuat(null);
			ct.setNgaySuaPX(null);
			ct.setNguoiSuaPX(null);

		}
		if (ct != null) {
			actual = true;
		}
		actual = false;
		Assert.assertEquals(actual, expected);
		Assert.assertEquals(ct.getSoLuongNhap(), SoKhung);
		Assert.assertEquals(ct.getMaPhieuNhap(), maPhieuNhap);
		Assert.assertEquals(ct.getNguoiSuaPN(), nguoiSua);
	}

	@DataProvider
	private Object[][] getFormChiTietPhieuNhapSua() {
		return new Object[][] { { "PN2023081700007", "NV2023073000009", new Date(), new Date(), "NV2023072100007",
				"VT04", "FCJLTC", "SK 12345678", "SM987654", "900", 15, true },

		};
	}

	@Test(dataProvider = "dataGeFormPN")
	public void getFormPNTest(Boolean checkNull, String dieuKien, String txtPNK, String txtMaNV, String txtDienGiai,
			String expected) {
		String actual = "";
		if (checkNull) {
			PhieuNhap pn = new PhieuNhap();
			if (dieuKien.equals("them")) {
				pn.setMaPhieuNhap(txtPNK);
				pn.setMaNhanVien(txtMaNV);
				pn.setNgayNhap(new Date());
				pn.setNgaySua(null);
				pn.setNguoiSua(null);
				pn.setDienGiai(txtDienGiai);
			} else if (dieuKien.equals("sua")) {
				PhieuNhap pnc = PhieuNhapDAO.getNewPhieuNhapDAO().selectById(txtPNK);
				pn.setMaPhieuNhap(txtPNK);
				pn.setMaNhanVien(pnc.getMaNhanVien());
				pn.setNgayNhap(pnc.getNgayNhap());
				pn.setNgaySua(new Date());
				pn.setNguoiSua(txtMaNV);
				pn.setDienGiai(txtDienGiai);
			}
			actual = "getFormPN Successfully";
		}

		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	private Object[][] dataGeFormPN() {
		return new Object[][] {
				{ false, "them", "PN2023081700008", "NV2023073000009", "Test case checkNull false", "" },
				{ false, "sua", "PN2023072100005", "NV2023073000009", "Test case checkNull false", "" },
				{ true, "sua", "PN2023072100005", "NV2023073000009", "Test case checkNull true",
						"getFormPN Successfully" },
				{ true, "them", "PN2023081700008", "NV2023073000009", "Test case checkNull true",
						"getFormPN Successfully" } };
	}

	@Test(dataProvider = "dataIsExist_PhieuNhap")
	public void isExist_PhieuNhapTest(String maPN, boolean expected) {
		boolean actual = false;
		List<PhieuNhap> list = PhieuNhapDAO.getNewPhieuNhapDAO().selectAll();
		for (PhieuNhap cd : list) {
			if (cd.getMaPhieuNhap().equals(maPN)) {
				actual = true;
			}

		}
		
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	private Object[][] dataIsExist_PhieuNhap() {
		return new Object[][] { { "PN2023072700006", true }, { "PN2023072100003", true }, { "PN2023120500003", false },
				{ "PN2023120500006", false } };
	}

	@Test(dataProvider = "dataChiTietPhieuNhap")
	public void themXeVaoPhieuNhapTest(boolean checkNotNull, String ct_getSoKhung, String ct_getMaPhieuNhap,
			String expected) {
		String actual = "";
		if (checkNotNull) {
			String check_ct = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().getMaPNBySoKhung(ct_getSoKhung);
			if (ct_getMaPhieuNhap.equals(check_ct)) {
				actual = "Đã tồn tại số khung";
			} else {
				// ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().insert(ct);

				actual = "Đã thêm xe vào phiếu nhập";
			}
			Assert.assertEquals(actual, expected);
		}else {
			actual = "Dữ liệu chưa hợp lệ";
		}
	}

	@DataProvider
	private Object[][] dataChiTietPhieuNhap() {
		return new Object[][] { { true, "SK 7543", "PN2023072100004", "Đã tồn tại số khung" }, // Số khung đã có ,trung
																								// phiếu nhập
				{ true, "SK8054", "PN2023072100004", "Đã tồn tại số khung" }, // số khung đã có, phiếu nhập khác
				{ true, "SK3949", "PN2023120500003", "Đã tồn tại số khung" }, // số khung đã có, phiếu nhập mới nhất
				{ true, "SK7122", "PN2023120500004", "Đã thêm xe vào phiếu nhập" }, // số khung mới, phiếu nhập mới
																						// nhất
				{ true, "SK7123", "PN2023072100002", "Đã thêm xe vào phiếu nhập" }, // số khung mới, phiếu nhập cũ
				{ false, "SK7143", "PN2023072100004", "Dữ liệu chưa hợp lệ" } };
	}

	@Test(dataProvider = "dataSuaPhieuNhap")
	public void suaPhieuNhapTest(String maPhieuNhap, String maNhanVien, Date ngayNhap,

			Date ngaySua, String nguoiSua, String dienGiai,

			int idChiTietPhieuNhap, String maNhanVienKD, String maKhachHang,

			String maPhieuXuat, String maViTri,

			String maLoaiXe, String soKhung, String soMay,

			int soLuongNhap, int giaNhap, int giaXuat, int soLuongXuat, int chkXuatKho,

			String maNhanVienXuat, Date ngayXuat,

			String nguoiSuaPX, Date ngaySuaPX, boolean checkExistSoKhung, String expected) {
		// PhieuNhap pn = this.getFormPN("sua");
		PhieuNhap pn = new PhieuNhap(maPhieuNhap, maNhanVien, ngayNhap, ngaySua, nguoiSua, dienGiai);
		// NhapKho_Form nkf = new NhapKho_Form();
		String actual = "";
		if (pn != null) {
			// ChiTietPhieuNhap ct = nkf.getFormChiTietPhieuNhap("sua");
			ChiTietPhieuNhap ct = new ChiTietPhieuNhap(idChiTietPhieuNhap, maNhanVienKD, maKhachHang,
					pn.getMaPhieuNhap(), maPhieuXuat, maViTri, maLoaiXe, soKhung, soMay, soLuongNhap, giaNhap, giaXuat,
					soLuongXuat, chkXuatKho, pn.getMaNhanVien(), ngayNhap, pn.getNguoiSua(), pn.getNgaySua(),
					maNhanVienXuat, ngayXuat, nguoiSuaPX, ngaySuaPX);
			if (ct != null && checkExistSoKhung) {
				PhieuNhapDAO.getNewPhieuNhapDAO().update(pn);
				ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().update(ct);

				actual = "Sửa thành công";
				Assert.assertEquals(actual, expected);
			}
		}

		Assert.assertTrue(true);
	}

	@DataProvider
	private Object[][] dataSuaPhieuNhap() {
		return new Object[][] {

				{ "PN2023120500007", "NV2023073000009", new Date(), new Date(), "NV2023081700016", "sua PN", 14, null,
						null, null, "VT03", "FCJLTC", "SK3399", "SM6771", 1, 700, 0, 0, 0, null, null, null, null,
						false, "" },

				{ "PN2023120500007", "NV2023073000009", new Date(), new Date(), "NV2023081700016", "sua PN", 14, null,
						null, null, "VT03", "FCJLTC", "SK3949", "SM7171", 1, 700, 0, 0, 0, null, null, null, null, true,
						"Sửa thành công" },

		};

	}

	@Test(dataProvider = "datathemPhieuNhap")
	public void themPhieuNhapTest(String maPhieuNhap, String maNhanVien, Date ngayNhap, Date ngaySua, String nguoiSua,
			String dienGiai, int idChiTietPhieuNhap, String maNhanVienKD, String maKhachHang, String maPhieuXuat,
			String maViTri, String maLoaiXe, String soKhung, String soMay, int soLuongNhap, int giaNhap, int giaXuat,
			int soLuongXuat, int chkXuatKho, String maNhanVienXuat, Date ngayXuat, String nguoiSuaPX, Date ngaySuaPX,
			boolean checkExistSoKhung, String expected) {
		// PhieuNhap pn = this.getFormPN("them");
		NhapKho_Form nkf = new NhapKho_Form();
		PhieuNhap pn = new PhieuNhap(maPhieuNhap, maNhanVien, ngayNhap, ngaySua, nguoiSua, dienGiai);

		String actual = "";
		if (pn != null) {
			// ChiTietPhieuNhap ct = nkf.getFormChiTietPhieuNhap("them");
			ChiTietPhieuNhap ct = new ChiTietPhieuNhap(idChiTietPhieuNhap, maNhanVienKD, maKhachHang,
					pn.getMaPhieuNhap(), maPhieuXuat, maViTri, maLoaiXe, soKhung, soMay, soLuongNhap, giaNhap, giaXuat,
					soLuongXuat, chkXuatKho, pn.getMaNhanVien(), ngayNhap, pn.getNguoiSua(), pn.getNgaySua(),
					maNhanVienXuat, ngayXuat, nguoiSuaPX, ngaySuaPX);
			if (ct != null && checkExistSoKhung) {
				if (!nkf.isExist_PhieuNhap(pn.getMaPhieuNhap())) {
					PhieuNhapDAO.getNewPhieuNhapDAO().insert(pn);
					ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().insert(ct);
					actual = "Thêm mới thành công";
				} else {

					actual = "Đã thêm xe vào phiếu nhập";
				}
			}
		}
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	private Object[][] datathemPhieuNhap() {
		return new Object[][] {

				{ "PN2023120500007", "NV2023073000009", new Date(), null, null, "dienGiai", 14, null, null, null,
						"VT03", "FCJLTC", "SK5051", "SM7375", 1, 700, 0, 0, 0, null, null, null, null, true,
						"Thêm mới thành công" },//thêm thành công
				{ "PN2023072100003", "NV2023073000009", new Date(), null, null, "dienGiai", 15, null, null, null,
						"VT03", "FCJLTC", "SK8054", "SM7979", 1, 700, 0, 0, 0, null, null, null, null, true,
						"Đã thêm xe vào phiếu nhập" },//phiếu nhập cũ số khung mới		
		
		};
	}

	@Test(dataProvider = "dataXoa")
	public void xoaTest(Boolean isManager, String maPN, String sk, String sm, double gia, boolean confirm,
			String expected) {
		String actual = "";
		if (isManager) {
			actual = "Bạn không có quyền xóa phiếu nhập";
			return;
		}
		List<ChiTietPhieuNhap> listPN = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_MaPhieuNhap(maPN);
		if (listPN != null) {
			if (confirm) {
				try {

//					for (ChiTietPhieuNhap ct : listPN) {
//						ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().delete(ct.getIdChiTietPhieuNhap() + "");
//					}
//
//					PhieuNhapDAO.getNewPhieuNhapDAO().delete(maPN);

					actual = "Xóa thành công";
				} catch (Exception e) {
					actual = "Có lỗi. Vui lòng kiểm tra lại thông tin!";
				}
			} else {
				actual = "Bạn không xác nhận xóa";
			}
		} else {
			actual = "Thông báo phiếu nhập chưa có trong cơ sở dữ liệu. Vui lòng chọn phiếu nhập khác";
		}
		Assert.assertEquals(actual, expected);
	}

	@DataProvider
	private Object[][] dataXoa() {
		return new Object[][] {
				{ false, "PN2023120600006", null, null, 0.0, true,
						"Thông báo phiếu nhập chưa có trong cơ sở dữ liệu. Vui lòng chọn phiếu nhập khác" },
				{ false, "PN2023081700007", "SK 1234", "SM 112", 900, false, "Bạn không xác nhận xóa" },
				{ true, "PN2023072100005", "SK 1091", "SM 4523", 900, true, "Bạn không có quyền xóa phiếu nhập" },
				{ false, "PN2023072100003", "SK8054", "SM7979", 700, true, "Xóa thành công" }, };
	}

}
