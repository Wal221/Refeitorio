/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.EstudanteTicket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Time;

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
                + ",dia_de_uso , horario_inicio,horario_fim,saldo ) VALUES(?,?,?,?,?,?,?,?,?)";
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
            pstm.setString(5, "EstudanteTick");
            pstm.setString(6, "Seg a Sext");
            pstm.setTime(7, horarioIni);
            pstm.setTime(8, horarioFim);
            pstm.setDouble(9, student.getSaldo());
            
            pstm.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ESTUDANTETICKDAO" + e.getMessage());

        }

    }

}
