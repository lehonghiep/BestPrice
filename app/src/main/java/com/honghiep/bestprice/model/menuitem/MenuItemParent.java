package com.honghiep.bestprice.model.menuitem;

import java.util.List;

/**
 * Created by honghiep on 07/09/2017.
 */

public class MenuItemParent extends MenuItemChild{
    private List<MenuItemChild>menuItemChildren;

    public MenuItemParent(String title, String link, List<MenuItemChild>menuItemChildren) {
        super(title, link);
        this.menuItemChildren=menuItemChildren;
    }

    public List<MenuItemChild> getMenuItemChildren() {
        return menuItemChildren;
    }
}
