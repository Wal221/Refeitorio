package DAO;

import DTO.Funcionario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

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
    public void update(){
        
    }
}
