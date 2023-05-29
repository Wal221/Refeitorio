/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexaoDAO {
    
 public Connection conectaBD(){
      Connection conn = null;
      
      try {
          String url ="jdbc:mysql://localhost:3306/pessoas" ;
          Class.forName("com.mysql.cj.jdbc.Driver");
          conn = DriverManager.getConnection(url+"?userTimezone=true&serverTimezone=UTC&useSSL=false","root","6037");
          
     } catch (SQLException e) {
          JOptionPane.showMessageDialog(null,"ConexaoDAO: "+ e.getMessage());
     } 
      catch (ClassNotFoundException ex) {
         Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
     }
      
      return conn;
 }
    
    
}