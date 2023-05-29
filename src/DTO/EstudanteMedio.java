package DTO;

public class EstudanteMedio extends Pessoa {
    /**
     * @anotação chave Primaria do meu banco de dados
     */
    private static int contador = 0;
     
    private int matricula;

    private boolean foto;

    private String nomCategory;


    /**@return esse construtor cria um objeto do tipo estudante
     * e objetos que herdam dessa classe
     * introduzi o metodo set matricula no propio construtor para a matricula ser gerada automaticamente
     * ja que o metodo que a gera tbm e no propio setMatricula
     */
    public EstudanteMedio(String nome, String cpf, int idade,boolean foto, String nomCategory,int anoIngresso) {
        super(nome, cpf, idade, anoIngresso, "Ensino medio");
        //this.matricula = matricula;
        setMatricula(matricula);
        this.foto = foto;
        this.nomCategory= nomCategory;
    }

    public int getMatricula() {
        return matricula;
    }



   
    public void setMatricula(int ano) {
    }

    public boolean isFoto() {
        return foto;
    }

    public void setFoto(boolean foto) {
        this.foto = foto;
    }

    public String getNomCategory() {
        return nomCategory;
    }

    public void setNomCategory(String nomCategory) {
        this.nomCategory = nomCategory;
    }

    public void numeroRefeições(){

    }

    public int numCategoria(){


        return  0;
    }



    @Override
    public String toString() {
        return "Estudante{" +
                "matricula=" + matricula +
                ", foto=" + foto +
                ", nomCategory='" + nomCategory + '\'' +
                '}';
    }
}
