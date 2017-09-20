package com.honghiep.bestprice.model.trangchu.xulymenuitem;

import android.util.Log;

import com.google.gson.Gson;
import com.honghiep.bestprice.model.menuitem.MenuItemParent;
import com.honghiep.bestprice.model.menuitem.ResultMenuItem;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by honghiep on 07/09/2017.
 */

public class XuLyMenuItem {
    public List<MenuItemParent> parserJSONMenu(String dulieujson){
        Gson gson=new Gson();
        ResultMenuItem resultMenuItem=gson.fromJson(dulieujson,ResultMenuItem.class);
        return resultMenuItem.getMenuItems();
    }
}
