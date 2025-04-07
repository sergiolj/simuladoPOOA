package br.ucsal.biblioteca.teste.Notificador;

import java.util.Collection;

public class NotificadorService {
    private Collection<Notificador> canais;

    public NotificadorService(Collection<Notificador> canais) {
        this.canais = canais;
    }
    public void notificar(String mensagem) {
        for (Notificador canal : canais) {
            canal.notificar(mensagem);
        }
    }

}
