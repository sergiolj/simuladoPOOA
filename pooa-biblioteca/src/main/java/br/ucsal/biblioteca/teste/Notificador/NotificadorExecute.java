package br.ucsal.biblioteca.teste.Notificador;

import java.util.HashSet;
import java.util.Set;

public class NotificadorExecute {
    public static void main(String[] args) {
        Set<Notificador> canais = new HashSet<Notificador>();
        canais.add(new EmailNotificador());
        canais.add(new SMSNotificador());

        NotificadorService service = new NotificadorService(canais);
        service.notificar("Promoção : Tudo com 50% de desconto!");
    }
}
