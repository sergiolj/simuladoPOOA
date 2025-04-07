package br.ucsal.biblioteca.teste.Notificador;

public class SMSNotificador implements Notificador {

    @Override
    public void notificar(String mensagem) {
        System.out.println("SMS: " + mensagem);
    }
}