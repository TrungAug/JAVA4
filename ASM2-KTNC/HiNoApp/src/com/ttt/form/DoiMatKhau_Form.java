/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ttt.form;

import com.ttt.DAO.NhanVienDAO;
import com.ttt.Entity.NhanVien;
import com.ttt.LibaryHelper.Auth;
import com.ttt.LibaryHelper.DialogHelper;
import com.ttt.properties.SystemProperties;
import com.ttt.theme.ThemeColorChange;
import java.awt.Color;

/**
 *
 * @author ASUS
 */
public class DoiMatKhau_Form extends javax.swing.JFrame {

    String maHienTai;
    String passHienTai;
    String passMoi;
    String xacNhanPassMoi;
    String maNvCu;
    String passNvCu;

    public DoiMatKhau_Form() {
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
        ThemeColorChange.getInstance().initBackground(panelBackgroundForget);
        //set background
        ThemeColorChange.getInstance().changeBackgroundImage(pro.getBackgroundImage());
        // set darkMode
        if (!pro.isDarkMode()) {
            ThemeColorChange.getInstance().setMode(ThemeColorChange.Mode.LIGHT);
            panelBackgroundForget.setBackground(Color.WHITE);
        } else {
            ThemeColorChange.getInstance().setMode(ThemeColorChange.Mode.DARK);
            panelBackgroundForget.setBackground(new Color(80, 80, 80));
        }

    }

//    private void send() {
//        System.out.println("Vui lòng kiểm tra email");
//        Forget_Confirm_Form cff = new Forget_Confirm_Form();
//        cff.setVisible(true);
//        this.dispose();
//    }
    private void cancel() {
        this.dispose();
    }

    boolean checkNull() {
        maHienTai = txtmaNhanVien.getText();
        passHienTai = new String(txtPassHienTai.getPassword());
        passMoi = new String(txtPassMoi.getPassword());
        xacNhanPassMoi = new String(txtXacNhanPassMoi.getPassword());
        if (Auth.user != null) {
            maNvCu = Auth.user.getMaNV();
            passNvCu = Auth.user.getMatKhau();
        }
        int flag_maht = 0;
        int flag_passht = 0;
        int flag_passmoi = 0;
        int flag_xacnhan = 0;
        int flag_check = 0;
        if (maHienTai == null || maHienTai.equalsIgnoreCase("")) {
            flag_maht = 1;
//            DialogHelper.alert(this, "Vui lòng nhập tên đăng nhập");
//            return false;
        }
        if (passHienTai == null || passHienTai.equalsIgnoreCase("") || passHienTai.equalsIgnoreCase("matkhau")) {
            flag_passht = 1;
//            DialogHelper.alert(this, "Vui lòng nhập mật khẩu hiện tại");
//            return false;
        }
        if (passMoi == null || passMoi.equalsIgnoreCase("") || passMoi.equalsIgnoreCase("matkhaumoi")) {
            flag_passmoi = 1;
//            DialogHelper.alert(this, "Vui lòng nhập mật khẩu moi");
//            return false;
        }
        if (passMoi.length() < 8) {
            flag_passmoi = 2;
//            DialogHelper.alert(this, "Mật khẩu phải có ít nhất 8 ký tự");
//            return false;
        }
        if (!passMoi.equalsIgnoreCase(xacNhanPassMoi)) {
            flag_xacnhan = 1;
//            DialogHelper.alert(this, "Xác nhận mật khẩu không đúng");
//            return false;
        }
        if (!maNvCu.equalsIgnoreCase(maHienTai) || !passNvCu.equalsIgnoreCase(passHienTai)) {
            flag_check = 1;
//            DialogHelper.alert(this, "Thông tin đăng nhập không đúng");
//            return false;
        }
        if (flag_maht == 1 && flag_passht == 1 && (flag_passmoi == 1 || flag_passmoi == 2) && flag_xacnhan == 1 && flag_check == 1) {
            DialogHelper.alert(this, "Vui lòng nhập đầy đủ thông tin");
            return false;
        } else if (flag_passht == 1 && (flag_passmoi == 1 || flag_passmoi == 2) && flag_xacnhan == 1 && flag_check == 1) {
            DialogHelper.alert(this, "Chưa nhập đủ thông tin");
            return false;
        } else if ((flag_passmoi == 1 || flag_passmoi == 2) && flag_xacnhan == 1 && flag_check == 1) {
            DialogHelper.alert(this, "Chưa nhập đủ thông tin");
            return false;
        } else if (flag_passmoi == 2 && flag_xacnhan == 1 && flag_check == 1) {
            DialogHelper.alert(this, "Thông tin nhập chưa đúng");
            return false;
        } else if (flag_xacnhan == 1 && flag_check == 1) {
            DialogHelper.alert(this, "Thông tin nhập chưa đúng");
            return false;
        } else if (flag_check == 1) {
            DialogHelper.alert(this, "Thông tin đăng nhập không đúng");
            return false;
        } else if (flag_xacnhan == 1) {
            DialogHelper.alert(this, "Xác nhận mật khẩu không đúng");
            return false;
        } else if (flag_passmoi == 2) {
            DialogHelper.alert(this, "Mật khẩu phải có ít nhất 8 ký tự");
            return false;
        } else if (flag_passmoi == 1) {
            DialogHelper.alert(this, "Vui lòng nhập mật khẩu mới");
            return false;
        } else if (flag_passht == 1) {
            DialogHelper.alert(this, "Vui lòng nhập mật khẩu hiện tại");
            return false;
        } else if (flag_maht == 1) {
            DialogHelper.alert(this, "Vui lòng nhập mã nhân viên");
            return false;
        } else {
            return true;
        }
    }

    private void xacNhan() {
        //thông tin pass cũ phải đúng với user hiện tại
        if (checkNull()) {
            NhanVien nvc = NhanVienDAO.getNewNhanVienDAO().selectById(maNvCu);
            NhanVien nv = new NhanVien(nvc.getMaNV(), passMoi, nvc.getHoTen(), nvc.getNgaySinh(), nvc.getGioiTinh(), nvc.getDiaChi(), nvc.getEmail(), nvc.getChucVu(), nvc.getMaPhong(), nvc.getHinh());
            NhanVienDAO.getNewNhanVienDAO().update(nv);
            if (DialogHelper.confirm(this, "Đổi mật khẩu thành công. Bạn có muốn đăng nhập lại không?")) {
                this.dispose();
                Login_Form lg = new Login_Form();
                lg.setVisible(true);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackgroundForget = new com.ttt.swing.PanelBackground();
        btnXacNhan = new com.ttt.swing.Button();
        btnCancel = new com.ttt.swing.Button();
        jLabel1 = new javax.swing.JLabel();
        panelBackground1 = new com.ttt.swing.PanelBackground();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPassMoi = new javax.swing.JPasswordField();
        jSeparator8 = new javax.swing.JSeparator();
        txtXacNhanPassMoi = new javax.swing.JPasswordField();
        jSeparator9 = new javax.swing.JSeparator();
        panelBackground2 = new com.ttt.swing.PanelBackground();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtmaNhanVien = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtPassHienTai = new javax.swing.JPasswordField();
        jSeparator7 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBackgroundForget.setLayout(null);

        btnXacNhan.setBackground(new java.awt.Color(0, 51, 51));
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("XÁC NHẬN");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });
        panelBackgroundForget.add(btnXacNhan);
        btnXacNhan.setBounds(620, 370, 81, 26);

        btnCancel.setBackground(new java.awt.Color(0, 51, 51));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("HỦY BỎ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        panelBackgroundForget.add(btnCancel);
        btnCancel.setBounds(510, 370, 70, 26);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("ĐỔI MẬT KHẨU");
        panelBackgroundForget.add(jLabel1);
        jLabel1.setBounds(280, 40, 190, 32);

        panelBackground1.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("X.nhận MK");
        panelBackground1.add(jLabel2);
        jLabel2.setBounds(10, 130, 90, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Thông tin mới");
        panelBackground1.add(jLabel3);
        jLabel3.setBounds(100, 10, 130, 30);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Mật khẩu mới");
        panelBackground1.add(jLabel4);
        jLabel4.setBounds(10, 70, 100, 30);

        txtPassMoi.setBackground(new java.awt.Color(0, 51, 51));
        txtPassMoi.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtPassMoi.setForeground(new java.awt.Color(102, 102, 102));
        txtPassMoi.setText("matkhaumoi");
        txtPassMoi.setBorder(null);
        txtPassMoi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassMoiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassMoiFocusLost(evt);
            }
        });
        panelBackground1.add(txtPassMoi);
        txtPassMoi.setBounds(110, 60, 200, 30);

        jSeparator8.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator8.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator8);
        jSeparator8.setBounds(110, 90, 200, 10);

        txtXacNhanPassMoi.setBackground(new java.awt.Color(0, 51, 51));
        txtXacNhanPassMoi.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtXacNhanPassMoi.setForeground(new java.awt.Color(102, 102, 102));
        txtXacNhanPassMoi.setText("xacnhanmatkhaumoi");
        txtXacNhanPassMoi.setBorder(null);
        txtXacNhanPassMoi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtXacNhanPassMoiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtXacNhanPassMoiFocusLost(evt);
            }
        });
        panelBackground1.add(txtXacNhanPassMoi);
        txtXacNhanPassMoi.setBounds(110, 120, 200, 30);

        jSeparator9.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator9.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground1.add(jSeparator9);
        jSeparator9.setBounds(110, 150, 200, 10);

        panelBackgroundForget.add(panelBackground1);
        panelBackground1.setBounds(390, 120, 320, 200);

        panelBackground2.setBackground(new java.awt.Color(0, 51, 51));
        panelBackground2.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Mã N.Viên");
        panelBackground2.add(jLabel5);
        jLabel5.setBounds(20, 70, 100, 30);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("M.khẩu H.Tại");
        panelBackground2.add(jLabel6);
        jLabel6.setBounds(10, 130, 100, 30);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Thông tin cũ");
        panelBackground2.add(jLabel7);
        jLabel7.setBounds(120, 10, 130, 30);

        txtmaNhanVien.setBackground(new java.awt.Color(0, 51, 51));
        txtmaNhanVien.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtmaNhanVien.setForeground(new java.awt.Color(204, 204, 204));
        txtmaNhanVien.setBorder(null);
        panelBackground2.add(txtmaNhanVien);
        txtmaNhanVien.setBounds(110, 60, 200, 30);

        jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground2.add(jSeparator3);
        jSeparator3.setBounds(110, 90, 200, 10);

        txtPassHienTai.setBackground(new java.awt.Color(0, 51, 51));
        txtPassHienTai.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtPassHienTai.setForeground(new java.awt.Color(102, 102, 102));
        txtPassHienTai.setText("matkhau");
        txtPassHienTai.setBorder(null);
        txtPassHienTai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPassHienTaiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPassHienTaiFocusLost(evt);
            }
        });
        panelBackground2.add(txtPassHienTai);
        txtPassHienTai.setBounds(110, 130, 200, 30);

        jSeparator7.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator7.setForeground(new java.awt.Color(204, 204, 204));
        panelBackground2.add(jSeparator7);
        jSeparator7.setBounds(110, 160, 200, 10);

        panelBackgroundForget.add(panelBackground2);
        panelBackground2.setBounds(50, 120, 320, 200);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackgroundForget, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackgroundForget, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        cancel();

    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        xacNhan();
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void txtPassHienTaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassHienTaiFocusGained
        if (new String(txtPassHienTai.getPassword()).equalsIgnoreCase("matkhau")) {
            txtPassHienTai.setText("");
        }

        txtPassHienTai.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtPassHienTaiFocusGained

    private void txtPassHienTaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassHienTaiFocusLost
        if (new String(txtPassHienTai.getPassword()).equalsIgnoreCase("")) {
            txtPassHienTai.setText("matkhau");
        }
        txtPassHienTai.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtPassHienTaiFocusLost

    private void txtPassMoiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassMoiFocusGained
        if (new String(txtPassMoi.getPassword()).equalsIgnoreCase("matkhaumoi")) {
            txtPassMoi.setText("");
        }

        txtPassMoi.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtPassMoiFocusGained

    private void txtPassMoiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPassMoiFocusLost
        if (new String(txtPassMoi.getPassword()).equalsIgnoreCase("")) {
            txtPassMoi.setText("matkhaumoi");
        }
        txtPassMoi.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtPassMoiFocusLost

    private void txtXacNhanPassMoiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtXacNhanPassMoiFocusGained
        if (new String(txtXacNhanPassMoi.getPassword()).equalsIgnoreCase("xacnhanmatkhaumoi")) {
            txtXacNhanPassMoi.setText("");
        }

        txtXacNhanPassMoi.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtXacNhanPassMoiFocusGained

    private void txtXacNhanPassMoiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtXacNhanPassMoiFocusLost
        if (new String(txtXacNhanPassMoi.getPassword()).equalsIgnoreCase("")) {
            txtXacNhanPassMoi.setText("xacnhanmatkhaumoi");
        }
        txtXacNhanPassMoi.setForeground(new Color(102, 102, 102));
    }//GEN-LAST:event_txtXacNhanPassMoiFocusLost

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//      
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Forget_Form().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.Button btnCancel;
    private com.ttt.swing.Button btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private com.ttt.swing.PanelBackground panelBackground1;
    private com.ttt.swing.PanelBackground panelBackground2;
    private com.ttt.swing.PanelBackground panelBackgroundForget;
    private javax.swing.JPasswordField txtPassHienTai;
    private javax.swing.JPasswordField txtPassMoi;
    private javax.swing.JPasswordField txtXacNhanPassMoi;
    private javax.swing.JTextField txtmaNhanVien;
    // End of variables declaration//GEN-END:variables
}
