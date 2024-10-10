package model;

import java.io.Serializable;

public class Snack implements Serializable {
    private static int snacksCounter = 0;
    private int idSnack;
    private String name;
    private double price;

    // Constructor that automatically assigns the ID
    public Snack(String name, double price) {
        this.idSnack = ++snacksCounter;
        this.name = name;
        this.price = price;
    }

    // Constructor used when loading snacks from a file
    public Snack(int idSnack, String name, double price) {
        this.idSnack = idSnack;
        this.name = name;
        this.price = price;
        if (idSnack > snacksCounter) {
            snacksCounter = idSnack;
        }
    }

    // Getters
    public int getIdSnack() {
        return idSnack;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return idSnack + ". " + name + " - $" + price;
    }

    @Override
    public int hashCode() {
        return idSnack;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Snack snack = (Snack) obj;
        return idSnack == snack.idSnack;
    }
}
