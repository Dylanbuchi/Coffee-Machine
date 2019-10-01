package coffee;

import java.util.Scanner;

import java.util.concurrent.TimeUnit;

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
    public static void main(String[] args) throws InterruptedException {
        newLine();
        System.out.println("Welcome to Express Coffee !");

        while (!userChoice.equals("exit")) {

            newLine();

            System.out.print("Choose an option (buy, fill, take, remaining, calculate or exit): ");
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
            case "calculate":

                calculatorOfCoffeeCups();

                // Exit
                break;

            case "exit":

                // Exit
                break;

            default:
                newLine();
                System.out.print("Please select a valid option!");
                newLine();
                break;
            }
        }

        newLine();
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
        newLine();
        System.out.println("The coffee machine has: ");
        System.out.println(water + " of water");
        System.out.println(milk + "  of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");

    }

    public static void fill() {
        newLine();
        System.out.println("Write how many ml of water do you want to add: ");
        newLine();
        addWater = sc.nextInt();
        water += addWater;

        newLine();
        System.out.println("Write how many ml of water do you want to add: ");
        newLine();
        addMilk = sc.nextInt();
        milk += addMilk;

        newLine();
        System.out.println("Write how many ml of water do you want to add: ");
        newLine();
        addCoffee = sc.nextInt();
        coffee += addCoffee;

        newLine();
        System.out.println("Write how many ml of water do you want to add: ");
        newLine();

        addCups = sc.nextInt();
        cups += addCups;

    }

    public static void take() {
        String userPass = "";

        while (!userPass.equals(password)) {

            newLine();
            System.out.println("To take the money you must enter the password or enter \"CANCEL\" to go back: ");
            userPass = sc.nextLine();

            if (userPass.equals("CANCEL") || userPass.equals("cancel")) {
                return;

            } else if (!userPass.equals(password)) {
                newLine();
                System.out.println("Wrong Password... Please enter the correct password or cancel");

            }
        }
        newLine();
        System.out.println("The coffee machine has $" + money);

        newLine();
        System.out.print("Write \"YES\" to take the money or \"NO\" to go back: ");
        String user = sc.nextLine();

        if (user.equals("yes") || user.equals("YES")) {
            money -= money;
            newLine();
            System.out.println("The machine now has $" + money);

        } else {
            return;
        }

    }

    public static void buy() throws InterruptedException {

        newLine();
        System.out.print("Choose your coffee! || [1] Espresso || [2] Latte || [3] Cappuccino || [0] Main Menu: ");

        userCoffeeNumber = sc.next();
        if (userCoffeeNumber.equals("1") && canMakeExpress()) {
            newLine();
            System.out.println("Making you an espresso! Please wait");
            buyOneExpress();
            newLine();
            waitingForCoffee();

        } else if (userCoffeeNumber.equals("1") && !canMakeExpress()) {
            notEnoughExpressIngredients();

        }

        else if (userCoffeeNumber.equals("2") && canMakeLatte()) {
            newLine();
            System.out.println("Making you a latte! Please wait");
            buyOneLatte();
            newLine();
            waitingForCoffee();

        } else if (userCoffeeNumber.equals("2") && !canMakeLatte()) {
            notEnoughLatteIngredients();

        }

        else if (userCoffeeNumber.equals("3") && canMakeCappuccino()) {
            newLine();
            System.out.println("Making you a cappuccino! Please wait...");
            buyOneCappuccino();
            newLine();
            waitingForCoffee();

        } else if (userCoffeeNumber.equals("3") && !canMakeCappuccino()) {
            notEnoughCappuccinoIngredients();

        } else if (userCoffeeNumber.equals("0")) {
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
            newLine();
            System.out.println("Sorry, we don't have enough water..");

        } else if (coffee < expressCoffee) {
            newLine();
            System.out.println("Sorry, not enough coffee!");

        } else if (cups < 1) {
            newLine();
            System.out.println("Sorry, not enough cups!");
        }

    }

    public static void notEnoughLatteIngredients() {
        if (water < latteWater) {
            newLine();
            System.out.println("Sorry, we don't have enough water..");

        } else if (coffee < latteCoffee) {
            newLine();
            System.out.println("Sorry, not enough coffee!");

        } else if (milk < latteMilk) {
            newLine();
            System.out.println("Sorry, not enough milk!");

        } else if (cups < 1) {
            newLine();
            System.out.println("Sorry, not enough cups!");
        }

    }

    public static void notEnoughCappuccinoIngredients() {
        if (water < cappuccinoWater) {
            newLine();
            System.out.println("Sorry, we don't have enough water..");

        } else if (coffee < cappuccinoCoffee) {
            newLine();
            System.out.println("Sorry, not enough coffee!");

        } else if (milk < cappuccinoMilk) {
            newLine();
            System.out.println("Sorry, not enough milk!");
        } else if (cups < 1) {
            newLine();
            System.out.println("Sorry, not enough cups!");

        }

    }

    public static void waitingForCoffee() throws InterruptedException {
        System.out.println("Starting to make your coffee!");
        newLine();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Grinding coffee beans...");
        newLine();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Boiling water...");
        newLine();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Mixing boiled water with crushed coffee beans...");
        newLine();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Pouring coffee into the cup...");
        newLine();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Pouring some milk into the cup...");
        newLine();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Coffee is ready!");

    }

    public static void newLine() {
        System.out.println();

    }

    public static void calculatorOfCoffeeCups() {

        int water = 200;
        int milk = 50;
        int coffeeBeans = 15;
        int cups = 0;
        // calculation

        // print result
        newLine();
        System.out.println("Calculate here how many cups a normal coffee machine can make.");
        newLine();
        System.out.print("how many cups of coffee you will need: ");
        cups = sc.nextInt();

        int waterCalcul = water * cups;
        int milkCalcul = milk * cups;
        int coffeeBeansCalcul = coffeeBeans * cups;

        newLine();
        System.out.println("For " + cups + " cups of coffee you will need: ");
        newLine();
        System.out.println(waterCalcul + " ml of water");
        newLine();
        System.out.println(milkCalcul + " ml of milk");
        newLine();
        System.out.println(coffeeBeansCalcul + " g of coffee beans");

    }
}