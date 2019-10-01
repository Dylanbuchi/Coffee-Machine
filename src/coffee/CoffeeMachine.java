package coffee;

import java.util.Scanner;

public class CoffeeMachine {

    private static Scanner sc = new Scanner(System.in);

    // password
    private static String password = "123";
    // user variables
    private static int addWater;
    private static int addMilk;
    private static int addCoffee;
    private static int addCups;

    private static String userChoice = "";
    private static String userCoffeeNumber;

    // Coffee Machine actual State with random numbers
    private static int money = (int) Math.floor(Math.random() * 10);
    private static int water = (int) Math.floor(Math.random() * 2000 + 1000);
    private static int milk = (int) Math.floor(Math.random() * 500 + 100);
    private static int coffee = (int) Math.floor(Math.random() * 100);
    private static int cups = (int) Math.floor(Math.random() * 5);

    // for a cup of express

    private static int expressWater = 250;
    private static int expressCoffee = 16;
    private static int expressMoney = 4;
    // for a cup of latte

    private static int latteWater = 350;
    private static int latteMilk = 75;
    private static int latteCoffee = 20;
    private static int latteMoney = 7;
    // for a cup of cappucino

    private static int cappuccinoWater = 200;
    private static int cappuccinoMilk = 100;
    private static int cappuccinoCoffee = 12;
    private static int cappuccinoMoney = 6;

    // main
    public static void main(String[] args) {

        System.out.println("Welcome to Express Coffee !");

        while (!userChoice.equals("exit")) {
            System.out.println();

            System.out.print("Choose an option (buy, fill, take, remaining or exit): ");
            userChoice = sc.next();
            sc.nextLine();

            // switch statements
            switch (userChoice) {

            // BUY
            case "buy":
                buy();

                break;

            // FILL
            case "fill":

                fill();

                break;

            // TAKE
            case "take":

                take();

                // REmaininig
                break;
            case "remaining":

                coffeeMachine();

                // Exit
                break;
            }
        }

        System.out.println();
        System.out.println("Good Bye!");
    }

    // buy a expresso
    public static void buyOneExpress() {

        water -= expressWater;
        coffee -= expressCoffee;
        money += expressMoney;
        cups -= 1;

    }

    // buy a latte
    public static void buyOneLatte() {

        water -= latteWater;
        milk -= latteMilk;
        coffee -= latteCoffee;
        money += latteMoney;
        cups -= 1;

    }

    // BUY a cappucciino
    public static void buyOneCappuccino() {

        water -= cappuccinoWater;
        milk -= cappuccinoMilk;
        coffee -= cappuccinoCoffee;
        money += cappuccinoMoney;
        cups -= 1;
    }

    public static void coffeeMachine() {
        System.out.println();
        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + "  of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");

    }

    public static void fill() {
        System.out.println();
        System.out.println("Write how many ml of water do you want to add: ");
        System.out.println();
        addWater = sc.nextInt();
        water += addWater;

        System.out.println();
        System.out.println("Write how many ml of water do you want to add: ");
        System.out.println();
        addMilk = sc.nextInt();
        milk += addMilk;

        System.out.println();
        System.out.println("Write how many ml of water do you want to add: ");
        System.out.println();
        addCoffee = sc.nextInt();
        coffee += addCoffee;

        System.out.println();
        System.out.println("Write how many ml of water do you want to add: ");
        System.out.println();

        addCups = sc.nextInt();
        cups += addCups;

    }

    public static void take() {
        String userPass = "";

        while (!userPass.equals(password)) {

            System.out.println();
            System.out.println("To take the money you must enter the password or enter \"CANCEL\" to go back: ");
            userPass = sc.nextLine();

            if (userPass.equals("CANCEL") || userPass.equals("cancel")) {
                return;

            } else if (!userPass.equals(password)) {
                System.out.println();
                System.out.println("Wrong Password... Please enter the correct password or cancel");

            }
        }
        System.out.println();
        System.out.println("The coffee machine has $" + money);

        System.out.println();
        System.out.print("Write \"YES\" to take the money or \"NO\" to go back: ");
        String user = sc.nextLine();

        if (user.equals("yes") || user.equals("YES")) {
            money -= money;
            System.out.println();
            System.out.println("The machine now has $" + money);

        } else {
            return;
        }

    }

    public static void buy() {

        System.out.println();
        System.out.print("Choose your coffee! 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");

        userCoffeeNumber = sc.next();
        if (userCoffeeNumber.equals("1") && canMakeExpress()) {
            System.out.println();
            System.out.println("Making you an Expresso! Please wait");
            buyOneExpress();

        } else if (userCoffeeNumber.equals("1") && !canMakeExpress()) {
            notEnoughExpressIngredients();

        }

        else if (userCoffeeNumber.equals("2") && canMakeLatte()) {
            System.out.println();
            System.out.println("Making you a Latte! Please wait");
            buyOneLatte();

        } else if (userCoffeeNumber.equals("2") && !canMakeLatte()) {
            notEnoughLatteIngredients();

        }

        else if (userCoffeeNumber.equals("3") && canMakeCappuccino()) {
            System.out.println();
            System.out.println("Making you a Cappuccino! Please wait");
            buyOneCappuccino();

        } else if (userCoffeeNumber.equals("3") && !canMakeCappuccino()) {
            notEnoughCappuccinoIngredients();

        } else if (userCoffeeNumber.equals("back")) {
            return;

        }
    }

    // IF MACHINE CAN MAKE EXPRESS
    public static boolean canMakeExpress() {
        if (coffee >= expressCoffee && water >= expressWater) {

            return true;

        }
        return false;

    }

    public static boolean canMakeLatte() {
        if (coffee >= latteCoffee && water >= latteWater && milk >= latteMilk) {

            return true;

        }
        return false;

    }

    public static boolean canMakeCappuccino() {
        if (coffee >= cappuccinoCoffee && water >= cappuccinoWater && milk >= cappuccinoMilk) {

            return true;

        }
        return false;

    }

    public static void notEnoughExpressIngredients() {
        if (water < expressWater) {
            System.out.println();
            System.out.println("Sorry, we don't have enough water..");

        } else if (coffee < expressCoffee) {
            System.out.println();
            System.out.println("Sorry, not enough coffee!");

        } else if (cups < 1) {
            System.out.println();
            System.out.println("Sorry, not enough cups!");
        }

    }

    public static void notEnoughLatteIngredients() {
        if (water < latteWater) {
            System.out.println();
            System.out.println("Sorry, we don't have enough water..");

        } else if (coffee < latteCoffee) {
            System.out.println();
            System.out.println("Sorry, not enough coffee!");

        } else if (milk < latteMilk) {
            System.out.println();
            System.out.println("Sorry, not enough milk!");

        } else if (cups < 1) {
            System.out.println();
            System.out.println("Sorry, not enough cups!");
        }

    }

    public static void notEnoughCappuccinoIngredients() {
        if (water < cappuccinoWater) {
            System.out.println();
            System.out.println("Sorry, we don't have enough water..");

        } else if (coffee < cappuccinoCoffee) {
            System.out.println();
            System.out.println("Sorry, not enough coffee!");

        } else if (milk < cappuccinoMilk) {
            System.out.println();
            System.out.println("Sorry, not enough milk!");
        } else if (cups < 1) {
            System.out.println();
            System.out.println("Sorry, not enough cups!");

        }

    }
}