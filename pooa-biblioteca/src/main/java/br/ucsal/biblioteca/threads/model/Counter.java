package br.ucsal.biblioteca.threads.model;

public class Counter implements Runnable {
    private String name;
    private final int target;

    public Counter(String name, int target) {
        this.name = name;
        this.target = target;
    }

    @Override
    public void run() {
        for (int i = 1; i <= target; i++) {
            System.out.println(name + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
