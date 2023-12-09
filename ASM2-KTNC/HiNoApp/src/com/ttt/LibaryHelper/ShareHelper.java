/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.LibaryHelper;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import static javax.swing.SpringLayout.WIDTH;

/**
 *
 * @author ASUS
 */
public class ShareHelper {
//    public static String nameHinh;
//    public static String pathHinh;
//    
//    public static ImageIcon getAppIcon(){
//         JFileChooser jfc = new JFileChooser();
//        int asw = jfc.showOpenDialog(null);
//        if (asw == JFileChooser.APPROVE_OPTION) {
//            File file = jfc.getSelectedFile();
//            nameHinh = file.getName();
//            pathHinh = file.getPath();
//            try {
//                Image img = ImageIO.read(file);
//                return new ImageIcon(img.getScaledInstance(130, 130,Image.SCALE_SMOOTH));
//            } catch (IOException ex) {
//                Logger.getLogger(ShareHelper.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return null;
//    }

    public static Image getAppIcon() {
        URL url = ShareHelper.class.getResource("/com/ttt/icon.png");
        return new ImageIcon(url).getImage();
    }

    public static ImageIcon read(String fileName) {   
        try {
            File path = new File(".\\HinhNhanVien", fileName);
            Image img = ImageIO.read(path);
            ImageIcon icon = new ImageIcon(img.getScaledInstance(160, 220, Image.SCALE_SMOOTH));
            return icon;
        } catch (IOException ex) {
           // Logger.getLogger(ShareHelper.class.getName()).log(Level.SEVERE, null, ex);
            DialogHelper.alert(null, "Không tìm thấy file hình. Vui lòng cập nhật lại hình");
        }

        //return new ImageIcon(path.getAbsolutePath());
        return null;
    }

    public static void save(String name,File src) {
        String file_name = name+"_"+ src.getName();              
        File dst = new File(".\\HinhNhanVien", file_name);

        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }
        try {
            Path from = Paths.get(src.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
