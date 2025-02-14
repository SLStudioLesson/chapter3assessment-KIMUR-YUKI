package com.recipeapp.model;
public class Ingredient{
    //設問１ステップ１
    private String name;//材料の名前(nameフィールド)

    public Ingredient(String name){//コンストラクタ
        this.name = name;//nameフィールドに同名の引数代入
    }

    public String getName(){//ゲッター
        return name;//nameフィールドを返す
    }
}