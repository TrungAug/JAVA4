package com.ttt.component;

import com.ttt.properties.SystemProperties;
import com.ttt.swing.EventSwitchSelected;
import com.ttt.swing.SwitchButton;
import com.ttt.theme.ThemeColorChange;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class ImageBackgroundOption extends javax.swing.JPanel {

    private MigLayout layout;

    public ImageBackgroundOption() {
        initComponents();
        layout = new MigLayout("fill, wrap 1, inset 0", "[fill]", "[]0[0!]");
        setLayout(layout);
        switchButton.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean selected) {
                if (!selected) {
                    ThemeColorChange.getInstance().changeBackgroundImage("");
                    new SystemProperties().save("background_image", "");
                }
            }
        });
        switchButton.getAnimator().addTarget(new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double size;
                if (switchButton.isSelected()) {
                    size = (1f - fraction) * 68;
                } else {
                    size = fraction * 68;
                }
                layout.setRowConstraints("[]0[" + size + "!]");
                revalidate();
            }

            @Override
            public void end() {
                if (!switchButton.isSelected()) {
                    clearSelected();
                }
            }
        });
        addEvent();
       
    }

    public SwitchButton getSwitch() {
        return switchButton;
    }

    public void changeColorLabel(Color color) {
        lbBack.setForeground(color);
    }

    private void addEvent() {
        int image = 6;
        for (Component com : panel.getComponents()) {
            JButton cmd = (JButton) com;
            cmd.setName("bg_" + image++ + ".jpg");
            cmd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    clearSelected();
                    cmd.setSelected(true);
                    ThemeColorChange.getInstance().changeBackgroundImage(cmd.getName());
                    new SystemProperties().save("background_image", cmd.getName());
                }
            });
        }
    }

    private void clearSelected() {
        for (Component com : panel.getComponents()) {
            JButton cmd = (JButton) com;
            cmd.setSelected(false);
        }
    }

    public void init(String imageSelected) {
        setSelected(imageSelected);
        if (!imageSelected.equals("")) {
            switchButton.setSelected(true);
            layout.setRowConstraints("[]0[68!]");
            revalidate();
        }
    }

    public void setSelected(String imageSelected) {
        clearSelected();
        for (Component com : panel.getComponents()) {
            JButton cmd = (JButton) com;
            if (cmd.getName().equals(imageSelected)) {
                cmd.setSelected(true);
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbBack = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        switchButton = new com.ttt.swing.SwitchButton();
        panel = new javax.swing.JPanel();
        buttomImage1 = new com.ttt.swing.ButtomImage();
        buttomImage2 = new com.ttt.swing.ButtomImage();
        buttomImage3 = new com.ttt.swing.ButtomImage();
        buttomImage4 = new com.ttt.swing.ButtomImage();
        buttomImage5 = new com.ttt.swing.ButtomImage();

        setOpaque(false);

        jPanel1.setOpaque(false);

        lbBack.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        lbBack.setForeground(new java.awt.Color(230, 230, 230));
        lbBack.setText("Background Image");

        jLabel2.setForeground(new java.awt.Color(128, 128, 128));
        jLabel2.setText("Use simple image as background of system");

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBack)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 518, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(switchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(switchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panel.setOpaque(false);

        buttomImage1.setIcon(new javax.swing.ImageIcon("D:\\SUMMER 2023\\Du An 1\\3tProject\\HiNoApp\\src\\com\\ttt\\background\\bg_6_small.jpg")); // NOI18N
        buttomImage1.setSelected(true);

        buttomImage2.setIcon(new javax.swing.ImageIcon("D:\\SUMMER 2023\\Du An 1\\3tProject\\HiNoApp\\src\\com\\ttt\\background\\bg_7_small.jpg")); // NOI18N

        buttomImage3.setIcon(new javax.swing.ImageIcon("D:\\SUMMER 2023\\Du An 1\\3tProject\\HiNoApp\\src\\com\\ttt\\background\\bg_8_small.jpg")); // NOI18N

        buttomImage4.setIcon(new javax.swing.ImageIcon("D:\\SUMMER 2023\\Du An 1\\3tProject\\HiNoApp\\src\\com\\ttt\\background\\bg_10_small.jpg")); // NOI18N

        buttomImage5.setIcon(new javax.swing.ImageIcon("D:\\SUMMER 2023\\Du An 1\\3tProject\\HiNoApp\\src\\com\\ttt\\background\\bg_9_small.jpg")); // NOI18N
        buttomImage5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttomImage5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttomImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttomImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(buttomImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttomImage5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttomImage4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttomImage5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttomImage4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttomImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttomImage3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttomImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttomImage5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttomImage5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttomImage5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.swing.ButtomImage buttomImage1;
    private com.ttt.swing.ButtomImage buttomImage2;
    private com.ttt.swing.ButtomImage buttomImage3;
    private com.ttt.swing.ButtomImage buttomImage4;
    private com.ttt.swing.ButtomImage buttomImage5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbBack;
    private javax.swing.JPanel panel;
    private com.ttt.swing.SwitchButton switchButton;
    // End of variables declaration//GEN-END:variables
}
