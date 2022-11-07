package htw.berlin.wi.prog2.domain;

import java.util.ArrayList;
import java.util.List;

public class PrecomputedBurger implements Burger{

    private double price;
    private int calories;
    private  List<String> ingredients = new ArrayList<String>();
    public PrecomputedBurger(double bPrice, int bCalories, List<String> bIngredientsNames) {
        this.price = bPrice;
        this.calories = bCalories;
        this.ingredients = bIngredientsNames;
    }

    @Override
    public double calculatePrice() {
        return this.price;
    }

    @Override
    public int calculateCalories() {
        return this.calories;
    }

    @Override
    public List<String> getIngredientNames() {
        return this.ingredients;
    }
}
