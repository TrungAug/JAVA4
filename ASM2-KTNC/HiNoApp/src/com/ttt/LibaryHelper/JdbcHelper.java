/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ttt.LibaryHelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author ASUS
 */
public class JdbcHelper {

    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://localhost:1433;databaseName=HinoData;encrypt=false;";
    static String userName = "admin";
    static String passWord = "123456";
    
    static {
        try{
            Class.forName(driver);
        }catch(ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    
    public static PreparedStatement getStmt(String sql,Object...args) throws SQLException{
         Connection con=DriverManager.getConnection(url, userName, passWord);
         PreparedStatement stmt;
         if(sql.trim().startsWith("{")){
             stmt=con.prepareCall(sql);
         }else{
             stmt=con.prepareStatement(sql);
         }
         for(int i=0;i<args.length;i++){
             stmt.setObject(i+1, args[i]);
         }
        return stmt;
        
    }
    public static int update(String sql,Object...args) throws SQLException{
        
        try {
            PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } 
            finally{
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    public static ResultSet query(String sql,Object...args)throws SQLException{
        PreparedStatement stmt = JdbcHelper.getStmt(sql, args);
        
        return stmt.executeQuery();
            
    }
    public static Object value(String sql,Object...args){
        try{
            ResultSet rs = JdbcHelper.query(sql, args);
            if(rs.next()){
                return rs.getObject(sql);
            }
            rs.getStatement().getConnection().close();
            return null;
        }catch(Exception e)
        {
            throw new RuntimeException(e);
        }   
        
    }
}
