package br.ucsal.biblioteca.teste.abstracts;

import java.util.Iterator;

public class TestMyCollection {
    public static void main(String[] args) {
        MyCollection<String> fleaMarketBag = new MyCollection<>(String.class);
        fleaMarketBag.add("Bananas");
        fleaMarketBag.add("Apples");
        fleaMarketBag.add("Oranges");
        fleaMarketBag.add("Pineapples");
        fleaMarketBag.add("Mango");

        fleaMarketBag.add(String.valueOf(3));
        System.out.println("Size: " + fleaMarketBag.size());

        System.out.println("\nIterator");


        Iterator<String> iterator = fleaMarketBag.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(",");
        }

        System.out.println("\nEnhanced for");
        for(String product : fleaMarketBag) {
            System.out.print(product+", ");
        }

        MyCollection<Integer> prices = new MyCollection<>(Integer.class);
        prices.add(13);
        prices.add(23);
        prices.add(31);
        //prices.add((Integer) (Object) "Preço");

        int sum = 0;
        for(Integer item : prices) {
            sum += item;
        }
        System.out.println("\nSum: " + sum);

    }
}
