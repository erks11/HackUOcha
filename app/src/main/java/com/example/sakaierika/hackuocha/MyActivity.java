package com.example.sakaierika.hackuocha;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ParseException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;


public class MyActivity extends Activity {

    static final int REQUEST_CAPTURE_IMAGE = 100;
    private static final int REQUEST_GALLERY = 0;

    LinearLayout linearLayout1;
    //ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        String url = "http://oglsv.ogl.is.ocha.ac.jp/hackYou/index.php";

        AsyncHttpRequest task = new AsyncHttpRequest(this);
       // task.owner = this;
        //task.execute(url);

//
//        String topsurl = "https:\\/\\/farm4.staticflickr.com\\/3923\\/15018622468_bc292bd6c8.jpg";
//        AsyncHttpRequest topstask = new AsyncHttpRequest(this);
//        topstask.owner = this;
//        //task.execute(topsurl);

//        final int WC = ViewGroup.LayoutParams.WRAP_CONTENT;
//        final int MP = ViewGroup.LayoutParams.MATCH_PARENT;
//
//        linearLayout1 = (LinearLayout)findViewById(R.id.LinearLayout2);
//
//        //普通のviewの生成
//        ImageView oImg = new ImageView(getApplicationContext());
//        //横MAXの縦幅は画像と同じ高さ
//        oImg.setLayoutParams(new LinearLayout.LayoutParams(MP, WC));
//
//        InputStream istream;
//        try {
//            //画像のURLを直うち
//            URL topurl = new URL(topsurl);
//            //インプットストリームで画像を読み込む
//            istream = topurl.openStream();
//            //読み込んだファイルをビットマップに変換
//            Bitmap oBmp = BitmapFactory.decodeStream(istream);
//            //ビットマップをImageViewに設定
//            oImg.setImageBitmap(oBmp);
//            //インプットストリームを閉じる
//            istream.close();
//        } catch (IOException e) {
//            // TODO 自動生成された catch ブロック
//            e.printStackTrace();
//        }
////        if(imgView.getParent() != null){
////        }
//        linearLayout1.addView(oImg);
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

    public void Ok(View v){ setContentView(R.layout.activity_ok);   }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode != KeyEvent.KEYCODE_BACK){
            return super.onKeyDown(keyCode, event);
            }else{
            setContentView(R.layout.activity_my);
            return false;
            }
    }

}
