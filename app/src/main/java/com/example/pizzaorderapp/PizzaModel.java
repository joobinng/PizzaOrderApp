package com.example.pizzaorderapp;

import java.util.ArrayList;

public class PizzaModel {
    double pizza_prices = 0;
    double pepperoni = 0;
    double chicken = 0;
    double olive = 0;
    double mushroom = 0;
    double green_pepper = 0;
    double extra_cheese = 0;

    public double getPizza_prices() {
        return pizza_prices;
    }

    public void setPizza_prices(double pizza_prices) {
        this.pizza_prices = pizza_prices;
    }

    public double getPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(double pepperoni) {
        this.pepperoni = pepperoni;
    }

    public double getChicken() {
        return chicken;
    }

    public void setChicken(double chicken) {
        this.chicken = chicken;
    }

    public double getOlive() {
        return olive;
    }

    public void setOlive(double olive) {
        this.olive = olive;
    }

    public double getMushroom() {
        return mushroom;
    }

    public void setMushroom(double mushroom) {
        this.mushroom = mushroom;
    }

    public double getGreen_pepper() {
        return green_pepper;
    }

    public void setGreen_pepper(double green_pepper) {
        this.green_pepper = green_pepper;
    }

    public double getExtra_cheese() {
        return extra_cheese;
    }

    public void setExtra_cheese(double extra_cheese) {
        this.extra_cheese = extra_cheese;
    }

    public void addItem(String item){
        ArrayList<String> toppings = new ArrayList<String>();
        toppings.add(item);
    }

    public void removeItem(String item){
        ArrayList<String> toppings = new ArrayList<String>();
        toppings.remove(item);
    }

    public void getItem(String item){
        ArrayList<String> toppings = new ArrayList<String>();
        toppings.get(0);
    }
}
