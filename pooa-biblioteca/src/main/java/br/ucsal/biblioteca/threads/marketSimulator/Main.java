package br.ucsal.biblioteca.threads.marketSimulator;

public class Main {
    public static void main(String[] args) {
        FactoryCheckout poolCheckout = new FactoryCheckout(3);
        FactoryCostumer costumer = new FactoryCostumer(10, poolCheckout);
   }
}
