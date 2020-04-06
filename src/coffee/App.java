package coffee;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        CoffeeMachine cm = new CoffeeMachine();
        UserInterface ui = new UserInterface(in, cm);

        ui.start();
    }
}