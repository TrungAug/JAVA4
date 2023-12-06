package com.ttt.form;

import com.ttt.DAO.NhanVienDAO;
import com.ttt.DAO.PhongBanDAO;
import com.ttt.DAO.ThongKeDAO;
import com.ttt.Entity.NhanVien;
import com.ttt.Entity.PhongBan;
import com.ttt.LibaryHelper.DateHelper;
import com.ttt.LibaryHelper.DialogHelper;
import com.ttt.LibaryHelper.Search;
import com.ttt.LibaryHelper.ShareHelper;
import com.ttt.component.Form;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class NhanVien_Form extends Form {

    int row = -1;
    DefaultTableModel model;

    public NhanVien_Form() {
        initComponents();
        init();
    }

    public void init() {
        this.initTable();
        fillTable();
        tblNhanVien.fixTable(jScrollPane3);
        fillcboPhongBan();
        txtManv.setText(ThongKeDAO.getNewThongKeDAO().getMaNhanVien());
    }

    public void initTable() {
        model = (DefaultTableModel) tblNhanVien.getModel();
        model.setColumnIdentifiers(new String[]{"Mã nhân viên", "Tên nhân viên", "Địa chỉ", "Email", "Ngày sinh", "Chức vụ", "Giới tính", "Hình"});
    }

    public void fillTable() {
        model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            List<NhanVien> list = NhanVienDAO.getNewNhanVienDAO().selectAll();
            for (NhanVien nv : list) {
                Object[] rows = {
                    nv.getMaNV(), nv.getHoTen(), nv.getDiaChi(), nv.getEmail(), DateHelper.toStringFormat(nv.getNgaySinh(), "dd-MM-yyyy"), nv.getChucVu(), nv.getGioiTinh(), nv.getHinh()
                };
                model.addRow(rows);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void fillcboPhongBan() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboPhongBan.getModel();
        model.removeAllElements();
        List<PhongBan> list = PhongBanDAO.getNewPhongBanDAO().selectAll();
        for (PhongBan cd : list) {
            model.addElement(cd);
        }
    }

    void chonAnh() {
        JFileChooser fileChooser = new JFileChooser(".\\HinhNhanVien");
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String maNV = txtManv.getText();
            ShareHelper.save(maNV, file);
            String new_name = maNV + "_" + file.getName();
            ImageIcon icon = ShareHelper.read(new_name);
            lblHinh.setIcon(icon);
            lblHinh.setText("");
            lblHinh.setToolTipText(file.getName());
        }
    }

    public void setForm(NhanVien nv) {
        txtManv.setText(nv.getMaNV());
        txtTennv.setText(nv.getHoTen());
        txtDiachi.setText(nv.getDiaChi());
        txtEmail.setText(nv.getEmail());
        txtMk.setText(nv.getMatKhau());
        txtMkx.setText(nv.getMatKhau());
        txtNgaysinh.setText(DateHelper.toStringFormat(nv.getNgaySinh(), "dd-MM-yyyy"));
        PhongBan pb = PhongBanDAO.getNewPhongBanDAO().selectById(nv.getMaPhong());

        cboPhongBan.setSelectedItem(pb);

        if (nv.getChucVu().equalsIgnoreCase("Admin")) {
            rdoAdmin.setSelected(true);
        } else if (nv.getChucVu().equalsIgnoreCase("NhanVien")) {
            rdoNhanVien.setSelected(true);
        } else if (nv.getChucVu().equalsIgnoreCase("TruongPhong")) {
            rdoTruongPhong.setSelected(true);
        }
        if (nv.getGioiTinh().equalsIgnoreCase("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }

        if (nv.getHinh() != null) {
            lblHinh.setIcon(ShareHelper.read(nv.getHinh()));
            String nameHinh = nv.getMaNV() + "_" + nv.getHinh();
            lblHinh.setToolTipText(nameHinh);
            lblHinh.setText("");
        } else {
            lblHinh.setText("Hình");
            lblHinh.setToolTipText(null);
            lblHinh.setIcon(new ImageIcon(""));
        }

    }

    public NhanVien getForm() {
        if (checkNull() && checkTrungEmail()) {
            NhanVien nv = new NhanVien();
            nv.setMaNV(txtManv.getText());
            nv.setHoTen(txtTennv.getText());
            nv.setDiaChi(txtDiachi.getText());
            nv.setEmail(txtEmail.getText());
            nv.setMatKhau(new String(txtMk.getPassword()));
            nv.setNgaySinh(DateHelper.toDate(txtNgaysinh.getText(), "dd-MM-yyyy"));
            PhongBan pb = (PhongBan) cboPhongBan.getSelectedItem();
            nv.setMaPhong(pb.getMaPhongBan());
            if (rdoTruongPhong.isSelected()) {
                nv.setChucVu("TruongPhong");
            } else if (rdoNhanVien.isSelected()) {
                nv.setChucVu("NhanVien");
            } else if (rdoAdmin.isSelected()) {
                nv.setChucVu("Admin");
            }

            if (rdoNam.isSelected()) {
                nv.setGioiTinh(rdoNam.getText());
            } else if (rdoNu.isSelected()) {
                nv.setGioiTinh(rdoNu.getText());
            }
            nv.setHinh(lblHinh.getToolTipText());

            return nv;
        }
        return null;
    }

    void edit() {
        String idCT = (String) tblNhanVien.getValueAt(this.row, 0);
        NhanVien pb = NhanVienDAO.getNewNhanVienDAO().selectById(idCT.trim());
        this.setForm(pb);
        tblNhanVien.setRowSelectionInterval(row, row);
    }


    void timKiem() {
        String key = txtTimKiem.getText();
        if (key.contains("*") || key.contains("(") || key.contains(")") || key.contains("[") || key.contains("]")) {
            return;
        }
        Search.search(tblNhanVien, key);
    }

    int getAge(String date) {
        if (date != null && !txtNgaysinh.getText().equalsIgnoreCase("dd-MM-yyyy")) {
            return (new Date().getYear() - DateHelper.toDate(date, "dd-MM-yyyy").getYear());
        }
        return 0;
    }

    int getIndexByMaNV(String maNV) {
        List<NhanVien> lisNV = NhanVienDAO.getNewNhanVienDAO().selectAll();
        for (int i = 0; i < lisNV.size(); i++) {
            NhanVien nv = lisNV.get(i);
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                return i;
            }
        }
        return -1;
    }

    boolean checkNull() {
        String patternDate = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}";
        String patternName = "^[\\p{L}\\s]+$";
        int checkTuoi = getAge(txtNgaysinh.getText());
        String passMoi = new String(txtMk.getPassword());
        String xacNhanPassMoi = new String(txtMkx.getPassword());
        int flag_ten = 0;
        int flag_email = 0;
        int flag_mk = 0;
        int flag_xnmk = 0;
        int flag_tuoi = 0;
        int flag_gt = 0;
        int flag_chucvu = 0;
        if (txtTennv.getText().equals("") || txtTennv.getText() == null) {
            flag_ten = 1;
        }
        
        if (!txtTennv.getText().matches(patternName)) {
            flag_ten = 2;
        }
        if(txtEmail.getText().equals("") || txtEmail.getText() == null){
            flag_email =1;
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
        if (rdoTruongPhong.isSelected() == false && rdoNhanVien.isSelected() == false && rdoAdmin.isSelected() == false) {
            flag_chucvu = 1;
        }
        if (rdoNam.isSelected() == false && rdoNu.isSelected() == false) {
            flag_gt = 1;
        }
        if (flag_email == 1 && (flag_ten == 1 || flag_ten == 2) && (flag_mk == 1 || flag_mk == 2) && flag_xnmk == 1
                && flag_tuoi == 1 && flag_chucvu == 1 && flag_gt == 1) {
            DialogHelper.alert(this, "Vui lòng nhập thông tin");
            return false;
        }else if ((flag_ten == 1 || flag_ten == 2) && (flag_mk == 1 || flag_mk == 2) && flag_xnmk == 1
                && flag_tuoi == 1 && flag_chucvu == 1 && flag_gt == 1) {
            DialogHelper.alert(this, "Chưa nhập đủ thông tin");
            return false;
        }else if ((flag_mk == 1 || flag_mk == 2) && flag_xnmk == 1
                && flag_tuoi == 1 && flag_chucvu == 1 && flag_gt == 1) {
            DialogHelper.alert(this, "Chưa nhập đủ thông tin");
            return false;
        }else if (flag_xnmk == 1
                && flag_tuoi == 1 && flag_chucvu == 1 && flag_gt == 1) {
            DialogHelper.alert(this, "Chưa nhập đủ thông tin");
            return false;
        }else if ( flag_tuoi == 1 && flag_chucvu == 1 && flag_gt == 1) {
            DialogHelper.alert(this, "Chưa nhập đủ thông tin");
            return false;
        }else if (flag_chucvu == 1 && flag_gt == 1) {
            DialogHelper.alert(this, "Chưa nhập đủ thông tin");
            return false;
        }else if(flag_email==1 && (flag_ten==1||flag_ten==1)){
            DialogHelper.alert(this, "Chưa nhập đủ thông tin");
            return false;
        }
        else if ( flag_ten == 2&&flag_mk == 2&&flag_tuoi == 1) {
            DialogHelper.alert(this, "Thông tin nhập chưa đúng");
            return false;
        }else if (flag_mk == 2&&flag_tuoi == 1) {
            DialogHelper.alert(this, "Thông tin nhập chưa đúng");
            return false;
        }else if (flag_tuoi == 1) {
            DialogHelper.alert(this, "Ngày sinh không hợp lệ. Nhân viên phải đủ 18 tuổi");
            return false;
        }else if (flag_mk == 2) {
            DialogHelper.alert(this, "Mật khẩu phải có ít nhất 8 ký tự");
            return false;
        }else if (flag_ten == 2) {
            DialogHelper.alert(this, "Tên nhân viên không hợp lệ");
            return false;
        }else if (flag_gt == 1) {
            DialogHelper.alert(this, "Vui lòng chọn giới tính");
            return false;
        }else if (flag_chucvu == 1) {
            DialogHelper.alert(this, "Vui lòng chọn chức vụ");
            return false;
        }else if (flag_xnmk == 1) {
            DialogHelper.alert(this, "Xác nhận mật khẩu không đúng");
            return false;
        }else if (flag_mk == 1) {
            DialogHelper.alert(this, "Vui lòng nhập mật khẩu");
            return false;
        }else if (flag_ten == 1) {
            DialogHelper.alert(this, "Vui lòng nhập tên nhân viên");
            return false;
        }else if (flag_email == 1) {
            DialogHelper.alert(this, "Vui lòng nhập email");
            return false;
        }else{
            return true;
        }
    }

    void clearForm() {
        layMaMoi();
        txtTennv.setText("");
        txtDiachi.setText("");
        txtEmail.setText("");
        txtMkx.setText("xacnhanmatkhau");
        txtMk.setText("matkhaumoi");
        lblHinh.setText("Hình");
        lblHinh.setIcon(null);
        txtTimKiem.setText("Nhập tìm kiếm");
        this.fillTable();

    }

    boolean checkTrungMaNV(String maNV) {
        List<NhanVien> list = NhanVienDAO.getNewNhanVienDAO().selectAll();
        for (NhanVien nv : list) {
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                return true;
            }

        }
        return false;
    }

    String getMaNhByEmail(String email) {
        String maNH = null;
        List<NhanVien> listNH = NhanVienDAO.getNewNhanVienDAO().selectAll();
        for (NhanVien nh : listNH) {
            if (nh.getEmail().equalsIgnoreCase(email)) {
                maNH = nh.getMaNV();
                break;
            }
        }
        return maNH;
    }

    public boolean checkTrungEmail() {
        String checkEmail = txtEmail.getText();
        String maNH = txtManv.getText();
        boolean flagCheckExistEmail = true;
        if (!checkEmail.matches("\\w+@\\w+(\\.\\w+){1,3}")) {
            DialogHelper.alert(this, "Email chưa đúng định dạng");
            flagCheckExistEmail = false;
        } else if (!maNH.equalsIgnoreCase(getMaNhByEmail(checkEmail))) {
            List<NhanVien> listNH = NhanVienDAO.getNewNhanVienDAO().selectAll();
            for (NhanVien nh : listNH) {
                if (nh.getEmail().equalsIgnoreCase(checkEmail)) {
                    DialogHelper.alert(this, "Đã tồn tại email " + checkEmail);
                    flagCheckExistEmail = false;
                    break;
                }
            }
        }
        return flagCheckExistEmail;
    }

    public void insert() {
        NhanVien nv = getForm();
        if (nv != null) {
            String ma = nv.getMaNV();
            if (checkTrungMaNV(nv.getMaNV())) {
                if (DialogHelper.confirm(this, "Đã tồn tại mã nhân viên " + nv.getMaNV() + " .Bạn có muốn cập nhật không?")) {
                    update();
                } else {
                    layMaMoi();
                }
            } else {
                try {
                    NhanVienDAO.getNewNhanVienDAO().insert(nv);
                    DialogHelper.alert(this, "Thêm mới thành công");
                    fillTable();
                    clearForm();
                    int index = getIndexByMaNV(ma);
                    tblNhanVien.setRowSelectionInterval(index, index);
                } catch (Exception e) {
                    DialogHelper.alert(this, "Thêm mới thất bại!");
                }
            }

        }
    }

    void update() {
        NhanVien nv = this.getForm();
        if (nv != null) {
            String ma = nv.getMaNV();
            try {
                NhanVienDAO.getNewNhanVienDAO().update(nv);
                this.fillTable();
                clearForm();
                DialogHelper.alert(this, "Cập nhật thành công");
                int index = getIndexByMaNV(ma);
                tblNhanVien.setRowSelectionInterval(index, index);

            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại");
            }
        }
    }

    void delete() {
        String ma = txtManv.getText();
        NhanVien nv = NhanVienDAO.getNewNhanVienDAO().selectById(ma);
        if (nv != null) {
            if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa nhân viên " + ma)) {
                try {
                    NhanVienDAO.getNewNhanVienDAO().delete(ma);
                    this.fillTable();
                    this.clearForm();
                    DialogHelper.alert(this, "Xóa thành công");
                } catch (Exception e) {
                    DialogHelper.alert(this, "Nhân đã tồn tại dữ liệu. Không được xóa!");
                }
            }
        } else {
            DialogHelper.alert(this, "Chưa có nhân viên " + ma);
        }
    }

    void first() {
        this.row = 0;
        this.edit();
        tblNhanVien.setRowSelectionInterval(this.row, this.row);
    }

    void next() {

        if (this.row < tblNhanVien.getRowCount() - 1) {
            this.row++;
            this.edit();

        } else {
            first();

        }
        tblNhanVien.setRowSelectionInterval(this.row, this.row);

    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();

        } else {
            last();

        }
        tblNhanVien.setRowSelectionInterval(this.row, this.row);

    }

    void last() {
        this.row = tblNhanVien.getRowCount() - 1;
        this.edit();
        tblNhanVien.setRowSelectionInterval(this.row, this.row);

    }

    void layMaMoi() {
        txtManv.setText(ThongKeDAO.getNewThongKeDAO().getMaNhanVien());
    }

    void export_excel() {
        try {
            JFileChooser jfileChooser = new JFileChooser();
            jfileChooser.showSaveDialog(this);
            File saveFile = jfileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("nhanvien");
                XSSFRow rowx = null;
                Cell cell = null;
                rowx = sheet.createRow(1);
                cell = rowx.createCell(0, CellType.STRING);
                cell.setCellValue("MaNV");
                cell = rowx.createCell(1, CellType.STRING);
                cell.setCellValue("TenNV");
                cell = rowx.createCell(2, CellType.STRING);
                cell.setCellValue("DiaChi");
                cell = rowx.createCell(3, CellType.STRING);
                cell.setCellValue("Email");
                cell = rowx.createCell(4, CellType.STRING);
                cell.setCellValue("NgaySinh");
                cell = rowx.createCell(5, CellType.STRING);
                cell.setCellValue("ChucVu");
                cell = rowx.createCell(6, CellType.STRING);
                cell.setCellValue("GioiTinh");
                List<NhanVien> arr = NhanVienDAO.getNewNhanVienDAO().selectAll();
                for (int i = 0; i < arr.size(); i++) {
                    rowx = sheet.createRow(2 + i);

                    cell = rowx.createCell(0, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaNV());
                    cell = rowx.createCell(1, CellType.STRING);
                    cell.setCellValue(arr.get(i).getHoTen());
                    cell = rowx.createCell(2, CellType.STRING);
                    cell.setCellValue(arr.get(i).getDiaChi());
                    cell = rowx.createCell(3, CellType.STRING);
                    cell.setCellValue(arr.get(i).getEmail());
                    cell = rowx.createCell(4, CellType.STRING);
                    cell.setCellValue(arr.get(i).getNgaySinh());
                    cell = rowx.createCell(5, CellType.STRING);
                    cell.setCellValue(arr.get(i).getChucVu());
                    cell = rowx.createCell(6, CellType.STRING);
                    cell.setCellValue(arr.get(i).getGioiTinh());
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
        dateNgaySinh = new com.ttt.datechooser.DateChooser();
        btnThem = new com.ttt.swing.Button();
        btnSua = new com.ttt.swing.Button();
        btnXoa = new com.ttt.swing.Button();
        btnFirst = new com.ttt.swing.Button();
        btnPrev = new com.ttt.swing.Button();
        btnNext = new com.ttt.swing.Button();
        btnLast = new com.ttt.swing.Button();
        btnXuatFile = new com.ttt.swing.Button();
        btnMoi = new com.ttt.swing.Button();
        panelBackground1 = new com.ttt.swing.PanelBackground();
        lblMaST5 = new javax.swing.JLabel();
        lblMaST6 = new javax.swing.JLabel();
        lblMaST = new javax.swing.JLabel();
        lblMaST1 = new javax.swing.JLabel();
        lblMaST2 = new javax.swing.JLabel();
        lblMaST7 = new javax.swing.JLabel();
        lblMaST8 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        txtManv = new javax.swing.JTextField();
        txtNgaysinh = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txtTennv = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtDiachi = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtMkx = new javax.swing.JPasswordField();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        txtMk = new javax.swing.JPasswordField();
        jSeparator9 = new javax.swing.JSeparator();
        txtEmail = new javax.swing.JTextField();
        button1 = new com.ttt.swing.Button();
        panelBackground2 = new com.ttt.swing.PanelBackground();
        cboPhongBan = new javax.swing.JComboBox<>();
        lblMaST3 = new javax.swing.JLabel();
        rdoAdmin = new javax.swing.JRadioButton();
        rdoTruongPhong = new javax.swing.JRadioButton();
        rdoNhanVien = new javax.swing.JRadioButton();
        lblMaST4 = new javax.swing.JLabel();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblNhanVien = new com.ttt.swing.TableDark();

        dateNgaySinh.setTextRefernce(txtNgaysinh);

        setPreferredSize(new java.awt.Dimension(902, 753));
        setLayout(null);

        btnThem.setBackground(new java.awt.Color(0, 51, 51));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });
        add(btnThem);
        btnThem.setBounds(30, 26, 70, 26);

        btnSua.setBackground(new java.awt.Color(0, 51, 51));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });
        add(btnSua);
        btnSua.setBounds(118, 26, 70, 26);

        btnXoa.setBackground(new java.awt.Color(0, 51, 51));
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("XÓA");
        btnXoa.setMaximumSize(new java.awt.Dimension(70, 26));
        btnXoa.setMinimumSize(new java.awt.Dimension(70, 26));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });
        add(btnXoa);
        btnXoa.setBounds(206, 26, 70, 26);

        btnFirst.setBackground(new java.awt.Color(0, 51, 51));
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });
        add(btnFirst);
        btnFirst.setBounds(280, 560, 31, 26);

        btnPrev.setBackground(new java.awt.Color(0, 51, 51));
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });
        add(btnPrev);
        btnPrev.setBounds(330, 560, 36, 26);

        btnNext.setBackground(new java.awt.Color(0, 51, 51));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(390, 560, 36, 26);

        btnLast.setBackground(new java.awt.Color(0, 51, 51));
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });
        add(btnLast);
        btnLast.setBounds(440, 560, 31, 26);

        btnXuatFile.setBackground(new java.awt.Color(0, 51, 51));
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });
        add(btnXuatFile);
        btnXuatFile.setBounds(720, 560, 70, 26);

        btnMoi.setBackground(new java.awt.Color(0, 51, 51));
        btnMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnMoi.setText("LÀM MỚI");
        btnMoi.setMaximumSize(new java.awt.Dimension(70, 26));
        btnMoi.setMinimumSize(new java.awt.Dimension(70, 26));
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });
        add(btnMoi);
        btnMoi.setBounds(294, 26, 71, 26);

        panelBackground1.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground1.setLayout(null);

        lblMaST5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST5.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST5.setText("Mã NV");
        panelBackground1.add(lblMaST5);
        lblMaST5.setBounds(30, 40, 42, 18);

        lblMaST6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST6.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST6.setText("Tên NV");
        panelBackground1.add(lblMaST6);
        lblMaST6.setBounds(30, 80, 46, 18);

        lblMaST.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST.setText("Địa chỉ");
        panelBackground1.add(lblMaST);
        lblMaST.setBounds(30, 120, 43, 18);

        lblMaST1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST1.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST1.setText("Email");
        panelBackground1.add(lblMaST1);
        lblMaST1.setBounds(40, 170, 34, 18);

        lblMaST2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST2.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST2.setText("Mật khẩu");
        panelBackground1.add(lblMaST2);
        lblMaST2.setBounds(20, 220, 58, 18);

        lblMaST7.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST7.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST7.setText("X.nhận MK");
        panelBackground1.add(lblMaST7);
        lblMaST7.setBounds(10, 270, 70, 18);

        lblMaST8.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST8.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST8.setText("Ngày sinh");
        panelBackground1.add(lblMaST8);
        lblMaST8.setBounds(10, 320, 90, 18);

        btnRefresh.setBackground(new java.awt.Color(0, 51, 51));
        btnRefresh.setIcon(new javax.swing.ImageIcon("D:\\SUMMER 2023\\Du An 1\\3tProject\\HiNoApp\\src\\com\\ttt\\icon\\Refresh.png")); // NOI18N
        btnRefresh.setBorderPainted(false);
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        panelBackground1.add(btnRefresh);
        btnRefresh.setBounds(340, 20, 30, 30);

        txtManv.setBackground(new java.awt.Color(0, 51, 51));
        txtManv.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtManv.setForeground(new java.awt.Color(204, 204, 204));
        txtManv.setBorder(null);
        panelBackground1.add(txtManv);
        txtManv.setBounds(90, 20, 250, 30);

        txtNgaysinh.setBackground(new java.awt.Color(0, 51, 51));
        txtNgaysinh.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtNgaysinh.setForeground(new java.awt.Color(102, 102, 102));
        txtNgaysinh.setBorder(null);
        txtNgaysinh.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNgaysinhFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNgaysinhFocusLost(evt);
            }
        });
        panelBackground1.add(txtNgaysinh);
        txtNgaysinh.setBounds(90, 300, 250, 30);

        jSeparator2.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator2);
        jSeparator2.setBounds(90, 90, 250, 10);

        jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator3);
        jSeparator3.setBounds(90, 50, 250, 10);

        txtTennv.setBackground(new java.awt.Color(0, 51, 51));
        txtTennv.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtTennv.setForeground(new java.awt.Color(204, 204, 204));
        txtTennv.setBorder(null);
        panelBackground1.add(txtTennv);
        txtTennv.setBounds(90, 60, 250, 30);

        jSeparator4.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator4);
        jSeparator4.setBounds(90, 130, 250, 10);

        txtDiachi.setBackground(new java.awt.Color(0, 51, 51));
        txtDiachi.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtDiachi.setForeground(new java.awt.Color(204, 204, 204));
        txtDiachi.setBorder(null);
        panelBackground1.add(txtDiachi);
        txtDiachi.setBounds(90, 100, 250, 30);

        jSeparator5.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator5);
        jSeparator5.setBounds(90, 180, 250, 10);

        txtMkx.setBackground(new java.awt.Color(0, 51, 51));
        txtMkx.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtMkx.setForeground(new java.awt.Color(102, 102, 102));
        txtMkx.setText("xacnhanmatkhau");
        txtMkx.setBorder(null);
        txtMkx.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMkxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMkxFocusLost(evt);
            }
        });
        panelBackground1.add(txtMkx);
        txtMkx.setBounds(90, 250, 250, 30);

        jSeparator7.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator7);
        jSeparator7.setBounds(90, 230, 250, 10);

        jSeparator8.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator8.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator8);
        jSeparator8.setBounds(90, 330, 250, 10);

        txtMk.setBackground(new java.awt.Color(0, 51, 51));
        txtMk.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtMk.setForeground(new java.awt.Color(102, 102, 102));
        txtMk.setText("matkhaumoi");
        txtMk.setBorder(null);
        txtMk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMkFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMkFocusLost(evt);
            }
        });
        panelBackground1.add(txtMk);
        txtMk.setBounds(90, 202, 250, 30);

        jSeparator9.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator9.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator9);
        jSeparator9.setBounds(90, 280, 250, 10);

        txtEmail.setBackground(new java.awt.Color(0, 51, 51));
        txtEmail.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(204, 204, 204));
        txtEmail.setBorder(null);
        panelBackground1.add(txtEmail);
        txtEmail.setBounds(90, 150, 250, 30);

        button1.setBackground(new java.awt.Color(0, 51, 51));
        button1.setText("...");
        panelBackground1.add(button1);
        button1.setBounds(340, 320, 30, 20);

        add(panelBackground1);
        panelBackground1.setBounds(420, 100, 380, 380);

        panelBackground2.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground2.setLayout(null);

        cboPhongBan.setBackground(new java.awt.Color(0, 51, 51));
        cboPhongBan.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cboPhongBan.setForeground(new java.awt.Color(255, 255, 255));
        cboPhongBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboPhongBan.setBorder(null);
        cboPhongBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhongBanActionPerformed(evt);
            }
        });
        panelBackground2.add(cboPhongBan);
        cboPhongBan.setBounds(60, 20, 250, 40);

        lblMaST3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST3.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST3.setText("Chức vụ");
        panelBackground2.add(lblMaST3);
        lblMaST3.setBounds(10, 80, 50, 18);

        btnGroupChucVu.add(rdoAdmin);
        rdoAdmin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoAdmin.setForeground(new java.awt.Color(153, 153, 153));
        rdoAdmin.setText("Admin");
        panelBackground2.add(rdoAdmin);
        rdoAdmin.setBounds(70, 80, 70, 21);

        btnGroupChucVu.add(rdoTruongPhong);
        rdoTruongPhong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoTruongPhong.setForeground(new java.awt.Color(153, 153, 153));
        rdoTruongPhong.setText("Trưởng phòng");
        panelBackground2.add(rdoTruongPhong);
        rdoTruongPhong.setBounds(70, 110, 110, 21);

        btnGroupChucVu.add(rdoNhanVien);
        rdoNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNhanVien.setForeground(new java.awt.Color(153, 153, 153));
        rdoNhanVien.setText("Nhân Viên");
        panelBackground2.add(rdoNhanVien);
        rdoNhanVien.setBounds(70, 140, 100, 21);

        lblMaST4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST4.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST4.setText("Giới tính");
        panelBackground2.add(lblMaST4);
        lblMaST4.setBounds(190, 80, 54, 18);

        btnGroupGioiTinh.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNam.setForeground(new java.awt.Color(153, 153, 153));
        rdoNam.setText("Nam");
        panelBackground2.add(rdoNam);
        rdoNam.setBounds(250, 80, 60, 21);

        btnGroupGioiTinh.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rdoNu.setForeground(new java.awt.Color(153, 153, 153));
        rdoNu.setText("Nữ");
        panelBackground2.add(rdoNu);
        rdoNu.setBounds(250, 120, 60, 21);

        lblHinh.setBackground(new java.awt.Color(0, 51, 51));
        lblHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinh.setText("Hình");
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );

        panelBackground2.add(jPanel1);
        jPanel1.setBounds(100, 180, 150, 180);

        add(panelBackground2);
        panelBackground2.setBounds(30, 100, 380, 380);

        txtTimKiem.setBackground(new java.awt.Color(0, 51, 51));
        txtTimKiem.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtTimKiem.setForeground(new java.awt.Color(153, 153, 153));
        txtTimKiem.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTimKiem.setText("Nhập tìm kiếm");
        txtTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtTimKiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimKiemFocusLost(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        add(txtTimKiem);
        txtTimKiem.setBounds(30, 550, 240, 40);

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null", "null", "null", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblNhanVien);

        add(jScrollPane3);
        jScrollPane3.setBounds(30, 600, 770, 150);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionActionPerformed
        String Option = evt.getActionCommand();
        String them = btnThem.getText();
        String sua = btnSua.getText();
        String xoa = btnXoa.getText();
        String moi = btnMoi.getText();
        String export = btnXuatFile.getText();
        if (Option.equals(them)) {
            insert();
        } else if (Option.equals(sua)) {
            update();
        } else if (Option.equals(xoa)) {
            delete();
        } else if (Option.equals(moi)) {
            clearForm();
        } else if (Option.equals(export)) {
            export_excel();
        }
    }//GEN-LAST:event_btnOptionActionPerformed

    private void btnLuaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuaChonActionPerformed
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
    }//GEN-LAST:event_btnLuaChonActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        chonAnh();
    }//GEN-LAST:event_lblHinhMouseClicked

    private void cboPhongBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPhongBanActionPerformed
        PhongBan pb = (PhongBan) cboPhongBan.getSelectedItem();

        if (pb != null) {
            if (pb.getMaPhongBan().startsWith("IT")) {
                rdoAdmin.setSelected(true);
                rdoAdmin.setEnabled(false);
                rdoNhanVien.setEnabled(false);
                rdoTruongPhong.setEnabled(false);
            } else {
                btnGroupChucVu.clearSelection();
                rdoAdmin.setEnabled(false);
                rdoNhanVien.setEnabled(true);
                rdoTruongPhong.setEnabled(true);
            }
            if (rdoAdmin.isSelected() == false) {
                rdoAdmin.addMouseListener(new MouseInputAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        DialogHelper.alert(null, "Không phân quyền Admin cho phòng ban này!");
                    }
                });
            }

        }


    }//GEN-LAST:event_cboPhongBanActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        layMaMoi();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void txtMkFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMkFocusGained
        if (new String(txtMk.getPassword()).equalsIgnoreCase("matkhaumoi")) {
            txtMk.setText("");
        }

        txtMk.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtMkFocusGained

    private void txtMkFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMkFocusLost
        if (new String(txtMk.getPassword()).equalsIgnoreCase("")) {
            txtMk.setText("matkhaumoi");
        }
        txtMk.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtMkFocusLost

    private void txtMkxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMkxFocusGained
        if (new String(txtMkx.getPassword()).equalsIgnoreCase("xacnhanmatkhau")) {
            txtMkx.setText("");
        }

        txtMkx.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtMkxFocusGained

    private void txtMkxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMkxFocusLost
        if (new String(txtMkx.getPassword()).equalsIgnoreCase("")) {
            txtMkx.setText("xacnhanmatkhau");
        }
        txtMkx.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtMkxFocusLost

    private void txtNgaysinhFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgaysinhFocusGained
   
        txtNgaysinh.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtNgaysinhFocusGained

    private void txtNgaysinhFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgaysinhFocusLost
        
        txtNgaysinh.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtNgaysinhFocusLost

    private void txtTimKiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusGained
        if (txtTimKiem.getText().equalsIgnoreCase("Nhập tìm kiếm")) {
            txtTimKiem.setText("");
        }

        txtTimKiem.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtTimKiemFocusGained

    private void txtTimKiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimKiemFocusLost
        if (txtTimKiem.getText().equalsIgnoreCase("")) {
            txtTimKiem.setText("Nhập tìm kiếm");
        }
        txtTimKiem.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_txtTimKiemFocusLost

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        timKiem();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblNhanVien.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblNhanVienMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.Button btnFirst;
    private javax.swing.ButtonGroup btnGroupChucVu;
    private javax.swing.ButtonGroup btnGroupGioiTinh;
    private com.ttt.swing.Button btnLast;
    private com.ttt.swing.Button btnMoi;
    private com.ttt.swing.Button btnNext;
    private com.ttt.swing.Button btnPrev;
    private javax.swing.JButton btnRefresh;
    private com.ttt.swing.Button btnSua;
    private com.ttt.swing.Button btnThem;
    private com.ttt.swing.Button btnXoa;
    private com.ttt.swing.Button btnXuatFile;
    private com.ttt.swing.Button button1;
    private javax.swing.JComboBox<String> cboPhongBan;
    private com.ttt.datechooser.DateChooser dateNgaySinh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblMaST;
    private javax.swing.JLabel lblMaST1;
    private javax.swing.JLabel lblMaST2;
    private javax.swing.JLabel lblMaST3;
    private javax.swing.JLabel lblMaST4;
    private javax.swing.JLabel lblMaST5;
    private javax.swing.JLabel lblMaST6;
    private javax.swing.JLabel lblMaST7;
    private javax.swing.JLabel lblMaST8;
    private com.ttt.swing.PanelBackground panelBackground1;
    private com.ttt.swing.PanelBackground panelBackground2;
    private javax.swing.JRadioButton rdoAdmin;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNhanVien;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdoTruongPhong;
    private com.ttt.swing.TableDark tblNhanVien;
    private javax.swing.JTextField txtDiachi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtManv;
    private javax.swing.JPasswordField txtMk;
    private javax.swing.JPasswordField txtMkx;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtTennv;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
