package DTO;

import DTO.EstudanteMedio;

/**
 * A classe estudanteTicket e a unica que recebera alteração no saldo do cartão
 * que sera utilizado para pode fazer a refeição
 * tendo isso em mente , que uma pessoa da categoria ticket estiva cadastrada em um banco de dado
 * o funcionario tera de percorre esse banco de dados com a matricula e verificar se ele e um estudante que
 * tenha que recarregara o cartão

 */
public class EstudanteTicket extends Pessoa {


    private Double saldo;

    public EstudanteTicket(String nome, String cpf, int idade, boolean foto,  Double saldo,int ano_Ingresso) {
        super(nome, cpf, idade, ano_Ingresso ,"Estudante Ticket");
        this.saldo = saldo;
    }


    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    
    public String Imprimi(){
        StringBuilder estu = new StringBuilder();
        estu.append("Matricula "+getMatricula());
        
        return estu.toString();
        
    }
}

