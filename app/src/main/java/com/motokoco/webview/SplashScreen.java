package com.motokoco.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by mitohida on 9/7/2016.
 */

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Thread timerSplash = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);

                }
                catch (InterruptedException e) {
                    e.printStackTrace(); }
                finally {
                    Intent to_main = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(to_main);
                }
            }
        };
        timerSplash.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
