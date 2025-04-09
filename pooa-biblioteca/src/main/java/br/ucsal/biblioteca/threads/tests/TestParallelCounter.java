package br.ucsal.biblioteca.threads.tests;

import br.ucsal.biblioteca.threads.model.Counter;

public class TestParallelCounter {
    public static void main(String[] args) {

        var counter = new Counter("Counter A :", 10);
        var counter2 = new Counter("Counter B :",10);
        new Thread(counter).start();
        new Thread(counter2).start();


//        Thread t1 = new Thread(counter);
//        Thread t2 = new Thread(counter2);
//        t1.start();
//        t2.start();


    }
}
