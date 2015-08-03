package com.syl.demo.FinalActivity;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.syl.demo.R;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
/*
 * PACKAGE_NAME :com.syl.demo.FinalActivity
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun
 * CREATE AT : 7/27/2015 5:09 PM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * NOTE :
 * 侵入式继承FinalActivity
 */
public class FinalActivityActivity extends FragmentActivity {
    public static final String TAG = "FinalActivity";

    @ViewInject(id = R.id.btn_activity_enter_fragment, click = "enterFragment")
    Button btnActivityEnterFragment;
    @ViewInject(id = R.id.rl_activity_content)
    RelativeLayout rlActivityContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        //在其他侵入式Activity中使用FinalActivity
        FinalActivity.initInjectedView(this);
    }

    /**
     * 进入Fragment
     */
    void enterFragment() {
        FinalFragment finalFragment = new FinalFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.rl_activity_content,finalFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_final, menu);
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
