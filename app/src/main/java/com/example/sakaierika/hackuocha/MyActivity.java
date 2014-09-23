package com.example.sakaierika.hackuocha;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import java.io.InputStream;
import java.util.ArrayList;


public class MyActivity extends Activity {

    static final int REQUEST_CAPTURE_IMAGE = 100;
    private static final int REQUEST_GALLERY = 0;

    HorizontalScrollView scrollView1;
    LinearLayout linearLayout1;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        LinearLayout linearLayout1 = (LinearLayout)
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
