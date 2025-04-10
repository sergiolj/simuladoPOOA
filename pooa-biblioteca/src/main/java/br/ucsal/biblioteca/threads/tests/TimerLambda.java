package br.ucsal.biblioteca.threads.tests;

import java.time.Duration;

public class TimerLambda {
    public static void main(String[] args) {
        int secondStep = 5;
        int repetitions = 5;
        Thread timer = new Thread(() -> {
            System.out.println("Begin counting: step " + secondStep + " repetitions " + repetitions);
            for (int i = 1; i <= repetitions; i++) {
                try {
                    Thread.sleep(Duration.ofSeconds(5).toMillis());
                    System.out.println("Elapsed time about: " + (secondStep * i) + " seconds and counting");
                } catch (InterruptedException e) {
                    System.out.println("Task interrupted");
                }
            }
        });
        timer.start();
    }
}
