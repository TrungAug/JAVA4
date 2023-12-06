/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ttt.form;

import com.ttt.component.Form;
import com.ttt.swing.EventNavigationBar;
import com.ttt.swing.NavigationBackgroundColor;
import com.ttt.swing.PanelBackground;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author ASUS
 */
public class ThongKe_Form extends javax.swing.JFrame {
///javax.swing.JFrame

    
    public ThongKe_Form() {
       
        initComponents();
        getContentPane().setBackground(new Color(240, 240, 240));
        navigationBar2.addItem(new ImageIcon(getClass().getResource("/com/ttt/icon/inventory.png")));
        navigationBar2.addItem(new ImageIcon(getClass().getResource("/com/ttt/icon/revenue.png")));
        navigationBar2.addItem(new ImageIcon(getClass().getResource("/com/ttt/icon/sale.png")));
//        navigationBar2.addItem(new ImageIcon(getClass().getResource("/com/ttt/icon/item4.png")));
//        navigationBar2.addItem(new ImageIcon(getClass().getResource("/com/ttt/icon/item5.png")));
        navigationBar2.addEvent(new EventNavigationBar() {
            @Override
            public void beforeSelected(int index) {
                if (index == 0) {
                    panelTransitions1.display(new TonKho_Form(), navigationBar2.getAnimator());
                } else if (index == 1) {
                    panelTransitions1.display(new DoanhThu_Form(), navigationBar2.getAnimator());
                } else if (index == 2) {
                    panelTransitions1.display(new BaoCaoDoanhSo_Form(), navigationBar2.getAnimator());
                }
//                else if (index == 3) {
//                    panelTransitions1.display(new TonKho_Form(), navigationBar2.getAnimator());
//                } else if (index == 4) {             
//                    panelTransitions1.display(new TonKho_Form(), navigationBar2.getAnimator());
//                }
            }

            @Override
            public void afterSelected(int index) {

            }
        });

        NavigationBackgroundColor nb = new NavigationBackgroundColor();
        //PanelBackground nb = new PanelBackground(null);
        nb.apply(getContentPane());
        nb.addColor(0, new Color(0,51,51));
        nb.addColor(1, new Color(0,51,51));
        nb.addColor(2, new Color(0,51,51));
        nb.addColor(3, new Color(126, 209, 132));
        nb.addColor(4, new Color(226, 222, 131));
        navigationBar2.setnavigationBackgroundColor(nb);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navigationBar2 = new com.ttt.swing.NavigationBar();
        btnClose = new com.ttt.swing.Button();
        panelTransitions1 = new com.ttt.transitions.PanelTransitions();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 51, 102));
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navigationBar2Layout = new javax.swing.GroupLayout(navigationBar2);
        navigationBar2.setLayout(navigationBar2Layout);
        navigationBar2Layout.setHorizontalGroup(
            navigationBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navigationBar2Layout.createSequentialGroup()
                .addContainerGap(844, Short.MAX_VALUE)
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        navigationBar2Layout.setVerticalGroup(
            navigationBar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navigationBar2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(navigationBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(panelTransitions1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelTransitions1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(navigationBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        navigationBar2.initSelectedIndex(0);
    }//GEN-LAST:event_formWindowOpened

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(ThongKe_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ThongKe_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ThongKe_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ThongKe_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {           
//                   new ThongKe_Form().setVisible(true); 
//   
//            }
//        });          
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.Button btnClose;
    private com.ttt.swing.NavigationBar navigationBar2;
    private com.ttt.transitions.PanelTransitions panelTransitions1;
    // End of variables declaration//GEN-END:variables
}
