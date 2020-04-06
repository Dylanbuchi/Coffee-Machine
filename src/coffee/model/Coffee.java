package coffee.model;

public abstract class Coffee {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int price;

    public Coffee(int water, int milk, int coffee, int price) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffee;
        this.price = price;

    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
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

    public void setCoffeeBeans(int coffee) {
        this.coffeeBeans = coffee;
    }

}