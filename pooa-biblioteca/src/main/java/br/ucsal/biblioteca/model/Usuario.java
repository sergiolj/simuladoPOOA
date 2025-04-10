package br.ucsal.biblioteca.model;

import br.ucsal.biblioteca.anotation.ValidateStringLength;
import br.ucsal.biblioteca.reflection.Validator;

public class Usuario {

    private static Integer contadorId = 1;

    private int id;

    @ValidateStringLength(min = 3)
    private String nome;

    public Usuario(String nome) {
        this.id = contadorId++;
        this.nome = nome;
    }
    private Usuario() {
        this.id = contadorId++;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    private void getPrivateInfo() {
        System.out.println("Nome: " + nome + "\nId: " + id);
    }

    public boolean isValid() {
        return Validator.validateFields(this);
    }
}
