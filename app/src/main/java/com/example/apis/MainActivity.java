package com.example.apis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.fact);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        img = findViewById(R.id.imageView);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                img.setImageResource(android.R.color.transparent);
                textView.setTextColor(Color.parseColor("#FF0000"));
                textView.setText("Please Wait");
                RequestQueue requestQueue;
                requestQueue = Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://catfact.ninja/fact", null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            textView.setText("Please Wait");
                            Log.d("My Aip = ", ""+response.getString("fact"));
                            textView.setText(response.getString("fact"));

                            
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("My app", "Lode galat hua kuch ");
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(android.R.color.transparent);
                textView.setTextColor(Color.parseColor("#8F00FF"));
                textView.setText("Please Wait");
                RequestQueue requestQueue;
                requestQueue = Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://www.boredapi.com/api/activity", null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            Log.d("My Aip = ", ""+response.getString("activity"));
                            textView.setText(response.getString("activity"));



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("My app", "Lode galat hua kuch ");
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setTextColor(Color.parseColor("#FF0000"));
                textView.setText("Please Wait");
                RequestQueue requestQueue;
                requestQueue = Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://dog.ceo/api/breeds/image/random", null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            Log.d("My Aip = ", ""+response.getString("message"));
//                            textView.setText("url is "+response.getString("message"));
                            Glide.with(MainActivity.this)
                                    .load(response.getString("message"))
                                    .override(400,400)
                                    .into(img);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("My app", "Lode galat hua kuch ");
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textView.setTextColor(Color.parseColor("#FF0000"));
                textView.setText("Please Wait");
                RequestQueue requestQueue;
                requestQueue = Volley.newRequestQueue(MainActivity.this);
                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://api.waifu.pics/sfw/dance", null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("My Aip = ", ""+response.getString("url"));
//                            textView.setText("url is "+response.getString("url"));
                            Glide.with(MainActivity.this)
                                    .load(response.getString("url"))
                                    .override(400,400)
                                    .into(img);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("My app", "Lode galat hua kuch ");
                    }
                });
                requestQueue.add(jsonObjectRequest);
            }
        });
    }
}