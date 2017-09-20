package com.honghiep.bestprice.presenter.trangchu.menuitem;

import com.honghiep.bestprice.adapter.IExpandAdapter;
import com.honghiep.bestprice.connectinternet.DownloadJSON;
import com.honghiep.bestprice.model.menuitem.MenuItemChild;
import com.honghiep.bestprice.model.menuitem.MenuItemParent;
import com.honghiep.bestprice.model.trangchu.xulymenuitem.XuLyMenuItem;
import com.honghiep.bestprice.presenter.trangchu.menuitem.IPresenterXuLyMenu;
import com.honghiep.bestprice.view.trangchu.IViewXuLyMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by honghiep on 07/09/2017.
 */

public class PresenterXulyMenuItem implements IPresenterXuLyMenu, IExpandAdapter{
    private IViewXuLyMenu mInterf;
    List<MenuItemParent>menuItemParentList;

    public PresenterXulyMenuItem(IViewXuLyMenu mInterf){
        this.mInterf = mInterf;
        menuItemParentList=new ArrayList<>();
    }

    @Override
    public void layDanhSachMenu() {
        String content=DownloadJSON.getJson("/user/getMenuItem");
        if(content!=null){
            XuLyMenuItem xuLyMenuItem=new XuLyMenuItem();
            menuItemParentList=xuLyMenuItem.parserJSONMenu(content);
        }
    }
    @Override
    public void loadDanhSachMenu(){
        mInterf.loadDanhSachMenuItem(this);
    }

    @Override
    public int getGroupCount() {
        if(menuItemParentList==null){
            return 0;
        }
        return menuItemParentList.size();
    }

    @Override
    public int getChilrenCount(int positionParent) {
        return menuItemParentList.get(positionParent).getMenuItemChildren().size();
    }

    @Override
    public MenuItemParent getDataGroup(int positionParent) {
        return menuItemParentList.get(positionParent);
    }

    @Override
    public MenuItemChild getDataChild(int positionParent, int positionChild) {
        return menuItemParentList.get(positionParent).getMenuItemChildren().get(positionChild);
    }

    @Override
    public long getGroupId(int i) {
        return menuItemParentList.get(i).getIdParent();
    }

    @Override
    public long getChildId(int i, int i1) {
        return menuItemParentList.get(i).getMenuItemChildren().get(i1).getIdChild();
    }
}
