package com.ttt.form;

import com.ttt.DAO.LoaiXeDAO;
import com.ttt.Entity.LoaiXe;
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

public class LoaiXe_Form extends Form {

    public LoaiXe_Form() {
        initComponents();
        init();
    }
    int row = -1;
    DefaultTableModel model;

    void init() {
        this.initTable();
        this.fillTable();
        tblLoaiXe.fixTable(jScrollPane2);
        this.row = -1;
        //  this.updateStatus();
    }

    //Fill Dữ liệu vào Table
    public void initTable() {
        model = (DefaultTableModel) tblLoaiXe.getModel();
        model.setColumnIdentifiers(new String[]{"Mã loại xe", "Dòng xe", "Tên loại xe"});
    }

    void fillTable() {
        model = (DefaultTableModel) tblLoaiXe.getModel();
        model.setRowCount(0);

        try {
            List<LoaiXe> list = LoaiXeDAO.getNewLoaiXeDAO().selectAll();
            for (LoaiXe lx : list) {
                Object[] rows = {lx.getMaLoaiXe(), lx.getDongXe(), lx.getTenLoaiXe()};
                model.addRow(rows);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");

        }
    }

    void fillTableByKeyword() {
        DefaultTableModel model = (DefaultTableModel) tblLoaiXe.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtTim.getText();
            List<LoaiXe> list = LoaiXeDAO.getNewLoaiXeDAO().selectByKeyword(keyword);
            for (LoaiXe lx : list) {
                Object[] rows = {lx.getMaLoaiXe(), lx.getDongXe(), lx.getTenLoaiXe()};
                model.addRow(rows);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void setForm(LoaiXe lx) {
        txtMaLoaiXe.setText(lx.getMaLoaiXe());
        txtDongXe.setText(lx.getDongXe());
        txtTenLoaiXe.setText(lx.getTenLoaiXe());

    }

    boolean checkNull() {
        if (txtMaLoaiXe.getText() == null || txtMaLoaiXe.getText().equalsIgnoreCase("")
                && txtDongXe.getText() == null || txtDongXe.getText().equalsIgnoreCase("")
                && txtTenLoaiXe.getText() == null || txtTenLoaiXe.getText().equalsIgnoreCase("")) {
            DialogHelper.alert(this, "Vui lòng nhập thông tin");
            return false;
        } else if (txtMaLoaiXe.getText() == null || txtMaLoaiXe.getText().equalsIgnoreCase("")) {
            DialogHelper.alert(this, "Vui lòng nhập mã loại xe");
            return false;
        } else if (txtDongXe.getText() == null || txtDongXe.getText().equalsIgnoreCase("")) {
            DialogHelper.alert(this, "Vui lòng nhập dòng xe");
            return false;
        } else if (txtTenLoaiXe.getText() == null || txtTenLoaiXe.getText().equalsIgnoreCase("")) {
            DialogHelper.alert(this, "Vui lòng tên loại xe");
            return false;
        }
        return true;
    }

    LoaiXe getForm() {
        if (checkNull()) {
            LoaiXe lx = new LoaiXe();
            lx.setMaLoaiXe(txtMaLoaiXe.getText());
            lx.setDongXe(txtDongXe.getText());
            lx.setTenLoaiXe(txtTenLoaiXe.getText());
            return lx;
        }
        return null;
    }

    // CHECK
    boolean CheckTrungMaLX(String maLX) {
        List<LoaiXe> list = LoaiXeDAO.getNewLoaiXeDAO().selectAll();
        for (LoaiXe lx : list) {
            if (lx.getMaLoaiXe().equalsIgnoreCase(maLX)) {
                System.out.println("Mã Đã Tồn Tại!!");
                return true;
            }
        }
        return false;
    }

    void updateStatus() {
        boolean edit = (this.row >= 0);
        txtMaLoaiXe.setEditable(!edit);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);

    }

    void clearForm() {
        LoaiXe lx = new LoaiXe();
        this.setForm(lx);
        this.row = -1;
        this.updateStatus();
        txtTim.setText("Nhập tìm kiếm");
    }

    void edit() {
        String maLX = (String) tblLoaiXe.getValueAt(this.row, 0);
        LoaiXe lx = LoaiXeDAO.getNewLoaiXeDAO().selectById(maLX);
        this.setForm(lx);
        this.updateStatus();
    }

    void insert() {
        LoaiXe lx = this.getForm();
        if (lx != null) {
            if (CheckTrungMaLX(lx.getMaLoaiXe())) {
                DialogHelper.alert(this, "Đã tồn tại mã loại xe: " + lx.getMaLoaiXe());

            } else {
                try {
                    LoaiXeDAO.getNewLoaiXeDAO().insert(lx);
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
        LoaiXe lx = this.getForm();
        if (lx != null) {
            try {
                LoaiXeDAO.getNewLoaiXeDAO().update(lx);
                this.fillTable();
                DialogHelper.alert(this, "Cập nhật thành công");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại");

            }

        }

    }

    void delete() {
        if (!Auth.isManager()) {
            DialogHelper.alert(this, "Bạn không có quyền xóa loại xe");
            return;
        }
        String ma = txtMaLoaiXe.getText();
        LoaiXe lx = LoaiXeDAO.getNewLoaiXeDAO().selectById(ma);
        if (lx != null) {
            if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa loại xe " + ma)) {
                try {
                    LoaiXeDAO.getNewLoaiXeDAO().delete(ma);
                    this.fillTable();
                    this.clearForm();
                    DialogHelper.alert(this, "Xóa thành công");

                } catch (Exception e) {
                    DialogHelper.alert(this, "Đã tồn tại dữ liệu liên quan đến loại xe này. Không được xóa!");
                }
            }
        } else {
            DialogHelper.alert(this, "Không tồn tại loại xe " + ma);
        }

    }

    void timKiem() {
        String key = txtTim.getText();
        if (key.contains("*") || key.contains("(") || key.contains(")") || key.contains("[") || key.contains("]")) {
            return;
        }
        Search.search(tblLoaiXe, key);
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
                cell.setCellValue("MaLX");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("DongXe");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("TenLoaiXe");
                List<LoaiXe> arr = LoaiXeDAO.getNewLoaiXeDAO().selectAll();
                for (int i = 0; i < arr.size(); i++) {
                    // LoaiXe cn = arr.get(i);
                    row = sheet.createRow(2 + i);

                    cell = row.createCell(0, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaLoaiXe());
                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(arr.get(i).getDongXe());
                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue(arr.get(i).getTenLoaiXe());

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

    void first() {
        this.row = 0;
        this.edit();
        tblLoaiXe.setRowSelectionInterval(this.row, this.row);
    }

    void next() {

        if (this.row < tblLoaiXe.getRowCount() - 1) {
            this.row++;
            this.edit();

        } else {
            first();

        }
        tblLoaiXe.setRowSelectionInterval(this.row, this.row);

    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();

        } else {
            last();

        }
        tblLoaiXe.setRowSelectionInterval(this.row, this.row);

    }

    void last() {
        this.row = tblLoaiXe.getRowCount() - 1;
        this.edit();
        tblLoaiXe.setRowSelectionInterval(this.row, this.row);

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
        btnLamMoi = new com.ttt.swing.Button();
        panelBackground1 = new com.ttt.swing.PanelBackground();
        txtMaLoaiXe = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtDongXe = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtTenLoaiXe = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        lbMaLoaiXe = new javax.swing.JLabel();
        lbDongXe = new javax.swing.JLabel();
        lblMaST = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLoaiXe = new com.ttt.swing.TableDark();

        setLayout(null);

        btnThem.setBackground(new java.awt.Color(0, 51, 51));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });
        add(btnThem);
        btnThem.setBounds(17, 28, 70, 26);

        btnSua.setBackground(new java.awt.Color(0, 51, 51));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
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
                btnLuaChonActionPerformed(evt);
            }
        });
        add(btnXoa);
        btnXoa.setBounds(193, 28, 70, 26);

        btnFirst.setBackground(new java.awt.Color(0, 51, 51));
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlActionPerformed(evt);
            }
        });
        add(btnFirst);
        btnFirst.setBounds(293, 302, 31, 26);

        btnPrev.setBackground(new java.awt.Color(0, 51, 51));
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlActionPerformed(evt);
            }
        });
        add(btnPrev);
        btnPrev.setBounds(336, 302, 36, 26);

        btnNext.setBackground(new java.awt.Color(0, 51, 51));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlActionPerformed(evt);
            }
        });
        add(btnNext);
        btnNext.setBounds(384, 302, 36, 26);

        btnLast.setBackground(new java.awt.Color(0, 51, 51));
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnControlActionPerformed(evt);
            }
        });
        add(btnLast);
        btnLast.setBounds(432, 302, 31, 26);

        btnXuatFile.setBackground(new java.awt.Color(0, 51, 51));
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });
        add(btnXuatFile);
        btnXuatFile.setBounds(737, 302, 70, 26);

        btnLamMoi.setBackground(new java.awt.Color(0, 51, 51));
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.setMaximumSize(new java.awt.Dimension(70, 26));
        btnLamMoi.setMinimumSize(new java.awt.Dimension(70, 26));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });
        add(btnLamMoi);
        btnLamMoi.setBounds(281, 28, 71, 26);

        panelBackground1.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground1.setLayout(null);

        txtMaLoaiXe.setBackground(new java.awt.Color(0, 51, 51));
        txtMaLoaiXe.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtMaLoaiXe.setForeground(new java.awt.Color(204, 204, 204));
        txtMaLoaiXe.setBorder(null);
        panelBackground1.add(txtMaLoaiXe);
        txtMaLoaiXe.setBounds(100, 30, 250, 30);

        jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator3);
        jSeparator3.setBounds(100, 60, 250, 10);

        txtDongXe.setBackground(new java.awt.Color(0, 51, 51));
        txtDongXe.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtDongXe.setForeground(new java.awt.Color(204, 204, 204));
        txtDongXe.setBorder(null);
        panelBackground1.add(txtDongXe);
        txtDongXe.setBounds(100, 70, 250, 30);

        jSeparator2.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator2);
        jSeparator2.setBounds(100, 100, 250, 10);

        txtTenLoaiXe.setBackground(new java.awt.Color(0, 51, 51));
        txtTenLoaiXe.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtTenLoaiXe.setForeground(new java.awt.Color(204, 204, 204));
        txtTenLoaiXe.setBorder(null);
        panelBackground1.add(txtTenLoaiXe);
        txtTenLoaiXe.setBounds(100, 110, 250, 30);

        jSeparator4.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator4);
        jSeparator4.setBounds(100, 140, 250, 10);

        lbMaLoaiXe.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbMaLoaiXe.setForeground(new java.awt.Color(255, 0, 51));
        lbMaLoaiXe.setText("Mã loại xe");
        panelBackground1.add(lbMaLoaiXe);
        lbMaLoaiXe.setBounds(20, 40, 64, 18);

        lbDongXe.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbDongXe.setForeground(new java.awt.Color(255, 0, 51));
        lbDongXe.setText("Dòng xe");
        panelBackground1.add(lbDongXe);
        lbDongXe.setBounds(30, 80, 52, 18);

        lblMaST.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST.setText("Tên loại xe");
        panelBackground1.add(lblMaST);
        lblMaST.setBounds(20, 120, 68, 18);

        add(panelBackground1);
        panelBackground1.setBounds(240, 80, 370, 180);

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
        txtTim.setBounds(20, 290, 250, 40);

        tblLoaiXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiXe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiXeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLoaiXe);

        add(jScrollPane2);
        jScrollPane2.setBounds(20, 390, 790, 160);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLuaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuaChonActionPerformed
        String Option = evt.getActionCommand();
        String them = btnThem.getText();
        String sua = btnSua.getText();
        String xoa = btnXoa.getText();
        String moi = btnLamMoi.getText();
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

    }//GEN-LAST:event_btnLuaChonActionPerformed

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

    private void txtTimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKeyReleased
        timKiem();
    }//GEN-LAST:event_txtTimKeyReleased

    private void tblLoaiXeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiXeMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblLoaiXe.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblLoaiXeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.Button btnFirst;
    private com.ttt.swing.Button btnLamMoi;
    private com.ttt.swing.Button btnLast;
    private com.ttt.swing.Button btnNext;
    private com.ttt.swing.Button btnPrev;
    private com.ttt.swing.Button btnSua;
    private com.ttt.swing.Button btnThem;
    private com.ttt.swing.Button btnXoa;
    private com.ttt.swing.Button btnXuatFile;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbDongXe;
    private javax.swing.JLabel lbMaLoaiXe;
    private javax.swing.JLabel lblMaST;
    private com.ttt.swing.PanelBackground panelBackground1;
    private com.ttt.swing.TableDark tblLoaiXe;
    private javax.swing.JTextField txtDongXe;
    private javax.swing.JTextField txtMaLoaiXe;
    private javax.swing.JTextField txtTenLoaiXe;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables
}
