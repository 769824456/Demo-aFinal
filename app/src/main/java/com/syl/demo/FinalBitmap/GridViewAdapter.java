package com.syl.demo.FinalBitmap;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.syl.demo.R;

import net.tsz.afinal.FinalBitmap;

import java.util.ArrayList;

/*
 * PROJECT_NAME :Demo
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun 
 * CREATE AT : 7/28/2015 10:05 AM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * NOTE :
 */
public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder> {
    private final LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<String> mData;
    private FinalBitmap mFinalBitmap;

    public GridViewAdapter(Context mContext, FinalBitmap mFinalHttp, ArrayList<String> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mFinalBitmap = mFinalHttp;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.listview_item_gridview, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.ivItem = (ImageView) view.findViewById(R.id.iv_item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mFinalBitmap.display(holder.ivItem, mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItem;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
