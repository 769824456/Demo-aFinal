package com.syl.demo.FinalBitmap;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.syl.demo.R;

import net.tsz.afinal.FinalBitmap;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * PACKAGE_NAME :com.syl.demo.FinalBitmap
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun
 * CREATE AT : 7/28/2015 10:03 AM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * NOTE :FinalBitmap
 */
public class FinalBitmapActivity extends AppCompatActivity {

    public static final String TAG = "FinalBitmapActivity";
    @Bind(R.id.rv_bitmap)
    RecyclerView rvBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_bitmap);
        ButterKnife.bind(this);
        String url = "http://ds.devstore.cn/dev_store/news/image_and_file/1437989279996/1437989301855.jpg";
        ArrayList<String> mDatas = new ArrayList<>();
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);
        mDatas.add(url);

        FinalBitmap finalBitmap = FinalBitmap.create(this);
        finalBitmap.configLoadingImage(R.mipmap.ic_launcher);

        GridViewAdapter mAdapter = new GridViewAdapter(FinalBitmapActivity.this, finalBitmap, mDatas);
        GridLayoutManager manager = new GridLayoutManager(this, 3);
        rvBitmap.setLayoutManager(manager);
        rvBitmap.setAdapter(mAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_final_bitmap, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
