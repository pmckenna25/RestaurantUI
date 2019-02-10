package ui.Model;

public class Drink extends Stuff {

    private SugarQuantity sugar;
    private float alcohol_percentage;

    public Drink(String name, float price, String category, SugarQuantity sugar, float alcohol_percentage) {
        super(name, price, category);
        this.sugar = sugar;
        this.alcohol_percentage = alcohol_percentage;
    }

    public void setAlcohol_percentage(float alcohol_percentage) {
        this.alcohol_percentage = alcohol_percentage;
    }

    public float getAlcohol_percentage() {
        return alcohol_percentage;
    }

    public boolean isAlcoholic() {
        return this.alcohol_percentage > 0;
    }

    public SugarQuantity getSugar() {
        return sugar;
    }

    public void setSugar(SugarQuantity sugar) {
        this.sugar = sugar;
    }

    @Override
    public String toString() {
        return super.toString() + ",sugar?" + this.sugar + ",alcohol?" + this.alcohol_percentage + "%";
    }

    static public enum SugarQuantity {
        HIGH(3), //calls constructor with value 3
        MEDIUM(2), //calls constructor with value 2
        LOW(1), //calls constructor with value 1
        NONE(0) //calls constructor with value 1
        ; // semicolon needed when fields / methods follow

        private final int levelSugar;

        SugarQuantity(int levelSugar) {
            this.levelSugar = levelSugar;
        }

        public int getlevelSugar() {
            return this.levelSugar;
        }

        @Override
        public String toString() {
            return super.toString() + ":" + this.levelSugar;
        }
    }
}
