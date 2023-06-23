package Model;

import java.util.Random;
import javax.swing.JOptionPane;

public class Pessoa {

    private String nome;
    private String cpf;
    private int idade;
    private int matricula;
    private String catego;
    private Cartao cartao = new Cartao();

    private static int quan = 0;
    private static int contador;
    private int ano_Ingresso;

    public Pessoa() {

    }

    public Pessoa(int matricula) {
        this.matricula = matricula;

    }

    public Pessoa(String nome, int idade, String cpf, int ano_Ingresso, String catego) {
        geraMatricula(ano_Ingresso);
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.catego = catego;
        cartao.geraNumCartao();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    /*    public void setCpf(String cpf) {
        this.cpf = cpf;
    } Pelo cpf não ser um atributo que não muda logo o unico acesso dele sera pelo construtor
    visto que não poderei mudalo depois


     */
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getMatricula() {

        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public static int getQuan() {
        return quan;
    }

    public static void setQuan(int quan) {
        Pessoa.quan = quan;
    }

    public int contadorAle() {
        Random ale = new Random();
        this.contador = ale.nextInt(30);
        if (contador == 0) {
            this.contador = ale.nextInt(30);

        }
        return contador;
    }

    public int getAno_Ingresso() {
        return ano_Ingresso;
    }

    public void setAno_Ingresso(int ano_Ingresso) {
        this.ano_Ingresso = ano_Ingresso;
    }

    public void geraMatricula(int ano_Ingresso) {
        int anoLetivo = 2023;

        if (ano_Ingresso != anoLetivo) {
            contador = contadorAle();
            this.matricula = (ano_Ingresso * 10000) + contador;
        } else if (ano_Ingresso == anoLetivo && anoLetivo > 0) {
            contador = contadorAle();
            this.matricula = (ano_Ingresso * 10000) + contador;
        }
    }

    public String Imprimi() {
        StringBuilder estu = new StringBuilder();
        estu.append("Matricula " + getMatricula());
        estu.append("Cartão " + getCartao().getNum_cartao());

        return estu.toString();

    }

}
