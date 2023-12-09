/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.LibaryHelper;

import com.ttt.Chart.Chart;
import com.ttt.Chart.ModelChart;
import com.ttt.DAO.ThongKeDAO;
import com.ttt.Chart.ModelPieChart;
import com.ttt.Chart.PieChart;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author ASUS
 */
public class ShowChartHelper {

    public static void showPieChart_DoanhThu(JPanel panelBarChart) {
        DefaultPieDataset barDataset = new DefaultPieDataset();
        List<Object[]> list = ThongKeDAO.getNewThongKeDAO().getDoanhThu();
        for (int i = 0; i < list.size(); i++) {
            Object[] obj = list.get(i);
            //System.out.println(Arrays.toString(obj));
            String getName = null;
            Double getDoanhThu = null;
            for (int j = 0; j < obj.length; j++) {
                getName = (String) obj[1];
                getDoanhThu = (Double) obj[3];
            }
            barDataset.setValue(getName+"-"+getDoanhThu, getDoanhThu);

        }
        //create chart
        JFreeChart piechart = ChartFactory.createPieChart("Doanh Thu Bán Hàng", barDataset, false, true, false);//explain

        PiePlot piePlot = (PiePlot) piechart.getPlot();
        //changing pie chart blocks colors
//        piePlot.setSectionPaint("Xe tải cẩu XZU730L", new Color(255, 255, 102));
//        piePlot.setSectionPaint("XE MUI BẠT FCJL", new Color(102, 255, 102));
//        piePlot.setSectionPaint("XE TẢI CẨU FLJL", new Color(255, 102, 153));
//        piePlot.setSectionPaint("XE MUI BẠT FLJL", new Color(0, 204, 204));
        piePlot.setBackgroundPaint(new Color(0,51,51));

        //create chartPanel to display chart(graph)
        ChartPanel barChartPanel = new ChartPanel(piechart);
        panelBarChart.removeAll();
        panelBarChart.add(barChartPanel, BorderLayout.CENTER);
        panelBarChart.validate();
    }

    public static void showBarChart_DoanhSo(JPanel jPanel1) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        List<Object[]> list = ThongKeDAO.getNewThongKeDAO().getSoLuongCuaNhanVienKD();
        for (int i = 0; i < list.size(); i++) {
            Object[] obj = list.get(i);
            // System.out.println(Arrays.toString(obj));
            String getName = null;
            int getSoLuong = 0;
            for (int j = 0; j < obj.length; j++) {
                getName = (String) obj[1];
                getSoLuong = (Integer) obj[2];

            }
//            System.out.println(getName);
//            System.out.println(getSoLuong);
            dataset.setValue(getSoLuong, "Số lượng bán", getName);

        }
        JFreeChart chart = ChartFactory.createBarChart("Doanh số bán hàng", "Nhân viên kinh doanh", "Số lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        //categoryPlot.setBackgroundPaint(Color.WHITE);
         categoryPlot.setBackgroundPaint(new Color(0,51,51));
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204, 0, 51);
        renderer.setSeriesPaint(0, clr3);

        ChartPanel barpChartPanel = new ChartPanel(chart);
        jPanel1.removeAll();
        jPanel1.add(barpChartPanel, BorderLayout.CENTER);
        jPanel1.validate();
    }
    
    public static void showChart_DoanhThu(PieChart pieChart1) {
        pieChart1.setChartType(PieChart.PeiChartType.DONUT_CHART);
        List<Object[]> list = ThongKeDAO.getNewThongKeDAO().getDoanhThu();
        for (int i = 0; i < list.size(); i++) {
            Object[] obj = list.get(i);
            //System.out.println(Arrays.toString(obj));
            String getName = null;
            Double getDoanhThu = null;
            for (int j = 0; j < obj.length; j++) {
                getName = (String) obj[1];
                getDoanhThu = (Double) obj[3];
            }
            pieChart1.addData(new ModelPieChart(getName + "-" + getDoanhThu, getDoanhThu, getColor(getName)));
 
        }
    }

    public static Color getColor(String name) {
        Color color = new Color(0, 51, 51);
        if (name.equalsIgnoreCase("XE MUI BẠT FCJJ")) {          
            color = new Color(255, 153, 255);
        } else if (name.equalsIgnoreCase("XE TẢI CẨU FCJJ")) {
            color = new Color(204, 255, 51);
        } else if (name.equalsIgnoreCase("XE MUI BẠT FCJL")) {
            color = new Color(196, 151, 58);
        } else if (name.equalsIgnoreCase("XE TẢI CẨU FCJL")) {
            color = new Color(255, 153, 153);
        } else if (name.equalsIgnoreCase("XE MUI BẠT FLJL")) {
            color = new Color(221, 65, 65);
        } else if (name.equalsIgnoreCase("XE TẢI CẨU FLJL")) {
            color = new Color(47, 157, 64);
        } else if (name.equalsIgnoreCase("XE MUI BẠT XZU730L")) {
            color = new Color(51, 255, 204);
        } else if (name.equalsIgnoreCase("XE TẢI CẨU XZU730L")) {
            color = new Color(23, 126, 238);
        }
        return color;
    }
    
    public static void showChart_DoanhSo(Chart chart) {
        chart.addLegend("Số lượng bán", new Color(0,153,153));
        List<Object[]> list = ThongKeDAO.getNewThongKeDAO().getSoLuongCuaNhanVienKD();
        for (int i = 0; i < list.size(); i++) {
            Object[] obj = list.get(i);
            // System.out.println(Arrays.toString(obj));
            String getName = null;
            int getSoLuong = 0;
            for (int j = 0; j < obj.length; j++) {
                getName = (String) obj[1];
                getSoLuong = (Integer) obj[2];

            }
            chart.addData(new ModelChart(getName, new double[]{getSoLuong}));
        }
    }
}
