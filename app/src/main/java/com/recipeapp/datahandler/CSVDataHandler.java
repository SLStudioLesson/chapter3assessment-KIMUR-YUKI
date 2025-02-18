package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    //設問３
    private String filePath;//レシピデータを格納するためのCSVファイルパス

    public CSVDataHandler(){//コンストラクタ
        filePath = "app/src/main/resources/recipes.csv";//フィールドfilepathに
                                                            //app/src/main/resources/recipes.csvを代入
    }

    public CSVDataHandler(String filepath){//コンストラクタ
        this.filePath = filepath;//フィールドfilepathに引数を代入する
    }

    public String getMode(){
        return "csv";//文字列csvを返す
    }

    public ArrayList<Recipe> readData(){
        ArrayList<Recipe> recipes = new ArrayList<>();//このまま(今はまだ空)
                
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {//ファイル読み込み
            String line;
            while ((line = reader.readLine()) != null) {//一行分の文字列が入っている
                String[] recipeData = line.split(",",2);//文字列分割
            //recipeDataの0番目を取り出す
                String recipeName = recipeData[0];
                String ingredientName = recipeData[1];
                String[] ingredientSplitData = ingredientName.split(",");
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                // 1. ingredientSplitDataから材料名を１つずつ取り出す
                for(String splitData : ingredientSplitData){
                    // 2. Ingredientインスタンスを生成する
                    // 2-1. インスタンス生成したときに、手順1で取り出したレシピ名を渡す
                    Ingredient ingredient = new Ingredient(splitData);
                    // 手順2で生成したIngredientインスタンスを、ingredientsに追加（add）する
                    ingredients.add(ingredient);

                }

                // 1. 取り出した値をレシピオブジェクトのnameフィールドに入れ
                // 1-1. レシピインスタンスを生成
                Recipe recipe = new Recipe(recipeName,ingredients);
                recipes.add(recipe);//変数recipesにデータを追加(recipe)
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return recipes;
    }
    public void writeData(Recipe recipe)throws IOException{
    // 新しいレシピをrecipes.csvに追加します。
    // レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
    // 1. ファイルを読み込む
    // 2. recipeの名前を書き込む
    // 3. recipeより材料情報(以下、ingredients)を取得する
    // 4. ingredientsのデータ件数分繰り返し、次の処理を行う
    //     4-1. カンマを書き込む
    //     4-2. 要素(以下、Ingredientオブジェクト)を1件取得する
    //     4-3. Ingredientオブジェクトより材料名を取得する
    //     4-4. 材料名を書き込む
    // 5. 改行を書き込む
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true))){//1.ファイル書き込み
        String recipeName = recipe.getName();//recipeNameにrecipeのリストの名前を代入
        ArrayList<Ingredient>ingredients = recipe.getIngredients();//ingredientsを取得
        
        writer.write(recipeName);//2.レシピの名前を書き込む
        for(int i = 0; i < ingredients.size(); i++){//4.ingredientsのデータ件数分繰り返し、次の処理を行う
            writer.write(",");//4-1.カンマを書き込む
            Ingredient ingredient = ingredients.get(i);//4-2. 要素(以下、Ingredientオブジェクト)を1件取得する
            String ingredientName = ingredient.getName();//4-3. Ingredientオブジェクトより材料名を取得する
            writer.write(ingredientName);//4-4. 材料名を書き込む
        }
        writer.newLine();//5. 改行を書き込む
        
        }catch(IOException e){
            System.out.println("Failed to add new recipe:" + e.getMessage());
        }
    }
    public ArrayList<Recipe>  searchData(String keyword){
        return null;//nullをリターン
    }
}