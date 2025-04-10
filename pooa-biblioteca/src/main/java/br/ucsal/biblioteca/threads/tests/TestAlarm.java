package br.ucsal.biblioteca.threads.tests;

import java.time.Duration;

public class TestAlarm {
    public static void main(String[] args) {
        int countDown = 30;
        Thread alarm = new Thread(()->{
            for (int i = countDown; i > 0; i--) {
                System.out.print(i + " ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("\nAlarm ringing!");
        });
        alarm.start();
        System.out.println("Countdown alarm started! (Set to "+countDown+" seconds)");
    }
}
