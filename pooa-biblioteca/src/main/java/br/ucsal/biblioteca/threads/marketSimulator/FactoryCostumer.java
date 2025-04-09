package br.ucsal.biblioteca.threads.marketSimulator;

import br.ucsal.biblioteca.threads.model.Costumer;
import br.ucsal.biblioteca.threads.model.MarketCheckout;

import java.util.Random;

public class FactoryCostumer {

    public FactoryCostumer(int numberOfClients, FactoryCheckout factoryCheckout) {
        Random rand = new Random();
        for (int i = 0; i < numberOfClients; i++) {
            String name = "Costumer" + (i+1);
            MarketCheckout checkout = factoryCheckout.get(rand.nextInt(factoryCheckout.size()));
            var costumer = new Costumer(name, checkout);
            costumer.generateRandomShoppList();
            System.out.println(costumer);
            Thread costumerThread = new Thread(costumer);
            costumerThread.start();
        }
    }
}
