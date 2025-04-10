package br.ucsal.biblioteca.threads.tests;

import java.time.Duration;
import java.util.Scanner;

public class ParallelWithInput {
    public static void main(String[] args) {
        Thread starting = new Thread(()-> {
            try {
                System.out.print("Charging");
                while (true) {
                    System.out.print(".");
                    Thread.sleep(Duration.ofSeconds(1).toMillis());
                }
            }catch(InterruptedException e){
                System.out.println("Thread interrupted!");
            }
        });
        starting.start();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer between 0 and 100");
        int number = scanner.nextInt();

        starting.interrupt();
        System.out.println("You entered: "+number);
    }
}
