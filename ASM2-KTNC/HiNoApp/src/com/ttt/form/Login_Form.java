/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ttt.form;

import com.ttt.DAO.NhanVienDAO;
import com.ttt.Entity.NhanVien;
import com.ttt.LibaryHelper.Auth;
import com.ttt.LibaryHelper.DialogHelper;
import com.ttt.main.HiNo_Main;
import com.ttt.properties.SystemProperties;
import com.ttt.theme.ThemeColorChange;
import java.awt.Color;

/**
 *
 * @author ASUS
 */
public class Login_Form extends javax.swing.JFrame {

    public Login_Form() {
        initComponents();
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

    }

    void login() {
        String maNV = txtUserName.getText();
        String matKhau = new String(txtPassWord.getPassword());
        NhanVien nhanVien = NhanVienDAO.getNewNhanVienDAO().selectById(maNV);

        if (nhanVien == null) {
            DialogHelper.alert(this, "Sai tên đăng nhập");
        } else if (!matKhau.equals(nhanVien.getMatKhau())) {
            DialogHelper.alert(this, "Sai mật khẩu");
        } else {
            Auth.user = nhanVien;
            HiNo_Main m = new HiNo_Main();
            m.setVisible(true);
            this.dispose();
        }

        // Auth.user = NhanVienDAO.getNewNhanVienDAO().selectById("NV2023072100001"); //Admin
        // Auth.user = NhanVienDAO.getNewNhanVienDAO().selectById("NV2023072100006");//kd
        // Auth.user = NhanVienDAO.getNewNhanVienDAO().selectById("NV2023073000009");//TP KT
//       // Auth.user=NhanVienDAO.getNewNhanVienDAO().selectById("NV2023073000010");// NV KT
//        HiNo_Main m = new HiNo_Main();
//        m.setVisible(true);
//        this.dispose();
    }

    void forgetPass() {
        //this.dispose();
        Forget_Form fg = new Forget_Form();
        fg.setVisible(true);
    }

    private void cancel() {
        if (DialogHelper.confirm(this, "Bạn muốn hủy đăng nhập")) {
            System.exit(0);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackgroundLogin = new com.ttt.swing.PanelBackground();
        btnLogin = new com.ttt.swing.Button();
        btnCancel = new com.ttt.swing.Button();
        lblForgetPass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtUserName = new javax.swing.JTextField();
        txtPassWord = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        chkShowPass = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnLogin.setBackground(new java.awt.Color(102, 102, 102));
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("ĐĂNG NHẬP");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(102, 102, 102));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("HỦY BỎ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblForgetPass.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        lblForgetPass.setForeground(new java.awt.Color(102, 102, 102));
        lblForgetPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblForgetPass.setText("Quên mật khẩu?");
        lblForgetPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgetPassMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblForgetPassMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblForgetPassMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\SUMMER 2023\\Du An 1\\3tProject\\HiNoApp\\src\\com\\ttt\\icon\\2.png")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("ĐĂNG NHẬP");

        txtUserName.setBackground(new java.awt.Color(102, 102, 102));
        txtUserName.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(153, 153, 153));
        txtUserName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtUserName.setText("Ma nhan vien");
        txtUserName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNameFocusLost(evt);
            }
        });

        txtPassWord.setBackground(new java.awt.Color(102, 102, 102));
        txtPassWord.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtPassWord.setForeground(new java.awt.Color(153, 153, 153));
        txtPassWord.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPassWord.setText("matkhau");
        txtPassWord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        txtPassWord.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassWordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassWordFocusLost(evt);
            }
        });

        chkShowPass.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        chkShowPass.setForeground(new java.awt.Color(102, 102, 102));
        chkShowPass.setText("Hiện mật khẩu");
        chkShowPass.setBorder(null);
        chkShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackgroundLoginLayout = new javax.swing.GroupLayout(panelBackgroundLogin);
        panelBackgroundLogin.setLayout(panelBackgroundLoginLayout);
        panelBackgroundLoginLayout.setHorizontalGroup(
            panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLoginLayout.createSequentialGroup()
                .addGroup(panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackgroundLoginLayout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassWord)
                            .addComponent(txtUserName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBackgroundLoginLayout.createSequentialGroup()
                                .addGroup(panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(chkShowPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblForgetPass, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelBackgroundLoginLayout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jLabel3)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        panelBackgroundLoginLayout.setVerticalGroup(
            panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLoginLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(txtPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(panelBackgroundLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblForgetPass)
                    .addComponent(chkShowPass))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBackgroundLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackgroundLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        cancel();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblForgetPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPassMouseClicked
        forgetPass();
    }//GEN-LAST:event_lblForgetPassMouseClicked

    private void chkShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowPassActionPerformed
      if(chkShowPass.isSelected()){
           txtPassWord.setEchoChar((char)0);
       }else{
           txtPassWord.setEchoChar('*');
       }
    }//GEN-LAST:event_chkShowPassActionPerformed

    private void txtUserNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusGained
       if (txtUserName.getText().equalsIgnoreCase("Ma nhan vien")) {
            txtUserName.setText("");
        }

        txtUserName.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtUserNameFocusGained

    private void txtUserNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUserNameFocusLost
        if (txtUserName.getText().equalsIgnoreCase("")) {
            txtUserName.setText("Ma nhan vien");
        }
        txtUserName.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_txtUserNameFocusLost

    private void txtPassWordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassWordFocusGained
       if (new String(txtPassWord.getPassword()).equalsIgnoreCase("matkhau")) {
            txtPassWord.setText("");
        }

        txtPassWord.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtPassWordFocusGained

    private void txtPassWordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassWordFocusLost
       if (new String(txtPassWord.getPassword()).equalsIgnoreCase("")) {
            txtPassWord.setText("matkhau");
        }
        txtPassWord.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_txtPassWordFocusLost

    private void lblForgetPassMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPassMouseEntered
      lblForgetPass.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_lblForgetPassMouseEntered

    private void lblForgetPassMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgetPassMouseExited
       lblForgetPass.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_lblForgetPassMouseExited

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Login_Form().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.Button btnCancel;
    private com.ttt.swing.Button btnLogin;
    private javax.swing.JCheckBox chkShowPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblForgetPass;
    private com.ttt.swing.PanelBackground panelBackgroundLogin;
    private javax.swing.JPasswordField txtPassWord;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
