package com.uni.trabajo.proyecto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WebActivity extends AppCompatActivity {

    Button calculadora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);



        WebView myWebView = (WebView) findViewById(R.id.webapiweb);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("http://www1.uabcs.mx/dsc/");


        /*calculadora=(Button)findViewById(R.id.btnCalculadora);
        calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intetCalcu = new Intent(MainActivity.this, CalculadoraActivity.class);
                startActivity(intetCalcu);

            }
        });*/


    }
}
