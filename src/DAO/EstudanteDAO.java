/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Cartao;
import Model.Estudante;
import Model.EstudanteTicket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class EstudanteDAO {

    public void save(Estudante student) {
        //salvamo um estudante por vez , ja na hora de recuperar recupermos uma lista de estudante
        // Lógica para salvar o funcionario no banco de dados
        // Utilize a conexão "connection" para executar as operações necessárias
        // ...
        String sql = "INSERT INTO pessoa(matricula, nome ,idade, cpf, catego_estudante"
                + ",dia_de_uso , horario_inicio,horario_fim ) VALUES(?,?,?,?,?,?,?,?)";
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            ConexaoDAO conect = new ConexaoDAO();
            con = conect.conectaBD();
            pstm = con.prepareStatement(sql);

            Time horarioIni = Time.valueOf("11:00:00");
            Time horarioFim = Time.valueOf("12:00:00");

            pstm.setInt(1, student.getMatricula());
            pstm.setString(2, student.getNome());
            pstm.setInt(3, student.getIdade());
            pstm.setString(4, student.getCpf());
            pstm.setString(5, student.getCategoria());
            pstm.setString(6, "Seg a Sext");
            pstm.setTime(7, horarioIni);
            pstm.setTime(8, horarioFim);
          
           
            
            pstm.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ESTUDANTETICKDAO" + e.getMessage());

        }finally{
           
             try{
                 
                 
                 if(pstm != null) pstm.close();
                 
                 if(con != null) con.close();
                 
             }catch(Exception e){
                 e.printStackTrace();
                 
             }
             
         }

    }
    
    
    public void alterar(Estudante estudante){
         //obj conection onde estamos nos conectando ao bd de dados
        Connection conn = new ConexaoDAO().conectaBD();

        PreparedStatement pstm = null;

        try {
            String sql = "UPDATE pessoa SET nome = ? WHERE matricula = ?";
            //adiona o valor do primeiro parametro que setei , nesse caso  o saldo
            pstm = conn.prepareStatement(sql);
           
             pstm.setNString(1,estudante.getNome());
             pstm.setInt(2, estudante.getMatricula());
            
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
    
    
        public List<Estudante> listar(){
         Connection conn = new ConexaoDAO().conectaBD();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        
         List<Estudante> student = new ArrayList<>();
              
         try {
             String sql = "SELECT *FROM pessoa";
              pstm = conn.prepareStatement(sql);
              rs = pstm.executeQuery();
           
              while(rs.next()){
                  Estudante est = new Estudante();
                  
                  est.setMatricula(rs.getInt("matricula"));
                  est.setNome(rs.getNString("nome"));
                  est.setIdade(rs.getInt("idade"));
                  student.add(est);
                  
                  
                  
              }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "EstudanteDAO: " + ex.getMessage());
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
        
        
        public Estudante select(Estudante estudante){
        Connection conn = new ConexaoDAO().conectaBD();
           Cartao cartao = new Cartao();

        PreparedStatement pstm = null;
        ResultSet rs = null;
        
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
              estudante.setNome(rs.getString("nome"));
              
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
    
}
