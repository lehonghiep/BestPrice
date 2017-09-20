package com.honghiep.bestprice.model.menuitem;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by honghiep on 07/09/2017.
 */

public class ResultMenuItem {
   @SerializedName("menuItems")
    List<MenuItemParent> menuItems;

    public ResultMenuItem(List<MenuItemParent> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MenuItemParent> getMenuItems() {
        return menuItems;
    }
}
