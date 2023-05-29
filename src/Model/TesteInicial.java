/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.EstudanteTicketDAO;
import DAO.FuncionarioDAO;
import DTO.EstudanteTicket;
import DTO.Funcionario;

/**
 *
 * @author Administrador
 */
public class TesteInicial {
    public static void main(String[] args) {
//       Funcionario fun = new Funcionario("Walmir", "3878", 15, "2020", 2022,"Funcionario");
//        FuncionarioDAO funcionario = new FuncionarioDAO();
//        funcionario.save(fun);
//        
      
        
        EstudanteTicket studente = new EstudanteTicket("Isack", "7575", 22, true, 56.0, 2023);
         EstudanteTicketDAO estudante = new EstudanteTicketDAO();
         
         estudante.save(studente);
                 System.out.println(studente.getMatricula());
        
        
        
    }
}
