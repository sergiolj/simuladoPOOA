package br.ucsal.biblioteca.controller;

import java.time.Duration;

public class LembreteDevolucao implements Runnable{
    private final Biblioteca biblioteca;

    public LembreteDevolucao(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void run() {
        while(true){
            try{
                biblioteca.enviarLembretesDevolucao();
                Thread.sleep(Duration.ofSeconds(5).toMillis());
            }catch(InterruptedException e){
                System.out.println("Thread interrompida..." + e.getMessage());
                break;
            }
        }
    }
}
