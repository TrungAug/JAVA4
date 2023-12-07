package com.ttt.TEST;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ttt.DAO.ChiTietPhieuNhapDAO;
import com.ttt.DAO.PhieuXuatDAO;
import com.ttt.Entity.ChiTietPhieuNhap;
import com.ttt.Entity.PhieuXuat;
import com.ttt.LibaryHelper.Auth;
import com.ttt.LibaryHelper.DialogHelper;
import com.ttt.form.XuatKho_Form;

public class TestPhieuXuat {

	 

	@Test(dataProvider = "checkNullDataProvider")
	public void checkNullTest(String txtSoKhung, String txtPXK, String txtgiaXuat, String expected) {
		double giaNhap;
		
		String actualy = "";
		try {
			double giaXuat = Double.parseDouble(txtgiaXuat);
			
			if (txtSoKhung.equalsIgnoreCase("") || txtSoKhung == null) {
				actualy = "Vui lòng chọn số khung";
			} else if (giaXuat < 0) {
				actualy = "Không được nhập âm giá xuất";

			}
		} catch (Exception e) {
			if (txtgiaXuat == null || txtgiaXuat.equalsIgnoreCase("")) {
				actualy = "Vui lòng nhập giá xuất";

			} else {
				actualy = "Giá nhập sai kiểu dữ liệu";

			}
		}

		Assert.assertEquals(actualy, expected);

	}

	@DataProvider
	private Object[][] checkNullDataProvider() {
		return new Object[][] { { "", "PXK001", "126", "Vui lòng chọn số khung" }, // Rỗng Số khung
				{ "PX001", "PXK001", "-124", "Không được nhập âm giá xuất" }, // số âm
				{ "PX001", "PXK001", null, "Vui lòng nhập giá xuất" }, // null giá xuất
				{ "PX001", "PXK001", "phieuXuat", "Giá nhập sai kiểu dữ liệu" },// sai định dạng giá xuất
		};

	}

// test làm mới form-----------------------------------------------------------------------------------------
	@Test(dataProvider = "lamMoiTestProvider")
	public void lamMoiTest(String txtPXK, String txtDienGiai, String txtGiaXuat, String txtsoKhung, String expected) {
		String actualy = "";
		if (txtPXK.isEmpty() && txtDienGiai.isEmpty() && txtGiaXuat.isEmpty() && txtPXK.isEmpty() && txtsoKhung.isEmpty()) {
			actualy = "Làm mới thành công";

		} else  {
			actualy = "Làm mới không thành công";

		}

		Assert.assertEquals(actualy, expected);

	}

	@DataProvider
	private Object[][] lamMoiTestProvider() {
		return new Object[][] { { "", "", "", "", "Làm mới thành công" },
				{ "PXK123", "", "", "", "Làm mới không thành công" },
				{ "", "abcxyz", "", "", "Làm mới không thành công" },
				{ "", "", "1235", "", "Làm mới không thành công" },
				{ "", "", "", "soKhung", "Làm mới không thành công" }

		};

	}

	// -----------------------------------------------------------------

	@Test(dataProvider = "themPXKProvider")
	public void themVaoPhieuXuatTest(String txtSoKhung, String txtPXK, String txtgiaXuat, String expected) {

		double giaNhap = 1000;
		
		String actualy = "";
		try {
			double giaXuat = Double.parseDouble(txtgiaXuat);
			
			if (txtSoKhung.equalsIgnoreCase("") || txtSoKhung == null) {
				actualy = "Vui lòng chọn số khung";
			} else if (giaXuat < 0) {
				actualy = "Không được nhập âm giá xuất";

			} else if (txtPXK.equals("PXK001")) {

				actualy = "Phiếu xuất đã tồn tại";
			} else if (txtPXK.equalsIgnoreCase("") || txtPXK==null) {
				actualy = "Vui lòng chọn phiếu xuất kho";
			} else if (giaXuat < giaNhap) {
				actualy = "Giá xuất nhỏ hơn giá nhập, xuất xe lỗ";

			} else {
				actualy = "Thêm mới thành công";

			}
		} catch (Exception e) {
			if (txtgiaXuat == null || txtgiaXuat.equalsIgnoreCase("")) {
				actualy = "Vui lòng nhập giá xuất";

			} else {
				actualy = "Giá xuất sai kiểu dữ liệu";

			}
		}

		Assert.assertEquals(actualy, expected);

	}

	@DataProvider
	private Object[][] themPXKProvider() {
		return new Object[][] { { "", "PXK001", "1261.12", "Vui lòng chọn số khung" },
				{ "PX001", "PXK001", "-124", "Không được nhập âm giá xuất" },
				{ "XK123", "PXK001", "1231", "Phiếu xuất đã tồn tại" },  
				{ "XK123", "PKX004", "900", "Giá xuất nhỏ hơn giá nhập, xuất xe lỗ" },
				{ "PX001", "PXK001", null, "Vui lòng nhập giá xuất" },
				{ "PX001", "PXK001", "phieuXuat", "Giá xuất sai kiểu dữ liệu" },
				{"PX001","","12121","Vui lòng chọn phiếu xuất kho"},
				{ "PX001", "PXK123", "1234", "Thêm mới thành công" }

		};
	}
	// ------------------------

	// --------------------------------------------------

	// sửa PXK
	@Test(dataProvider = "suaPXKProvider")
	public void suaPhieuXuat(String txtSoKhung, String txtPXK, String txtgiaXuat, String expected) {
		String PXK_Da_Xuat = "PX2023081000006";
		double giaNhap = 1000;
		
		String actualy = "";
		try {
			double giaXuat = Double.parseDouble(txtgiaXuat);
			if (txtSoKhung.equalsIgnoreCase("") || txtSoKhung == null) {
				actualy = "Vui lòng chọn số khung";
			}else if(txtPXK.equalsIgnoreCase("") || txtPXK==null) {
				
				actualy = "Vui lòng chọn phiếu xuất kho";
			} else if (giaXuat < 0) {
				actualy = "Không được nhập âm giá xuất";

			}   else if (giaXuat < giaNhap) {
				actualy = "Giá xuất nhỏ hơn giá nhập, xuất xe lỗ";

			} else if (txtPXK.equalsIgnoreCase(PXK_Da_Xuat)) {
				actualy = "Đã xuất xe rồi";
			} else {
				actualy = "Sửa thành công";

			}
		} catch (Exception e) {
			if (txtgiaXuat == null || txtgiaXuat.equalsIgnoreCase("")) {
				actualy = "Vui lòng nhập giá xuất";

			} else {
				actualy = "Giá nhập sai kiểu dữ liệu";

			}
		}

		Assert.assertEquals(actualy, expected);

	}

	@DataProvider
	private Object[][] suaPXKProvider() {
		return new Object[][] { { "", "PXK001", "1212", "Vui lòng chọn số khung" },
				{ "PX001", "PXK001", "-124", "Không được nhập âm giá xuất" },
				{ "XK123", "PX2023081000006", "12333", "Đã xuất xe rồi" }, 
				{"XK123","","1111","Vui lòng chọn phiếu xuất kho"},
				{ "XK123", "PKX004", "900", "Giá xuất nhỏ hơn giá nhập, xuất xe lỗ" },
				{ "PX001", "PXK001", "", "Vui lòng nhập giá xuất" },
				{ "PX001", "PXK001", "phieuXuat", "Giá nhập sai kiểu dữ liệu" },
				{ "PX001", "PXK123", "1234", "Sửa thành công" }

		};
	}

	// Xóa PXK

	@Test (dataProvider =  "xoaPXKProvider")
	public void xoaPhieuXuat(boolean isManager,String txtSoKhung, String txtPXK, String txtgiaXuat, boolean confirm,String expected ) 
	{
 

String actual = "";
if (isManager) {
actual = "Bạn không có quyền xóa phiếu nhập";
return;
}
List<ChiTietPhieuNhap> listPX = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_MaPhieuNhap(txtPXK);
String actualy="";
if (listPX != null) {
if (confirm) {
		  
		  try {
//              List<ChiTietPhieuNhap> listPX = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_MaPhieuNhap(txtPXK.getText());
//              for (ChiTietPhieuNhap ct : listPX) {
//                  ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().delete(ct.getIdChiTietPhieuNhap() + "");
//                  // System.out.println(ct.getIdChiTietPhieuNhap());
//              }
//              PhieuXuatDAO.getNewPhieuXuatDAO().delete(txtPXK);
//             
              actualy="Xóa thành công";  
		  }catch (Exception e) {
			  actual = "Có lỗi. Vui lòng kiểm tra lại thông tin!";
		  }
		  } else {
		  actual = "Bạn không xác nhận xóa";
		  }
		  } else {
		  actual = "Thông báo phiếu xuất chưa có trong cơ sở dữ liệu. Vui lòng chọn phiếu xuất khác";
		  }
          
			 

				Assert.assertEquals(actualy, expected);

		 
		}

	@DataProvider
	private Object[][] xoaPXKProvider() {
		return new Object[][] {
			{false,"PX001","PN2023072100001","123",true,"Thông báo phiếu nhập chưa có trong cơ sở dữ liệu. Vui lòng chọn phiếu nhập khác nhập"},
			{false,"PX001","PN2023072100001","123",false,"Bạn không xác nhận xóa"},
			{true,"PX2023072200001","PX001","123",true,"Bạn không có quyền xóa phiếu nhập"},
			{false,"PXK001","PX001","123",true,"Xóa thành công" } };
	 
			
			
		}
	}

 																																													// cũ
																																															// số
		 
 
 