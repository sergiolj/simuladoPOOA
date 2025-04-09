package br.ucsal.biblioteca.threads.marketSimulator;

import br.ucsal.biblioteca.threads.model.MarketCheckout;

import java.util.ArrayList;
import java.util.List;

public class FactoryCheckout {
    List<MarketCheckout> serviceStations = new ArrayList<>();

    public FactoryCheckout(int quantityServiceStations) {
        for (int i = 0; i < quantityServiceStations; i++) {
            serviceStations.add (new MarketCheckout());
        }
    }
    public int size(){
        return serviceStations.size();
    }

    public MarketCheckout get(int index){
        return serviceStations.get(index);
    }
}
