package com.recipeapp.datahandler;

import java.io.IOException;
import java.util.ArrayList;

import com.recipeapp.model.Recipe;
//設問２
public interface DataHandler {//DataHandlerインターフェース
    public String getMode();//現在のモードを返す
    
    public ArrayList<Recipe> readData()throws IOException;//	レシピデータを読み込み、Recipeオブジェクトのリストとして返します

    public void writeData(Recipe recipe)throws IOException;//指定されたRecipeオブジェクトを追加します。

    
    public ArrayList<Recipe> searchData(String keyword)throws IOException;//指定されたキーワードでレシピを検索し、一致するRecipeオブジェクトのリストを返します。
}