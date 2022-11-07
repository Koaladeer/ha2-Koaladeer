package htw.berlin.wi.prog2.domain;

import java.util.ArrayList;
import java.util.List;

public class DynamicallyComputedBurger implements Burger {

    List<Ingredient> ingredients = new ArrayList<Ingredient>();

    public DynamicallyComputedBurger(List<Ingredient> burgerIngredients) {
        this.ingredients = burgerIngredients;
    }

    @Override
    public double calculatePrice() {
        double sumPrice = 0;
        for (Ingredient i : ingredients) sumPrice += i.getPrice();
        return sumPrice;
    }

    @Override
    public int calculateCalories() {
        int sumCalories = 0;
        for (Ingredient i : ingredients) {
            sumCalories += i.getCalories();
        }
        return sumCalories;
    }

    @Override
    public List<String> getIngredientNames() {
        List<String> ingredientsNameList = new ArrayList<String>();
        for (Ingredient i : ingredients) {
            ingredientsNameList.add(i.getName());
        }
        return ingredientsNameList;
    }
}
