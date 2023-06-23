package DAO;

import Model.EstudanteTicket;
import Model.Funcionario;

import java.sql.ResultSet;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {
    
 


    public void save(Funcionario funcionario) {
        String sql = "INSERT INTO pessoa(matricula, nome ,idade, cpf,senha,catego_estudante) VALUES(?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            //criando conexão com BD
            ConexaoDAO conect = new ConexaoDAO();
            con = conect.conectaBD();

            //criado uma PreparedStatement ,para executar uma query
            pstm = con.prepareStatement(sql);

            //Adicionando valores que são esperados de um funcionaio
            pstm.setInt(1, funcionario.getMatricula());
            pstm.setString(2, funcionario.getNome());
            pstm.setInt(3, funcionario.getIdade());
            pstm.setString(4, funcionario.getCpf());
            pstm.setString(5, funcionario.getSenha());
            pstm.setString(6, "Funcionario");
          

            pstm.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO" + e.getMessage());

        } finally {
            //fecha as conexões
            try {
                if (pstm != null) {
                    pstm.close();

                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        // Lógica para salvar o funcionario no banco de dados
        // Utilize a conexão "connection" para executar as operações necessárias
        // ...
    }
    
    public ResultSet autenti(Funcionario funcio){
        
          ConexaoDAO  conect = new ConexaoDAO();
        Connection conn = conect.conectaBD();
              
        
        try{
            String sql = " select *from pessoa where matricula = ? and senha = ?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            //Esse ponto de interrogação significa que estou prepara a conexão e passa ele na primeira posição
             pstm.setInt(1, funcio.getMatricula());
            //ja a segundo interrogação segue o mesmo padrão 
            pstm.setString(2, funcio.getSenha());
            //para resumir esse codigo vai trazer o Funcionario atravez do nosso select onde o funcionario e a sua senha 
            //que ja estiver no banco que voce vai digitar
            
            ResultSet rs = pstm.executeQuery();
            
            return rs;
            

            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "FuncionarioDAO"+ e.getMessage());
            return null;
        }
        
        
        
    }
     public void recarga(EstudanteTicket estu, Double recarga){ 
       // Funcionario func = new Funcionario(0, senha);
        Connection conn = new ConexaoDAO().conectaBD();
        recarga(estu, recarga);
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
       
       
        try {
            String sql = "UPDATE pessoa SET saldo = saldo + ? WHERE matricula = ?";
            pstm = conn.prepareStatement(sql);
 
            if(recarga > 0){
            pstm.setDouble(1, recarga);
            pstm.setInt(2, estu.getMatricula());
     
            pstm.executeUpdate();
            }else{
            JOptionPane.showMessageDialog(null,"EstudanteTicketDAORecarga Digite um valor"
                    + "valido" + recarga);
            }
           
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"EstudanteTicketDAORecarga" + recarga);
           
        }
       
   }  public  List<Funcionario> listFuncionarios( ){
         
       
        Double usaCartao;
        Connection conn = new ConexaoDAO().conectaBD();
        
        PreparedStatement pstm = null;
        ResultSet rs = null;
         List<Funcionario> f = new ArrayList<>();
         
        try {
            
            String sql = "SELECT *FROM pessoa WHERE senha IS NOT NULL ";
              pstm = conn.prepareStatement(sql);
              rs = pstm.executeQuery();
           
              while(rs.next()){
                  Funcionario func = new Funcionario();
                  func.setMatricula(rs.getInt("matricula"));
                  func.setNome(rs.getNString("nome"));
                  func.setIdade(rs.getInt("idade"));
                  
                  f.add(func);
             }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"EstudanteTicketDAORecarga"+ e.getMessage());
           
        }
        return f;
   }
    
    
    
}
