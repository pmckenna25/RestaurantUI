package ui.Model;

public class Food extends Stuff {

    private boolean egg;
    private boolean milk;
    private boolean meat;

    public Food(String name, float price, String category, boolean egg, boolean milk, boolean meat) {
        super(name, price, category);
        this.egg = egg;
        this.milk = milk;
        this.meat = meat;
    }

    public boolean isEgg() {
        return egg;
    }

    public boolean isMilk() {
        return milk;
    }

    public boolean isMeat() {
        return meat;
    }

    public void setEgg(boolean egg) {
        this.egg = egg;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public void setMeat(boolean meat) {
        this.meat = meat;
    }

    @Override
    public String toString() {
        return super.toString() + ",meat?" + this.meat + ",milk?" + this.milk + ",egg?" + this.egg;
    }
}
