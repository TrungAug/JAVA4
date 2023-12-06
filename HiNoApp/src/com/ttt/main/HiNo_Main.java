/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ttt.main;

import com.ttt.LibaryHelper.Auth;
import com.ttt.LibaryHelper.DialogHelper;
import com.ttt.event.EventColorChange;
import com.ttt.form.ChiNhanh_Form;
import com.ttt.form.DoiMatKhau_Form;
import com.ttt.form.Home_Form;
import com.ttt.form.KhachHang_Form;
import com.ttt.form.Loading_Form;
import com.ttt.form.ViTri_Form;
import com.ttt.form.Login_Form;
import com.ttt.form.NhanVien_Form;
import com.ttt.form.NhapKho_Form;
import com.ttt.form.PhongBan_Form;
import com.ttt.form.CaiDat_Form;
import com.ttt.form.ThongKe_Form;
import com.ttt.form.LoaiXe_Form;
import com.ttt.form.XuatKho_Form;
import com.ttt.menu.EventMenu;
import com.ttt.properties.SystemProperties;
import com.ttt.theme.SystemTheme;
import com.ttt.theme.ThemeColor;
import com.ttt.theme.ThemeColorChange;
import java.awt.Color;

/**
 *
 * @author ASUS
 */
public class HiNo_Main extends javax.swing.JFrame {

    public static String imgBackgroud;
    private CaiDat_Form settingForm;
    // public static HiNo_Main getInstance;

    public HiNo_Main() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        init();
        //    getInstance=this;
    }

    private void init() {

        header.initMoving(this);
        header.initEvent(this, panelBackground1);
        menu.addEventMenu(new EventMenu() {
            @Override
            public void selectedMenu(int index) {
                if (index == 0) {
                    mainBody.displayForm(new Home_Form());
                } else if (index == 1) {
                    if (checkBP() != 2) {
                        DialogHelper.alert(null, "Bạn không được phân quyền thực hiện chức năng này!");
                        return;
                    }
                    mainBody.displayForm(new ChiNhanh_Form());
                } else if (index == 2) {
                    if (checkBP() != 2) {
                        DialogHelper.alert(null, "Bạn không được phân quyền thực hiện chức năng này!");
                        return;
                    }
                    mainBody.displayForm(new PhongBan_Form());
                } else if (index == 3) {
                    if (checkBP() != 2) {
                        DialogHelper.alert(null, "Bạn không được phân quyền thực hiện chức năng này!");
                        return;
                    }
                    mainBody.displayForm(new ViTri_Form());
                } else if (index == 4) {
                    if (checkBP() != 2) {
                        DialogHelper.alert(null, "Bạn không được phân quyền thực hiện chức năng này!");
                        return;
                    }
                    mainBody.displayForm(new LoaiXe_Form());
                } else if (index == 5) {
                    if (checkBP() != 1) {
                        DialogHelper.alert(null, "Bạn không được phân quyền thực hiện chức năng này!");
                        return;
                    }
                    mainBody.displayForm(new NhanVien_Form());
                } else if (index == 6) {
                    if (checkBP() != 2) {
                        DialogHelper.alert(null, "Bạn không được phân quyền thực hiện chức năng này!");
                        return;
                    }
                    mainBody.displayForm(new KhachHang_Form());
                } else if (index == 7) {
                    if (checkBP() != 2) {
                        DialogHelper.alert(null, "Bạn không được phân quyền thực hiện chức năng này!");
                        return;
                    }
                    mainBody.displayForm(new NhapKho_Form());
                } else if (index == 8) {
                    if (checkBP() != 2) {
                        DialogHelper.alert(null, "Bạn không được phân quyền thực hiện chức năng này!");
                        return;
                    }
                    mainBody.displayForm(new XuatKho_Form());
                } else if (index == 9) {
                    if (checkBP() == 1) {
                        DialogHelper.alert(null, "Bạn không được phân quyền thực hiện chức năng này!");
                        return;
                    }
                    // mainBody.displayForm(new Report_Form());
                    ThongKe_Form lg = new ThongKe_Form();
                    lg.setVisible(true);
                } else if (index == 10) {
                    Login_Form lg = new Login_Form();
                    lg.setVisible(true);
//                        Menu.avatar.setImage(new ImageIcon(""));
//                        Menu.labelChucVu.setText("Bạn chưa đăng nhập");
//                        Menu.labelTen.setText("Bạn chưa đăng nhập");
//                        Auth.user = null;

                } else if (index == 11) {
                    ketThuc();
                    // System.exit(0);
                } else if (index == 12) {
                    DoiMatKhau_Form lg = new DoiMatKhau_Form();
                    lg.setVisible(true);
                } else if (index == 13) {
                    mainBody.displayForm(settingForm, "Setting");
                }
            }
        });

        ThemeColorChange.getInstance().addThemes(new ThemeColor(new Color(34, 34, 34), Color.WHITE) {
            @Override
            public void onColorChange(Color color) {
                panelBackground1.setBackground(color);
            }
        });
        ThemeColorChange.getInstance().addThemes(new ThemeColor(Color.WHITE, new Color(80, 80, 80)) {
            @Override
            public void onColorChange(Color color) {
                mainBody.changeColor(color);
            }
        });
        ThemeColorChange.getInstance().initBackground(panelBackground1);
        SystemProperties pro = new SystemProperties();
        pro.loadFromFile();
        if (!pro.isDarkMode()) {
            ThemeColorChange.getInstance().setMode(ThemeColorChange.Mode.LIGHT);
            panelBackground1.setBackground(Color.WHITE);
            mainBody.changeColor(new Color(80, 80, 80));
        }
        if (pro.getBackgroundImage() != null) {
            ThemeColorChange.getInstance().changeBackgroundImage(pro.getBackgroundImage());
        }

        SystemTheme.mainColor = pro.getColor();

        settingForm = new CaiDat_Form();
        settingForm.setEventColorChange(new EventColorChange() {
            @Override
            public void colorChange(Color color) {
                SystemTheme.mainColor = color;
                ThemeColorChange.getInstance().ruenEventColorChange(color);
                repaint();
                pro.save("theme_color", color.getRGB() + "");
            }
        });
        settingForm.setSelectedThemeColor(pro.getColor());
        settingForm.setDarkMode(pro.isDarkMode());
        settingForm.initBackgroundImage(pro.getBackgroundImage());
        mainBody.displayForm(new Home_Form());
    }

    void ketThuc() {
        if (DialogHelper.confirm(this, "Bạn muốn kết thúc ứng dụng")) {
            System.exit(0);
        }
    }

    int checkBP() {
        int result = 0;
        if (Auth.user.getMaPhong().startsWith("IT")) {
            result = 1;
        }
        if (Auth.user.getMaPhong().startsWith("KT")) {
            result = 2;
        }
        if (Auth.user.getMaPhong().startsWith("KD")) {
            result = 3;
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground1 = new com.ttt.swing.PanelBackground();
        header = new com.ttt.component.Header();
        menu = new com.ttt.menu.Menu();
        mainBody = new com.ttt.component.MainBody();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBackground1.setBackground(new java.awt.Color(34, 34, 34));

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(mainBody, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainBody, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HiNo_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HiNo_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HiNo_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HiNo_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new HiNo_Main().setVisible(true);
//            }
//        });
        Loading_Form ld = new Loading_Form();
        ld.setVisible(true);
        ld.progess();
        ld.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.component.Header header;
    private com.ttt.component.MainBody mainBody;
    private com.ttt.menu.Menu menu;
    private com.ttt.swing.PanelBackground panelBackground1;
    // End of variables declaration//GEN-END:variables
}
