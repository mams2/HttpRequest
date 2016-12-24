package com.example.root.httprequest;

import java.io.IOException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends Activity {
    OkHttpClient client;
    final Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        client = new OkHttpClient();
    }

    public void makeGetRequest(View v) throws IOException {
        GetTask task = new GetTask();
        task.execute();
    }

    public class GetTask extends AsyncTask <String, Void, String> {
        private Exception exception;

        protected String doInBackground(String... urls) {
            try {
                return get("http://api.openweathermap.org/data/2.5/find?lat=-9.0&lon=-35&cnt=15&APPID=fb83342443d6727211b36da403438b02");
            } catch (Exception e) {
                this.exception = e;
                return null;
            }
        }

        protected void onPostExecute(String getResponse) {
            System.out.println(getResponse);
            System.out.println("acabou");
        }

        public String get(String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        }
    }
}