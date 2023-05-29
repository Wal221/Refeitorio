package DTO;

import DTO.EstudanteMedio;

import java.io.FileWriter;
import java.io.IOException;

public class Interno extends Pessoa {


  public Interno(String nome, String cpf, int idade,int ano_Ingresso){
     
      super(nome, cpf, idade,ano_Ingresso, "interno");
  }



    @Override
    public String toString() {
        return
                "matricula = " +getMatricula() + "\n" ;
                       // "Categoria = "+getNomCategory() +"\n"
               
    }

}
