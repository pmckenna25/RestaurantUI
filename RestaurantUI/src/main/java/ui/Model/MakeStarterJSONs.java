package ui.Model;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.LinkedList;
import java.util.List;
import ui.Model.Drink.SugarQuantity;

public class MakeStarterJSONs {

    static Gson gson;

    public MakeStarterJSONs() throws IOException {
        gson = new GsonBuilder().create();
        Food omelette_bacon = new Food("omelette bacon", 5.5f, "main", true, false, true);
        Food chips = new Food("chips", 2.5f, "side", false, false, false);
        Food burger = new Food("beef cheese burger", 4.9f, "main", false, true, true);
        Food apple_pie = new Food("apple pie", 4.5f, "dessert", true, true, false);
        Drink guinness = new Drink("guinness", 3.8f, "beer", SugarQuantity.LOW, 4f);
        Drink smithwicks = new Drink("smithwicks", 4.2f, "beer", SugarQuantity.MEDIUM, 5.5f);
        Drink arabicTea = new Drink("arabic tea", 2.5f, "tea", SugarQuantity.LOW, 0f);
        Drink cocaCola = new Drink("Coca Cola", 1.2f, "soft drink", SugarQuantity.HIGH, 0f);

        List<Food> foods = new LinkedList<>();
        foods.add(omelette_bacon);
        foods.add(apple_pie);
        foods.add(chips);
        foods.add(burger);

        List<Drink> drinks = new LinkedList<>();
        drinks.add(guinness);
        drinks.add(smithwicks);
        drinks.add(arabicTea);
        drinks.add(cocaCola);

        try (Writer writer1 = new OutputStreamWriter(new FileOutputStream("Food.json"), "UTF-8")) {
            gson.toJson(foods, writer1);
        }
        try (Writer writer2 = new OutputStreamWriter(new FileOutputStream("Drink.json"), "UTF-8")) {
            gson.toJson(drinks, writer2);
        }
    }

}
