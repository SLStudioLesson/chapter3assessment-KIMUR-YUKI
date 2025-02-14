package com.recipeapp.datahandler;

import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler {
    //設問３
    private String filiPath;//レシピデータを格納するためのCSVファイルパス

    public CSVDataHandler(){//コンストラクタ
        this.filiPath = "app/src/main/resources/recipes.csv";//フィールドfilepathに
                                                            //app/src/main/resources/recipes.csvを代入
    }

    public CSVDataHandler(String filepath){//コンストラクタ
        this.filiPath = filepath;//フィールドfilepathに引数を代入する
    }

    public String getMode(){
        return "csv";//文字列csvを返す
    }

    public ArrayList<Recipe> readData(){
        return null;//nullをリターン
    }
    public void writeData(Recipe recipe){
        return ;
    }
    public ArrayList<Recipe>  searchData(String keyword){
        return null;//nullをリターン
    }
}