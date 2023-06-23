package Model;

import java.util.Random;

public class Cartao {
    private int num_cartao;

    public Cartao (){
       num_cartao = geraNumCartao();
    }

    public int getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(int num_cartao) {
     //tenho que gerar um numero automatico para o cartao
        this.num_cartao = num_cartao;
    }
   public int geraNumCartao(){
       Random ale = new Random();
        //todo cartão do estudante vai começar com 202
       int inicioCartao = 202;
         
        return this.num_cartao= (202 * 10) + ale.nextInt(50);
        
    }

}
