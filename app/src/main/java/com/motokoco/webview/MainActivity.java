package com.motokoco.webview;


import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private WebView mywebview;
    private String url1 = "http://www.e-ckp.tk";
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mywebview = (WebView) findViewById(R.id.webviewutama);
        mywebview.getSettings().setJavaScriptEnabled(true);
        mywebview.setWebViewClient(new browserku());
        mywebview.loadUrl(url1);
        mywebview.getSettings().setSupportZoom(true);
        mywebview.getSettings().setBuiltInZoomControls(true);


            }
    public class browserku extends WebViewClient {





        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            mywebview.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progressBar = (ProgressBar)findViewById(R.id.progressBar);
            progressBar.setVisibility(View.VISIBLE);
            mywebview.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

            progressBar.setVisibility(View.GONE);
            mywebview.setVisibility(View.VISIBLE);

        }
    }


    public boolean onKeyDown(int keycode, KeyEvent event){
        if ((keycode == KeyEvent.KEYCODE_BACK) && mywebview.canGoBack()){
            mywebview.goBack();
            return true;

        }

        return super.onKeyDown(keycode, event);
    }
}
