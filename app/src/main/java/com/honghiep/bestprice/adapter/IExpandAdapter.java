package com.honghiep.bestprice.adapter;

import com.honghiep.bestprice.model.menuitem.MenuItemChild;
import com.honghiep.bestprice.model.menuitem.MenuItemParent;

/**
 * Created by honghiep on 07/09/2017.
 */

public interface IExpandAdapter {
    int getGroupCount();

    int getChilrenCount(int positionParent);

    MenuItemParent getDataGroup(int positionParent);

    MenuItemChild getDataChild(int positionParent, int positionChild);

    long getGroupId(int i);

    long getChildId(int i, int i1);

}
