package com.honghiep.bestprice.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.honghiep.bestprice.R;
import com.honghiep.bestprice.model.news.News;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

/**
 * Created by honghiep on 13/09/2017.
 */

public class GridViewNewsAdapter extends BaseAdapter{
    private IGridViewNewsAdapter mInterf;
    public GridViewNewsAdapter(IGridViewNewsAdapter iGridViewNewsAdapter){
        mInterf=iGridViewNewsAdapter;
    }
    @Override
    public int getCount() {
        return mInterf.getCount();
    }

    @Override
    public Object getItem(int i) {
        return mInterf.getData(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
            view=inflater.inflate(R.layout.custom_item_gridview_news,viewGroup,false);
            ViewHolder holder=new ViewHolder();
            holder.image=view.findViewById(R.id.image);
            holder.tvTitle=view.findViewById(R.id.tv_title);
            view.setTag(holder);
        }
        final ViewHolder holder= (ViewHolder) view.getTag();
        holder.tvTitle.setText(mInterf.getData(i).getTitle());
//        Picasso.with(viewGroup.getContext())
//                .load(mInterf.getData(i).getLinkImg())
//                .placeholder(R.mipmap.ic_launcher_round)
//                .error(R.mipmap.ic_launcher)
//                .into(holder.image);
        String linkImg=mInterf.getData(i).getLinkImg();
//        Picasso.with(viewGroup.getContext()).load("https://img.websosanh.vn/v2/users/review/images/aa6gwt82t7nox.jpg").into(holder.image);
//        Glide.with(viewGroup.getContext())
//                .load("https://img.websosanh.vn/v2/users/review/images/aa6gwt82t7nox.jpg")
//                .into(holder.image);
        final Context context=viewGroup.getContext();
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.listener(new Picasso.Listener() {

            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
                holder.image
                        .setImageDrawable(context.getResources()
                                .getDrawable(R.mipmap.ic_launcher_round));
            }
        });
//        builder.downloader(new OkHttpDownloader(context));
        builder.build().load("https://img.websosanh.vn/v2/users/review/images/aa6gwt82t7nox.jpg").into(holder.image);
        return view;
    }
    public interface IGridViewNewsAdapter{
        int getCount();
        News getData(int position);
    }
    class ViewHolder{
        ImageView image;
        TextView tvTitle;
    }
}
