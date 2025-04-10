package br.ucsal.biblioteca.threads.tests;

import br.ucsal.biblioteca.threads.model.PessoaChat;

public class TestChat {
    public static void main(String[] args) {
        var p1 = new PessoaChat("Marcio", 5,3, PessoaChat.type.ASK);
        var p2 = new PessoaChat("Carla", 5,2 ,PessoaChat.type.ANSWER);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        t1.start();
        t2.start();
    }
}
