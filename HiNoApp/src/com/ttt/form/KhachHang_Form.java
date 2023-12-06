package com.ttt.form;

import com.ttt.DAO.KhachHangDAO;
import com.ttt.DAO.ThongKeDAO;
import com.ttt.Entity.KhachHang;
import com.ttt.LibaryHelper.Auth;
import com.ttt.LibaryHelper.DialogHelper;
import com.ttt.LibaryHelper.Search;
import com.ttt.component.Form;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class KhachHang_Form extends Form {

    public KhachHang_Form() {
        initComponents();
        init();
    }
    int row = -1;
    DefaultTableModel model;

    void init() {
        txtMaKH.setText(ThongKeDAO.getNewThongKeDAO().getMaKhachHang());
        this.initTable();
        this.fillTable();
        tblKhachHang.fixTable(jScrollPane1);
//        tblKhachHang.setColumnAlignment(0, JLabel.CENTER);
//        tblKhachHang.setCellAlignment(0, JLabel.CENTER);
//        tblKhachHang.setColumnAlignment(2, JLabel.CENTER);
//        tblKhachHang.setCellAlignment(2, JLabel.CENTER);
//        tblKhachHang.setColumnAlignment(4, JLabel.RIGHT);
//        tblKhachHang.setCellAlignment(4, JLabel.RIGHT);
//        tblKhachHang.setColumnWidth(0, 50);
//        tblKhachHang.setColumnWidth(2, 100);
        this.row = -1;
        //  this.updateStatus();
    }

    public void initTable() {
        model = (DefaultTableModel) tblKhachHang.getModel();
        model.setColumnIdentifiers(new String[]{"Mã KH", "Tên KH", "Địa chỉ", "Email", "Điện thoại", "MST"});
    }

    //Fill Dữ liệu vào Table
    void fillTable() {
        model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);

        try {
            List<KhachHang> list = KhachHangDAO.getNewKhachHangDAO().selectAll();
            for (KhachHang kh : list) {
                Object[] rows = {kh.getMaKhachHang(), kh.getTenKhanhHang(), kh.getDiaChi(), kh.getEmail(), kh.getSoDienThoai(), kh.getMaSoThue()};
                model.addRow(rows);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");

        }
    }

//    void fillTableByKeyword() {
//        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
//        model.setRowCount(0);
//        try {
//            String keyword = txtTimKiem.getText();
//            List<KhachHang> list = KhachHangDAO.getNewKhachHangDAO().selectByKeyword(keyword);
//            for (KhachHang kh : list) {
//                Object[] rows = {kh.getMaKhachHang(), kh.getTenKhanhHang(), kh.getDiaChi(), kh.getEmail(), kh.getSoDienThoai(), kh.getMaSoThue()};
//                model.addRow(rows);
//            }
//        } catch (Exception e) {
//            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
//        }
//    }
    boolean checkNull() {
        String patternName = "^[\\p{L}\\s]+$";
        //String patternEmail = "\\w+@\\w+(\\.\\w+){1,3}";

        if (txtTenKH.getText() == null || txtTenKH.getText().equalsIgnoreCase("")
                && (txtDiaChi.getText() == null || txtDiaChi.getText().equalsIgnoreCase(""))) {
            DialogHelper.alert(this, "Vui lòng nhập tên và địa chỉ khách hàng");
            return false;
        } else if (txtTenKH.getText() == null || txtTenKH.getText().equalsIgnoreCase("")) {
            DialogHelper.alert(this, "Vui lòng nhập tên Khách hàng");
            return false;
        } else if (!txtTenKH.getText().matches(patternName)) {
            DialogHelper.alert(this, "Họ tên khách hàng không hợp lệ");
            return false;
        } else if (txtDiaChi.getText() == null || txtDiaChi.getText().equalsIgnoreCase("")) {
            DialogHelper.alert(this, "Vui lòng nhập địa chỉ khách hàng");
            return false;
        }

        return true;
    }

    void setForm(KhachHang kh) {
        txtMaKH.setText(kh.getMaKhachHang());
        txtTenKH.setText(kh.getDiaChi());
        txtEmail.setText(kh.getEmail());
        txtMST.setText(kh.getMaSoThue());
        txtSDT.setText(kh.getSoDienThoai());
        txtTenKH.setText(kh.getTenKhanhHang());
        txtDiaChi.setText(kh.getDiaChi());

    }

    KhachHang getForm() {
        if (checkNull()) {
            KhachHang kh = new KhachHang();
            kh.setMaKhachHang(txtMaKH.getText());
            kh.setDiaChi(txtTenKH.getText());
            kh.setEmail(txtEmail.getText());
            kh.setMaSoThue(txtMST.getText());
            kh.setSoDienThoai(txtSDT.getText());
            kh.setTenKhanhHang(txtTenKH.getText());
            kh.setDiaChi(txtDiaChi.getText());
            return kh;
        }
        return null;
    }

    boolean CheckTrungMaKH(String maKH) {
        List<KhachHang> list = KhachHangDAO.getNewKhachHangDAO().selectAll();
        for (KhachHang kh : list) {
            if (kh.getMaKhachHang().equalsIgnoreCase(maKH)) {
                return true;
            }
        }
        return false;
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        txtMaKH.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);

    }

    void clearForm() {
        KhachHang kh = new KhachHang();
        this.setForm(kh);
        this.row = -1;
        this.updateStatus();
        txtMaKH.setText(ThongKeDAO.getNewThongKeDAO().getMaKhachHang());
        txtTimKiem.setText("Nhập tìm kiếm");
        this.fillTable();
    }

    void edit() {
        String maKH = (String) tblKhachHang.getValueAt(this.row, 0);
        KhachHang kh = KhachHangDAO.getNewKhachHangDAO().selectById(maKH);
        this.setForm(kh);
        this.updateStatus();
    }

    void insert() {
        KhachHang kh = this.getForm();
        if (kh != null) {
            if (CheckTrungMaKH(kh.getMaKhachHang())) {
                DialogHelper.alert(this, "Đã tồn tại mã loại xe: " + kh.getMaKhachHang());

            } else {
                try {
                    KhachHangDAO.getNewKhachHangDAO().insert(kh);
                    this.fillTable();
                    this.clearForm();
                    DialogHelper.alert(this, "Thêm mới thành công");
                } catch (Exception e) {
                    DialogHelper.alert(this, "Thêm mới thất bại");
                }
            }
        }

    }

    void update() {
        KhachHang kh = this.getForm();
        if (kh != null) {
            try {
                KhachHangDAO.getNewKhachHangDAO().update(kh);
                this.fillTable();
                DialogHelper.alert(this, "Cập nhật thành công");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại");

            }

        }

    }

    void delete() {
        if (!Auth.isManager()) {
            DialogHelper.alert(this, "Bạn không có quyền xóa khách hàng");
            return;
        }
        String ma = txtMaKH.getText();
        KhachHang kh = KhachHangDAO.getNewKhachHangDAO().selectById(ma);
        if (kh != null) {
            if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa chi nhánh " + ma)) {
                try {
                    KhachHangDAO.getNewKhachHangDAO().delete(ma);
                    this.fillTable();
                    this.clearForm();
                    DialogHelper.alert(this, "Xóa thành công");

                } catch (Exception e) {
                    DialogHelper.alert(this, "Đã tồn tại dữ liệu liên quan đến khách hàng. Không được xóa!");
                }
            }
        } else {
            DialogHelper.alert(this, "Khách hàng " + ma + " chưa có trong cơ sở dữ liệu. Vui lòng chọn khách hàng khác!");
        }

    }

    void timKiem() {
        String key = txtTimKiem.getText();
        if (key.contains("*") || key.contains("(") || key.contains(")") || key.contains("[") || key.contains("]")) {
            return;
        }
        Search.search(tblKhachHang, key);
    }

    void first() {
        this.row = 0;
        this.edit();
        tblKhachHang.setRowSelectionInterval(this.row, this.row);
    }

    void next() {

        if (this.row < tblKhachHang.getRowCount() - 1) {
            this.row++;
            this.edit();

        } else {
            first();

        }
        tblKhachHang.setRowSelectionInterval(this.row, this.row);

    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();

        } else {
            last();

        }
        tblKhachHang.setRowSelectionInterval(this.row, this.row);

    }

    void last() {
        this.row = tblKhachHang.getRowCount() - 1;
        this.edit();
        tblKhachHang.setRowSelectionInterval(this.row, this.row);
    }

    void export_excel() {
        try {
            JFileChooser jfileChooser = new JFileChooser();
            jfileChooser.showSaveDialog(this);
            File saveFile = jfileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("chinhanh");
                XSSFRow row = null;
                Cell cell = null;
                row = sheet.createRow(1);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("MaKH");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("TenKH");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("DiaChi");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("Email");
                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue("soDienThoai");
                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue("maSoThue");
                List<KhachHang> arr = KhachHangDAO.getNewKhachHangDAO().selectAll();
                for (int i = 0; i < arr.size(); i++) {
                    // LoaiXe cn = arr.get(i);
                    row = sheet.createRow(2 + i);

                    cell = row.createCell(0, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaKhachHang());
                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(arr.get(i).getTenKhanhHang());
                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue(arr.get(i).getDiaChi());
                    cell = row.createCell(3, CellType.STRING);
                    cell.setCellValue(arr.get(i).getEmail());
                    cell = row.createCell(4, CellType.STRING);
                    cell.setCellValue(arr.get(i).getSoDienThoai());
                    cell = row.createCell(5, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaSoThue());

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
        txtEmail = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtSDT = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtMST = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        lblMaST1 = new javax.swing.JLabel();
        lblMaST5 = new javax.swing.JLabel();
        lblMaST4 = new javax.swing.JLabel();
        panelBackground2 = new com.ttt.swing.PanelBackground();
        txtMaKH = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        txtTenKH = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        txtDiaChi = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        lblMaST3 = new javax.swing.JLabel();
        lblMaST2 = new javax.swing.JLabel();
        lblMaST = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new com.ttt.swing.TableDark();

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
        btnThem.setBounds(17, 28, 70, 26);

        btnSua.setBackground(new java.awt.Color(0, 51, 51));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });
        add(btnSua);
        btnSua.setBounds(105, 28, 70, 26);

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
        btnXoa.setBounds(193, 28, 70, 26);

        btnFirst.setBackground(new java.awt.Color(0, 51, 51));
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });
        add(btnFirst);
        btnFirst.setBounds(300, 350, 31, 26);

        btnPrev.setBackground(new java.awt.Color(0, 51, 51));
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });
        add(btnPrev);
        btnPrev.setBounds(340, 350, 36, 26);

        btnNext.setBackground(new java.awt.Color(0, 51, 51));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(390, 350, 36, 26);

        btnLast.setBackground(new java.awt.Color(0, 51, 51));
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });
        add(btnLast);
        btnLast.setBounds(440, 350, 31, 26);

        btnXuatFile.setBackground(new java.awt.Color(0, 51, 51));
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });
        add(btnXuatFile);
        btnXuatFile.setBounds(713, 350, 70, 26);

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
        btnMoi.setBounds(281, 28, 71, 26);

        panelBackground1.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground1.setLayout(null);

        txtEmail.setBackground(new java.awt.Color(0, 51, 51));
        txtEmail.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(204, 204, 204));
        txtEmail.setBorder(null);
        panelBackground1.add(txtEmail);
        txtEmail.setBounds(90, 10, 250, 30);

        jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator3);
        jSeparator3.setBounds(90, 40, 250, 10);

        txtSDT.setBackground(new java.awt.Color(0, 51, 51));
        txtSDT.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtSDT.setForeground(new java.awt.Color(204, 204, 204));
        txtSDT.setBorder(null);
        panelBackground1.add(txtSDT);
        txtSDT.setBounds(90, 60, 250, 30);

        jSeparator4.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator4);
        jSeparator4.setBounds(90, 90, 250, 10);

        txtMST.setBackground(new java.awt.Color(0, 51, 51));
        txtMST.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtMST.setForeground(new java.awt.Color(204, 204, 204));
        txtMST.setBorder(null);
        panelBackground1.add(txtMST);
        txtMST.setBounds(90, 110, 250, 30);

        jSeparator5.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator5);
        jSeparator5.setBounds(90, 140, 250, 10);

        lblMaST1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST1.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST1.setText("MST");
        panelBackground1.add(lblMaST1);
        lblMaST1.setBounds(50, 120, 27, 18);

        lblMaST5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST5.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST5.setText("Điện thoại");
        panelBackground1.add(lblMaST5);
        lblMaST5.setBounds(10, 70, 65, 18);

        lblMaST4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST4.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST4.setText("Email");
        panelBackground1.add(lblMaST4);
        lblMaST4.setBounds(40, 20, 34, 18);

        add(panelBackground1);
        panelBackground1.setBounds(390, 100, 350, 180);

        panelBackground2.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground2.setLayout(null);

        txtMaKH.setEditable(false);
        txtMaKH.setBackground(new java.awt.Color(0, 51, 51));
        txtMaKH.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtMaKH.setForeground(new java.awt.Color(204, 204, 204));
        txtMaKH.setBorder(null);
        txtMaKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtKhongDuocSuaMouseClicked(evt);
            }
        });
        panelBackground2.add(txtMaKH);
        txtMaKH.setBounds(70, 10, 250, 30);

        jSeparator6.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator6.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground2.add(jSeparator6);
        jSeparator6.setBounds(70, 40, 250, 10);

        txtTenKH.setBackground(new java.awt.Color(0, 51, 51));
        txtTenKH.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtTenKH.setForeground(new java.awt.Color(204, 204, 204));
        txtTenKH.setBorder(null);
        panelBackground2.add(txtTenKH);
        txtTenKH.setBounds(70, 60, 250, 30);

        jSeparator7.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground2.add(jSeparator7);
        jSeparator7.setBounds(70, 90, 250, 10);

        txtDiaChi.setBackground(new java.awt.Color(0, 51, 51));
        txtDiaChi.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtDiaChi.setForeground(new java.awt.Color(204, 204, 204));
        txtDiaChi.setBorder(null);
        panelBackground2.add(txtDiaChi);
        txtDiaChi.setBounds(70, 110, 250, 30);

        jSeparator8.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator8.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground2.add(jSeparator8);
        jSeparator8.setBounds(70, 140, 250, 10);

        lblMaST3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST3.setForeground(new java.awt.Color(153, 0, 0));
        lblMaST3.setText("Mã KH");
        panelBackground2.add(lblMaST3);
        lblMaST3.setBounds(20, 20, 41, 20);

        lblMaST2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST2.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST2.setText("Tên KH");
        panelBackground2.add(lblMaST2);
        lblMaST2.setBounds(20, 70, 45, 20);

        lblMaST.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST.setText("Địa chỉ");
        panelBackground2.add(lblMaST);
        lblMaST.setBounds(20, 120, 43, 20);

        add(panelBackground2);
        panelBackground2.setBounds(30, 100, 350, 180);

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
        txtTimKiem.setBounds(30, 340, 240, 40);

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        add(jScrollPane1);
        jScrollPane1.setBounds(30, 400, 750, 210);
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

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblKhachHang.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void txtKhongDuocSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtKhongDuocSuaMouseClicked
        if (evt.getClickCount() == 2) {
            DialogHelper.alert(this, "Không được sửa!");
        }
    }//GEN-LAST:event_txtKhongDuocSuaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.Button btnFirst;
    private com.ttt.swing.Button btnLast;
    private com.ttt.swing.Button btnMoi;
    private com.ttt.swing.Button btnNext;
    private com.ttt.swing.Button btnPrev;
    private com.ttt.swing.Button btnSua;
    private com.ttt.swing.Button btnThem;
    private com.ttt.swing.Button btnXoa;
    private com.ttt.swing.Button btnXuatFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JLabel lblMaST;
    private javax.swing.JLabel lblMaST1;
    private javax.swing.JLabel lblMaST2;
    private javax.swing.JLabel lblMaST3;
    private javax.swing.JLabel lblMaST4;
    private javax.swing.JLabel lblMaST5;
    private com.ttt.swing.PanelBackground panelBackground1;
    private com.ttt.swing.PanelBackground panelBackground2;
    private com.ttt.swing.TableDark tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMST;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
