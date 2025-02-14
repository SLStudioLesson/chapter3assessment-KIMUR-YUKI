package com.recipeapp.model;

import java.util.ArrayList;

public class Recipe{
    private String name;//レシピの名前
    private ArrayList<Ingredient> ingredient;//レシピの材料リスト

    public Recipe(String name, ArrayList ingredients){
        this.name = name;
        this.ingredient = ingredients;
    }

    //getter
    public String getName(){
        return name;
    }

    public ArrayList<Ingredient> getIngredients(){
        return ingredient;
    }
}
