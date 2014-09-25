package com.example.sakaierika.hackuocha;

/**
 * Created by erikasakai on 2014/09/25.
 */
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.*;
import org.apache.http.impl.client.*;
import org.apache.http.client.methods.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class AsyncHttpRequest extends AsyncTask<String, Void, String> {
    public Activity owner;
    private String ReceiveStr;
    private Bitmap oBmp;
    private ImageView imgview;


    public AsyncHttpRequest(Activity activity) {
        owner = activity;
    }


    @Override
    protected String doInBackground(String... url) {

        HttpClient httpClient = new DefaultHttpClient();
        HttpParams params = httpClient.getParams();
        HttpConnectionParams.setConnectionTimeout(params, 1000);
        HttpConnectionParams.setSoTimeout(params, 1000);

        HttpUriRequest httpRequest = new HttpGet(url[0]);

        HttpResponse httpResponse = null;

        try {
            httpResponse = httpClient.execute(httpRequest);
        } catch (ClientProtocolException e) {
            //例外処理
        } catch (IOException e) {
            //例外処理
        }
        // ここからJsonの取得部分
        String json = null;
        if (httpResponse != null && httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity httpEntity = httpResponse.getEntity();
            try {
                json = EntityUtils.toString(httpEntity);
            } catch (ParseException e) {
                //例外処理
            } catch (IOException e) {
                //例外処理
            } finally {
                try {
                    httpEntity.consumeContent();
                } catch (IOException e) {
                    //例外処理
                }
            }
        }
            httpClient.getConnectionManager().shutdown();

        // この下にjson のparse を書く（json には既に結果が返ってきているはず）

        imgview = (ImageView)owner.findViewById(R.id.imageView2);

        try {
            //文字列をJSONオブジェクトに変換
            JSONObject rootObject = new JSONObject(json);

            //キーから、アイテムを取得する
            JSONObject topsobject = (JSONObject)rootObject.get("tops");

            //JSONオブジェクト型から、文字列に変換
            String sKekka = topsobject.get("01").toString();
            //this.loadInBackground(sKekka);
              //oBmp = loadInBackground(sKekka);
                //ビットマップをImageViewに設定

            Handler handler= new Handler();

            handler.post(new Runnable() {
                @Override
                public void run() {
                    imgview.setImageBitmap(oBmp);
                }
            });




        } catch (JSONException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }


        return "";
    }

//
//    public Bitmap loadInBackground(String image) {
//
//        try {
//            URL url = new URL(image);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoInput(true);
//            connection.connect();
//            return BitmapFactory.decodeStream(connection.getInputStream());
//        } catch (IOException e) {
//            // 404はここでキャッチする
//            e.printStackTrace();
//        }
//
//        return null;
//    }



    @Override
    protected void onPostExecute(String result) {


    }
}

//        String parsedText = "";
//
//        try {
//            // オブジェクトの生成
//            JSONObject rootObject = new JSONObject(ReceiveStr);
//
//            // 「”BooksBookSearch”オブジェクト」
//            JSONObject topsobject= rootObject.getJSONObject("tops");
//            JSONArray topsArray = topsobject.getJSONArray("tops");
//
//            int count = topsArray.length();
//
//            Log.v("json",Integer.toString(count));
//
//            JSONObject[] bookObject = new JSONObject[count];
//            for (int i=0; i<count; i++){
//                bookObject[i] = topsArray.getJSONObject(i);
//            }
//            for (int i=0; i<bookObject.length; i++){
//                String title = bookObject[i].getString("tops");
//                //TextView textView2 = (TextView) owner.findViewById(R.id.textView2);
//                //textView2.setHorizontallyScrolling(true);  // 行の折り返しをさせない
//                //
//                //
//                // textView2.setText(title);
//            }
//
//            // JSON 形式データ文字列にインデントを加えた形に成形
//            //parsedText = rootObject.toString(1);
//        } catch (JSONException e) {
//            // 例外処理
//        }
//
//             // 成形した文字列を表示
//
//    }

