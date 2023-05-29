package DTO;

import java.util.Random;

public abstract class Pessoa {

    private String nome;
    private String cpf;
    private int idade;
    private int matricula ;
    private String catego;
    
    
    private static int contador;
    private int  ano_Ingresso;

    public Pessoa(String nome, String cpf, int idade,int ano_Ingresso, String catego) {
        setMatricula(ano_Ingresso);
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.catego = catego;
       
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

    public void setMatricula(int ano_Ingresso) {
        int anoLetivo = 2023;

        if (ano_Ingresso != anoLetivo ) {
            contador = contadorAle();
            this.matricula = (ano_Ingresso * 10000) + contador;
        } else if (ano_Ingresso == anoLetivo && anoLetivo > 0) {
            contador = contadorAle();
            this.matricula = (ano_Ingresso * 10000) + contador;
        }
    }

    public int contadorAle(){
        Random ale = new Random();
        this.contador = ale.nextInt(30);
        if(contador == 0){
            this.contador = ale.nextInt(30);

        }
        
      
        
        return contador ;
    }

    public int getAno_Ingresso() {
        return ano_Ingresso;
    }

    public void setAno_Ingresso(int ano_Ingresso) {
        this.ano_Ingresso = ano_Ingresso;
    }
}
