package com.example.maliasikcom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    WebView websayfasi;
    ProgressDialog acilismesaj;
    @Override
    public void onBackPressed() {
        if (websayfasi.canGoBack()) {
            websayfasi.goBack();
        } else {
            super.onBackPressed();
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimlama();
        siteyukle();
        acilismesaj=ProgressDialog.show (this, "Sizde hak vereceksiniz ama", "Biraz kalbinize dokunacak...", true);

        websayfasi.setWebViewClient(new WebViewClient()
                                    {
                           public void onPageFinished(WebView view, String url)
                                        {
                                 super.onPageFinished(view,url);
                                 acilismesaj.dismiss();
                                         }
                                    }
        );
    }
    public void tanimlama()
    {
        websayfasi=findViewById(R.id.site);
    }
    public void siteyukle()
    {
        websayfasi.getSettings().setJavaScriptEnabled(true);
        websayfasi.getSettings().setSupportZoom(true);
        websayfasi.loadUrl("https://maliasik.com");
    }



}