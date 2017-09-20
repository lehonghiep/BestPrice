package com.honghiep.bestprice.model.menuitem;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by honghiep on 07/09/2017.
 */

public class MenuItemParent{
    @SerializedName("idParent")
    private int idParent;
    @SerializedName("titleParent")
    private String titleParent;
    @SerializedName("linkParent")
    private String linkParent;
    @SerializedName("menuItemChildren")
    private List<MenuItemChild>menuItemChildren;

    public MenuItemParent(int idParent, String title, String link, List<MenuItemChild>menuItemChildren) {
        this.idParent=idParent;
        this.menuItemChildren=menuItemChildren;
        this.titleParent =title;
        this.linkParent =link;
    }

    public List<MenuItemChild> getMenuItemChildren() {
        return menuItemChildren;
    }

    public String getTitleParent() {
        return titleParent;
    }

    public String getLinkParent() {
        return linkParent;
    }

    public int getIdParent() {
        return idParent;
    }
}
