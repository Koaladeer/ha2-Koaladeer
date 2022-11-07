package htw.berlin.wi.prog2.service;

import htw.berlin.wi.prog2.domain.*;

import java.util.ArrayList;
import java.util.List;

public class BurgerBuilder {

    /*Implementieren Sie nun in der BurgerBuilder-Klasse die drei Methoden add,
    buildPrecomputed und buildDynamically so, dass sie die jeweilige Burger-Implementierung nutzen
     (statt der DummyBurgerImpl), um die Testfälle im BurgerBuilderTest grün zu machen (ohne die Tests zu verändern!)
     */
    private List<Ingredient> ingredientList = new ArrayList<>();
    private  boolean flag = false;
    public BurgerBuilder add(Ingredient newBuIngredient) {
        if (flag) {
            ingredientList.clear();
            flag = false;}
        ingredientList.add(newBuIngredient);
        return this; // die Rückgabe von this sollte beibehalten bleiben (siehe Benutzung im BurgerBuilderTest)
    }

    public Burger buildPrecomputed() {
        // TODO hier stattdessen die neue Klasse PrecomputedBurger verwenden
        double priceSum = 0;
        int caloriesSum = 0;
        List<String> ingredientsNames;
        ingredientsNames = new ArrayList<>();
        checkIngredientsMinCount(ingredientList);
        for (Ingredient i:ingredientList) {
            caloriesSum += i.getCalories();
            priceSum += i.getPrice();
            ingredientsNames.add(i.getName());
        }
        //ingredientList.clear();
        flag = true;
        return new PrecomputedBurger(priceSum,caloriesSum,ingredientsNames);
    }

    public Burger buildDynamicallyComputed() {
        // TODO hier stattdessen die neue Klasse DynamicallyComputedBurger verwenden
        List<Ingredient> tempList = new ArrayList<>();
        for (Ingredient ingredient : ingredientList) {
            tempList.add(ingredient);
        }
        checkIngredientsMinCount(tempList);
        flag = true;
        return new DynamicallyComputedBurger(tempList);
    }
    private void checkIngredientsMinCount(List<Ingredient> ingredientsList){
        if (ingredientsList.size() < 2){
            throw  new IllegalBurgerException("you need at least two ingredients for a burger");
        }
    }
}
