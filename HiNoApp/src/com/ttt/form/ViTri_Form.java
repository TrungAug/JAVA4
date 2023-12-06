package com.ttt.form;

import com.ttt.DAO.ChiNhanhDAO;
import com.ttt.DAO.ThongKeDAO;
import com.ttt.DAO.ViTriDAO;
import com.ttt.Entity.ChiNhanh;
import com.ttt.Entity.ViTri;
import com.ttt.LibaryHelper.Auth;
import com.ttt.LibaryHelper.DialogHelper;
import com.ttt.LibaryHelper.Search;
import com.ttt.component.Form;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ViTri_Form extends Form {

    ViTriDAO dao = new ViTriDAO();
    DefaultTableModel model;

    public ViTri_Form() {
        initComponents();
        init();
    }
    int row = -1;

    void init() {
        initTable();
        fillTable();
        fillcboChiNhanh();       
        tblViTri.fixTable(jScrollPane2);
        txtMavt.setText(ThongKeDAO.getNewThongKeDAO().getMaViTri());
    }

    public void initTable() {
        model = (DefaultTableModel) tblViTri.getModel();
        model.setColumnIdentifiers(new String[]{"Mã vị trí", "Tên vị trí", "Mã chi nhánh"});
    }

    public void fillTable() {
        model = (DefaultTableModel) tblViTri.getModel();
        model.setRowCount(0);
        try {
            List<ViTri> list = dao.selectAll();
            for (ViTri nv : list) {
                Object[] row = {
                    nv.getMaViTri(), nv.getTenViTri(), nv.getMaChiNhanh()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void fillcboChiNhanh() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboChiNhanh.getModel();
        model.removeAllElements();
        List<ChiNhanh> list = ChiNhanhDAO.getNewChiNhanhDAO().selectAll();
        for (ChiNhanh cd : list) {
            model.addElement(cd);
        }
    }

    boolean checkNull() {
        if (txtTenVt.getText() == null || txtTenVt.getText().equalsIgnoreCase("")) {
            DialogHelper.alert(this, "Vui lòng nhập tên Vị trí");
            return false;
        }
        return true;
    }

    boolean CheckTrungMaVT(String maKH) {
        List<ViTri> list = ViTriDAO.getNewViTriDAO().selectAll();
        for (ViTri vt : list) {
            if (vt.getMaViTri().equalsIgnoreCase(maKH)) {
                return true;
            }
        }
        return false;
    }

    public void setForm(ViTri vt) {
        txtMavt.setText(vt.getMaViTri());
        txtTenVt.setText(vt.getTenViTri());
        ChiNhanh cn = ChiNhanhDAO.getNewChiNhanhDAO().selectById(vt.getMaChiNhanh());
        cboChiNhanh.setSelectedItem(cn);

    }

    ViTri getForm() {
        if (checkNull()) {
            ViTri vt = new ViTri();
            vt.setMaViTri(txtMavt.getText());
            vt.setTenViTri(txtTenVt.getText());
            ChiNhanh pb = (ChiNhanh) cboChiNhanh.getSelectedItem();
            vt.setMaChiNhanh(pb.getMaChiNhanh());

            return vt;
        }
        return null;
    }

    void lamMoi() {
        txtMavt.setText(ThongKeDAO.getNewThongKeDAO().getMaViTri());
        txtTenVt.setText("");
        txtTimKiem.setText("Nhập tìm kiếm");
        this.row = -1;
        this.fillTable();
    }

    void edit() {
        String idCT = (String) tblViTri.getValueAt(this.row, 0);
        ViTri pb = ViTriDAO.getNewViTriDAO().selectById(idCT.trim());
        this.setForm(pb);
        tblViTri.setRowSelectionInterval(row, row);
    }

    public void insert() {
        ViTri vt = getForm();
        if (vt != null) {
            if (CheckTrungMaVT(vt.getMaViTri())) {
                if (DialogHelper.confirm(this, "Đã tồn tại mã vị trí " + vt.getMaViTri() + " .Bạn có muốn cập nhật không?")) {
                    update();
                }
            } else {
                try {
                    dao.insert(vt);
                    fillTable();
                    DialogHelper.alert(this, "Thêm mới thành công");
                    lamMoi();

                } catch (Exception e) {
                    DialogHelper.alert(this, "Thêm mới thất bại");
                    System.out.println(e);
                }
            }

        }

    }

    public void update() {
        ViTri vt = this.getForm();
        if (vt != null) {
            try {
                ViTriDAO.getNewViTriDAO().update(vt);
                this.fillTable();
                this.lamMoi();
                DialogHelper.alert(this, "Cập nhật thành công");
            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại");
            }
        }
    }

    public void delete() {
        if (!Auth.isManager()) {
            DialogHelper.alert(this, "Bạn không có quyền xóa Vị trí");
            return;
        }
        String ma = txtMavt.getText();
        ViTri vt = ViTriDAO.getNewViTriDAO().selectById(ma);
        if (vt != null) {
            if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa chi vị trí " + ma)) {
                try {
                    ViTriDAO.getNewViTriDAO().delete(ma);
                    this.fillTable();
                    this.lamMoi();
                    DialogHelper.alert(this, "Xóa thành công");
                } catch (Exception e) {
                    DialogHelper.alert(this, "Vị trí đã tồn tại dữ liệu. Không được xóa!");
                    //e.printStackTrace();
                }
            }
        } else {
            DialogHelper.alert(this, "Chưa có vị trí " + ma + " .Vui long chọn vị trí!");
        }
    }

    void fillTableByKeyword() {
        DefaultTableModel model = (DefaultTableModel) tblViTri.getModel();
        model.setRowCount(0);
        try {
            String id = txtTimKiem.getText();
            List<ViTri> list = ViTriDAO.getNewViTriDAO().selectByKeyword(id);
            for (ViTri nv : list) {
                Object[] rows = {
                    nv.getMaViTri(), nv.getTenViTri(), nv.getMaChiNhanh()
                };
                model.addRow(rows);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
        }
    }

    void timKiem() {
        String key = txtTimKiem.getText();
        if(key.contains("*") || key.contains("(")||key.contains(")")|| key.contains("[")||key.contains("]")){
            return;
        }
        Search.search(tblViTri, key);
    }

    void export_excel() {
        try {
            JFileChooser jfileChooser = new JFileChooser();
            jfileChooser.showSaveDialog(this);
            File saveFile = jfileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                XSSFWorkbook wb = new XSSFWorkbook();
                XSSFSheet sheet = wb.createSheet("vitri");
                XSSFRow row = null;
                Cell cell = null;
                row = sheet.createRow(1);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue("MaVT");
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue("TenVT");
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue("MaCN");

                List<ViTri> arr = ViTriDAO.getNewViTriDAO().selectAll();
                for (int i = 0; i < arr.size(); i++) {
                    //  ChiNhanh cn = arr.get(i);
                    row = sheet.createRow(2 + i);

                    cell = row.createCell(0, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaViTri());
                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(arr.get(i).getTenViTri());
                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaChiNhanh());

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
        tblViTri.setRowSelectionInterval(this.row, this.row);
    }

    void next() {

        if (this.row < tblViTri.getRowCount() - 1) {
            this.row++;
            this.edit();

        } else {
            first();

        }
        tblViTri.setRowSelectionInterval(this.row, this.row);

    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();

        } else {
            last();

        }
        tblViTri.setRowSelectionInterval(this.row, this.row);

    }

    void last() {
        this.row = tblViTri.getRowCount() - 1;
        this.edit();
        tblViTri.setRowSelectionInterval(this.row, this.row);

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
        panelBackground2 = new com.ttt.swing.PanelBackground();
        txtMavt = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        cboChiNhanh = new javax.swing.JComboBox<>();
        txtTenVt = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        lbMaViTri = new javax.swing.JLabel();
        lblMaST = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblViTri = new com.ttt.swing.TableDark();

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
        btnLast.setBounds(430, 350, 31, 26);

        btnXuatFile.setBackground(new java.awt.Color(0, 51, 51));
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });
        add(btnXuatFile);
        btnXuatFile.setBounds(740, 350, 70, 26);

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

        panelBackground2.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground2.setLayout(null);

        txtMavt.setEditable(false);
        txtMavt.setBackground(new java.awt.Color(0, 51, 51));
        txtMavt.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtMavt.setForeground(new java.awt.Color(204, 204, 204));
        txtMavt.setBorder(null);
        txtMavt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtKhongDuocSuaMouseClicked(evt);
            }
        });
        panelBackground2.add(txtMavt);
        txtMavt.setBounds(90, 70, 250, 40);

        jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground2.add(jSeparator3);
        jSeparator3.setBounds(90, 110, 250, 10);

        cboChiNhanh.setBackground(new java.awt.Color(0, 51, 51));
        cboChiNhanh.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cboChiNhanh.setForeground(new java.awt.Color(255, 255, 255));
        cboChiNhanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chi Nhánh" }));
        cboChiNhanh.setBorder(null);
        panelBackground2.add(cboChiNhanh);
        cboChiNhanh.setBounds(90, 20, 250, 33);

        txtTenVt.setBackground(new java.awt.Color(0, 51, 51));
        txtTenVt.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtTenVt.setForeground(new java.awt.Color(204, 204, 204));
        txtTenVt.setBorder(null);
        panelBackground2.add(txtTenVt);
        txtTenVt.setBounds(90, 130, 250, 40);

        jSeparator4.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground2.add(jSeparator4);
        jSeparator4.setBounds(90, 170, 250, 10);

        lbMaViTri.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbMaViTri.setForeground(new java.awt.Color(153, 0, 0));
        lbMaViTri.setText("Mã vị trí");
        panelBackground2.add(lbMaViTri);
        lbMaViTri.setBounds(20, 90, 52, 18);

        lblMaST.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST.setText("Tên vị trí");
        panelBackground2.add(lblMaST);
        lblMaST.setBounds(20, 150, 56, 18);

        add(panelBackground2);
        panelBackground2.setBounds(270, 90, 410, 210);

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
        txtTimKiem.setBounds(20, 350, 260, 40);

        tblViTri.setModel(new javax.swing.table.DefaultTableModel(
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
        tblViTri.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViTriMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblViTri);

        add(jScrollPane2);
        jScrollPane2.setBounds(20, 420, 780, 160);
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
            lamMoi();
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

    private void tblViTriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViTriMouseClicked
       if (evt.getClickCount() == 2) {
            this.row = tblViTri.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblViTriMouseClicked

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
    private javax.swing.JComboBox<String> cboChiNhanh;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbMaViTri;
    private javax.swing.JLabel lblMaST;
    private com.ttt.swing.PanelBackground panelBackground2;
    private com.ttt.swing.TableDark tblViTri;
    private javax.swing.JTextField txtMavt;
    private javax.swing.JTextField txtTenVt;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
