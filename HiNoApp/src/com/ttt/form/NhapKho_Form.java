package com.ttt.form;

import com.ttt.DAO.ChiTietPhieuNhapDAO;
import com.ttt.DAO.LoaiXeDAO;
import com.ttt.DAO.NhanVienDAO;
import com.ttt.DAO.PhieuNhapDAO;
import com.ttt.DAO.ThongKeDAO;
import com.ttt.DAO.ViTriDAO;
import com.ttt.Entity.ChiTietPhieuNhap;
import com.ttt.Entity.LoaiXe;
import com.ttt.Entity.NhanVien;
import com.ttt.Entity.PhieuNhap;
import com.ttt.Entity.ViTri;
import com.ttt.LibaryHelper.Auth;
import com.ttt.LibaryHelper.DateHelper;
import com.ttt.LibaryHelper.DialogHelper;
import com.ttt.LibaryHelper.Search;
import com.ttt.component.Form;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class NhapKho_Form extends Form {

	DefaultTableModel model;
	int row = -1;
	public static NhapKho_Form getIstance;
	public static JButton btn;
	public static JTextField txt;
	public static JTextField txtDG;

	public NhapKho_Form() {
		initComponents();
		init();
		getIstance = this;
		btn = btnPlus;
		txt = txtPNK;
		txtDG = txtDienGiai;
	}

	void init() {
		this.initTable();
		this.fillTable();
		this.fillcboViTri();
		this.fillcboLoaiXe();
		// txtPNK.setText(ThongKeDAO.getNewThongKeDAO().getMaPhieuNhapKho());
		tblChiTiet.fixTable(jScrollPane2);
		layMaMoi();
		txtSoLuong.setText("1");
		if (Auth.user != null) {
			txtMaNV.setText(Auth.user.getMaNV());
			txtTenNV.setText(Auth.user.getHoTen());
		}
	}

	public void initTable() {
		model = (DefaultTableModel) tblChiTiet.getModel();
		model.setColumnIdentifiers(new String[] { "id", "Mã PN", "Vị trí", "Loại xe", "S.Khung", "S.Máy", "S.Lượng",
				"Giá nhập", "Người nhập", "Ngày nhập", "Người sửa", "Ngày sửa" });
	}

	void fillTable() {
		model = (DefaultTableModel) tblChiTiet.getModel();
		model.setRowCount(0);
		try {
			List<ChiTietPhieuNhap> list = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_chuaXuatKho();
			for (ChiTietPhieuNhap c : list) {
				Object[] rows = { c.getIdChiTietPhieuNhap(), c.getMaPhieuNhap(), c.getMaViTri(), c.getMaLoaiXe(),
						c.getSoKhung(), c.getSoMay(), c.getSoLuongNhap(), c.getGiaNhap(), c.getMaNhanVienNhap(),
						DateHelper.toStringFormat(c.getNgayNhap(), "dd-MM-yyyy"), c.getNguoiSuaPN(),
						DateHelper.toStringFormat(c.getNgaySuaPN(), "dd-MM-yyyy") };
				model.addRow(rows);
			}
		} catch (Exception e) {
			DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
		}
	}

	void fillTableByKeyword() {
		DefaultTableModel model = (DefaultTableModel) tblChiTiet.getModel();
		model.setRowCount(0);
		try {
			String keyword = txtTim.getText();
			List<ChiTietPhieuNhap> list = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectByKeyword(keyword);
			for (ChiTietPhieuNhap c : list) {
				Object[] rows = { c.getIdChiTietPhieuNhap(), c.getMaPhieuNhap(), c.getMaViTri(), c.getMaLoaiXe(),
						c.getSoKhung(), c.getSoMay(), c.getSoLuongNhap(), c.getGiaNhap(), c.getMaNhanVienNhap(),
						DateHelper.toStringFormat(c.getNgayNhap(), "dd-MM-yyyy"), c.getNguoiSuaPN(),
						DateHelper.toStringFormat(c.getNgaySuaPN(), "dd-MM-yyyy") };
				model.addRow(rows);
			}
		} catch (Exception e) {
			DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
		}
	}

	void fillcboViTri() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) cboViTri.getModel();
		model.removeAllElements();
		List<ViTri> list = ViTriDAO.getNewViTriDAO().selectAll();
		for (ViTri cd : list) {
			model.addElement(cd);
		}
	}

	void fillcboLoaiXe() {
		DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoaiXe.getModel();
		model.removeAllElements();
		List<LoaiXe> list = LoaiXeDAO.getNewLoaiXeDAO().selectAll();
		for (LoaiXe cd : list) {
			model.addElement(cd);
		}
	}

	void layMaMoi() {
		txtPNK.setText(ThongKeDAO.getNewThongKeDAO().getMaPhieuNhapKho());
	}

	void edit() {
		int idCT = (int) tblChiTiet.getValueAt(this.row, 0);
		ChiTietPhieuNhap ct = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectById(idCT + "");
		this.setForm(ct);
	}

	public boolean checkExistSoKhung() {
		String soKhung = txtSoKhung.getText();
		String maPN = txtPNK.getText();
		boolean flagCheckExistEmail = true;
		if (!maPN.equalsIgnoreCase(ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().getMaPNBySoKhung(soKhung))) {
			List<ChiTietPhieuNhap> listNH = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_chuaXuatKho();
			for (ChiTietPhieuNhap nh : listNH) {
				if (nh.getSoKhung().equalsIgnoreCase(soKhung)) {
					DialogHelper.alert(this, "Đã tồn tại số khung " + soKhung);
					flagCheckExistEmail = false;
					break;
				}
			}
		}
		return flagCheckExistEmail;
	}

	public boolean isExist_PhieuNhap(String maPN) {
		List<PhieuNhap> list = PhieuNhapDAO.getNewPhieuNhapDAO().selectAll();
		for (PhieuNhap cd : list) {
			if (cd.getMaPhieuNhap().equals(maPN)) {
				return true;
			}

		}
		return false;
	}

	boolean checkNull() {
		double giaNhap;
		try {
			giaNhap = Double.parseDouble(txtGiaNhap.getText());
			if (txtSoKhung.getText() == null || txtSoKhung.getText().equalsIgnoreCase("")) {
				DialogHelper.alert(this, "Vui lòng nhập số khung");
				return false;
			} else if (txtSoMay.getText() == null || txtSoMay.getText().equalsIgnoreCase("")) {
				DialogHelper.alert(this, "Vui lòng nhập số máy");
				return false;
			} else if (giaNhap < 0) {
				DialogHelper.alert(this, "Không được nhập âm giá");
				return false;
			}
		} catch (NumberFormatException e) {
			if (txtGiaNhap.getText() == null || txtGiaNhap.getText().equalsIgnoreCase("") && txtSoMay.getText() == null
					|| txtSoMay.getText().equalsIgnoreCase("") && txtSoKhung.getText() == null
					|| txtSoKhung.getText().equalsIgnoreCase("")) {
				DialogHelper.alert(this, "Vui lòng nhập dữ liệu");
				return false;
			} else {
				DialogHelper.alert(this, "Giá nhập sai kiểu dữ liệu");
				return false;
			}

		}

		return true;
	}

	void setForm(ChiTietPhieuNhap ct) {
		txtPNK.setText(ct.getMaPhieuNhap());
		ViTri vt = ViTriDAO.getNewViTriDAO().selectById(ct.getMaViTri());
		cboViTri.setSelectedItem(vt);
		LoaiXe lx = LoaiXeDAO.getNewLoaiXeDAO().selectById(ct.getMaLoaiXe());
		cboLoaiXe.setSelectedItem(lx);
		txtMaNV.setText(ct.getMaNhanVienNhap());
		NhanVien nv = NhanVienDAO.getNewNhanVienDAO().selectById(ct.getMaNhanVienNhap());
		txtTenNV.setText(nv.getHoTen());
		PhieuNhap pn = PhieuNhapDAO.getNewPhieuNhapDAO().selectById(ct.getMaPhieuNhap());
		txtDienGiai.setText(pn.getDienGiai());
		txtSoKhung.setText(ct.getSoKhung());
		txtSoMay.setText(ct.getSoMay());
		txtSoLuong.setText(ct.getSoLuongNhap() + "");
		txtGiaNhap.setText(ct.getGiaNhap() + "");
	}

	PhieuNhap getFormPN(String dieuKien) {
		if (checkNull()) {
			PhieuNhap pn = new PhieuNhap();
			if (dieuKien.equals("them")) {
				pn.setMaPhieuNhap(txtPNK.getText());
				pn.setMaNhanVien(txtMaNV.getText());
				pn.setNgayNhap(new Date());
				pn.setNgaySua(null);
				pn.setNguoiSua(null);
				pn.setDienGiai(txtDienGiai.getText());

			} else if (dieuKien.equals("sua")) {
				PhieuNhap pnc = PhieuNhapDAO.getNewPhieuNhapDAO().selectById(txtPNK.getText());
				pn.setMaPhieuNhap(txtPNK.getText());
				pn.setMaNhanVien(pnc.getMaNhanVien());
				pn.setNgayNhap(pnc.getNgayNhap());
				pn.setNgaySua(new Date());
				pn.setNguoiSua(txtMaNV.getText());
				pn.setDienGiai(txtDienGiai.getText());
			}
			return pn;
		}
		return null;
	}

	public ChiTietPhieuNhap getFormChiTietPhieuNhap(String dieuKien) {
		if (checkNull()) {
			ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
			if (dieuKien.equals("them")) {
				PhieuNhap pn = this.getFormPN("them");
				ct.setMaNhanVienKD(null);
				ct.setMaPhieuNhap(pn.getMaPhieuNhap());
				ct.setMaPhieuXuat(null);
				ViTri vt = (ViTri) cboViTri.getSelectedItem();
				ct.setMaViTri(vt.getMaViTri());
				LoaiXe lx = (LoaiXe) cboLoaiXe.getSelectedItem();
				ct.setMaLoaiXe(lx.getMaLoaiXe());
				ct.setSoKhung(txtSoKhung.getText());
				ct.setSoMay(txtSoMay.getText());
				ct.setSoLuongNhap(Integer.parseInt(txtSoLuong.getText()));
				ct.setGiaNhap(Double.parseDouble(txtGiaNhap.getText()));
				ct.setGiaXuat(0);
				ct.setSoLuongXuat(0);
				ct.setChkXuatKho(0);
				ct.setMaNhanVienNhap(txtMaNV.getText());
				ct.setNgayNhap(new Date());
				ct.setNgaySuaPN(null);
				ct.setNguoiSuaPN(null);
				ct.setMaNhanVienXuat(null);
				ct.setNgayXuat(null);
				ct.setNgaySuaPX(null);
				ct.setNguoiSuaPX(null);
			} else if (dieuKien.equals("sua")) {
				int idCT = (int) tblChiTiet.getValueAt(this.row, 0);
				ChiTietPhieuNhap ctc = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectById(idCT + "");
				PhieuNhap pn = this.getFormPN("sua");
				ct.setIdChiTietPhieuNhap(idCT);
				ct.setMaNhanVienKD(null);
				ct.setMaPhieuNhap(pn.getMaPhieuNhap());
				ct.setMaPhieuXuat(null);
				ViTri vt = (ViTri) cboViTri.getSelectedItem();
				ct.setMaViTri(vt.getMaViTri());
				LoaiXe lx = (LoaiXe) cboLoaiXe.getSelectedItem();
				ct.setMaLoaiXe(lx.getMaLoaiXe());
				ct.setSoKhung(txtSoKhung.getText());
				ct.setSoMay(txtSoMay.getText());
				ct.setSoLuongNhap(Integer.parseInt(txtSoLuong.getText()));
				ct.setGiaNhap(Double.parseDouble(txtGiaNhap.getText()));
				ct.setGiaXuat(0);
				ct.setSoLuongXuat(0);
				ct.setChkXuatKho(0);
				ct.setMaNhanVienNhap(ctc.getMaNhanVienNhap());
				ct.setNgayNhap(ctc.getNgayNhap());
				ct.setNgaySuaPN(new Date());
				ct.setNguoiSuaPN(txtMaNV.getText());
				ct.setMaNhanVienXuat(null);
				ct.setNgayXuat(null);
				ct.setNgaySuaPX(null);
				ct.setNguoiSuaPX(null);
			}

			return ct;
		}
		return null;
	}

	void lamMoi() {
		layMaMoi();
		txtDienGiai.setText("");
		txtSoKhung.setText("");
		txtSoMay.setText("");
		txtGiaNhap.setText("");
		txtTim.setText("Nhập tìm kiếm");
		this.fillTable();
	}

	void themXeVaoPhieuNhap() {
		ChiTietPhieuNhap ct = this.getFormChiTietPhieuNhap("them");
		if (ct != null) {
			String check_ct = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().getMaPNBySoKhung(ct.getSoKhung());
			if (ct.getMaPhieuNhap().equals(check_ct)) {
				DialogHelper.alert(this, "Đã tồn tại số khung");
			} else {
				ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().insert(ct);
				txtSoKhung.setText("");
				txtSoMay.setText("");
				txtGiaNhap.setText("");
				this.fillTable();
				DialogHelper.alert(this, "Đã thêm xe vào phiếu nhập");
			}

		}

	}

	void themPhieuNhap() {
		PhieuNhap pn = this.getFormPN("them");
		if (pn != null) {
			ChiTietPhieuNhap ct = this.getFormChiTietPhieuNhap("them");
			if (ct != null && checkExistSoKhung()) {
				if (!isExist_PhieuNhap(pn.getMaPhieuNhap())) {
					// Chưa tồn tại phiếu nhập trong dtb
					// 1. Thêm phiếu nhập vào dtb
					PhieuNhapDAO.getNewPhieuNhapDAO().insert(pn);
					// 2. Thêm Vào chi tiết phiếu nhập
					ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().insert(ct);
					this.fillTable();
					txtSoKhung.setText("");
					txtSoMay.setText("");
					txtGiaNhap.setText("");
					DialogHelper.alert(this, "Thêm mới thành công");
				} else {
					themXeVaoPhieuNhap();
					// this.fillTable();
				}
			}
		}

	}

	void suaPhieuNhap() {
		PhieuNhap pn = this.getFormPN("sua");
		if (pn != null) {
			ChiTietPhieuNhap ct = this.getFormChiTietPhieuNhap("sua");
			if (ct != null && checkExistSoKhung()) {
				PhieuNhapDAO.getNewPhieuNhapDAO().update(pn);
				ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().update(ct);
				this.fillTable();
				// System.out.println(ct.totoString());
				DialogHelper.alert(this, "Sửa thành công");
			}
		}

	}

	void xoa() {
		if (!Auth.isManager()) {
			DialogHelper.alert(this, "Bạn không có quyền xóa phiếu nhập");
			return;
		}
		List<ChiTietPhieuNhap> listPN = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO()
				.selectAll_MaPhieuNhap(txtPNK.getText());
		if (listPN != null) {
			if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa phiếu nhập ")) {
				try {
					// List<ChiTietPhieuNhap> listPN =
					// ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_MaPhieuNhap(txtPNK.getText());

					for (ChiTietPhieuNhap ct : listPN) {
						ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().delete(ct.getIdChiTietPhieuNhap() + "");
					}

					PhieuNhapDAO.getNewPhieuNhapDAO().delete(txtPNK.getText());
					this.fillTable();
					this.lamMoi();
					DialogHelper.alert(this, "Xóa thành công");
				} catch (Exception e) {
					DialogHelper.alert(this, "Có lỗi. Vui lòng kiểm tra lại thông tin!");
				}
			}
		} else {
			DialogHelper.alert(this,
					"Phiếu nhập " + txtPNK.getText() + " chưa có trong cơ sở dữ liệu. Vui lòng chọn phiếu nhập khác!");
		}

	}

	void timKiem() {
		String key = txtTim.getText();
		if (key.contains("*") || key.contains("(") || key.contains(")") || key.contains("[") || key.contains("]")) {
			return;
		}
		Search.search(tblChiTiet, key);
	}

	void first() {
		this.row = 0;
		this.edit();
		tblChiTiet.setRowSelectionInterval(this.row, this.row);
	}

	void next() {

		if (this.row < tblChiTiet.getRowCount() - 1) {
			this.row++;
			this.edit();

		} else {
			first();

		}
		tblChiTiet.setRowSelectionInterval(this.row, this.row);

	}

	void prev() {
		if (this.row > 0) {
			this.row--;
			this.edit();

		} else {
			last();

		}
		tblChiTiet.setRowSelectionInterval(this.row, this.row);

	}

	void last() {
		this.row = tblChiTiet.getRowCount() - 1;
		this.edit();
		tblChiTiet.setRowSelectionInterval(this.row, this.row);

	}

	void export_excel() {
		try {
			JFileChooser jfileChooser = new JFileChooser();
			jfileChooser.showSaveDialog(this);
			File saveFile = jfileChooser.getSelectedFile();
			if (saveFile != null) {
				saveFile = new File(saveFile.toString() + ".xlsx");
				XSSFWorkbook wb = new XSSFWorkbook();
				XSSFSheet sheet = wb.createSheet("NhapKho");
				XSSFRow row = null;
				Cell cell = null;
				row = sheet.createRow(1);
				cell = row.createCell(0, CellType.NUMERIC);
				cell.setCellValue("id");
				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue("MaPN");
				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue("ViTri");
				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue("LoaiXe");
				cell = row.createCell(4, CellType.STRING);
				cell.setCellValue("SoKhung");
				cell = row.createCell(5, CellType.STRING);
				cell.setCellValue("SoMay");
				cell = row.createCell(6, CellType.NUMERIC);
				cell.setCellValue("SoLuong");
				cell = row.createCell(7, CellType.NUMERIC);
				cell.setCellValue("GiaNhap");
				cell = row.createCell(8, CellType.STRING);
				cell.setCellValue("NguoiNhap");
				cell = row.createCell(9, CellType.STRING);
				cell.setCellValue("NgayNhap");
				cell = row.createCell(10, CellType.STRING);
				cell.setCellValue("NguoiSua");
				cell = row.createCell(11, CellType.STRING);
				cell.setCellValue("NgaySua");
				List<ChiTietPhieuNhap> arr = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_chuaXuatKho();
				for (int i = 0; i < arr.size(); i++) {
					// LoaiXe cn = arr.get(i);
					row = sheet.createRow(2 + i);

					cell = row.createCell(0, CellType.NUMERIC);
					cell.setCellValue(arr.get(i).getIdChiTietPhieuNhap());

					cell = row.createCell(1, CellType.STRING);
					cell.setCellValue(arr.get(i).getMaPhieuNhap());

					cell = row.createCell(2, CellType.STRING);
					cell.setCellValue(arr.get(i).getMaViTri());

					cell = row.createCell(3, CellType.STRING);
					cell.setCellValue(arr.get(i).getMaLoaiXe());

					cell = row.createCell(4, CellType.STRING);
					cell.setCellValue(arr.get(i).getSoKhung());

					cell = row.createCell(5, CellType.STRING);
					cell.setCellValue(arr.get(i).getSoMay());

					cell = row.createCell(6, CellType.STRING);
					cell.setCellValue(arr.get(i).getSoLuongNhap());

					cell = row.createCell(7, CellType.STRING);
					cell.setCellValue(arr.get(i).getGiaNhap());

					cell = row.createCell(8, CellType.STRING);
					cell.setCellValue(arr.get(i).getMaNhanVienNhap());

					cell = row.createCell(9, CellType.STRING);
					cell.setCellValue(arr.get(i).getNgayNhap());

					cell = row.createCell(10, CellType.STRING);
					cell.setCellValue(arr.get(i).getNguoiSuaPN());

					cell = row.createCell(11, CellType.STRING);
					cell.setCellValue(arr.get(i).getNgaySuaPN());

				}
				try {
					FileOutputStream fos = new FileOutputStream(new File(saveFile.toString()));
					wb.write(fos);
					fos.close();
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				}
				DialogHelper.alert(null, "Xuất file thành công!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		btnGroupChucVu = new javax.swing.ButtonGroup();
		btnGroupGioiTinh = new javax.swing.ButtonGroup();
		btnThemMoi = new com.ttt.swing.Button();
		btnSua = new com.ttt.swing.Button();
		btnXoa = new com.ttt.swing.Button();
		btnFirst = new com.ttt.swing.Button();
		btnPrev = new com.ttt.swing.Button();
		btnNext = new com.ttt.swing.Button();
		btnLast = new com.ttt.swing.Button();
		btnXuatFile = new com.ttt.swing.Button();
		btnLamMoi = new com.ttt.swing.Button();
		panelBackground1 = new com.ttt.swing.PanelBackground();
		lblMaST2 = new javax.swing.JLabel();
		lblMaST1 = new javax.swing.JLabel();
		lblMaST7 = new javax.swing.JLabel();
		lblMaST8 = new javax.swing.JLabel();
		lblMaST6 = new javax.swing.JLabel();
		txtSoKhung = new javax.swing.JTextField();
		jSeparator3 = new javax.swing.JSeparator();
		txtSoMay = new javax.swing.JTextField();
		jSeparator4 = new javax.swing.JSeparator();
		txtSoLuong = new javax.swing.JTextField();
		jSeparator5 = new javax.swing.JSeparator();
		txtGiaNhap = new javax.swing.JTextField();
		jSeparator6 = new javax.swing.JSeparator();
		txtDienGiai = new javax.swing.JTextField();
		jSeparator7 = new javax.swing.JSeparator();
		panelBackground2 = new com.ttt.swing.PanelBackground();
		lblMaST3 = new javax.swing.JLabel();
		btnPlus = new com.ttt.swing.Button();
		cboViTri = new javax.swing.JComboBox<>();
		cboLoaiXe = new javax.swing.JComboBox<>();
		lblMaST5 = new javax.swing.JLabel();
		lblMaST4 = new javax.swing.JLabel();
		lblMaST9 = new javax.swing.JLabel();
		lblMaST10 = new javax.swing.JLabel();
		txtPNK = new javax.swing.JTextField();
		jSeparator8 = new javax.swing.JSeparator();
		txtTenNV = new javax.swing.JTextField();
		jSeparator9 = new javax.swing.JSeparator();
		txtMaNV = new javax.swing.JTextField();
		jSeparator10 = new javax.swing.JSeparator();
		btnRefresh = new javax.swing.JButton();
		txtTim = new javax.swing.JTextField();
		jScrollPane2 = new javax.swing.JScrollPane();
		tblChiTiet = new com.ttt.swing.TableDark();

		setBackground(new java.awt.Color(0, 51, 51));
		setPreferredSize(new java.awt.Dimension(902, 753));
		setLayout(null);

		btnThemMoi.setBackground(new java.awt.Color(0, 51, 51));
		btnThemMoi.setForeground(new java.awt.Color(255, 255, 255));
		btnThemMoi.setText("THÊM");
		btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChucNangActionPerformed(evt);
			}
		});
		add(btnThemMoi);
		btnThemMoi.setBounds(70, 20, 70, 26);

		btnSua.setBackground(new java.awt.Color(0, 51, 51));
		btnSua.setForeground(new java.awt.Color(255, 255, 255));
		btnSua.setText("SỬA");
		btnSua.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChucNangActionPerformed(evt);
			}
		});
		add(btnSua);
		btnSua.setBounds(150, 20, 70, 26);

		btnXoa.setBackground(new java.awt.Color(0, 51, 51));
		btnXoa.setForeground(new java.awt.Color(255, 255, 255));
		btnXoa.setText("XÓA");
		btnXoa.setMaximumSize(new java.awt.Dimension(70, 26));
		btnXoa.setMinimumSize(new java.awt.Dimension(70, 26));
		btnXoa.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChucNangActionPerformed(evt);
			}
		});
		add(btnXoa);
		btnXoa.setBounds(240, 20, 70, 26);

		btnFirst.setBackground(new java.awt.Color(0, 51, 51));
		btnFirst.setForeground(new java.awt.Color(255, 255, 255));
		btnFirst.setText("|<");
		btnFirst.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnControlActionPerformed(evt);
			}
		});
		add(btnFirst);
		btnFirst.setBounds(280, 560, 31, 26);

		btnPrev.setBackground(new java.awt.Color(0, 51, 51));
		btnPrev.setForeground(new java.awt.Color(255, 255, 255));
		btnPrev.setText("<<");
		btnPrev.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnControlActionPerformed(evt);
			}
		});
		add(btnPrev);
		btnPrev.setBounds(330, 560, 36, 26);

		btnNext.setBackground(new java.awt.Color(0, 51, 51));
		btnNext.setForeground(new java.awt.Color(255, 255, 255));
		btnNext.setText(">>");
		btnNext.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnControlActionPerformed(evt);
			}
		});
		add(btnNext);
		btnNext.setBounds(380, 560, 36, 26);

		btnLast.setBackground(new java.awt.Color(0, 51, 51));
		btnLast.setForeground(new java.awt.Color(255, 255, 255));
		btnLast.setText(">|");
		btnLast.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnControlActionPerformed(evt);
			}
		});
		add(btnLast);
		btnLast.setBounds(440, 560, 31, 26);

		btnXuatFile.setBackground(new java.awt.Color(0, 51, 51));
		btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
		btnXuatFile.setText("Xuất file");
		btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChucNangActionPerformed(evt);
			}
		});
		add(btnXuatFile);
		btnXuatFile.setBounds(720, 560, 70, 26);

		btnLamMoi.setBackground(new java.awt.Color(0, 51, 51));
		btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
		btnLamMoi.setText("LÀM MỚI");
		btnLamMoi.setMaximumSize(new java.awt.Dimension(70, 26));
		btnLamMoi.setMinimumSize(new java.awt.Dimension(70, 26));
		btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnChucNangActionPerformed(evt);
			}
		});
		add(btnLamMoi);
		btnLamMoi.setBounds(330, 20, 71, 26);

		panelBackground1.setBackground(new java.awt.Color(0, 51, 51));
		panelBackground1.setLayout(null);

		lblMaST2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaST2.setForeground(new java.awt.Color(255, 0, 51));
		lblMaST2.setText("Số khung");
		panelBackground1.add(lblMaST2);
		lblMaST2.setBounds(6, 34, 58, 18);

		lblMaST1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaST1.setForeground(new java.awt.Color(255, 0, 51));
		lblMaST1.setText("Số máy");
		panelBackground1.add(lblMaST1);
		lblMaST1.setBounds(6, 90, 45, 18);

		lblMaST7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaST7.setForeground(new java.awt.Color(153, 0, 0));
		lblMaST7.setText("Số lượng");
		panelBackground1.add(lblMaST7);
		lblMaST7.setBounds(6, 146, 56, 18);

		lblMaST8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaST8.setForeground(new java.awt.Color(255, 0, 51));
		lblMaST8.setText("Giá nhập");
		panelBackground1.add(lblMaST8);
		lblMaST8.setBounds(6, 202, 55, 18);

		lblMaST6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaST6.setForeground(new java.awt.Color(255, 0, 51));
		lblMaST6.setText("Diễn giải");
		panelBackground1.add(lblMaST6);
		lblMaST6.setBounds(10, 300, 56, 18);

		txtSoKhung.setBackground(new java.awt.Color(0, 51, 51));
		txtSoKhung.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
		txtSoKhung.setForeground(new java.awt.Color(204, 204, 204));
		txtSoKhung.setBorder(null);
		panelBackground1.add(txtSoKhung);
		txtSoKhung.setBounds(90, 20, 250, 30);

		jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
		jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
		panelBackground1.add(jSeparator3);
		jSeparator3.setBounds(90, 50, 250, 10);

		txtSoMay.setBackground(new java.awt.Color(0, 51, 51));
		txtSoMay.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
		txtSoMay.setForeground(new java.awt.Color(204, 204, 204));
		txtSoMay.setBorder(null);
		panelBackground1.add(txtSoMay);
		txtSoMay.setBounds(90, 80, 250, 30);

		jSeparator4.setBackground(new java.awt.Color(0, 51, 51));
		jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
		panelBackground1.add(jSeparator4);
		jSeparator4.setBounds(90, 110, 250, 10);

		txtSoLuong.setEditable(false);
		txtSoLuong.setBackground(new java.awt.Color(0, 51, 51));
		txtSoLuong.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
		txtSoLuong.setForeground(new java.awt.Color(204, 204, 204));
		txtSoLuong.setBorder(null);
		txtSoLuong.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				txtKhongDuocSuaMouseClicked(evt);
			}
		});
		panelBackground1.add(txtSoLuong);
		txtSoLuong.setBounds(90, 130, 250, 30);

		jSeparator5.setBackground(new java.awt.Color(0, 51, 51));
		jSeparator5.setForeground(new java.awt.Color(204, 204, 204));
		panelBackground1.add(jSeparator5);
		jSeparator5.setBounds(90, 160, 250, 10);

		txtGiaNhap.setBackground(new java.awt.Color(0, 51, 51));
		txtGiaNhap.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
		txtGiaNhap.setForeground(new java.awt.Color(204, 204, 204));
		txtGiaNhap.setBorder(null);
		panelBackground1.add(txtGiaNhap);
		txtGiaNhap.setBounds(90, 190, 250, 30);

		jSeparator6.setBackground(new java.awt.Color(0, 51, 51));
		jSeparator6.setForeground(new java.awt.Color(204, 204, 204));
		panelBackground1.add(jSeparator6);
		jSeparator6.setBounds(90, 220, 250, 10);

		txtDienGiai.setBackground(new java.awt.Color(0, 51, 51));
		txtDienGiai.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
		txtDienGiai.setForeground(new java.awt.Color(204, 204, 204));
		txtDienGiai.setBorder(null);
		panelBackground1.add(txtDienGiai);
		txtDienGiai.setBounds(90, 280, 250, 40);

		jSeparator7.setBackground(new java.awt.Color(0, 51, 51));
		jSeparator7.setForeground(new java.awt.Color(204, 204, 204));
		panelBackground1.add(jSeparator7);
		jSeparator7.setBounds(90, 320, 250, 10);

		add(panelBackground1);
		panelBackground1.setBounds(420, 90, 380, 380);

		panelBackground2.setBackground(new java.awt.Color(0, 51, 51));
		panelBackground2.setLayout(null);

		lblMaST3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaST3.setForeground(new java.awt.Color(153, 0, 0));
		lblMaST3.setText("PNK");
		panelBackground2.add(lblMaST3);
		lblMaST3.setBounds(10, 40, 26, 18);

		btnPlus.setBackground(new java.awt.Color(0, 51, 51));
		btnPlus.setForeground(new java.awt.Color(255, 255, 255));
		btnPlus.setText("+");
		btnPlus.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPlusActionPerformed(evt);
			}
		});
		panelBackground2.add(btnPlus);
		btnPlus.setBounds(30, 20, 40, 40);

		cboViTri.setBackground(new java.awt.Color(0, 51, 51));
		cboViTri.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
		cboViTri.setForeground(new java.awt.Color(255, 255, 255));
		cboViTri.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vị Trí 1", "Vị Trí 2", " " }));
		cboViTri.setBorder(null);
		panelBackground2.add(cboViTri);
		cboViTri.setBounds(70, 90, 250, 40);

		cboLoaiXe.setBackground(new java.awt.Color(0, 51, 51));
		cboLoaiXe.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
		cboLoaiXe.setForeground(new java.awt.Color(255, 255, 255));
		cboLoaiXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loai Xe 1", "Loai Xe  2", " " }));
		cboLoaiXe.setBorder(null);
		panelBackground2.add(cboLoaiXe);
		cboLoaiXe.setBounds(70, 150, 250, 40);

		lblMaST5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaST5.setForeground(new java.awt.Color(255, 0, 51));
		lblMaST5.setText("Vị trí");
		panelBackground2.add(lblMaST5);
		lblMaST5.setBounds(10, 100, 46, 18);

		lblMaST4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaST4.setForeground(new java.awt.Color(153, 0, 0));
		lblMaST4.setText("Mã NV");
		panelBackground2.add(lblMaST4);
		lblMaST4.setBounds(10, 280, 42, 18);

		lblMaST9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaST9.setForeground(new java.awt.Color(153, 0, 0));
		lblMaST9.setText("Tên NV");
		panelBackground2.add(lblMaST9);
		lblMaST9.setBounds(10, 220, 46, 18);

		lblMaST10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
		lblMaST10.setForeground(new java.awt.Color(255, 0, 51));
		lblMaST10.setText("Loại xe");
		panelBackground2.add(lblMaST10);
		lblMaST10.setBounds(10, 160, 46, 18);

		txtPNK.setEditable(false);
		txtPNK.setBackground(new java.awt.Color(0, 51, 51));
		txtPNK.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
		txtPNK.setForeground(new java.awt.Color(204, 204, 204));
		txtPNK.setBorder(null);
		txtPNK.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				txtKhongDuocSuaMouseClicked(evt);
			}
		});
		panelBackground2.add(txtPNK);
		txtPNK.setBounds(70, 30, 250, 30);

		jSeparator8.setBackground(new java.awt.Color(0, 51, 51));
		jSeparator8.setForeground(new java.awt.Color(204, 204, 204));
		panelBackground2.add(jSeparator8);
		jSeparator8.setBounds(70, 60, 250, 10);

		txtTenNV.setEditable(false);
		txtTenNV.setBackground(new java.awt.Color(0, 51, 51));
		txtTenNV.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
		txtTenNV.setForeground(new java.awt.Color(204, 204, 204));
		txtTenNV.setBorder(null);
		txtTenNV.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				txtKhongDuocSuaMouseClicked(evt);
			}
		});
		panelBackground2.add(txtTenNV);
		txtTenNV.setBounds(70, 210, 250, 30);

		jSeparator9.setBackground(new java.awt.Color(0, 51, 51));
		jSeparator9.setForeground(new java.awt.Color(204, 204, 204));
		panelBackground2.add(jSeparator9);
		jSeparator9.setBounds(70, 240, 250, 10);

		txtMaNV.setEditable(false);
		txtMaNV.setBackground(new java.awt.Color(0, 51, 51));
		txtMaNV.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
		txtMaNV.setForeground(new java.awt.Color(204, 204, 204));
		txtMaNV.setBorder(null);
		txtMaNV.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				txtKhongDuocSuaMouseClicked(evt);
			}
		});
		panelBackground2.add(txtMaNV);
		txtMaNV.setBounds(70, 270, 250, 30);

		jSeparator10.setBackground(new java.awt.Color(0, 51, 51));
		jSeparator10.setForeground(new java.awt.Color(204, 204, 204));
		panelBackground2.add(jSeparator10);
		jSeparator10.setBounds(70, 300, 250, 10);

		btnRefresh.setBackground(new java.awt.Color(0, 51, 51));
		btnRefresh.setIcon(new javax.swing.ImageIcon(
				"D:\\SUMMER 2023\\Du An 1\\3tProject\\HiNoApp\\src\\com\\ttt\\icon\\Refresh.png")); // NOI18N
		btnRefresh.setBorderPainted(false);
		btnRefresh.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRefreshActionPerformed(evt);
			}
		});
		panelBackground2.add(btnRefresh);
		btnRefresh.setBounds(330, 40, 30, 30);

		add(panelBackground2);
		panelBackground2.setBounds(30, 90, 380, 380);

		txtTim.setBackground(new java.awt.Color(0, 51, 51));
		txtTim.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
		txtTim.setForeground(new java.awt.Color(153, 153, 153));
		txtTim.setHorizontalAlignment(javax.swing.JTextField.LEFT);
		txtTim.setText("Nhập tìm kiếm");
		txtTim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
		txtTim.addFocusListener(new java.awt.event.FocusAdapter() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				txtTimFocusGained(evt);
			}

			public void focusLost(java.awt.event.FocusEvent evt) {
				txtTimFocusLost(evt);
			}
		});
		txtTim.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtTimKeyReleased(evt);
			}
		});
		add(txtTim);
		txtTim.setBounds(30, 550, 240, 40);

		tblChiTiet.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null } },
				new String[] { "Title 1", "Title 2", "Title 3", "Title 4", "null", "null", "null", "null", "null",
						"null", "null", "null" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, false, false, false, false,
					false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tblChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblChiTietMouseClicked(evt);
			}
		});
		jScrollPane2.setViewportView(tblChiTiet);

		add(jScrollPane2);
		jScrollPane2.setBounds(30, 600, 760, 160);
	}// </editor-fold>//GEN-END:initComponents

	private void btnChucNangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnChucNangActionPerformed
		String Option = evt.getActionCommand();
		String them = btnThemMoi.getText();
		String sua = btnSua.getText();
		String xoa = btnXoa.getText();
		String moi = btnLamMoi.getText();
		String export = btnXuatFile.getText();
		if (Option.equals(them)) {
			themPhieuNhap();
		} else if (Option.equals(sua)) {
			suaPhieuNhap();
		} else if (Option.equals(xoa)) {
			xoa();
		} else if (Option.equals(moi)) {
			lamMoi();
		} else if (Option.equals(export)) {
			export_excel();
		}
	}// GEN-LAST:event_btnChucNangActionPerformed

	private void btnPlusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPlusActionPerformed
		new GetPN_Form().setVisible(true);

	}// GEN-LAST:event_btnPlusActionPerformed

	private void btnControlActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnControlActionPerformed
		String Option = evt.getActionCommand();
		String first = btnFirst.getText();
		String prev = btnPrev.getText();
		String next = btnNext.getText();
		String last = btnLast.getText();
		if (Option.equals(first)) {
			first();
		} else if (Option.equals(prev)) {
			prev();
		} else if (Option.equals(next)) {
			next();
		} else if (Option.equals(last)) {
			last();
		}
	}// GEN-LAST:event_btnControlActionPerformed

	private void txtTimFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtTimFocusGained
		if (txtTim.getText().equalsIgnoreCase("Nhập tìm kiếm")) {
			txtTim.setText("");
		}

		txtTim.setForeground(new Color(204, 204, 204));
	}// GEN-LAST:event_txtTimFocusGained

	private void txtTimFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_txtTimFocusLost
		if (txtTim.getText().equalsIgnoreCase("")) {
			txtTim.setText("Nhập tìm kiếm");
		}
		txtTim.setForeground(new Color(153, 153, 153));
	}// GEN-LAST:event_txtTimFocusLost

	private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnRefreshActionPerformed
		layMaMoi();
	}// GEN-LAST:event_btnRefreshActionPerformed

	private void txtTimKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtTimKeyReleased
		timKiem();
	}// GEN-LAST:event_txtTimKeyReleased

	private void tblChiTietMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tblChiTietMouseClicked
		if (evt.getClickCount() == 2) {
			this.row = tblChiTiet.getSelectedRow();
			this.edit();
		}
	}// GEN-LAST:event_tblChiTietMouseClicked

	private void txtKhongDuocSuaMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_txtKhongDuocSuaMouseClicked
		if (evt.getClickCount() == 2) {
			DialogHelper.alert(null, "Không được sửa!");
		}

	}// GEN-LAST:event_txtKhongDuocSuaMouseClicked

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private com.ttt.swing.Button btnFirst;
	private javax.swing.ButtonGroup btnGroupChucVu;
	private javax.swing.ButtonGroup btnGroupGioiTinh;
	private com.ttt.swing.Button btnLamMoi;
	private com.ttt.swing.Button btnLast;
	private com.ttt.swing.Button btnNext;
	private com.ttt.swing.Button btnPlus;
	private com.ttt.swing.Button btnPrev;
	private javax.swing.JButton btnRefresh;
	private com.ttt.swing.Button btnSua;
	private com.ttt.swing.Button btnThemMoi;
	private com.ttt.swing.Button btnXoa;
	private com.ttt.swing.Button btnXuatFile;
	private javax.swing.JComboBox<String> cboLoaiXe;
	private javax.swing.JComboBox<String> cboViTri;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JSeparator jSeparator10;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	private javax.swing.JSeparator jSeparator5;
	private javax.swing.JSeparator jSeparator6;
	private javax.swing.JSeparator jSeparator7;
	private javax.swing.JSeparator jSeparator8;
	private javax.swing.JSeparator jSeparator9;
	private javax.swing.JLabel lblMaST1;
	private javax.swing.JLabel lblMaST10;
	private javax.swing.JLabel lblMaST2;
	private javax.swing.JLabel lblMaST3;
	private javax.swing.JLabel lblMaST4;
	private javax.swing.JLabel lblMaST5;
	private javax.swing.JLabel lblMaST6;
	private javax.swing.JLabel lblMaST7;
	private javax.swing.JLabel lblMaST8;
	private javax.swing.JLabel lblMaST9;
	private com.ttt.swing.PanelBackground panelBackground1;
	private com.ttt.swing.PanelBackground panelBackground2;
	private com.ttt.swing.TableDark tblChiTiet;
	private javax.swing.JTextField txtDienGiai;
	private javax.swing.JTextField txtGiaNhap;
	private javax.swing.JTextField txtMaNV;
	private javax.swing.JTextField txtPNK;
	private javax.swing.JTextField txtSoKhung;
	private javax.swing.JTextField txtSoLuong;
	private javax.swing.JTextField txtSoMay;
	private javax.swing.JTextField txtTenNV;
	private javax.swing.JTextField txtTim;
	// End of variables declaration//GEN-END:variables

	// @Override
//    public void run() {
//        try {
//            cboPhieuNhap_Form cboPn = new cboPhieuNhap_Form();
//            cboPn.setVisible(true);
//            while (true) {
//                txtPNK.setText(cboPhieuNhap_Form.maPN);
//                Thread.sleep(500);
//            }
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }
//    }
}
