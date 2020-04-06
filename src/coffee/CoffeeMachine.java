package coffee;

import java.util.Scanner;

import coffee.model.*;

/**
 * CoffeeMachine
 */
public class CoffeeMachine {

    private int balance;
    private int cups;
    private int water;
    private int milk;
    private int coffeeBeans;
    private String password;

    private Coffee espresso;
    private Coffee latte;
    private Coffee cappuccino;

    // Coffee Machine actual State with random numbers
    public CoffeeMachine() {

        this.password = "123";

        // set prices of 3 coffee inside the machine
        // a new coffee is (water, milk, coffee, price)

        this.espresso = new Espresso(250, 0, 16, 4);
        this.latte = new Latte(350, 75, 20, 7);
        this.cappuccino = new Cappuccino(200, 100, 12, 6);

        // add random values to every new machine created
        this.balance = (int) Math.floor(Math.random() * 10);
        this.water = (int) Math.floor(Math.random() * 2000 + 1000);
        this.milk = (int) Math.floor(Math.random() * 500 + 100);
        this.coffeeBeans = (int) Math.floor(Math.random() * 100);
        this.cups = (int) Math.floor(Math.random() * 5);

    }

    // check if a machine can make a coffee
    public boolean CanMakeACupOfCoffee(Coffee coffee) {
        if (coffeeBeans >= coffee.getCoffeeBeans() && water >= coffee.getWater() && milk >= coffee.getMilk()
                && cups > 0) {

            return true;

        }
        return false;

    }

    public boolean isPasswordCorrect(String password) {

        if (password.equals(password)) {
            return true;
        }

        return false;

    }

    public void takeMoney() {
        balance -= balance;
    }

    // fill the machine
    public void fill(Scanner in) {

        System.out.println("Write how many ml of water do you want to add: ");

        int addWater = in.nextInt();
        water += addWater;

        System.out.println("Write how many ml of milk do you want to add: ");

        int addMilk = in.nextInt();
        milk += addMilk;

        System.out.println("Write how many beans of coffee do you want to add: ");

        int addCoffee = in.nextInt();
        coffeeBeans += addCoffee;

        System.out.println("Write how many cups do you want to add: ");

        int addCups = in.nextInt();
        cups += addCups;

    }

    // check which ingredient is missing
    public void ingredients(Coffee coffee) {
        if (water < coffee.getWater()) {

            System.out.println("Sorry, we don't have enough water..");

        }
        if (coffeeBeans < coffee.getCoffeeBeans()) {

            System.out.println("Sorry, we don't have enough coffee!");

        }
        if (cups < 1) {

            System.out.println("Sorry, we don't have enough cups!");
        }
        if (milk < coffee.getMilk()) {

            System.out.println("Sorry, not enough milk!");

        }

    }

    // buy a coffee from machine
    public void buy(Coffee coffee) {

        milk -= coffee.getMilk();
        water -= coffee.getWater();
        coffeeBeans -= coffee.getCoffeeBeans();
        balance += coffee.getPrice();
        cups--;
        if (balance < 0) {
            balance = 0;
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int money) {
        this.balance = money;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("The coffee machine has: ");
        string.append(water + " of water \n");
        string.append(milk + "  of milk \n");
        string.append(coffeeBeans + " of coffee beans \n");
        string.append(cups + " of disposable cups\n ");
        string.append("and $" + balance);

        return string.toString();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Coffee getEspresso() {
        return espresso;
    }

    public void setEspresso(Coffee espresso) {
        this.espresso = espresso;
    }

    public Coffee getLatte() {
        return latte;
    }

    public void setLatte(Coffee latte) {
        this.latte = latte;
    }

    public Coffee getCappuccino() {
        return cappuccino;
    }

    public void setCappuccino(Coffee cappuccino) {
        this.cappuccino = cappuccino;
    }

}