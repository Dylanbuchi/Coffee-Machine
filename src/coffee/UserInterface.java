package coffee;

import java.util.Scanner;

import java.util.concurrent.TimeUnit;

import coffee.model.Coffee;

public class UserInterface {
    private Scanner in;

    private CoffeeMachine coffeeMachine;

    public UserInterface(Scanner in, CoffeeMachine coffeeMachine) {
        this.in = in;
        this.coffeeMachine = coffeeMachine;
    }

    // main
    public void start() throws InterruptedException {

        System.out.println("Welcome to Biiiig ❤️ Coffee !");
        String input = "";
        while (!input.equals("exit")) {

            System.out.print("Choose an option (buy, fill, take, remaining, calculate or exit): ");
            input = in.next();
            in.nextLine();

            // switch statements
            switch (input) {

                // BUY
                case "buy":
                    buy();

                    break;

                // FILL
                case "fill":

                    coffeeMachine.fill(in);

                    break;

                // TAKE
                case "take":

                    take();

                    // REmaininig
                    break;
                case "remaining":

                    printCoffeeMachine();

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

                    System.out.print("Please select a valid option!");

                    break;
            }
        }

        newLine();
        System.out.println("Good Bye!");
    }

    // buy a expresso
    public void buyCoffee(Coffee coffee) {
        coffeeMachine.buy(coffee);
    }

    public void printCoffeeMachine() {
        System.out.println(coffeeMachine);

    }

    public void take() {
        String input = "";

        while (!coffeeMachine.isPasswordCorrect(input)) {

            System.out.println("To take the money you must enter the password or enter \"CANCEL\" to go back: ");
            input = in.nextLine();

            if (input.equals("CANCEL") || input.equals("cancel")) {
                return;

            } else if (!coffeeMachine.isPasswordCorrect(input)) {

                System.out.println("Wrong Password... Please enter the correct password or cancel");

            }
        }

        System.out.println("The coffee machine has $" + coffeeMachine.getBalance());

        System.out.print("Write \"YES\" to take the money or \"NO\" to go back: ");

        String response = in.nextLine().toLowerCase();

        if (response.equals("yes")) {
            coffeeMachine.takeMoney();

            System.out.println("The machine now has $" + coffeeMachine.getBalance());

        } else {
            return;
        }

    }

    public void buy() throws InterruptedException {
        String number = "";

        Coffee espresso = coffeeMachine.getEspresso();
        Coffee latte = coffeeMachine.getLatte();
        Coffee cappuccino = coffeeMachine.getCappuccino();

        System.out.print("Choose your coffee! || [1] Espresso || [2] Latte || [3] Cappuccino || [0] Main Menu: ");

        number = in.nextLine();
        if (number.equals("1") && coffeeMachine.CanMakeACupOfCoffee(espresso)) {

            System.out.println("Making you an espresso! Please wait");
            buyCoffee(espresso);

            waitingForCoffee();

        } else if (number.equals("1") && !coffeeMachine.CanMakeACupOfCoffee(espresso)) {
            coffeeMachine.ingredients(espresso);

        }

        else if (number.equals("2") && coffeeMachine.CanMakeACupOfCoffee(latte)) {

            System.out.println("Making you a latte! Please wait");
            buyCoffee(latte);

            waitingForCoffee();

        } else if (number.equals("2") && !coffeeMachine.CanMakeACupOfCoffee(latte)) {
            coffeeMachine.ingredients(latte);

        }

        else if (number.equals("3") && coffeeMachine.CanMakeACupOfCoffee(espresso)) {

            System.out.println("Making you a cappuccino! Please wait...");
            buyCoffee(cappuccino);

            waitingForCoffee();

        } else if (number.equals("3") && !coffeeMachine.CanMakeACupOfCoffee(cappuccino)) {
            coffeeMachine.ingredients(cappuccino);

        } else if (number.equals("0")) {
            return;

        }
    }

    public void waitingForCoffee() throws InterruptedException {
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

    public void calculatorOfCoffeeCups() {

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
        cups = in.nextInt();

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