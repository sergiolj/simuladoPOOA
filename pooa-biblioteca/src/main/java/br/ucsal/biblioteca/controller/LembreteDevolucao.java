package br.ucsal.biblioteca.controller;

import java.time.Duration;

public class LembreteDevolucao implements Runnable{
    private final Biblioteca biblioteca;

    public LembreteDevolucao(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        Duration timeSleep = Duration.ofSeconds(5);
        while(true){
            biblioteca.enviarLembretesDevolucao();
            try{
                Thread.sleep(timeSleep.toMillis());
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                System.out.println("Thread interrompida..." + e.getMessage());
                break;
            }
        }
    }
}
