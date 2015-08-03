package com.syl.demo.FinalDB;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.syl.demo.FinalDB.bean.User;
import com.syl.demo.R;

import net.tsz.afinal.FinalDb;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * PACKAGE_NAME :com.syl.demo.FinalDB
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun
 * CREATE AT : 7/27/2015 4:02 PM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * NOTE :FinalDB--半Orm数据库框架
 * 注意需要添加的权限：
 * SD卡可读
 * SD卡可写
 * 教程：http://my.oschina.net/yangfuhai/blog/87459
 */
public class FinalDBActivity extends AppCompatActivity {
    public static final String TAG = "FinalDBActivity";
    @Bind(R.id.btn_db_add)
    Button btnDbAdd;
    @Bind(R.id.btn_db_delete)
    Button btnDbDelete;
    @Bind(R.id.btn_db_find)
    Button btnDbFind;
    @Bind(R.id.btn_db_find_all)
    Button btnDbFindAll;
    @Bind(R.id.tv_db_content)
    TextView tvDbContent;
    private FinalDb db;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_db);
        ButterKnife.bind(this);
        //1.
        db = FinalDb.create(this, "FinalDB");


    }

    @OnClick(R.id.btn_db_add)
    void addUser() {
        //2.添加
        User user = new User();
        user.setName("张三" + count);
        user.setAge(11 + count);
        db.save(user);
        count++;
        Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_db_delete)
    void deleteUser() {
        //3.删除User
        List<User> userList = db.findAll(User.class);
        int size = userList.size();
        if(size>0){
            db.deleteById(User.class,size);
            Toast.makeText(this,"删除成功",Toast.LENGTH_SHORT).show();
        }else{
            tvDbContent.setText("没有数据可以删除");
        }

    }

    @OnClick(R.id.btn_db_find)
    void findLast() {
        //查找最后一条数据
        List<User> userList = db.findAll(User.class);
        int size = userList.size();
        if(size>0){
            User user = db.findById(size,User.class);
            tvDbContent.setText(user.toString());
        }else{
            tvDbContent.setText("没有数据");
        }
    }

    @OnClick(R.id.btn_db_find_all)
    void findAll() {
        //.查询所有用户
        List<User> userList = db.findAll(User.class);
        Log.d(TAG, "user size:" + userList.size());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < userList.size(); i++) {
            User item = userList.get(i);
            Log.d(TAG, item.getName() + ":" + item.getAge());
            sb.append(item.getName() + ":" + item.getAge()+"\n");
        }
        tvDbContent.setText(sb.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_final_db, menu);
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
