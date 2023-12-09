package com.ttt.menu;

import com.ttt.DAO.NhanVienDAO;
import com.ttt.LibaryHelper.Auth;
import com.ttt.LibaryHelper.ShareHelper;
import com.ttt.swing.MenuButton;
import com.ttt.theme.ImageAvatar;
import com.ttt.theme.SystemTheme;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

public class Menu extends javax.swing.JPanel {

    public int getSelectedLocation() {
        return selectedLocation;
    }

    public void setSelectedLocation(int selectedLocation) {
        this.selectedLocation = selectedLocation;
        repaint();
    }

    public void addEventMenu(EventMenu event) {
        this.events.add(event);
    }

    private int selectedIndex = 0;
    private Animator animator;
    private TimingTarget target;
    private int selectedLocation = 151;
    private int targetLocation;
    private List<EventMenu> events = new ArrayList<>();
    String nameImg;// = "ttt_1_small.jpg"; //Update Img from database User.getHinh
    public static JLabel labelTen;
    public static JLabel labelChucVu;
    public static ImageAvatar avatar;
    public static Menu getInstance;
             
    public Menu() {
        initComponents();
        setOpaque(false);
        setBackground(Color.WHITE);
        menu.setLayout(new MigLayout("fillx, wrap, inset 0", "[fill]", "[fill, 36!]0[fill, 36!]"));
        initMenu();
        labelTen=lblName;
        labelChucVu=lblRole;
        avatar=imageAvatar;
        getInstance=this;
    }

    private void initAthur() {
     
        if (Auth.user != null) {
            nameImg = Auth.user.getHinh();
            lblName.setText(Auth.user.getHoTen());
            lblRole.setText(Auth.user.getChucVu());
            //URL location = getClass().getResource("/com/ttt/" + nameImg);
            ImageIcon icon = ShareHelper.read(nameImg);
            if (icon != null) {
                imageAvatar.setImage(icon);
            }
        }
    }

    private void initMenu() {
        initAthur();       
        addMenu("Dashboard", "1", 0);
        addMenu("Chi Nhánh", "22", 1);
        addMenu("Phòng Ban", "23", 2);
        addMenu("Vị Trí Lưu Kho", "24", 3);
        addMenu("Loại Xe", "25", 4);
        addMenu("Thông Tin Nhân Viên", "26", 5);
        addMenu("Thông Tin Khách Hàng", "27", 6);
        addMenu("Phiếu Nhập Kho", "28", 7);
        addMenu("Phiếu Xuất Kho", "29", 8);
        addMenu("Báo Cáo Thống Kê", "30", 9);
        addMenu("Đăng Xuất", "31", 10);
        addMenu("Thoát", "32", 11);
        addMenu("Đổi Mật Khẩu", "33", 12);
        addMenu("Cài Đặt", "7", 13);
        //update icon
        //  add more menu here
        menu.repaint();
        menu.revalidate();
        setSelectedMenu(0);
        animator = new Animator(300);
        animator.addTarget(new TimingTargetAdapter() {
            @Override
            public void begin() {
                clearSelected();
            }

            @Override
            public void end() {
                setSelectedMenu(selectedIndex);
                runEvent();
            }
        });
        animator.setDeceleration(.5f);
        animator.setAcceleration(.5f);
        animator.setResolution(0);
    }

    private void addMenu(String menuName, String icon, int index) {
        MenuButton m = new MenuButton();
        m.setIcoName(icon);
        URL location=getClass().getResource("/com/ttt/icon/" + icon + ".png");
        if(location!=null){
            m.setIcon(new ImageIcon(location));
        }        
        m.setFont(m.getFont().deriveFont(Font.BOLD, 12));
        m.setForeground(new Color(127, 127, 127));
        m.setHorizontalAlignment(JButton.LEFT);
        m.setText("  " + menuName);
        m.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (index != selectedIndex) {
                    if (animator.isRunning()) {
                        animator.stop();
                    }
                    int y = m.getY() + menu.getY();
                    targetLocation = y;
                    selectedIndex = index;
                    animator.removeTarget(target);
                    target = new PropertySetter(Menu.this, "selectedLocation", selectedLocation, targetLocation);
                    animator.addTarget(target);
                    animator.start();
                }
            }
        });
        menu.add(m);
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int y = selectedLocation;
        g2.setColor(SystemTheme.mainColor);
        g2.fill(createShape(y));
        g2.dispose();
        super.paintComponent(grphcs);
    }

    private Shape createShape(int y) {
        int width = getWidth() - 12;
        int r = 20;
        Area area = new Area(new RoundRectangle2D.Float(6, y, width, 35, r, r));
        area.add(new Area(new RoundRectangle2D.Float(width - r + 6, y, r, r, 5, 5)));
        area.add(new Area(new RoundRectangle2D.Float(6, y + 35 - r, r, r, 5, 5)));
        return area;
    }

    private void clearSelected() {
        for (Component com : menu.getComponents()) {
            if (com instanceof MenuButton) {
                MenuButton c = (MenuButton) com;
                c.setForeground(new Color(127, 127, 127));
                c.setEffectColor(new Color(173, 173, 173));
                if (!c.getIcoName().contains("_s")) {
                    c.setIcon(new ImageIcon(getClass().getResource("/com/ttt/icon/" + c.getIcoName() + ".png")));
                }
            }
        }
    }

    public void setSelectedMenu(int index) {
        MenuButton cmd = (MenuButton) menu.getComponent(index);
        cmd.setForeground(Color.WHITE);
        cmd.setEffectColor(Color.WHITE);
        cmd.setIcon(new ImageIcon(getClass().getResource("/com/ttt/icon/" + cmd.getIcoName() + "_s.png")));
    }

    private void runEvent() {
        for (EventMenu event : events) {
            event.selectedMenu(selectedIndex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        imageAvatar = new com.ttt.theme.ImageAvatar();

        menu.setOpaque(false);

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        lblName.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(117, 117, 117));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.setText("Dashboard UI");

        lblRole.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lblRole.setForeground(new java.awt.Color(154, 154, 154));
        lblRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRole.setText("Admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRole, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(lblName)
                .addGap(3, 3, 3)
                .addComponent(lblRole)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.ttt.theme.ImageAvatar imageAvatar;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRole;
    private javax.swing.JPanel menu;
    // End of variables declaration//GEN-END:variables
}
