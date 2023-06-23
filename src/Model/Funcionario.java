package Model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Funcionario extends Pessoa {

    /** O funcionario devera receber o ano em que o aluno entrou na instituição
     * para gerar a matricula e cadastrala no banco de dados de acordo com  a
     * sua categoria
     * Para isso o funcionario deve fazer uma composição com o estudante podendo utilizar o metodo setMatricula
     * sendo gerado e adiconado no banco de dados(E uma possibilidade)
     */
    private String senha;
    private String categoria;
    
    
    public Funcionario(){
        
    }
    
    public Funcionario(String nome, String cpf, int idade, String senha, int anoIngresso,String catego ) {
        super(nome,  idade, cpf,anoIngresso,catego );
        this.senha = senha;
    }
    
    public Funcionario(int matricula , String senha){
        super(matricula);
        this.senha = senha;
        
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    


   /* public void cadastroEstudante(){
        estudantes.get()
    }

    */

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = "Funcionario";
    }
    
     public static void recarregaTicketestudante(EstudanteTicket estu, Double recarga){
        
        if(recarga < 0){
            JOptionPane.showMessageDialog(null, "DIGITE UM VALOR VALIDO");
            return;
        }else{
        estu.setSaldo(estu.getSaldo() + recarga);
         estu.quantRefeicao();
        }
    }
    




    @Override
    public String toString() {
        return "Funcionario{" +
                "senha='" + senha + '\'' +
          
                '}';
    }
}
