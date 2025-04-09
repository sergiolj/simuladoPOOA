package br.ucsal.biblioteca.threads.model;

import java.time.Duration;

public class Timer implements Runnable {
    private int secondsStep = 0;
    private int numberOfRepetitions = 0;


    public Timer(int secondsStep, int numberOfRepetitions ) {
        this.secondsStep = secondsStep;
        this.numberOfRepetitions = numberOfRepetitions;
    }

    @Override
    public void run() {
        System.out.println("Begin counting " + secondsStep + " seconds delay " + numberOfRepetitions + " times");
        for(int i = 1; i <= numberOfRepetitions; i++) {
            try {
                Thread.sleep(Duration.ofSeconds(secondsStep).toMillis());
                System.out.println("Elapsed time: about " + (secondsStep * i) + " seconds");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
