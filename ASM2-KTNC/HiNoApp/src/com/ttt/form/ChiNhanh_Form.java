package com.ttt.form;

import com.ttt.DAO.ChiNhanhDAO;
import com.ttt.Entity.ChiNhanh;
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
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ChiNhanh_Form extends Form {

    public ChiNhanh_Form() {
        initComponents();
        init();
    }
    int row = -1;
    DefaultTableModel model;

    void init() {
        this.initTable();
        this.fillTable();
        tblChiNhanh.fixTable(jScrollPane2);
        this.row = -1;
        //this.updateStatus();
    }

    public void initTable() {
        model = (DefaultTableModel) tblChiNhanh.getModel();
        model.setColumnIdentifiers(new String[]{"Mã chi nhánh", "Tên chi nhánh", "MST", "Địa chỉ"});
    }

    void fillTable() {
        model = (DefaultTableModel) tblChiNhanh.getModel();
        model.setRowCount(0);
        try {
            List<ChiNhanh> list = ChiNhanhDAO.getNewChiNhanhDAO().selectAll();
            for (ChiNhanh nv : list) {
                Object[] rows = {nv.getMaChiNhanh(), nv.getTenChiNhanh(), nv.getMaSoThue(), nv.getDiaChi()};
                model.addRow(rows);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void fillTableByKeyword() {
        DefaultTableModel model = (DefaultTableModel) tblChiNhanh.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtTimKiem.getText();
            List<ChiNhanh> list = ChiNhanhDAO.getNewChiNhanhDAO().selectByKeyword(keyword);
            for (ChiNhanh nv : list) {
                Object[] rows = {nv.getMaChiNhanh(), nv.getTenChiNhanh(), nv.getMaSoThue(), nv.getDiaChi()};
                model.addRow(rows);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void setForm(ChiNhanh nv) {
        txtMaChiNhanh.setText(nv.getMaChiNhanh());
        txtTenChiNhanh.setText(nv.getTenChiNhanh());
        txtMaSoThue.setText(nv.getMaSoThue());
        txtDiaChi.setText(nv.getDiaChi());
    }

    ChiNhanh getForm() {
        if (checkNull()) {
            ChiNhanh nv = new ChiNhanh();
            nv.setMaChiNhanh(txtMaChiNhanh.getText());
            nv.setTenChiNhanh(txtTenChiNhanh.getText());
            nv.setMaSoThue(txtMaSoThue.getText());
            nv.setDiaChi(txtDiaChi.getText());
            return nv;
        }
        return null;
    }

    boolean checkNull() {
        int flag_ma = 0;
        int flag_ten = 0;
        int flag_mst = 0;
        int flag_diaChi = 0;

        if (txtMaChiNhanh.getText().length() < 3 || txtMaChiNhanh.getText().length() > 7) {
            flag_ma = 1;
        }
        if (txtTenChiNhanh.getText() == null || txtTenChiNhanh.getText().equalsIgnoreCase("")) {
            flag_ten = 1;
        }
        if (txtMaSoThue.getText().length() < 10 || txtMaSoThue.getText().length() > 14) {
            flag_mst = 1;
        }
        if (txtDiaChi.getText() == null || txtDiaChi.getText().equalsIgnoreCase("")) {
            flag_diaChi = 1;
        }
        if (flag_ma == 1 && flag_ten == 1 && flag_mst == 1 && flag_diaChi == 1) {
            DialogHelper.alert(this, "Vui lòng kiểm tra lại thông tin");
            return false;
        } else if (flag_ten == 1 && flag_mst == 1 && flag_diaChi == 1) {
            DialogHelper.alert(this, "Chưa nhập đủ thông tin");
            return false;
        } else if (flag_mst == 1 && flag_diaChi == 1) {
            DialogHelper.alert(this, "Chưa nhập đủ thông tin");
            return false;
        } else if (flag_ma == 1) {
            DialogHelper.alert(this, "Vui lòng nhập mã chi nhánh từ 3 đến 7 ký tự");
            return false;
        } else if (flag_ten == 1) {
            DialogHelper.alert(this, "Vui lòng nhập tên chi nhánh");
            return false;
        } else if (flag_mst == 1) {
            DialogHelper.alert(this, "Vui lòng nhập mã số thuế từ 10 đến 14 ký tự");
            return false;
        } else if (flag_diaChi == 1) {
            DialogHelper.alert(this, "Vui lòng nhập địa chỉ chi nhánh");
            return false;
        } else {
            return true;
        }
    }

    boolean checkTrungMaNV(String maNV) {
        List<ChiNhanh> list = ChiNhanhDAO.getNewChiNhanhDAO().selectAll();
        for (ChiNhanh nv : list) {
            if (nv.getMaChiNhanh().equalsIgnoreCase(maNV)) {
                return true;
            }

        }
        return false;
    }

    void lamMoi() {
        txtMaChiNhanh.setText("");
        txtTenChiNhanh.setText("");
        txtMaSoThue.setText("");
        txtDiaChi.setText("");
        txtTimKiem.setText("Nhập tìm kiếm");
        this.row = -1;
        this.fillTable();
    }

    void insert() {

        ChiNhanh nv = this.getForm();
        if (nv != null) {
            if (checkTrungMaNV(nv.getMaChiNhanh())) {
                if (DialogHelper.confirm(this, "Đã tồn tại mã chi nhánh " + nv.getMaChiNhanh() + " .Bạn có muốn cập nhật không?")) {
                    update();
                }
            } else {
                try {
                    ChiNhanhDAO.getNewChiNhanhDAO().insert(nv);
                    this.fillTable();
                    this.lamMoi();
                    DialogHelper.alert(this, "Thêm mới thành công");

                } catch (Exception e) {
                    DialogHelper.alert(this, "Thêm mới thất bại");
                }
            }
        }

    }

    void update() {
        ChiNhanh nv = this.getForm();
        if (nv != null) {
            ChiNhanh cn2 = ChiNhanhDAO.getNewChiNhanhDAO().selectById(nv.getMaChiNhanh());
            if (cn2 == null) {
                if (DialogHelper.confirm(this, "Chưa có mã chi nhánh " + nv.getMaChiNhanh() + " .Bạn có muốn thêm chi nhánh không?")) {
                    insert();
                }
            } else {
                try {
                    ChiNhanhDAO.getNewChiNhanhDAO().update(nv);
                    this.fillTable();
                    DialogHelper.alert(this, "Cập nhật thành công");
                } catch (Exception e) {
                    DialogHelper.alert(this, "Cập nhật thất bại");
                }
            }

        }
    }

    void delete() {
        if (!Auth.isManager()) {
            DialogHelper.alert(this, "Bạn không có quyền xóa Chi nhánh");
        } else {
            String ma = txtMaChiNhanh.getText();
            ChiNhanh cn = ChiNhanhDAO.getNewChiNhanhDAO().selectById(ma);
            if (cn != null) {
                if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa chi nhánh " + ma)) {
                    try {
                        ChiNhanhDAO.getNewChiNhanhDAO().delete(ma);
                        this.fillTable();
                        this.lamMoi();
                        DialogHelper.alert(this, "Xóa thành công");
                    } catch (Exception e) {
                        DialogHelper.alert(this, "Chi nhánh đã tồn tại dữ liệu. Không được xóa!");
                    }

                }
            } else {
                DialogHelper.alert(this, "Chưa có chi nhánh " + ma);
            }

        }
    }

    void timKiem() {
        String key = txtTimKiem.getText();
        if (key.contains("*") || key.contains("(") || key.contains(")") || key.contains("[") || key.contains("]")) {
            return;
        }
        Search.search(tblChiNhanh, key);
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
                cell.setCellValue("MaCN");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("TenCN");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("MaSoThue");
                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue("DiaChi");
                List<ChiNhanh> arr = ChiNhanhDAO.getNewChiNhanhDAO().selectAll();
                for (int i = 0; i < arr.size(); i++) {
                    //  ChiNhanh cn = arr.get(i);
                    row = sheet.createRow(2 + i);

                    cell = row.createCell(0, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaChiNhanh());
                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(arr.get(i).getTenChiNhanh());
                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaSoThue());
                    cell = row.createCell(3, CellType.STRING);
                    cell.setCellValue(arr.get(i).getDiaChi());
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

    void edit() {
        String macn = (String) tblChiNhanh.getValueAt(this.row, 0);
        ChiNhanh nv = ChiNhanhDAO.getNewChiNhanhDAO().selectById(macn);
        this.setForm(nv);
        //this.updateStatus();
    }

    void first() {
        this.row = 0;
        this.edit();
        tblChiNhanh.setRowSelectionInterval(this.row, this.row);
    }

    void next() {

        if (this.row < tblChiNhanh.getRowCount() - 1) {
            this.row++;
            this.edit();

        } else {
            first();

        }
        tblChiNhanh.setRowSelectionInterval(this.row, this.row);

    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();

        } else {
            last();

        }
        tblChiNhanh.setRowSelectionInterval(this.row, this.row);

    }

    void last() {
        this.row = tblChiNhanh.getRowCount() - 1;
        this.edit();
        tblChiNhanh.setRowSelectionInterval(this.row, this.row);

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
        txtMaChiNhanh = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        txtTenChiNhanh = new javax.swing.JTextField();
        txtMaSoThue = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtDiaChi = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        lblMaCN = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblMaST = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiNhanh = new com.ttt.swing.TableDark();

        setLayout(null);

        btnThem.setBackground(new java.awt.Color(0, 51, 51));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionsActionPerformed(evt);
            }
        });
        add(btnThem);
        btnThem.setBounds(17, 28, 70, 26);

        btnSua.setBackground(new java.awt.Color(0, 51, 51));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionsActionPerformed(evt);
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
                btnOptionsActionPerformed(evt);
            }
        });
        add(btnXoa);
        btnXoa.setBounds(193, 28, 70, 26);

        btnFirst.setBackground(new java.awt.Color(0, 51, 51));
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlsActionPerformed(evt);
            }
        });
        add(btnFirst);
        btnFirst.setBounds(290, 370, 31, 26);

        btnPrev.setBackground(new java.awt.Color(0, 51, 51));
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlsActionPerformed(evt);
            }
        });
        add(btnPrev);
        btnPrev.setBounds(330, 370, 36, 26);

        btnNext.setBackground(new java.awt.Color(0, 51, 51));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlsActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(380, 370, 36, 26);

        btnLast.setBackground(new java.awt.Color(0, 51, 51));
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlsActionPerformed(evt);
            }
        });
        add(btnLast);
        btnLast.setBounds(430, 370, 31, 26);

        btnXuatFile.setBackground(new java.awt.Color(0, 51, 51));
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionsActionPerformed(evt);
            }
        });
        add(btnXuatFile);
        btnXuatFile.setBounds(740, 370, 70, 26);

        btnMoi.setBackground(new java.awt.Color(0, 51, 51));
        btnMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnMoi.setText("LÀM MỚI");
        btnMoi.setMaximumSize(new java.awt.Dimension(70, 26));
        btnMoi.setMinimumSize(new java.awt.Dimension(70, 26));
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionsActionPerformed(evt);
            }
        });
        add(btnMoi);
        btnMoi.setBounds(281, 28, 71, 26);

        panelBackground1.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground1.setLayout(null);

        txtMaChiNhanh.setBackground(new java.awt.Color(0, 51, 51));
        txtMaChiNhanh.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtMaChiNhanh.setForeground(new java.awt.Color(204, 204, 204));
        txtMaChiNhanh.setBorder(null);
        panelBackground1.add(txtMaChiNhanh);
        txtMaChiNhanh.setBounds(180, 10, 250, 30);

        jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator3);
        jSeparator3.setBounds(180, 40, 250, 10);

        jSeparator4.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator4);
        jSeparator4.setBounds(180, 90, 250, 10);

        txtTenChiNhanh.setBackground(new java.awt.Color(0, 51, 51));
        txtTenChiNhanh.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtTenChiNhanh.setForeground(new java.awt.Color(204, 204, 204));
        txtTenChiNhanh.setBorder(null);
        panelBackground1.add(txtTenChiNhanh);
        txtTenChiNhanh.setBounds(180, 60, 250, 30);

        txtMaSoThue.setBackground(new java.awt.Color(0, 51, 51));
        txtMaSoThue.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtMaSoThue.setForeground(new java.awt.Color(204, 204, 204));
        txtMaSoThue.setBorder(null);
        panelBackground1.add(txtMaSoThue);
        txtMaSoThue.setBounds(180, 110, 250, 30);

        jSeparator5.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator5);
        jSeparator5.setBounds(180, 140, 250, 10);

        txtDiaChi.setBackground(new java.awt.Color(0, 51, 51));
        txtDiaChi.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtDiaChi.setForeground(new java.awt.Color(204, 204, 204));
        txtDiaChi.setBorder(null);
        panelBackground1.add(txtDiaChi);
        txtDiaChi.setBounds(180, 160, 250, 30);

        jSeparator7.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator7);
        jSeparator7.setBounds(180, 190, 250, 10);

        lblMaCN.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaCN.setForeground(new java.awt.Color(255, 0, 51));
        lblMaCN.setText("Mã chi nhánh");
        panelBackground1.add(lblMaCN);
        lblMaCN.setBounds(80, 30, 84, 18);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Tên chi nhánh");
        panelBackground1.add(jLabel2);
        jLabel2.setBounds(80, 80, 88, 18);

        lblMaST.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST.setText("Mã số thuế");
        panelBackground1.add(lblMaST);
        lblMaST.setBounds(90, 130, 69, 18);

        lblDiaChi.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblDiaChi.setForeground(new java.awt.Color(255, 0, 51));
        lblDiaChi.setText("Địa chỉ");
        panelBackground1.add(lblDiaChi);
        lblDiaChi.setBounds(110, 180, 43, 18);

        add(panelBackground1);
        panelBackground1.setBounds(160, 100, 516, 225);

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
        txtTimKiem.setBounds(20, 360, 240, 40);

        tblChiNhanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChiNhanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiNhanhMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblChiNhanh);

        add(jScrollPane2);
        jScrollPane2.setBounds(20, 450, 790, 160);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionsActionPerformed
        String Option = evt.getActionCommand();
        String them = btnThem.getText();
        String sua = btnSua.getText();
        String xoa = btnXoa.getText();
        String moi = btnMoi.getText();
        // String timKiem = btnTimKiem.getText();
        String export = btnXuatFile.getText();
        if (Option.equals(them)) {
            insert();
        } else if (Option.equals(sua)) {
            update();
        } else if (Option.equals(xoa)) {
            delete();
        } else if (Option.equals(moi)) {
            lamMoi();
        } else if (Option.equals(export)) {
            export_excel();
        }
    }//GEN-LAST:event_btnOptionsActionPerformed

    private void btnControlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnControlsActionPerformed
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
    }//GEN-LAST:event_btnControlsActionPerformed

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

    private void tblChiNhanhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiNhanhMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblChiNhanh.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblChiNhanhMouseClicked

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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblMaCN;
    private javax.swing.JLabel lblMaST;
    private com.ttt.swing.PanelBackground panelBackground1;
    private com.ttt.swing.TableDark tblChiNhanh;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaChiNhanh;
    private javax.swing.JTextField txtMaSoThue;
    private javax.swing.JTextField txtTenChiNhanh;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
