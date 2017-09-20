package com.honghiep.bestprice.view.trangchu.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.honghiep.bestprice.R;
import com.honghiep.bestprice.adapter.GridViewNewsAdapter;
import com.honghiep.bestprice.model.news.News;
import com.honghiep.bestprice.view.trangchu.MainActivity;

import java.util.List;

/**
 * Created by honghiep on 04/09/2017.
 */

public class FragmentOtoXeMayXeDap extends Fragment implements GridViewNewsAdapter.IGridViewNewsAdapter{
    private GridView gridView;
    private List<News> newsList;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList = ((MainActivity) activity).xuLyNews.getNewsListOtoXemayXedap();
    }
    @Override
    public int getCount() {
        if(newsList==null){
            return 0;
        }
        return newsList.size();
    }

    @Override
    public News getData(int position) {
        return newsList.get(position);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_oto_xemay_xedap,container,false);
        gridView = view.findViewById(R.id.gridview_otoxemayxedap);
        GridViewNewsAdapter gridViewNewsAdapter=new GridViewNewsAdapter(this);
        gridView.setAdapter(gridViewNewsAdapter);
        return view;
    }


}