
package ui.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class FoodAndDrinkMenus {
    
    Drink[] drinks;
    Food[] food;
    static Gson gson;
    
    public FoodAndDrinkMenus() throws IOException{
        gson = new GsonBuilder().create();
        this.food = createOrderFood();
        this.drinks = createOrderDrink();
    }
    
    private Food[] createOrderFood() throws IOException{
        try (Reader reader = new InputStreamReader(new FileInputStream("Food.json"), "UTF-8")) {
            return gson.fromJson(reader, Food[].class);
        }
    }
    private Drink[] createOrderDrink() throws IOException{
        try (Reader reader = new InputStreamReader(new FileInputStream("Drink.json"), "UTF-8")) {
            return gson.fromJson(reader, Drink[].class);
        }
    }

    public Drink[] getDrinks() {
        return drinks;
    }

    public Food[] getFood() {
        return food;
    }
    
    
}
