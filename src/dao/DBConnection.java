/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Android Team
 */
public class DBConnection {

    public  static Connection setConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/tiketpesawat", "root", "");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal :" + e);
        }
        return null;
    }

}
