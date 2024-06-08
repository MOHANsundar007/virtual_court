package com.example.justiceapp;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splashscreen extends Activity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 4000; // 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        // Delay the login activity launch for the splash screen duration
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the login activity
                Intent intent = new Intent(splashscreen.this,SignupActivity.class);
                startActivity(intent);

                // Close the splash activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
