package com.honghiep.bestprice.model.menuitem;

import com.google.gson.annotations.SerializedName;

/**
 * Created by honghiep on 07/09/2017.
 */

public class MenuItemChild {
    @SerializedName("idChild")
    private int idChild;
    @SerializedName("titleChild")
    private String titleChild;
    @SerializedName("linkChild")
    private String linkChild;

    public MenuItemChild(int idChild, String title, String link) {
        this.idChild=idChild;
        this.titleChild = title;
        this.linkChild = link;
    }

    public String getTitleChild() {
        return titleChild;
    }

    public String getLinkChild() {
        return linkChild;
    }

    public int getIdChild() {
        return idChild;
    }
}
