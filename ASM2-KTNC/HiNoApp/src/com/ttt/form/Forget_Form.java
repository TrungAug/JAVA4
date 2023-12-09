/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ttt.form;

import com.ttt.DAO.NhanVienDAO;
import com.ttt.Entity.NhanVien;
import com.ttt.LibaryHelper.DialogHelper;
import com.ttt.properties.SystemProperties;
import com.ttt.theme.ThemeColorChange;
import java.awt.Color;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ASUS
 */
public class Forget_Form extends javax.swing.JFrame {

    public Forget_Form() {
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

    public void sendmail(String recipientEmail, String newPassword) {
        try {
            // Cấu hình thông tin mail server
            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "587");

            // Thông tin tài khoản email gửi
            final String senderEmail = "dumedanh@gmail.com";
            final String senderPassword = "bcvqncfyoxzwevst";

            Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, senderPassword);
                }
            });

            // Tạo nội dung email
            String subject = "New Password";
            String content = "Mật khẩu mới của bạn là: " + newPassword;

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            message.setSubject(subject);
            message.setText(content);

            // Gửi email
            Transport.send(message);

            DialogHelper.alert(this, "Mật khẩu mới đã được gửi đến email của bạn.");
            this.dispose();
        } catch (MessagingException ex) {
            ex.printStackTrace();
            DialogHelper.alert(this, "Không thể gửi mật khẩu mới. Vui lòng thử lại sau.");
        }
    }

    public void doiMK() {
        String user = txtUserName.getText();
        String email = txtEmail.getText();

        NhanVienDAO dao = new NhanVienDAO();
        NhanVien nv = dao.findEmployeeByEmployeeCodeAndEmail(user, email);

        if (nv == null) {
            DialogHelper.alert(this, "Mã nhân viên hoặc email chưa đúng.");
        } else {
            String newPassword = RandomPassword(8); // Tạo mật khẩu mới với độ dài 10 ký tự

            // Cập nhật mật khẩu mới vào cơ sở dữ liệu
            nv.setMatKhau(newPassword);
            dao.update(nv);

            // Gửi mật khẩu mới qua email
            sendmail(email, newPassword);
        }

    }

    public static String RandomPassword(int length) {
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charset.length());
            password.append(charset.charAt(index));
        }
        return password.toString();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackgroundForget = new com.ttt.swing.PanelBackground();
        btnSend = new com.ttt.swing.Button();
        btnCancel = new com.ttt.swing.Button();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtEmail = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        btnSend.setBackground(new java.awt.Color(0, 51, 51));
        btnSend.setForeground(new java.awt.Color(255, 255, 255));
        btnSend.setText("GỬI");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(0, 51, 51));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("HỦY BỎ");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Lấy lại mật khẩu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Tên đ.nhập");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Email");

        txtUserName.setBackground(new java.awt.Color(0, 51, 51));
        txtUserName.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtUserName.setForeground(new java.awt.Color(204, 204, 204));
        txtUserName.setText("Ma nhan vien");
        txtUserName.setBorder(null);
        txtUserName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUserNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUserNameFocusLost(evt);
            }
        });

        jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

        txtEmail.setBackground(new java.awt.Color(0, 51, 51));
        txtEmail.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(204, 204, 204));
        txtEmail.setText("Email");
        txtEmail.setBorder(null);
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });

        jSeparator4.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout panelBackgroundForgetLayout = new javax.swing.GroupLayout(panelBackgroundForget);
        panelBackgroundForget.setLayout(panelBackgroundForgetLayout);
        panelBackgroundForgetLayout.setHorizontalGroup(
            panelBackgroundForgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackgroundForgetLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(panelBackgroundForgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBackgroundForgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackgroundForgetLayout.createSequentialGroup()
                        .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelBackgroundForgetLayout.createSequentialGroup()
                        .addGroup(panelBackgroundForgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                            .addComponent(jSeparator3)
                            .addComponent(txtEmail)
                            .addComponent(jSeparator4))
                        .addGap(191, 191, 191))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackgroundForgetLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
        );
        panelBackgroundForgetLayout.setVerticalGroup(
            panelBackgroundForgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundForgetLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(panelBackgroundForgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(panelBackgroundForgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBackgroundForgetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackgroundForget, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackgroundForget, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        cancel();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        doiMK();
    }//GEN-LAST:event_btnSendActionPerformed

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        if (txtEmail.getText().equalsIgnoreCase("Email")) {
            txtEmail.setText("");
        }

        txtEmail.setForeground(new Color(204, 204, 204));
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        if (txtEmail.getText().equalsIgnoreCase("")) {
            txtEmail.setText("Email");
        }
        txtEmail.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_txtEmailFocusLost

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
    private com.ttt.swing.Button btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private com.ttt.swing.PanelBackground panelBackgroundForget;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
