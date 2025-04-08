package br.ucsal.biblioteca.threads;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaUses {
    public static void main(String[] args) {

        //Usando expressões lambda em threads
        var t1 = new Thread(() -> {System.out.println("Testando lambda expressions");});
        t1.start();

        List<String> list = Arrays.asList("Banana", "Maça", "Uva","Abacate");
        Collections.sort(list, new Comparator<String>() {@Override public int compare(String o1, String o2) {return o1.compareTo(o2);}});

        Collections.sort(list);


        list.sort((a,b) -> a.compareTo(b));


        list.sort(String::compareTo);

    }
}
