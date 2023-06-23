/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Cartao;
import Model.Estudante;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Time;

import Model.Estudante;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.JOptionPane;

import Model.EstudanteTicket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

;

/**
 *
 * @author Administrador
 */
public class EstudanteTicketDAO {

    public void save(EstudanteTicket student) {
        //salvamo um estudante por vez , ja na hora de recuperar recupermos uma lista de estudante
        // Lógica para salvar o funcionario no banco de dados
        // Utilize a conexão "connection" para executar as operações necessárias
        // ...
        String sql = "INSERT INTO pessoa(matricula, nome ,idade, cpf, catego_estudante"
                + ",dia_de_uso , horario_inicio,horario_fim,saldo, num_cartao ) VALUES(?,?,?,?,?,?,?,?,?,?)";
        Connection con = null;
        
        PreparedStatement pstm = null;
        
        try {
            ConexaoDAO conect = new ConexaoDAO();
            con = conect.conectaBD();
            pstm = con.prepareStatement(sql);

            Time horarioIni = Time.valueOf("11:30:00");
            Time horarioFim = Time.valueOf("12:15:00");

            pstm.setInt(1, student.getMatricula());
            pstm.setString(2, student.getNome());
            pstm.setInt(3, student.getIdade());
            pstm.setString(4, student.getCpf());
            pstm.setString(5, student.getCategoria());
            pstm.setString(6, "Seg a Sext");
            pstm.setTime(7, horarioIni);
            pstm.setTime(8, horarioFim);
            pstm.setDouble(9, student.getSaldo());
            pstm.setInt(10,student.getCartao().getNum_cartao());

            pstm.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ESTUDANTETICKDAO" + e.getMessage());

        }

    }

    
    
    
    public void alterar(EstudanteTicket estudante) {
        //obj conection onde estamos nos conectando ao bd de dados
        Connection conn = new ConexaoDAO().conectaBD();

        PreparedStatement pstm = null;

        try {
            String sql = "UPDATE pessoa SET saldo = saldo + ? WHERE matricula = ? ";
            //adiona o valor do primeiro parametro que setei , nesse caso  o saldo
            pstm = conn.prepareStatement(sql);
             
             
             pstm.setDouble(1, estudante.getSaldo());
             pstm.setInt(2, estudante.getMatricula());
             
         
            System.err.println("matricula" + estudante.getMatricula());
          
            pstm.executeUpdate();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "EstudanteTickectDAO" + ex.getMessage());
        }
        finally{
           
             try{
                 
                 if(pstm != null) pstm.close();
                 
                 if(conn != null) conn.close();
                 
             }catch(Exception e){
                 e.printStackTrace();
                 
             }
             
         }
    }
    
    
    
    
    
    public List<EstudanteTicket> listar(){
         Connection conn = new ConexaoDAO().conectaBD();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        
         List<EstudanteTicket> student = new ArrayList<>();
              Cartao cartao = new Cartao();
         try {
             String sql = "SELECT *FROM pessoa WHERE senha IS NULL";
             
              pstm = conn.prepareStatement(sql);
              rs = pstm.executeQuery();
           
              while(rs.next()){
                  EstudanteTicket est = new EstudanteTicket();
                  
                  est.setMatricula(rs.getInt("matricula"));
                  est.setNome(rs.getNString("nome"));
                  est.setSaldo(rs.getDouble("saldo"));
                  int num = (rs.getInt("num_cartao"));
                   cartao.setNum_cartao(num);
                   est.setCartao(cartao);
                   
             
                  
                 
                  student.add(est);
                  
                  
                  
              }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "EstudanteTickectDAO: " + ex.getMessage());
        }finally{
           
             try{
                 if(rs != null)rs.close();
                 
                 if(pstm != null) pstm.close();
                 
                 if(conn != null) conn.close();
                 
             }catch(Exception e){
                 e.printStackTrace();
                 
             }
             
         }
        
        return student;
    }
    
    
    
   public void recarga(EstudanteTicket estu, Double recarga){ 
        estu.recarrega(recarga);
        Connection conn = new ConexaoDAO().conectaBD();

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
       
   }
   
   
   
   
   public EstudanteTicket select(EstudanteTicket estudante){
        Connection conn = new ConexaoDAO().conectaBD();
           Cartao cartao = new Cartao();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        //EstudanteTicket est = new EstudanteTicket();
        try{
            /*estou pesquisando no banco de dados por Estudante que contenham a senha nula
             e a matricula que eu pesquisa 
            */
      
           
             String sql = "SELECT *FROM pessoa WHERE senha IS NULL and matricula = ? ";
             
              pstm = conn.prepareStatement(sql);
              pstm.setInt(1, estudante.getMatricula());
              rs = pstm.executeQuery();
              
              //Se por acaso for encontrado no banco de dado e por que provavelmente
              //o rs existe ou seja ele foi para a proxima linha
              //dessa forma eu recupero a minha entidade com meu saldo e matricula desejado
              if(rs.next()){
              estudante.setMatricula(rs.getInt("matricula"));
              estudante.setSaldo(rs.getDouble("saldo"));
              // Recupere o número do cartão do ResultSet e atribua-o ao objeto Cartao
              
              int numCartao = rs.getInt("num_cartao");
              cartao.setNum_cartao(numCartao);
              estudante.setCartao(cartao);
              
              
              //A variavel local do estudante ficara mantida aqui para que se
              // a entidade buscada for encontrada eu possa a utilizar s
          
              }
               pstm.execute();
            
        }catch(SQLException e ){
            JOptionPane.showMessageDialog(null,"SelectEstudanteTickDAO" + e.getMessage());
            
        }
        return estudante;
       
   }
   
   
   
   
   public EstudanteTicket usar(EstudanteTicket estu){ 
        Double usaCartao;
        Connection conn = new ConexaoDAO().conectaBD();
   
        PreparedStatement pstm = null;
        ResultSet rs = null;
      
         
        try {
       
            //no primeiro parametro da minha atualização , essa atualização sera realizada na
            //classe EstudanteTick na qual e recuperado uma entidade atravez da sua matricula , e com isso 
            // e recuperado tambem o seu saldo, ao utilizar o metodo usar cartão , e pego o saldo do aluno e decremetado
            // 1,50 fixamente , em seguida esse saldo e recuperado e atualizado atravez desse metodo
            // ja que nessa classe e necessaria somente para acessar o banco de dados , as seguintes operações e 
            // realizada somente na classe EstudanteTick da qual , o classe dao recupera somente os resultados dos metodos 
            // feitos nessa classe
            String sql = "UPDATE pessoa SET saldo = ?   WHERE matricula = ?";
            pstm = conn.prepareStatement(sql);
             
             
             pstm.setDouble(1, estu.usaCartao());
             pstm.setInt(2, estu.getMatricula());
            
     
             
             
            pstm.executeUpdate();
          
             System.out.println("Cartão usado com sucesso boa refeição!");
             
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"EstudanteTicketDAORecarga"+ e.getMessage());
           
        }finally{
           
             try{
                 if(rs != null)rs.close();
                 
                 if(pstm != null) pstm.close();
                 
                 if(conn != null) conn.close();
                 
             }catch(Exception e){
                 e.printStackTrace();
                 
             }
             
         }
        
       return estu;
   }
   
   public  List<EstudanteTicket> salvarUsa( EstudanteTicket estu){
         
       
        Double usaCartao;
        Connection conn = new ConexaoDAO().conectaBD();
   
        PreparedStatement pstm = null;
        ResultSet rs = null;
         List<EstudanteTicket> es = new ArrayList<>();
         
        try {
            
            String sql = "SELECT *FROM pessoa WHERE senha IS NULL and matricula = ? ";
             
              pstm = conn.prepareStatement(sql);
              pstm.setInt(1, estu.getMatricula());
              rs = pstm.executeQuery();
     
           
             if(rs.next()){
             estu.setMatricula(rs.getInt("matricula"));
             estu.setNome(rs.getNString("nome"));
              // Recupere o número do cartão do ResultSet e atribua-o ao objeto Cartao
              
             System.out.println("Cartão usado com sucesso boa refeição!");
             }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"EstudanteTicketDAORecarga"+ e.getMessage());
           
        }
        return es;
   }
   
   

}
