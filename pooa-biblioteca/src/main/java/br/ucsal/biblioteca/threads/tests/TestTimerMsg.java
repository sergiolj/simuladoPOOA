package br.ucsal.biblioteca.threads.tests;

import br.ucsal.biblioteca.threads.model.Timer;

public class TestTimerMsg {
    public static void main(String[] args) {
        var timer = new Timer(5,5);
        new Thread(timer).start();
    }
}
