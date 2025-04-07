package br.ucsal.biblioteca.teste;

import java.util.List;

public class ClientService <T> {
    private final List<T> clients;

    //A variável é criada na classe como List<String> mas poderia ser List<E> e passada para o serviço na aplicação o
    //que torna a aplicação mais flexível e a classe pode ser utilizada para outras coisas.
    public ClientService(List<T> clients) {
        this.clients = clients;
    }

    public void adicionar(T element){
        this.clients.add(element);
    }
    public void remover(T element){
        this.clients.remove(element);
    }
}
