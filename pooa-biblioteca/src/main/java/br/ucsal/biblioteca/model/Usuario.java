package br.ucsal.biblioteca.model;

public class Usuario {

    private static Integer contadorId = 1;

    private int id;

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

}
