package br.ucsal.biblioteca.controller;

import br.ucsal.biblioteca.model.Emprestimo;
import br.ucsal.biblioteca.model.Livro;
import br.ucsal.biblioteca.model.Usuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Livro> livros = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();

    private final List<Emprestimo> emprestimos = new ArrayList<>();


    public List<Livro> getLivros() {
        return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }




    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void removerEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public void enviarLembretesDevolucao() {
        LocalDate hoje = LocalDate.now();
        for (Emprestimo emprestimo : emprestimos) {
            long diasRestantes = ChronoUnit.DAYS.between(hoje, emprestimo.getDataDevolucao());
            if (diasRestantes <= 1) {
                System.out.println("Lembrete para " + emprestimo.getUsuario().getNome() + ":");
                if (diasRestantes >= 0) {
                    System.out.println("O livro '" + emprestimo.getLivro().getTitulo() + "' foi emprestado em " +
                            emprestimo.getDataRetirada() + ". Você tem " + diasRestantes +
                            " dia(s) restantes para devolvê-lo antes do prazo em " + emprestimo.getDataDevolucao() + ".");
                } else {
                    // Mensagem para quem ultrapassou o prazo
                    System.out.println("O livro '" + emprestimo.getLivro().getTitulo() + "' foi emprestado em " +
                            emprestimo.getDataRetirada() + ". O prazo de devolução era " + emprestimo.getDataDevolucao() +
                            ". Por favor, devolva o livro o quanto antes.");
                }
                System.out.println("--------------------------------------------------");
            }
        }
    }
    public void enviarLembretedevThread(){

    }
}
