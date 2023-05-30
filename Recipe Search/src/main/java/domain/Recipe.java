package domain;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private int duration;
    private ArrayList<String> ingredients;

    public Recipe(String name, int duration, ArrayList<String> ingredients) {
        this.name = name;
        this.duration = duration;
        this.ingredients = ingredients;
    }

    public int getDuration() {
        return duration;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name + ", cooking time: " + duration;
    }
}
