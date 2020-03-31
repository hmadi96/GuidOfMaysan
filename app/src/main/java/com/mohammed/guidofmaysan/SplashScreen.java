package com.mohammed.guidofmaysan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class SplashScreen extends AppCompatActivity {

//ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        display();
       // imageView=findViewById(R.id.imageView1);
        // imageView.animate().alpha(1).setDuration(2000);



            WebView webView = (WebView) findViewById(R.id.web);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("file:///android_asset/www/index.html");
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);

    }

    public void display (){

        Handler friend = new Handler();
        friend.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, HomePage.class));
                finish();
                //وقت استمرار الظهور الشاقه بالثواني
            }
        },3000);

    }
}
