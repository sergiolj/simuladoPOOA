package br.ucsal.biblioteca.teste.Notificador;

public class EmailNotificador implements Notificador{
    @Override
    public void notificar(String mensagem) {
        System.out.println("Email: " + mensagem);
    }

}
