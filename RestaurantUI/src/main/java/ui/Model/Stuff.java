package ui.Model;


public class Stuff implements Comparable<Stuff> {
    	private String name;
	float price;
	String category;

    public Stuff(String name, float price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public String toString() {
            return name+")"+this.price+"£)["+this.category+"]";
    }
    
    @Override
    public boolean equals(Object other){
        if(other instanceof Stuff){
            Stuff other_stuff =(Stuff)other;
            return
                    other_stuff.getName().equals(this.getName()) &&
                    other_stuff.category.equals(this.category) &&
                    other_stuff.price == this.price;
        }
        return false;
    }
    
    static float getSumPrice(Stuff [] array){
        float sum = 0f;
        for(int i = 0; i < array.length; i++){
            sum += array[i].getPrice();
        }
        return sum;
    }

    @Override
    public int compareTo(Stuff o) {
        return Float.compare(this.price, o.price);
    }
   

}
