package br.ucsal.biblioteca.threads;

public class ExemploRunnable {
    public static void main(String[] args) {

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World");
            }
        };
        Thread t = new Thread(r);
        t.start();

        // O uso da expressão lambda diminui a quantidade de código a ser escrito para executar a mesma tarefa
        //No caso as variáveis r e r1 executam a mesma coisa.
        Runnable r1 = () ->System.out.println("Hello World");
        Thread t1 = new Thread(r1);
        t1.start();

        //Nesse caso a thread não possui nem mesmo uma variável de referência, uma implementação que só deve ser
        //utilizada em casos muito simples como a resposta em console abaixo e nunca para uma thread mais complexa
        // que possa necessitar um controle de exceção, por exemplo.
        new Thread(() -> System.out.println("Hello World")).start();

        var t2 = new Thread(() -> System.out.println("Hello World"));
        t2.setName("Thread com lambda");
        t2.start();
    }

}
