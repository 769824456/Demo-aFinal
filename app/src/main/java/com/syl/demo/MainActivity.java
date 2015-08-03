package com.syl.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.syl.demo.FinalActivity.FinalActivityActivity;
import com.syl.demo.FinalBitmap.FinalBitmapActivity;
import com.syl.demo.FinalDB.FinalDBActivity;
import com.syl.demo.FinalHttp.FinalHttpActivity;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/*
 * PACKAGE_NAME :com.syl.demo
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun 
 * CREATE AT : 7/27/2015 3:21 PM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * NOTE :AFinal Demo
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Bind(R.id.lv_main_content)
    ListView lvMainContent;
    private ArrayList<String> mData;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListView();

    }

    private void initListView() {
        mData = new ArrayList<String>();
        mData.add(FinalDBActivity.TAG);
        mData.add(FinalActivityActivity.TAG);
        mData.add(FinalHttpActivity.TAG);
        mData.add(FinalBitmapActivity.TAG);

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mData);
        lvMainContent.setAdapter(mAdapter);
        lvMainContent.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = null;
        String TAG = mData.get(i);
        if(TextUtils.equals(TAG,FinalDBActivity.TAG)){
            intent = new Intent(this,FinalDBActivity.class);
        }else  if(TextUtils.equals(TAG, FinalActivityActivity.TAG)){
            intent = new Intent(this,FinalActivityActivity.class);
        }else  if(TextUtils.equals(TAG, FinalHttpActivity.TAG)){
            intent = new Intent(this,FinalHttpActivity.class);
        }else  if(TextUtils.equals(TAG, FinalBitmapActivity.TAG)){
            intent = new Intent(this,FinalBitmapActivity.class);
        }
        if (intent != null) {
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
