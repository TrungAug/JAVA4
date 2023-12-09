package com.ttt.form;

import com.ttt.DAO.ChiTietPhieuNhapDAO;
import com.ttt.DAO.KhachHangDAO;
import com.ttt.DAO.NhanVienDAO;
import com.ttt.DAO.PhieuXuatDAO;
import com.ttt.DAO.ThongKeDAO;
import com.ttt.Entity.ChiTietPhieuNhap;
import com.ttt.Entity.KhachHang;
import com.ttt.Entity.NhanVien;
import com.ttt.Entity.PhieuXuat;
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
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class XuatKho_Form extends Form {

    DefaultTableModel model;
    int row = -1;
    public static XuatKho_Form getIstance;
    public static JTextField txtDG;
    public static JTextField txtpx;
    public static JTextField txtsk;

    public XuatKho_Form() {
        initComponents();
        init();
        getIstance = this;
        txtDG = txtDienGiai;
        txtpx = txtPXK;
        txtsk = txtSoKhung;

    }

    void init() {
        this.initTable();
        this.fillTable();
        this.fillcboKhachHang();
        this.fillcboNhanVienKD();
        tblChiTiet.fixTable(jScrollPane1);
        //this.setSoKhung();
        txtPXK.setText(ThongKeDAO.getNewThongKeDAO().getMaPhieuXuatKho());
        txtSoLuongXuat.setText("1");
        if (Auth.user != null) {
            txtMaNV.setText(Auth.user.getMaNV());
            txtTenNV.setText(Auth.user.getHoTen());
        }

    }

    public void initTable() {
        model = (DefaultTableModel) tblChiTiet.getModel();
        model.setColumnIdentifiers(new String[]{"id", "Mã PX", "Vị trí", "Loại xe", "S.Khung", "S.Máy", "S.Lượng", "Giá xuất",
            "Người xuất", "Ngày xuất", "Người sửa", "Ngày sửa", "Mã KH", "Mã NVKD"});
    }

    void fillTable() {
        model = (DefaultTableModel) tblChiTiet.getModel();
        model.setRowCount(0);
        try {
            List<ChiTietPhieuNhap> list = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_daXuatKho();
            for (ChiTietPhieuNhap c : list) {
                Object[] rows = {c.getIdChiTietPhieuNhap(), c.getMaPhieuXuat(), c.getMaViTri(), c.getMaLoaiXe(), c.getSoKhung(), c.getSoMay(), c.getSoLuongXuat(), c.getGiaXuat(), c.getMaNhanVienXuat(), DateHelper.toStringFormat(c.getNgayXuat(), "dd-MM-yyyy"), c.getNguoiSuaPX(), DateHelper.toStringFormat(c.getNgaySuaPX(), "dd-MM-yyyy"), c.getMaKhachHang(), c.getMaNhanVienKD()};
                model.addRow(rows);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
            e.printStackTrace();
        }
    }

    void fillTableByKeyword() {
        DefaultTableModel model = (DefaultTableModel) tblChiTiet.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtTim.getText();
            List<ChiTietPhieuNhap> list = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectByKeyword_PhieuXuat(keyword);
            for (ChiTietPhieuNhap c : list) {
                Object[] rows = {c.getIdChiTietPhieuNhap(), c.getMaPhieuXuat(), c.getMaViTri(), c.getMaLoaiXe(), c.getSoKhung(), c.getSoMay(), c.getSoLuongXuat(), c.getGiaXuat(), c.getMaNhanVienXuat(), DateHelper.toStringFormat(c.getNgayXuat(), "dd-MM-yyyy"), c.getNguoiSuaPX(), DateHelper.toStringFormat(c.getNgaySuaPX(), "dd-MM-yyyy"), c.getMaKhachHang(), c.getMaNhanVienKD()};
                model.addRow(rows);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
            e.printStackTrace();
        }
    }

    void fillcboKhachHang() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboKhachHang.getModel();
        model.removeAllElements();
        List<KhachHang> list = KhachHangDAO.getNewKhachHangDAO().selectAll();
        for (KhachHang cd : list) {
            model.addElement(cd);
        }
    }

    void fillcboNhanVienKD() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNhanVienKD.getModel();
        model.removeAllElements();
        List<NhanVien> list = NhanVienDAO.getNewNhanVienDAO().selectAll_NhanVienKD();
        for (NhanVien cd : list) {
            model.addElement(cd);
        }
    }

    void layMaMoi() {
        txtPXK.setText(ThongKeDAO.getNewThongKeDAO().getMaPhieuXuatKho());
    }

    boolean checkNull() {
        double giaXuat;
        try {
            giaXuat = Double.parseDouble(txtGiaXuat.getText());
            if (txtSoKhung.getText() == null || txtSoKhung.getText().equalsIgnoreCase("")) {
                DialogHelper.alert(this, "Vui lòng chọn số khung");
                return false;
            } else if (giaXuat < 0) {
                DialogHelper.alert(this, "Không được nhập âm giá xuất");
                return false;
            }
        } catch (NumberFormatException e) {
            if (txtGiaXuat.getText() == null || txtGiaXuat.getText().equalsIgnoreCase("")
                    && txtSoKhung.getText() == null || txtSoKhung.getText().equalsIgnoreCase("")) {
                DialogHelper.alert(this, "Vui lòng nhập dữ liệu");
                return false;
            } else {
                DialogHelper.alert(this, "Giá nhập sai kiểu dữ liệu");
                return false;
            }

        }

        return true;
    }

    PhieuXuat getFormPX(String dieuKien) {
        if (checkNull()) {
            PhieuXuat pn = new PhieuXuat();
            if (dieuKien.equals("them")) {
                pn.setMaPhieuXuat(txtPXK.getText());
                pn.setNguoiXuat(txtMaNV.getText());
                pn.setNgayXuat(new Date());
                pn.setNgaySua(null);
                pn.setNguoiSua(null);
                pn.setDienGiai(txtDienGiai.getText());

            } else if (dieuKien.equals("sua")) {
                PhieuXuat pnc = PhieuXuatDAO.getNewPhieuXuatDAO().selectById(txtPXK.getText());
                pn.setMaPhieuXuat(txtPXK.getText());
                pn.setNguoiXuat(pnc.getNguoiXuat());
                pn.setNgayXuat(pnc.getNgayXuat());
                pn.setNgaySua(new Date());
                pn.setNguoiSua(txtMaNV.getText());
                pn.setDienGiai(txtDienGiai.getText());
            } else if (dieuKien.equals("xoa")) {
                pn.setMaPhieuXuat("");
                pn.setNguoiXuat("");
                pn.setNgayXuat(null);
                pn.setNgaySua(null);
                pn.setNguoiSua("");
                pn.setDienGiai("");
            }
            return pn;
        }
        return null;
    }

    ChiTietPhieuNhap getFormChiTietPhieuNhap(String dieuKien) {
        if (checkNull()) {
            ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
            if (dieuKien.equals("them")) {
                //Bước 1: Tạo ra phiếu xuất mới
                PhieuXuat pn = this.getFormPX("them");

                //Bước 2: Set các thông ti vào chi tiết mới
                //Có những thông tin laauys từ việc nhập ko thay đổi, tạo ra một chi tiết cũ để lưu lại và set vao chi tiết mới
                ChiTietPhieuNhap ctc = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectBySoKhung(txtSoKhung.getText());
                ct.setIdChiTietPhieuNhap(ctc.getIdChiTietPhieuNhap());//đối với phiếu xuất thêm mới ko insert mà update
                NhanVien nv = (NhanVien) cboNhanVienKD.getSelectedItem();
                ct.setMaNhanVienKD(nv.getMaNV());
                KhachHang kh = (KhachHang) cboKhachHang.getSelectedItem();
                ct.setMaKhachHang(kh.getMaKhachHang());
                ct.setMaPhieuXuat(pn.getMaPhieuXuat());
                ct.setMaNhanVienXuat(txtMaNV.getText());
                ct.setNgayXuat(new Date());
                ct.setNgaySuaPX(null);//thêm mới nên chưa phát sinh ng sửa
                ct.setNguoiSuaPX(null);//thêm mới nên chưa phát sinh ng sửa
                ct.setGiaXuat(Double.parseDouble(txtGiaXuat.getText()));
                ct.setSoLuongXuat(Integer.parseInt(txtSoLuongXuat.getText()));
                ct.setChkXuatKho(1);
                ct.setSoKhung(ctc.getSoKhung());
                ct.setSoMay(ctc.getSoMay());
                ct.setMaPhieuNhap(ctc.getMaPhieuNhap());
                ct.setMaViTri(ctc.getMaViTri());
                ct.setMaLoaiXe(ctc.getMaLoaiXe());
                ct.setSoLuongNhap(ctc.getSoLuongNhap());
                ct.setGiaNhap(ctc.getGiaNhap());
                ct.setMaNhanVienNhap(ctc.getMaNhanVienNhap());
                ct.setNgayNhap(ctc.getNgayNhap());
                ct.setNgaySuaPN(ctc.getNgaySuaPN());
                ct.setNguoiSuaPN(ctc.getNguoiSuaPN());

            } else if (dieuKien.equals("sua")) {

                //Bước 1: Tạo ra phiếu xuất mới
                PhieuXuat pn = this.getFormPX("sua");

                //Bước 2: Set các thông ti vào chi tiết mới
                //Có những thông tin laauys từ việc nhập ko thay đổi, tạo ra một chi tiết cũ để lưu lại và set vao chi tiết mới
                // int idCT = (int) tblChiTiet.getValueAt(this.row, 0);
                //ChiTietPhieuNhap ctc = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectById(idCT + "");
                ChiTietPhieuNhap ctc = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectBySoKhung(txtSoKhung.getText());

                ct.setIdChiTietPhieuNhap(ctc.getIdChiTietPhieuNhap());//đối với phiếu xuất thêm mới ko insert mà update
                NhanVien nv = (NhanVien) cboNhanVienKD.getSelectedItem();
                ct.setMaNhanVienKD(nv.getMaNV());
                KhachHang kh = (KhachHang) cboKhachHang.getSelectedItem();
                ct.setMaKhachHang(kh.getMaKhachHang());
                ct.setMaPhieuXuat(pn.getMaPhieuXuat());
                ct.setMaNhanVienXuat(ctc.getMaNhanVienXuat());
                ct.setNgayXuat(ctc.getNgayXuat());
                ct.setNgaySuaPX(new Date());//thêm mới nên chưa phát sinh ng sửa
                ct.setNguoiSuaPX(txtMaNV.getText());//thêm mới nên chưa phát sinh ng sửa
                ct.setGiaXuat(Double.parseDouble(txtGiaXuat.getText()));
                ct.setSoLuongXuat(Integer.parseInt(txtSoLuongXuat.getText()));
                ct.setChkXuatKho(1);
                ct.setSoKhung(ctc.getSoKhung());
                ct.setSoMay(ctc.getSoMay());
                ct.setMaPhieuNhap(ctc.getMaPhieuNhap());
                ct.setMaViTri(ctc.getMaViTri());
                ct.setMaLoaiXe(ctc.getMaLoaiXe());
                ct.setSoLuongNhap(ctc.getSoLuongNhap());
                ct.setGiaNhap(ctc.getGiaNhap());
                ct.setMaNhanVienNhap(ctc.getMaNhanVienNhap());
                ct.setNgayNhap(ctc.getNgayNhap());
                ct.setNgaySuaPN(ctc.getNgaySuaPN());
                ct.setNguoiSuaPN(ctc.getNguoiSuaPN());

            }

            return ct;
        }
        return null;
    }

    public boolean checkExistSoKhung() {
        String soKhung = txtSoKhung.getText();
        String maPX = txtPXK.getText();
        boolean flagCheckExistEmail = true;
        if (!maPX.equalsIgnoreCase(ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().getMaPXBySoKhung(soKhung))) {
            List<ChiTietPhieuNhap> listNH = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_daXuatKho();
            for (ChiTietPhieuNhap nh : listNH) {
                if (nh.getSoKhung().equalsIgnoreCase(soKhung)) {
                    DialogHelper.alert(this, "Đã xuất xe số khung " + soKhung);
                    flagCheckExistEmail = false;
                    break;
                }
            }
        }
        return flagCheckExistEmail;
    }

    boolean isExist_PhieuXuat(String maPX) {
        List<PhieuXuat> list = PhieuXuatDAO.getNewPhieuXuatDAO().selectAll();
        for (PhieuXuat cd : list) {
            if (cd.getMaPhieuXuat().equals(maPX)) {
                return true;
            }

        }
        return false;
    }

    void lamMoi() {
        txtPXK.setText(ThongKeDAO.getNewThongKeDAO().getMaPhieuXuatKho());
        txtDienGiai.setText("");
        txtGiaXuat.setText("");
        txtSoKhung.setText("");
        txtTim.setText("Nhập tìm kiếm");
        if (Auth.user != null) {
            txtMaNV.setText(Auth.user.getMaNV());
            txtTenNV.setText(Auth.user.getHoTen());
        }
        this.fillTable();
    }

    void themXeVaoPhieuXuat() {
        ChiTietPhieuNhap ct = this.getFormChiTietPhieuNhap("them");
        if (ct != null) {
            String check_ct = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().getMaPXBySoKhung(ct.getSoKhung());
            if (ct.getMaPhieuNhap().equals(check_ct)) {
                DialogHelper.alert(this, "Xe này đã xuất kho");
            } else {
                ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().update(ct);
                txtGiaXuat.setText("");
                txtSoKhung.setText("");
                this.fillTable();
                DialogHelper.alert(this, "Đã xuất xe");
            }

        }

    }

    void themPhieuXuat() {
        PhieuXuat px = this.getFormPX("them");
        if (px != null) {
            ChiTietPhieuNhap ct = this.getFormChiTietPhieuNhap("them");
            if (ct != null && checkExistSoKhung()) {
                if (!isExist_PhieuXuat(px.getMaPhieuXuat())) {
                    //Chưa tồn tại phiếu nhập trong dtb
                    //1. Thêm phiếu nhập vào dtb
                    PhieuXuatDAO.getNewPhieuXuatDAO().insert(px);
                    //2. Thêm Vào chi tiết phiếu nhập            
                    ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().update(ct);
                    this.lamMoi();
                    DialogHelper.alert(this, "Thêm mới thành công");
                } else {
                    themXeVaoPhieuXuat();
                    this.fillTable();
                }
            }
        }

    }

    void suaPhieuXuat() {
        int idCT = (int) tblChiTiet.getValueAt(this.row, 0);
        ChiTietPhieuNhap ctc = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectById(idCT + "");
        if (!ctc.getSoKhung().equals(txtSoKhung.getText())) {
            if (DialogHelper.confirm(null, "Bạn muốn thêm xe vào phiếu xuất?")) {
                themPhieuXuat();
            }
        } else {
            PhieuXuat px = this.getFormPX("sua");
            ChiTietPhieuNhap ct = this.getFormChiTietPhieuNhap("sua");
            if (px != null && ct != null && checkExistSoKhung()) {
                PhieuXuatDAO.getNewPhieuXuatDAO().update(px);
                ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().update(ct);
                this.fillTable();
                DialogHelper.alert(this, "Sửa thành công");
            }
        }

    }

    void xoa() {
        if (!Auth.isManager()) {
            DialogHelper.alert(this, "Bạn không có quyền xóa nhân viên");
            return;
        }
        List<ChiTietPhieuNhap> listPX = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_MaPhieuXuat(txtPXK.getText());
        if (listPX != null) {
            if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa phiếu xuất ")) {
                try {
                    // List<ChiTietPhieuNhap> listPX = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_MaPhieuNhap(txtPXK.getText());
                    for (ChiTietPhieuNhap ctpn : listPX) {
                        //ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().delete(ctpn.getIdChiTietPhieuNhap() + "");
                        // System.out.println(ct.getIdChiTietPhieuNhap());
                        ChiTietPhieuNhap ct = new ChiTietPhieuNhap();
                        ChiTietPhieuNhap ctc = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectById(ctpn.getIdChiTietPhieuNhap() + "");
                        ct.setIdChiTietPhieuNhap(ctc.getIdChiTietPhieuNhap());

                        ct.setMaNhanVienKD(null);
                        ct.setMaKhachHang(null);
                        ct.setMaPhieuXuat(null);
                        ct.setMaNhanVienXuat(null);
                        ct.setNgayXuat(null);
                        ct.setNgaySuaPX(null);
                        ct.setNguoiSuaPX(null);
                        ct.setGiaXuat(0);
                        ct.setSoLuongXuat(0);
                        ct.setChkXuatKho(0);

                        ct.setSoKhung(ctc.getSoKhung());
                        ct.setSoMay(ctc.getSoMay());
                        ct.setMaPhieuNhap(ctc.getMaPhieuNhap());
                        ct.setMaViTri(ctc.getMaViTri());
                        ct.setMaLoaiXe(ctc.getMaLoaiXe());
                        ct.setSoLuongNhap(ctc.getSoLuongNhap());
                        ct.setGiaNhap(ctc.getGiaNhap());
                        ct.setMaNhanVienNhap(ctc.getMaNhanVienNhap());
                        ct.setNgayNhap(ctc.getNgayNhap());
                        ct.setNgaySuaPN(ctc.getNgaySuaPN());
                        ct.setNguoiSuaPN(ctc.getNguoiSuaPN());
                        ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().update(ct);
                        //System.out.println(ct.totoString());
                    }

                    this.fillTable();
                    //this.lamMoi();

                } catch (Exception e) {
                    DialogHelper.alert(this, "Có lỗi. Vui lòng kiểm tra lại thông tin!");
                    e.printStackTrace();
                }

            }

        } else {
            DialogHelper.alert(this, "Phiếu xuất " + txtPXK.getText() + " chưa có trong cơ sở dữ liệu. Vui lòng chọn phiếu xuất khác!");

        }
        PhieuXuatDAO.getNewPhieuXuatDAO().delete(txtPXK.getText());
        this.lamMoi();
        DialogHelper.alert(this, "Xóa thành công");
    }

    void timKiem() {
        String key = txtTim.getText();
        if(key.contains("*") || key.contains("(")||key.contains(")")|| key.contains("[")||key.contains("]")){
            return;
        }
        Search.search(tblChiTiet, key);
    }

    void edit() {
        int idCT = (int) tblChiTiet.getValueAt(this.row, 0);
        ChiTietPhieuNhap ct = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectById(idCT + "");
        this.setForm(ct);
    }

    void setForm(ChiTietPhieuNhap ct) {
        txtPXK.setText(ct.getMaPhieuXuat());
        KhachHang kh = KhachHangDAO.getNewKhachHangDAO().selectById(ct.getMaKhachHang());
        if (kh != null) {
            cboKhachHang.setSelectedItem(kh);
        }

        NhanVien nv = NhanVienDAO.getNewNhanVienDAO().selectById(ct.getMaNhanVienKD());
        if (nv != null) {
            cboNhanVienKD.setSelectedItem(nv);
        }

        txtMaNV.setText(ct.getMaNhanVienXuat());
        NhanVien nv2 = NhanVienDAO.getNewNhanVienDAO().selectById(txtMaNV.getText());
        if (nv2 != null) {
            txtTenNV.setText(nv2.getHoTen());
        }

        PhieuXuat px = PhieuXuatDAO.getNewPhieuXuatDAO().selectById(ct.getMaPhieuXuat());
        if (px != null) {
            txtDienGiai.setText(px.getDienGiai());
        }

        //cboChiTietPhieuNhap.setSelectedItem(ct);
        txtSoKhung.setText(ct.getSoKhung());
        txtSoLuongXuat.setText(ct.getSoLuongXuat() + "");
        txtGiaXuat.setText(ct.getGiaXuat() + "");
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
                cell.setCellValue("MaPX");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("ViTri");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("LoaiXe");
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("SoKhung");
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("SoMay");
                cell = row.createCell(6, CellType.NUMERIC);
                cell.setCellValue("SoLuongXuat");
                cell = row.createCell(7, CellType.NUMERIC);
                cell.setCellValue("GiaXuat");
                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue("NguoiXuat");
                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue("NgayXuat");
                cell = row.createCell(10, CellType.STRING);
                cell.setCellValue("NguoiSuaPX");
                cell = row.createCell(11, CellType.STRING);
                cell.setCellValue("NgaySuaPX");
                cell = row.createCell(12, CellType.STRING);
                cell.setCellValue("MaKH");
                cell = row.createCell(13, CellType.STRING);
                cell.setCellValue("Ma NVKD");
                List<ChiTietPhieuNhap> arr = ChiTietPhieuNhapDAO.getNewChiTietPhieuNhapDAO().selectAll_daXuatKho();
                for (int i = 0; i < arr.size(); i++) {
                    // LoaiXe cn = arr.get(i);
                    row = sheet.createRow(2 + i);

                    cell = row.createCell(0, CellType.NUMERIC);
                    cell.setCellValue(arr.get(i).getIdChiTietPhieuNhap());

                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaPhieuXuat());

                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaViTri());

                    cell = row.createCell(3, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaLoaiXe());

                    cell = row.createCell(4, CellType.STRING);
                    cell.setCellValue(arr.get(i).getSoKhung());

                    cell = row.createCell(5, CellType.STRING);
                    cell.setCellValue(arr.get(i).getSoMay());

                    cell = row.createCell(6, CellType.STRING);
                    cell.setCellValue(arr.get(i).getSoLuongXuat());

                    cell = row.createCell(7, CellType.STRING);
                    cell.setCellValue(arr.get(i).getGiaXuat());

                    cell = row.createCell(8, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaNhanVienXuat());

                    cell = row.createCell(9, CellType.STRING);
                    cell.setCellValue(arr.get(i).getNgayXuat());

                    cell = row.createCell(10, CellType.STRING);
                    cell.setCellValue(arr.get(i).getNguoiSuaPX());

                    cell = row.createCell(11, CellType.STRING);
                    cell.setCellValue(arr.get(i).getNgaySuaPX());

                    cell = row.createCell(12, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaKhachHang());

                    cell = row.createCell(13, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaNhanVienKD());

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        btnPlusSoKhung = new com.ttt.swing.Button();
        lblMaST11 = new javax.swing.JLabel();
        lblMaST7 = new javax.swing.JLabel();
        lblMaST8 = new javax.swing.JLabel();
        lblMaST5 = new javax.swing.JLabel();
        lblMaST9 = new javax.swing.JLabel();
        txtSoKhung = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtSoLuongXuat = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtGiaXuat = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtMaNV = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtTenNV = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        panelBackground2 = new com.ttt.swing.PanelBackground();
        lblMaST6 = new javax.swing.JLabel();
        lblMaST10 = new javax.swing.JLabel();
        cboNhanVienKD = new javax.swing.JComboBox<>();
        lblMaST4 = new javax.swing.JLabel();
        cboKhachHang = new javax.swing.JComboBox<>();
        lblMaST3 = new javax.swing.JLabel();
        btnPlusPXK = new com.ttt.swing.Button();
        txtPXK = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        txtDienGiai = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        btnRefresh = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblChiTiet = new com.ttt.swing.TableDark();

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
        btnThemMoi.setBounds(30, 20, 70, 26);

        btnSua.setBackground(new java.awt.Color(0, 51, 51));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChucNangActionPerformed(evt);
            }
        });
        add(btnSua);
        btnSua.setBounds(130, 20, 70, 26);

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
        btnXoa.setBounds(220, 20, 70, 26);

        btnFirst.setBackground(new java.awt.Color(0, 51, 51));
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlActionPerformed(evt);
            }
        });
        add(btnFirst);
        btnFirst.setBounds(280, 490, 31, 26);

        btnPrev.setBackground(new java.awt.Color(0, 51, 51));
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlActionPerformed(evt);
            }
        });
        add(btnPrev);
        btnPrev.setBounds(330, 490, 36, 26);

        btnNext.setBackground(new java.awt.Color(0, 51, 51));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(390, 490, 36, 26);

        btnLast.setBackground(new java.awt.Color(0, 51, 51));
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlActionPerformed(evt);
            }
        });
        add(btnLast);
        btnLast.setBounds(440, 490, 31, 26);

        btnXuatFile.setBackground(new java.awt.Color(0, 51, 51));
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChucNangActionPerformed(evt);
            }
        });
        add(btnXuatFile);
        btnXuatFile.setBounds(690, 490, 70, 26);

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
        btnLamMoi.setBounds(310, 20, 71, 26);

        panelBackground1.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground1.setLayout(null);

        btnPlusSoKhung.setBackground(new java.awt.Color(0, 51, 51));
        btnPlusSoKhung.setForeground(new java.awt.Color(255, 255, 255));
        btnPlusSoKhung.setText("+");
        btnPlusSoKhung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusSoKhungActionPerformed(evt);
            }
        });
        panelBackground1.add(btnPlusSoKhung);
        btnPlusSoKhung.setBounds(340, 10, 32, 26);

        lblMaST11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST11.setForeground(new java.awt.Color(153, 0, 0));
        lblMaST11.setText("Số khung");
        panelBackground1.add(lblMaST11);
        lblMaST11.setBounds(20, 50, 60, 18);

        lblMaST7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST7.setForeground(new java.awt.Color(153, 0, 0));
        lblMaST7.setText("Số lượng");
        panelBackground1.add(lblMaST7);
        lblMaST7.setBounds(20, 110, 56, 18);

        lblMaST8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST8.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST8.setText("Giá xuất");
        panelBackground1.add(lblMaST8);
        lblMaST8.setBounds(20, 170, 51, 18);

        lblMaST5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST5.setForeground(new java.awt.Color(153, 0, 0));
        lblMaST5.setText("Mã NV");
        panelBackground1.add(lblMaST5);
        lblMaST5.setBounds(30, 230, 50, 18);

        lblMaST9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST9.setForeground(new java.awt.Color(153, 0, 0));
        lblMaST9.setText("Tên NV");
        panelBackground1.add(lblMaST9);
        lblMaST9.setBounds(30, 290, 46, 18);

        txtSoKhung.setEditable(false);
        txtSoKhung.setBackground(new java.awt.Color(0, 51, 51));
        txtSoKhung.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtSoKhung.setForeground(new java.awt.Color(204, 204, 204));
        txtSoKhung.setBorder(null);
        txtSoKhung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtKhongDuocSuaMouseClicked(evt);
            }
        });
        panelBackground1.add(txtSoKhung);
        txtSoKhung.setBounds(90, 40, 250, 30);

        jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator3);
        jSeparator3.setBounds(90, 70, 250, 10);

        txtSoLuongXuat.setEditable(false);
        txtSoLuongXuat.setBackground(new java.awt.Color(0, 51, 51));
        txtSoLuongXuat.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtSoLuongXuat.setForeground(new java.awt.Color(204, 204, 204));
        txtSoLuongXuat.setBorder(null);
        txtSoLuongXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtKhongDuocSuaMouseClicked(evt);
            }
        });
        panelBackground1.add(txtSoLuongXuat);
        txtSoLuongXuat.setBounds(90, 100, 250, 30);

        jSeparator4.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator4);
        jSeparator4.setBounds(90, 130, 250, 10);

        txtGiaXuat.setBackground(new java.awt.Color(0, 51, 51));
        txtGiaXuat.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtGiaXuat.setForeground(new java.awt.Color(204, 204, 204));
        txtGiaXuat.setBorder(null);
        panelBackground1.add(txtGiaXuat);
        txtGiaXuat.setBounds(90, 160, 250, 30);

        jSeparator5.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator5);
        jSeparator5.setBounds(90, 190, 250, 10);

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
        panelBackground1.add(txtMaNV);
        txtMaNV.setBounds(90, 220, 250, 30);

        jSeparator6.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator6.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator6);
        jSeparator6.setBounds(90, 250, 250, 10);

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
        panelBackground1.add(txtTenNV);
        txtTenNV.setBounds(90, 280, 250, 30);

        jSeparator7.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator7);
        jSeparator7.setBounds(90, 310, 250, 10);

        add(panelBackground1);
        panelBackground1.setBounds(400, 70, 380, 380);

        panelBackground2.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground2.setLayout(null);

        lblMaST6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST6.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST6.setText("Diễn giải");
        panelBackground2.add(lblMaST6);
        lblMaST6.setBounds(20, 260, 56, 18);

        lblMaST10.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST10.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST10.setText("NVKD");
        panelBackground2.add(lblMaST10);
        lblMaST10.setBounds(40, 170, 37, 18);

        cboNhanVienKD.setBackground(new java.awt.Color(0, 51, 51));
        cboNhanVienKD.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cboNhanVienKD.setForeground(new java.awt.Color(255, 255, 255));
        cboNhanVienKD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên kinh doanh" }));
        cboNhanVienKD.setBorder(null);
        panelBackground2.add(cboNhanVienKD);
        cboNhanVienKD.setBounds(90, 160, 250, 40);

        lblMaST4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST4.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST4.setText("Khách hàng");
        panelBackground2.add(lblMaST4);
        lblMaST4.setBounds(10, 110, 80, 18);

        cboKhachHang.setBackground(new java.awt.Color(0, 51, 51));
        cboKhachHang.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cboKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        cboKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách hàng", " " }));
        cboKhachHang.setBorder(null);
        panelBackground2.add(cboKhachHang);
        cboKhachHang.setBounds(90, 100, 250, 40);

        lblMaST3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST3.setForeground(new java.awt.Color(153, 0, 0));
        lblMaST3.setText("PXK");
        panelBackground2.add(lblMaST3);
        lblMaST3.setBounds(50, 60, 25, 18);

        btnPlusPXK.setBackground(new java.awt.Color(0, 51, 51));
        btnPlusPXK.setForeground(new java.awt.Color(255, 255, 255));
        btnPlusPXK.setText("+");
        btnPlusPXK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlusPXKActionPerformed(evt);
            }
        });
        panelBackground2.add(btnPlusPXK);
        btnPlusPXK.setBounds(60, 40, 30, 20);

        txtPXK.setEditable(false);
        txtPXK.setBackground(new java.awt.Color(0, 51, 51));
        txtPXK.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtPXK.setForeground(new java.awt.Color(204, 204, 204));
        txtPXK.setBorder(null);
        txtPXK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtKhongDuocSuaMouseClicked(evt);
            }
        });
        panelBackground2.add(txtPXK);
        txtPXK.setBounds(90, 40, 250, 30);

        jSeparator8.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator8.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground2.add(jSeparator8);
        jSeparator8.setBounds(90, 70, 250, 10);

        txtDienGiai.setBackground(new java.awt.Color(0, 51, 51));
        txtDienGiai.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtDienGiai.setForeground(new java.awt.Color(204, 204, 204));
        txtDienGiai.setBorder(null);
        panelBackground2.add(txtDienGiai);
        txtDienGiai.setBounds(90, 240, 250, 30);

        jSeparator9.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator9.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground2.add(jSeparator9);
        jSeparator9.setBounds(90, 270, 250, 10);

        btnRefresh.setBackground(new java.awt.Color(0, 51, 51));
        btnRefresh.setIcon(new javax.swing.ImageIcon("D:\\SUMMER 2023\\Du An 1\\3tProject\\HiNoApp\\src\\com\\ttt\\icon\\Refresh.png")); // NOI18N
        btnRefresh.setBorderPainted(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        panelBackground2.add(btnRefresh);
        btnRefresh.setBounds(340, 40, 30, 30);

        add(panelBackground2);
        panelBackground2.setBounds(10, 70, 380, 380);

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
        txtTim.setBounds(20, 490, 250, 40);

        tblChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null", "null", "null", "null", "null", "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblChiTiet);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 550, 740, 190);
    }// </editor-fold>//GEN-END:initComponents

    private void btnControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlActionPerformed
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
    }//GEN-LAST:event_btnControlActionPerformed

    private void btnChucNangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChucNangActionPerformed
        String Option = evt.getActionCommand();
        String them = btnThemMoi.getText();
        String sua = btnSua.getText();
        String xoa = btnXoa.getText();
        String moi = btnLamMoi.getText();
        String export = btnXuatFile.getText();

        if (Option.equals(them)) {
            themPhieuXuat();
        } else if (Option.equals(sua)) {
            suaPhieuXuat();
        } else if (Option.equals(xoa)) {
            xoa();
        } else if (Option.equals(moi)) {
            lamMoi();
        } else if (Option.equals(export)) {
            export_excel();
        }
    }//GEN-LAST:event_btnChucNangActionPerformed

    private void btnPlusPXKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusPXKActionPerformed
        new GetPX_Form().setVisible(true);
    }//GEN-LAST:event_btnPlusPXKActionPerformed

    private void btnPlusSoKhungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlusSoKhungActionPerformed
        new GetSKX_Form().setVisible(true);
    }//GEN-LAST:event_btnPlusSoKhungActionPerformed

    private void txtKhongDuocSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtKhongDuocSuaMouseClicked
        if (evt.getClickCount() == 2) {
            DialogHelper.alert(this, "Không được sửa!");
        }
    }//GEN-LAST:event_txtKhongDuocSuaMouseClicked

    private void txtTimFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimFocusGained
        if (txtTim.getText().equalsIgnoreCase("Nhập tìm kiếm")) {
            txtTim.setText("");
        }

        txtTim.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtTimFocusGained

    private void txtTimFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimFocusLost
        if (txtTim.getText().equalsIgnoreCase("")) {
            txtTim.setText("Nhập tìm kiếm");
        }
        txtTim.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_txtTimFocusLost

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        layMaMoi();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtTimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyReleased
        timKiem();
    }//GEN-LAST:event_txtTimKeyReleased

    private void tblChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblChiTiet.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblChiTietMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.Button btnFirst;
    private javax.swing.ButtonGroup btnGroupChucVu;
    private javax.swing.ButtonGroup btnGroupGioiTinh;
    private com.ttt.swing.Button btnLamMoi;
    private com.ttt.swing.Button btnLast;
    private com.ttt.swing.Button btnNext;
    private com.ttt.swing.Button btnPlusPXK;
    private com.ttt.swing.Button btnPlusSoKhung;
    private com.ttt.swing.Button btnPrev;
    private javax.swing.JButton btnRefresh;
    private com.ttt.swing.Button btnSua;
    private com.ttt.swing.Button btnThemMoi;
    private com.ttt.swing.Button btnXoa;
    private com.ttt.swing.Button btnXuatFile;
    private javax.swing.JComboBox<String> cboKhachHang;
    private javax.swing.JComboBox<String> cboNhanVienKD;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblMaST10;
    private javax.swing.JLabel lblMaST11;
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
    private javax.swing.JTextField txtGiaXuat;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtPXK;
    private javax.swing.JTextField txtSoKhung;
    private javax.swing.JTextField txtSoLuongXuat;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
