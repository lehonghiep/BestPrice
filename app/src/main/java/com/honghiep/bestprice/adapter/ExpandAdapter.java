package com.honghiep.bestprice.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.honghiep.bestprice.R;

/**
 * Created by honghiep on 07/09/2017.
 */

public class ExpandAdapter extends BaseExpandableListAdapter{
    private IExpandAdapter mInterf;
    public ExpandAdapter(IExpandAdapter mInterf){
        this.mInterf=mInterf;
    }
    @Override
    public int getGroupCount() {
        return mInterf.getGroupCount();
    }

    @Override
    public int getChildrenCount(int positionParent) {
        return mInterf.getChilrenCount(positionParent);
    }

    @Override
    public Object getGroup(int positionParent) {
        return mInterf.getDataGroup(positionParent);
    }

    @Override
    public Object getChild(int positionParent, int positionChild) {
        return mInterf.getDataChild(positionParent,positionChild);
    }

    @Override
    public long getGroupId(int i) {
        return mInterf.getGroupId(i);
    }

    @Override
    public long getChildId(int i, int i1) {
        return mInterf.getChildId(i, i1);
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderGroup viewHolderGroup;
        if (view == null) {
            viewHolderGroup = new ViewHolderGroup();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_groupview, viewGroup, false);
            viewHolderGroup.tvGroup = (TextView) view.findViewById(R.id.tv_title_parent);
            view.setTag(viewHolderGroup);
        } else {
            viewHolderGroup = (ViewHolderGroup) view.getTag();
        }
        viewHolderGroup.tvGroup.setText(mInterf.getDataGroup(i).getTitleParent());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderChild viewHolderChild;
        if (view == null) {
            viewHolderChild = new ViewHolderChild();
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_childview, viewGroup, false);
            viewHolderChild.tvChild = (TextView) view.findViewById(R.id.tv_title_child);
            view.setTag(viewHolderChild);
        } else {
            viewHolderChild = (ViewHolderChild) view.getTag();
        }
        viewHolderChild.tvChild.setText(mInterf.getDataChild(i,i1).getTitleChild());
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
    public static class ViewHolderGroup {
        TextView tvGroup;

    }


    public static class ViewHolderChild {
        TextView tvChild;

    }
}
