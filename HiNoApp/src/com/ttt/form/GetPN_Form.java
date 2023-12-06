/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ttt.form;

import com.ttt.DAO.PhieuNhapDAO;
import com.ttt.Entity.PhieuNhap;
import com.ttt.properties.SystemProperties;
import com.ttt.theme.ThemeColorChange;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 *
 * @author ASUS
 */
public class GetPN_Form extends javax.swing.JFrame {

    public static GetPN_Form Instance;
   // public static JComboBox cbbPN;
    public JButton button;
    public String maPN;
    public String dienGiai;
    public String maNV;
    public String tenNV;
    public GetPN_Form() {
        initComponents();
        Instance=this;
        button=btnOK;
     //   cbbPN=cboPhieuNhap;
        setBackground(new Color(0, 0, 0, 0));
        init();
    }
    //SystemProperties pro = new SystemProperties();

    private void init() {
        // headerLogin.initMoving(this);
        // headerLogin.initEvent(this, panelBackgroundLogin);
        SystemProperties pro = new SystemProperties();
        pro.loadFromFile();
        //tạo panel
        ThemeColorChange.getInstance().initBackground(panelBackgroundLogin);
        //set background
        ThemeColorChange.getInstance().changeBackgroundImage(pro.getBackgroundImage());
        // set darkMode
        if (!pro.isDarkMode()) {
            ThemeColorChange.getInstance().setMode(ThemeColorChange.Mode.LIGHT);
            panelBackgroundLogin.setBackground(Color.WHITE);
        } else {
            ThemeColorChange.getInstance().setMode(ThemeColorChange.Mode.DARK);
            panelBackgroundLogin.setBackground(new Color(80, 80, 80));
        }
        fillcboPhieuNhap();
    }

    void fillcboPhieuNhap() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboPhieuNhap.getModel();
        model.removeAllElements();
        List<PhieuNhap> list = PhieuNhapDAO.getNewPhieuNhapDAO().selectAll();
        for (PhieuNhap cd : list) {
            model.addElement(cd);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackgroundLogin = new com.ttt.swing.PanelBackground();
        btnOK = new com.ttt.swing.Button();
        btnCancel = new com.ttt.swing.Button();
        cboPhieuNhap = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnOK.setBackground(new java.awt.Color(0, 51, 51));
        btnOK.setForeground(new java.awt.Color(255, 255, 255));
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 51, 51));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("ĐÓNG");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        cboPhieuNhap.setBackground(new java.awt.Color(0, 51, 51));
        cboPhieuNhap.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cboPhieuNhap.setForeground(new java.awt.Color(255, 255, 255));
        cboPhieuNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phiếu Nhập" }));
        cboPhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPhieuNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackgroundLoginLayout = new javax.swing.GroupLayout(panelBackgroundLogin);
        panelBackgroundLogin.setLayout(panelBackgroundLoginLayout);
        panelBackgroundLoginLayout.setHorizontalGroup(
            panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLoginLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addComponent(cboPhieuNhap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBackgroundLoginLayout.setVerticalGroup(
            panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLoginLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(cboPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackgroundLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackgroundLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
     
       NhapKho_Form.txt.setText(maPN);
       NhapKho_Form.txtDG.setText(dienGiai);
       this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void cboPhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPhieuNhapActionPerformed
       
        PhieuNhap pn = (PhieuNhap) cboPhieuNhap.getSelectedItem();
       if(pn!=null){
           maPN=pn.getMaPhieuNhap();
           dienGiai=pn.getDienGiai();
       }
        
    }//GEN-LAST:event_cboPhieuNhapActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GetPN_Form().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.Button btnCancel;
    private com.ttt.swing.Button btnOK;
    private javax.swing.JComboBox<String> cboPhieuNhap;
    private com.ttt.swing.PanelBackground panelBackgroundLogin;
    // End of variables declaration//GEN-END:variables
}
