package com.ttt.form;

import com.ttt.component.Form;
import com.ttt.event.EventColorChange;
import com.ttt.properties.SystemProperties;
import com.ttt.swing.EventSwitchSelected;
import com.ttt.theme.ThemeColorChange;
import java.awt.Color;

public final class CaiDat_Form extends Form {

    public CaiDat_Form() {
        initComponents();
        ThemeColorChange.getInstance().addEventColorChange(new EventColorChange() {
            @Override
            public void colorChange(Color color) {
                switchButton.setBackground(color);
                imageBackgroundOption1.getSwitch().setBackground(color);

            }
        });
        if (ThemeColorChange.getInstance().getMode() == ThemeColorChange.Mode.LIGHT) {
            lbDark.setForeground(new Color(80, 80, 80));
            lbColor.setForeground(new Color(80, 80, 80));
        }
    }

    @Override
    public void changeColor(Color color) {
        lbDark.setForeground(color);
        lbColor.setForeground(color);
        imageBackgroundOption1.changeColorLabel(color);
    }

    public void setEventColorChange(EventColorChange event) {
        colorOption1.setEvent(event);
    }

    public void setSelectedThemeColor(Color color) {
        colorOption1.setSelectedColor(color);
    }

    public void setDarkMode(boolean darkMode) {
        switchButton.setSelected(darkMode);
        switchButton.addEventSelected(new EventSwitchSelected() {
            @Override
            public void onSelected(boolean selected) {
                new SystemProperties().save("dark_mode", selected + "");
                if (selected) {
                    ThemeColorChange.getInstance().changeMode(ThemeColorChange.Mode.DARK);
                } else {
                    ThemeColorChange.getInstance().changeMode(ThemeColorChange.Mode.LIGHT);
                }
            }
        });
    }

    public void initBackgroundImage(String imageSelected) {
        imageBackgroundOption1.init(imageSelected);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        selectMode = new javax.swing.JPanel();
        lbDark = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        switchButton = new com.ttt.swing.SwitchButton();
        jPanel3 = new javax.swing.JPanel();
        lbColor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        colorOption1 = new com.ttt.component.ColorOption();
        imageBackgroundOption1 = new com.ttt.component.ImageBackgroundOption();

        selectMode.setOpaque(false);

        lbDark.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        lbDark.setForeground(new java.awt.Color(230, 230, 230));
        lbDark.setText("Dark mode");

        jLabel2.setForeground(new java.awt.Color(128, 128, 128));
        jLabel2.setText("Use darker color paletter for system backgrounds and compatible apps");

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(switchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(switchButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout selectModeLayout = new javax.swing.GroupLayout(selectMode);
        selectMode.setLayout(selectModeLayout);
        selectModeLayout.setHorizontalGroup(
            selectModeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectModeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectModeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(lbDark))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        selectModeLayout.setVerticalGroup(
            selectModeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(selectModeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(selectModeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(selectModeLayout.createSequentialGroup()
                        .addComponent(lbDark)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setOpaque(false);

        lbColor.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        lbColor.setForeground(new java.awt.Color(230, 230, 230));
        lbColor.setText("Theme Color");

        jLabel4.setForeground(new java.awt.Color(128, 128, 128));
        jLabel4.setText("Select color to set theme system");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbColor)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(colorOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbColor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(colorOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imageBackgroundOption1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectMode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imageBackgroundOption1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.component.ColorOption colorOption1;
    private com.ttt.component.ImageBackgroundOption imageBackgroundOption1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbColor;
    private javax.swing.JLabel lbDark;
    private javax.swing.JPanel selectMode;
    private com.ttt.swing.SwitchButton switchButton;
    // End of variables declaration//GEN-END:variables
}
