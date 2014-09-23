package com.example.sakaierika.hackuocha;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;


public class MyActivity extends Activity {

    static final int REQUEST_CAPTURE_IMAGE = 100;

    HorizontalScrollView scrollView;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        HorizontalScrollView scrollView = (HorizontalScrollView)findViewById(R.id.HorizontalScrollView1);

        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.LinearLayout1);
        // ScrollView に LinearLayout を追加


        //追加したいView
        //LinearLayoutにviewを追加する

        //linearLayout.addView(v);

        scrollView.removeAllViews();
        scrollView.addView(linearLayout);




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void Camera(View v){
        Log.v("tag", "camera");
        Intent intent = new Intent();

        //インテントのアクションを指定する
        intent.setAction("android.media.action.IMAGE_CAPTURE");

        //標準搭載されているカメラアプリのアクティビティを起動する
        startActivity(intent);

        //アクティビティを閉じる
        finish();

    }

    public void Ok(View v){
        setContentView(R.layout.activity_ok);
    }

}
