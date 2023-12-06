package com.ttt.form;

import com.ttt.DAO.ChiNhanhDAO;
import com.ttt.DAO.PhongBanDAO;
import com.ttt.Entity.ChiNhanh;
import com.ttt.Entity.PhongBan;
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

public final class PhongBan_Form extends Form {

    public PhongBan_Form() {
        initComponents();
        init();
    }
    int row = -1;
    DefaultTableModel model;

    void init() {
        initTable();
        fillTable();
        fillcboChiNhanh();
        tblPhongBan.fixTable(jScrollPane2);
    }

    public void initTable() {
        model = (DefaultTableModel) tblPhongBan.getModel();
        model.setColumnIdentifiers(new String[]{"Mã phòng ban", "Tên phòng ban", "Mã chi nhánh"});
    }

    public void fillTable() {
        model = (DefaultTableModel) tblPhongBan.getModel();
        model.setRowCount(0);
        try {
            List<PhongBan> list = PhongBanDAO.getNewPhongBanDAO().selectAll();
            for (PhongBan nv : list) {
                Object[] rows = {
                    nv.getMaPhongBan(), nv.getTenPhongBan(), nv.getMaChiNhanh()
                };
                model.addRow(rows);
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

    public void setForm(PhongBan vt) {
        txtMapb.setText(vt.getMaPhongBan());
        txtTenpb.setText(vt.getTenPhongBan());
        ChiNhanh pb = ChiNhanhDAO.getNewChiNhanhDAO().selectById(vt.getMaChiNhanh());
        cboChiNhanh.setSelectedItem(pb);

    }

    PhongBan getForm() {
        if (check()) {
            PhongBan vt = new PhongBan();
            vt.setMaPhongBan(txtMapb.getText());
            vt.setTenPhongBan(txtTenpb.getText());
            ChiNhanh pb = (ChiNhanh) cboChiNhanh.getSelectedItem();
            vt.setMaChiNhanh(pb.getMaChiNhanh());

            return vt;
        }
        return null;
    }

    void edit() {
        String idCT = (String) tblPhongBan.getValueAt(this.row, 0);
        PhongBan pb = PhongBanDAO.getNewPhongBanDAO().selectById(idCT.trim());
        this.setForm(pb);
        tblPhongBan.setRowSelectionInterval(row, row);

    }

    public void lamMoi() {
        txtMapb.setText("");
        txtTenpb.setText("");
        txtTimKiem.setText("Nhập tìm kiếm");
        this.fillTable();
    }

    void fillTableByKeyword() {
        DefaultTableModel model = (DefaultTableModel) tblPhongBan.getModel();
        model.setRowCount(0);
        try {
            String id = txtTimKiem.getText();
            List<PhongBan> list = PhongBanDAO.getNewPhongBanDAO().selectByKeyword(id);
            for (PhongBan nv : list) {
                Object[] rows = {
                    nv.getMaPhongBan(), nv.getTenPhongBan(), nv.getMaChiNhanh()
                };
                model.addRow(rows);
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
            System.out.println(e);
        }
    }

    void timKiem() {
        String key = txtTimKiem.getText();
        if (key.contains("*") || key.contains("(") || key.contains(")") || key.contains("[") || key.contains("]")) {
            return;
        }
        Search.search(tblPhongBan, key);
    }

    public void insert() {
        PhongBan pb = getForm();
        if (pb != null) {
            if (PhongBanDAO.getNewPhongBanDAO().selectById(pb.getMaPhongBan()) != null) {
                if (DialogHelper.confirm(this, "Đã tồn tại mã phòng ban " + pb.getMaPhongBan() + " .Bạn có muốn cập nhật không?")) {
                    update();
                }
            } else {
                try {
                    PhongBanDAO.getNewPhongBanDAO().insert(pb);
                    fillTable();
                    DialogHelper.alert(this, "Thêm mới thành công");
                    lamMoi();
                } catch (Exception e) {
                    DialogHelper.alert(this, "Thêm mới thất bại");
                }
            }

        }

    }

    public void update() {
        PhongBan pb = getForm();
        if (pb != null) {
            try {
                PhongBanDAO.getNewPhongBanDAO().update(pb);
                fillTable();
                lamMoi();
                DialogHelper.alert(this, "Cập nhật thành công");

            } catch (Exception e) {
                DialogHelper.alert(this, "Cập nhật thất bại");
            }
        }

    }

    public void delete() {
        if (!Auth.isManager()) {
            DialogHelper.alert(this, "Bạn không có quyền xóa phòng ban");
            return;
        }
        String ma = txtMapb.getText();
        PhongBan pb = PhongBanDAO.getNewPhongBanDAO().selectById(ma);
        if (pb != null) {
            if (DialogHelper.confirm(this, "Bạn thực sự muốn xóa phòng ban " + ma)) {
                try {
                    PhongBanDAO.getNewPhongBanDAO().delete(ma);
                    this.fillTable();
                    this.lamMoi();
                    DialogHelper.alert(this, "Xóa thành công");
                } catch (Exception e) {
                    DialogHelper.alert(this, "Phòng ban đã tồn tại dữ liệu. Không được xóa!");
                }
            }
        } else {
            DialogHelper.alert(this, "Chưa có phòng ban " + ma);
        }

    }

    public boolean check() {
        if (txtMapb.getText().equals("") || txtMapb.getText() == null
                && txtTenpb.getText().equals("") || txtTenpb.getText() == null) {
            DialogHelper.alert(this, "Vui lòng nhập thông tin");
            return false;
        }
        if (txtMapb.getText().equals("") || txtMapb.getText() == null) {
            DialogHelper.alert(this, "Mã phòng ban không được để trống");
            return false;
        }
        if (txtTenpb.getText().equals("") || txtTenpb.getText() == null) {
            DialogHelper.alert(this, "Tên phòng ban không được để trống");
            return false;
        }

        return true;
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
                XSSFRow rowex = null;
                Cell cell = null;
                rowex = sheet.createRow(1);
                cell = rowex.createCell(0, CellType.STRING);
                cell.setCellValue("MaPB");
                cell = rowex.createCell(1, CellType.STRING);
                cell.setCellValue("TenPB");
                cell = rowex.createCell(2, CellType.STRING);
                cell.setCellValue("MaCN");

                List<PhongBan> arr = PhongBanDAO.getNewPhongBanDAO().selectAll();
                for (int i = 0; i < arr.size(); i++) {
                    //  ChiNhanh cn = arr.get(i);
                    rowex = sheet.createRow(2 + i);

                    cell = rowex.createCell(0, CellType.STRING);
                    cell.setCellValue(arr.get(i).getMaPhongBan());
                    cell = rowex.createCell(1, CellType.STRING);
                    cell.setCellValue(arr.get(i).getTenPhongBan());
                    cell = rowex.createCell(2, CellType.STRING);
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
        tblPhongBan.setRowSelectionInterval(this.row, this.row);
    }

    void next() {

        if (this.row < tblPhongBan.getRowCount() - 1) {
            this.row++;
            this.edit();

        } else {
            first();

        }
        tblPhongBan.setRowSelectionInterval(this.row, this.row);

    }

    void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();

        } else {
            last();

        }
        tblPhongBan.setRowSelectionInterval(this.row, this.row);

    }

    void last() {
        this.row = tblPhongBan.getRowCount() - 1;
        this.edit();
        tblPhongBan.setRowSelectionInterval(this.row, this.row);

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
        cboChiNhanh = new javax.swing.JComboBox<>();
        txtMapb = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtTenpb = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        lbMaPhong = new javax.swing.JLabel();
        lblMaST = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhongBan = new com.ttt.swing.TableDark();

        btnThem.setBackground(new java.awt.Color(0, 51, 51));
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 51, 51));
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });

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

        btnFirst.setBackground(new java.awt.Color(0, 51, 51));
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(0, 51, 51));
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(0, 51, 51));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(0, 51, 51));
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaChonActionPerformed(evt);
            }
        });

        btnXuatFile.setBackground(new java.awt.Color(0, 51, 51));
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });

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

        panelBackground1.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground1.setLayout(null);

        cboChiNhanh.setBackground(new java.awt.Color(0, 51, 51));
        cboChiNhanh.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cboChiNhanh.setForeground(new java.awt.Color(255, 255, 255));
        cboChiNhanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chi Nhánh 1", "Chi Nhánh 2" }));
        cboChiNhanh.setBorder(null);
        panelBackground1.add(cboChiNhanh);
        cboChiNhanh.setBounds(107, 10, 250, 41);

        txtMapb.setBackground(new java.awt.Color(0, 51, 51));
        txtMapb.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtMapb.setForeground(new java.awt.Color(204, 204, 204));
        txtMapb.setBorder(null);
        panelBackground1.add(txtMapb);
        txtMapb.setBounds(110, 70, 250, 30);

        jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator3);
        jSeparator3.setBounds(110, 100, 250, 10);

        txtTenpb.setBackground(new java.awt.Color(0, 51, 51));
        txtTenpb.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtTenpb.setForeground(new java.awt.Color(204, 204, 204));
        txtTenpb.setBorder(null);
        panelBackground1.add(txtTenpb);
        txtTenpb.setBounds(110, 120, 250, 30);

        jSeparator4.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator4);
        jSeparator4.setBounds(110, 150, 250, 10);

        lbMaPhong.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lbMaPhong.setForeground(new java.awt.Color(255, 0, 51));
        lbMaPhong.setText("Mã phòng ban");
        panelBackground1.add(lbMaPhong);
        lbMaPhong.setBounds(0, 90, 90, 18);

        lblMaST.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lblMaST.setForeground(new java.awt.Color(255, 0, 51));
        lblMaST.setText("Tên phòng ban");
        panelBackground1.add(lblMaST);
        lblMaST.setBounds(0, 140, 94, 18);

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

        tblPhongBan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPhongBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhongBanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPhongBan);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(panelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 354, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 318, Short.MAX_VALUE)
                        .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(panelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );
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

    private void tblPhongBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhongBanMouseClicked
        if (evt.getClickCount() == 2) {
            this.row = tblPhongBan.getSelectedRow();
            this.edit();
        }
    }//GEN-LAST:event_tblPhongBanMouseClicked

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
    private javax.swing.JLabel lbMaPhong;
    private javax.swing.JLabel lblMaST;
    private com.ttt.swing.PanelBackground panelBackground1;
    private com.ttt.swing.TableDark tblPhongBan;
    private javax.swing.JTextField txtMapb;
    private javax.swing.JTextField txtTenpb;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
