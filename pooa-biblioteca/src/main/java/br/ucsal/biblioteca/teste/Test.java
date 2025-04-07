package br.ucsal.biblioteca.teste;

import java.util.ArrayList;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> c = new ArrayList<>();

        //Essa é sintaxe mais utilizada onde o tipo da variável é passado no diamond operator da esquerda.
        // Foi introduzido no java 7+
        ClientService<String> service1 = new ClientService<>(c);

        //Essa sintaxe também é permitida e é a mais antiga, mas considerada redundante uma vez que a variável
        // já foi tipificada na esquerda da instância.
        ClientService<String> service2 = new ClientService<String>(c);

        //Essa sintaxe é permitida a partir do Java 10, pois foi quando o diamond operator foi inserido,
        // utilizando o var para tornar o código mais limpo, passando o
        //tipo do dado para a direita.
        var service3 = new ClientService<String>(c);






    }
}
