package com.recipeapp.model;

import java.util.ArrayList;

public class Recipe{
    //設問１ステップ１
    private String name;//レシピの名前(nameフィールド)
    private ArrayList<Ingredient> ingredients;//レシピの材料リスト(ingredientsフィールド)

    public Recipe(String name, ArrayList<Ingredient> ingredients){//コンストラクタ
        this.name = name;//nameフィールドに同名の引数代入
        this.ingredients = ingredients;//ingredientsフィールドに同名の引数代入
    }

    //getter
    public String getName(){//ゲッター()
        return name;//nameフィールドを返す
    }

    public ArrayList<Ingredient> getIngredients(){//ゲッター()
        return ingredients;//ingredientsフィールドを返す
    }
}
