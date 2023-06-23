/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.CardapioDAO;
import DAO.EstudanteDAO;
import DAO.EstudanteTicketDAO;
import DAO.FuncionarioDAO;
import Model.Cartao;
import Model.Estudante;
import Model.EstudanteTicket;
import Model.Funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrador
 */
public class TesteInicial {

    public static void main(String[] args) {
        Cardapio car = new Cardapio("Esse representa diversos brasileiros");
        CardapioDAO ca = new CardapioDAO();
        
        ca.selecrData(car);
        
        System.out.println(car.getDatacarda());
        
        
                
                
        
    }
}
