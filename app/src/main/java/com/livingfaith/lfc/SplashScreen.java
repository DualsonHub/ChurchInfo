package com.livingfaith.lfc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class SplashScreen extends AppCompatActivity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
          /*      // This method will be executed once the timer is over
          SharedPreferences      sharedPreferences = getSharedPreferences("ShaPreferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                boolean  firstTime=sharedPreferences.getBoolean("first", true);
                if(firstTime) {
                    editor.putBoolean("first",false);
                    editor.commit();
                    Intent intent = new Intent(SplashScreen.this, Main2Activity.class);
                    startActivity(intent);
                }
                else
                {*/
                    Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(intent);



                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
