/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ttt.form;

import com.ttt.properties.SystemProperties;
import com.ttt.theme.ThemeColorChange;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class Loading_Form extends javax.swing.JFrame {

    public Loading_Form() {
        initComponents();
        init();
    }

    private void init() {
        SystemProperties pro = new SystemProperties();
        pro.loadFromFile();
        ThemeColorChange.getInstance().initBackground(panelBackgroundLoading);
        ThemeColorChange.getInstance().changeBackgroundImage(pro.getBackgroundImage());
        if (!pro.isDarkMode()) {
            ThemeColorChange.getInstance().setMode(ThemeColorChange.Mode.LIGHT);
            panelBackgroundLoading.setBackground(Color.WHITE);
        } else {
            ThemeColorChange.getInstance().setMode(ThemeColorChange.Mode.DARK);
            panelBackgroundLoading.setBackground(new Color(80, 80, 80));
        }
    }

    public void progess() {
        int i = 0;
        while (i <= 100) {
            i++;
            pgrBar.setValue(i);
            try {
                Thread.sleep(45);
            } catch (InterruptedException ex) {
                Logger.getLogger(Loading_Form.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        Login_Form lg = new Login_Form();
        lg.setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackgroundLoading = new com.ttt.swing.PanelBackground();
        pgrBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pgrBar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pgrBar.setForeground(new java.awt.Color(255, 0, 0));
        pgrBar.setBorderPainted(false);
        pgrBar.setStringPainted(true);

        javax.swing.GroupLayout panelBackgroundLoadingLayout = new javax.swing.GroupLayout(panelBackgroundLoading);
        panelBackgroundLoading.setLayout(panelBackgroundLoadingLayout);
        panelBackgroundLoadingLayout.setHorizontalGroup(
            panelBackgroundLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
            .addGroup(panelBackgroundLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBackgroundLoadingLayout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addComponent(pgrBar, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(46, Short.MAX_VALUE)))
        );
        panelBackgroundLoadingLayout.setVerticalGroup(
            panelBackgroundLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
            .addGroup(panelBackgroundLoadingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBackgroundLoadingLayout.createSequentialGroup()
                    .addGap(155, 155, 155)
                    .addComponent(pgrBar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(156, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackgroundLoading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackgroundLoading, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        Loading_Form ld = new Loading_Form();
//        ld.setVisible(true);
//        ld.progess();
//        ld.dispose();
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new Loading_Form().setVisible(true);
////
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.PanelBackground panelBackgroundLoading;
    private javax.swing.JProgressBar pgrBar;
    // End of variables declaration//GEN-END:variables
}
