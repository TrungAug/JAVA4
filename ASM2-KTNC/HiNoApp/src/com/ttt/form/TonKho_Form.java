package com.ttt.form;

import com.ttt.DAO.LoaiXeDAO;
import com.ttt.DAO.ThongKeDAO;
import com.ttt.DAO.ViTriDAO;
import com.ttt.Entity.LoaiXe;
import com.ttt.Entity.ViTri;
import com.ttt.LibaryHelper.Search;
import com.ttt.transitions.TransitionsForm;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public final class TonKho_Form extends TransitionsForm {

    DefaultTableModel model;
    int row = -1;
    public String maVT;
    public String maLX;

    public TonKho_Form() {
        initComponents();
        init();
    }

    void init() {
        // this.fillcboLoaiXe();
        //this.fillcboViTri();
        this.initTable();
        this.fillTableTonKho();
        tblTonKho.fixTable(jScrollPane2);
    }

//    void fillcboLoaiXe() {
//        DefaultComboBoxModel model1 = (DefaultComboBoxModel) cboLoaiXe.getModel();
//        model1.removeAllElements();
//        List<LoaiXe> list = LoaiXeDAO.getNewLoaiXeDAO().selectAll();
//        for (LoaiXe cd : list) {
//            model1.addElement(cd);
//        }
//        this.fillTableTonKho();
//    }
//
//    void fillcboViTri() {
//        DefaultComboBoxModel model2 = (DefaultComboBoxModel) cboViTri.getModel();
//        model2.removeAllElements();
//        List<ViTri> list = ViTriDAO.getNewViTriDAO().selectAll();
//        for (ViTri vt : list) {
//            model2.addElement(vt);
//
//        }
//        this.fillTableTonKho();
//    }

    public void initTable() {
        model = (DefaultTableModel) tblTonKho.getModel();
        model.setColumnIdentifiers(new String[]{"Mã loại xe", "Dòng xe", "Tên loại xe", "Số lượng tồn", "Vị trí"});
    }

    void fillTableTonKho() {
        // System.out.println(maLX);
        // System.out.println(maVT);
        model = (DefaultTableModel) tblTonKho.getModel();
        model.setRowCount(0);
        //List<Object[]> list = ThongKeDAO.getNewThongKeDAO().getSoLuongTonKho(maLX, maVT);
        List<Object[]> list = ThongKeDAO.getNewThongKeDAO().getSLTonKho();
        if (list != null) {
            for (Object[] rows : list) {
                String temp = String.valueOf(rows[3]).trim();
                double soLuong = Integer.parseInt(temp);
                model.addRow(
                        new Object[]{
                            rows[0],
                            rows[1],
                            rows[2],
                            soLuong,
                            rows[4]
                        }
                );
            }
        }
    }

    void first() {
        this.row = 0;
        tblTonKho.setRowSelectionInterval(this.row, this.row);
    }

    void next() {

        if (this.row < tblTonKho.getRowCount() - 1) {
            this.row++;

        } else {
            first();

        }
        tblTonKho.setRowSelectionInterval(this.row, this.row);

    }

    void prev() {
        if (this.row > 0) {
            this.row--;

        } else {
            last();

        }
        tblTonKho.setRowSelectionInterval(this.row, this.row);

    }

    void last() {
        this.row = tblTonKho.getRowCount() - 1;

        tblTonKho.setRowSelectionInterval(this.row, this.row);

    }

    void timKiem() {
        String key = txtTim.getText();
        if(key.contains("*") || key.contains("(")||key.contains(")")|| key.contains("[")||key.contains("]")){
            return;
        }
        Search.search(tblTonKho, key);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnFirst = new com.ttt.swing.Button();
        btnPrev = new com.ttt.swing.Button();
        btnNext = new com.ttt.swing.Button();
        btnLast = new com.ttt.swing.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTonKho = new com.ttt.swing.TableDark();
        txtTim = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("BÁO CÁO HÀNG TỒN KHO");

        btnFirst.setBackground(new java.awt.Color(0, 51, 51));
        btnFirst.setForeground(new java.awt.Color(255, 255, 255));
        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });

        btnPrev.setBackground(new java.awt.Color(0, 51, 51));
        btnPrev.setForeground(new java.awt.Color(255, 255, 255));
        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });

        btnNext.setBackground(new java.awt.Color(0, 51, 51));
        btnNext.setForeground(new java.awt.Color(255, 255, 255));
        btnNext.setText(">>");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });

        btnLast.setBackground(new java.awt.Color(0, 51, 51));
        btnLast.setForeground(new java.awt.Color(255, 255, 255));
        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOptionActionPerformed(evt);
            }
        });

        tblTonKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTonKho);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOptionActionPerformed
        if (tblTonKho.getRowCount() != 0) {
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

        }


    }//GEN-LAST:event_btnOptionActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.Button btnFirst;
    private com.ttt.swing.Button btnLast;
    private com.ttt.swing.Button btnNext;
    private com.ttt.swing.Button btnPrev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.ttt.swing.TableDark tblTonKho;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables

}
