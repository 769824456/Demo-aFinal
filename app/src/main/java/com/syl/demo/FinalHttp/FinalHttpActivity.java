package com.syl.demo.FinalHttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.syl.demo.R;

import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import net.tsz.afinal.http.HttpHandler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/*
 * PACKAGE_NAME :com.syl.demo.FinalHttp
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun
 * CREATE AT : 7/28/2015 9:20 AM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * NOTE :FinalHttp的使用
 */
public class FinalHttpActivity extends AppCompatActivity {


    public static final String TAG = "FinalHttpActivity";
    @Bind(R.id.btn_http_do_get_from_server)
    Button btnHttpDoGetFromServer;
    @Bind(R.id.btn_http_do_upload_or_post)
    Button btnHttpDoUpload;
    @Bind(R.id.btn_http_do_download)
    Button btnHttpDoDownload;
    @Bind(R.id.tv_http_content)
    TextView tvHttpContent;
    private FinalHttp finalHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_http);
        ButterKnife.bind(this);

        finalHttp = new FinalHttp();
    }

    /**
     * 普通get方法
     */
    @OnClick(R.id.btn_http_do_get_from_server)
    void doGetFromServer() {

        String url = "http://www.baidu.com";
        finalHttp.get(url, new AjaxCallBack() {
            @Override
            public void onStart() {
                super.onStart();
                //开始时调用
                Log.d(TAG, "doGet:onStart");
            }

            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
                //每一秒钟自动被回调一次
                tvHttpContent.setText(current + "/" + count);
                Log.d(TAG, "doGet:onLoading");
            }

            @Override
            public void onSuccess(Object o) {
                super.onSuccess(o);
                tvHttpContent.setText(o == null ? "null" : (String) o);
                Toast.makeText(FinalHttpActivity.this, "onSuccess", Toast.LENGTH_LONG).show();
                Log.d(TAG, "doGet:onSuccess");
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                Toast.makeText(FinalHttpActivity.this, "onFailure", Toast.LENGTH_LONG).show();
                Log.d(TAG, "doGet:onFailure");
            }
        });
    }

    /**
     * 使用FinalHttp上传文件 或者 提交数据 到服务器（post方法）
     */
    @OnClick(R.id.btn_http_do_upload_or_post)
    void doUpLoadOrPost() {
        try {
            AjaxParams params = new AjaxParams();
            params.put("username", "michael yang");
            params.put("password", "123456");
            params.put("email", "test@tsz.net");
            params.put("profile_picture", new File("/mnt/sdcard/pic.jpg")); // 上传文件
            //        params.put("profile_picture2", inputStream); // 上传数据流
//            params.put("profile_picture3", new ByteArrayInputStream(bytes)); // 提交字节流

            FinalHttp fh = new FinalHttp();
            fh.post("http://www.yangfuhai.com", params, new AjaxCallBack() {
                @Override
                public void onLoading(long count, long current) {
                    tvHttpContent.setText(current + "/" + count);
                }

                @Override
                public void onSuccess(Object t) {
                    tvHttpContent.setText(t == null ? "null" : (String) t);
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }

    /**
     *下载
     */
    @OnClick(R.id.btn_http_do_download)
    void doDownLoad() {
        String url = "http://ds.devstore.cn/dev_store/news/image_and_file/1437989279996/1437989301855.jpg"; //下载路径
        String savePath = "/mnt/sdcard/test.jpg";//保存路径
        //第三个参数为true，支持断点续传
        HttpHandler<File> handler = finalHttp.download(url, savePath, new AjaxCallBack<File>() {
            @Override
            public void onLoading(long count, long current) {
                super.onLoading(count, current);
                Log.d(TAG, "doDownLoad：onLoading");
                tvHttpContent.setText(current + "/" + count);
            }

            @Override
            public void onSuccess(File file) {
                super.onSuccess(file);
                Log.d(TAG, "doDownLoad：onSuccess");
                Toast.makeText(FinalHttpActivity.this, "doDownLoad:onSuccess", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
                Log.d(TAG, "doDownLoad：onFailure");
                Toast.makeText(FinalHttpActivity.this, "doDownLoad:onFailure", Toast.LENGTH_LONG).show();
            }
        });
//        handler.stop();//停止下载

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_final_http, menu);
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
