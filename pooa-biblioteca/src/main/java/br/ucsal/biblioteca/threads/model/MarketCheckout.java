package br.ucsal.biblioteca.threads.model;

public class MarketCheckout {
    private final String idName;
    private static int serviceStations = 0;

    public MarketCheckout() {
            this.idName = "Checkout " + Integer.toString(++serviceStations);
    }

    public String getIdName() {
        return idName;
    }

    public synchronized void serveCostumer(Costumer costumer) {
        System.out.println("Serving " + costumer.getName() + " in the station " + this.idName);
        try{
            int attendanceTime = costumer.getCart().size() * 1000;
            Thread.sleep(attendanceTime);

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Attendance interrupted.");
        }
        System.out.println(costumer.getName() + " was served at " + this.idName);
    }

    @Override
    public String toString() {
        return "MarketCheckout{" + idName + "}";
    }
}
