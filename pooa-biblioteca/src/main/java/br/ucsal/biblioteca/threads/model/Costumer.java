package br.ucsal.biblioteca.threads.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Costumer implements Runnable {
    private final String name;
    private Map<String, Double> cart = new HashMap<>();
    private MarketCheckout checkout;

    public Costumer(String name, MarketCheckout checkout) {
        this.name = name;
        this.checkout = checkout;
    }

    public Map<String, Double> getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }

    public void generateRandomShoppList(){
        Random rand = new Random();
        int itemListSize = rand.nextInt(1,10);
        String[] products = {"Beer", "Rice", "Milk", "Coffee", "IceCream", "Potato", "Carrots", "Bread", "Eggs", "Chicken breast", "Chicken drumstick", "Chicken Thigh"};

        for(int i = 0; i < itemListSize; i++){
            String product = products[rand.nextInt(products.length)];
            double price = rand.nextDouble(20.0);
            price = new BigDecimal(price)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();

            cart.put(product, price);
        }
    }

    public MarketCheckout getCheckout() {
        return checkout;
    }

    public void setCheckout(MarketCheckout checkout) {
        this.checkout = checkout;
    }

    @Override
    public void run() {
        System.out.println(name + " began to be attended to by " + checkout.getIdName() );
        checkout.serveCostumer(this);
    }

    @Override
    public String toString() {
        return "Client " + name + cart.toString();
    }
}
