package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class RecipeUI {
    private BufferedReader reader;
    private DataHandler dataHandler;

    
    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    

    public void displayMenu() {

        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        displayRecipes();//１の選択のときにこのメソッド実行
                        break;
                    case "2":
                        addNewRecipe();//２の選択のときにこのメソッド実行
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private void displayRecipes(){
        try{
            ArrayList<Recipe> recipes = dataHandler.readData();//DataHandlerのreadDataを取り出す
            if (recipes.isEmpty()) {//recipesが空だったら
                System.out.println("No recipes available.");
                return;
            }
            System.out.println();//改行
            System.out.println("Recipes:");
            System.out.println("-----------------------------------");
            for(Recipe recipe : recipes){//recipeという変数にrecipesのデータを格納
                System.out.println("Recipe Name: " + recipe.getName());//ゲッターを使いレシピ名取得
                System.out.print("Main Ingredirnts:");
                for(Ingredient ingredient : recipe.getIngredients()){//ゲッターを使って材料名取得
                System.out.print(ingredient.getName() + ",");
                }
                System.out.println();
                System.out.println("-----------------------------------");
            }
            
            
        }catch (IOException e){
            System.out.println("Error reading file: 例外のメッセージ");
        }
}

    public void addNewRecipe()throws IOException{
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Adding a new recipe");//1. `Adding a new recipe.`と画面に出力する（改行アリ）
            System.out.print("Enter recipe name:");//2. `Enter recipe name: `と画面に出力する（改行ナシ）
            String recipeName = reader.readLine();//3. 文字入力処理を実行し、変数（以下、recipeName）に代入する
            String ingredientInput;//4-1. 材料情報入力用の変数を用意する（以下、ingredientInput）
            ArrayList<Ingredient> ingredients = new ArrayList<>();//4-2. 材料オブジェクトのリストを生成する（以下、ingredients）
            
            
            System.out.println("Enter ingredients (type 'done' when finished):");//5. `Enter ingredients (type 'done' when finished):`と画面に出力する（改行アリ）
            while(true){
                System.out.print("Ingredient:");//6-1. `Ingredient: `と画面に出力する（改行ナシ）
                ingredientInput = reader.readLine();// 6-2. 文字入力処理を実行し、ingredientInputに代入する
                if(ingredientInput.equals("done")){//6-3. ingredientInputが `done`であった場合、次の処理をする
                    break;//6-3-1. 繰り返しを修了する
                }
                Ingredient ingredient = new Ingredient(ingredientInput);//6-4. Ingredientオブジェクト（以下、ingredient）を生成する
                                                                        //6-4-1. 材料名にはingredientInputを指定する
                ingredients.add(ingredient);//6-5. ingredientをingredientsに追加する
                Recipe recipe = new Recipe(recipeName, ingredients);//7. Recipeオブジェクト(以下、recipe)を生成する
                                                                    //7-1. レシピ名は recipeName を指定する
                                                                    //7-2. 材料リストは ingredientsを指定する
                dataHandler.writeData(recipe);//8. writeDataに recipeを渡す
            }
            System.out.println("Recipe added successfully.");//9. `Recipe added successfully.`を画面に出力する（改行アリ）
        }catch (IOException e){//10. 上記処理のいずれかの中でIOExceptionが発生した場合は次の処理を行う
            System.out.print("Failed to add new recipe: 例外のメッセージ");//10-1. `Failed to add new recipe: `を画面に出力する（改行ナシ）
            System.out.println();//改行
        }
    }
}
