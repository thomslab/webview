package com.motokoco.webview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

/**
 * Created by mitohida on 9/7/2016.
 */

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        TextView myText = (TextView) findViewById(R.id.loading );

        Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(350); //efek blinking text loading (milliseconds)
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        myText.startAnimation(anim);
        Thread timerSplash = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);

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
