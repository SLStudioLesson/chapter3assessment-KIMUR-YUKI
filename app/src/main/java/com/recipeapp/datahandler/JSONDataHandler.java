package com.recipeapp.datahandler;

import java.util.ArrayList;

import com.recipeapp.model.Recipe;

public class JSONDataHandler implements DataHandler{
    public String getMode(){
        return "JSON";
    }

    public ArrayList<Recipe> readData(){
        return null;//nullをリターン
    }

    public void writeData(Recipe recipe){
        return ;
    }

    public ArrayList<Recipe> searchData(String keyword){
        return null;//nullをリターン
    }
}