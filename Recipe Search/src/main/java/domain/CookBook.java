package domain;

import java.util.ArrayList;

public class CookBook {

    private ArrayList<Recipe> recipes;

    public CookBook() {
        this.recipes = new ArrayList<>();
    }

    public void add(Recipe recipe) {
        recipes.add(recipe);
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }
}
