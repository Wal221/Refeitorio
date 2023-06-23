package Model;

/**
 * A classe estudanteTicket e a unica que recebera alteração no saldo do cartão
 * que sera utilizado para pode fazer a refeição tendo isso em mente , que uma
 * pessoa da categoria ticket estiva cadastrada em um banco de dado o
 * funcionario tera de percorre esse banco de dados com a matricula e verificar
 * se ele e um estudante que tenha que recarregara o cartão
 *
 */
public class Estudante extends Pessoa {

   
    private String categoria;
    private Cartao cartao;
    private static int refeicao = 0;
            
            
            
    public Estudante() {

    }
    
    public Estudante(int matricula){
        super(matricula);
        
    }

    public Estudante(String nome, String cpf, int idade, boolean foto, int ano_Ingresso, String categoria) {
        super(nome, idade, cpf, ano_Ingresso, "Estudante");
        this.categoria = categoria;
        

    }

  

    public String Imprimi() {
        StringBuilder estu = new StringBuilder();
        estu.append("Matricula " + getMatricula());

        return estu.toString();

    }

    public String getCategoria() {
        return categoria;
    }
    

    public void setCategoria(String Categoria) {
        this.categoria = Categoria;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public static int getRefeicao() {
        return refeicao;
    }

    public static void setRefeicao(int refeicao) {
        Estudante.refeicao = refeicao;
    }
    public void refeica(){
     
      setQuan(getQuan() + 1);
       
    }
    

}
