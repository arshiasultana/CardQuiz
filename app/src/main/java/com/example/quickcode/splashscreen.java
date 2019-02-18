package com.example.quickcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class splashscreen extends AppCompatActivity {


    private int SLEEP_TIMER =3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //for displaying a full window by removing task bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        //the two parameters,int flags and int mask should be set to fullscreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splashscreen);

        //hiding action bar
        getSupportActionBar().hide();



        //create logo launcher starting activity
        LogoLauncher logoLauncher = new LogoLauncher();
        logoLauncher.start();




    }

    private class LogoLauncher extends Thread{
        public void run(){

            //throw exceptions
            try {
                sleep(1000* SLEEP_TIMER);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

            //use intent to move to next page
            Intent intent = new Intent(splashscreen.this,Login.class);

            //start the activity
            startActivity(intent);

            //finish splashscreen so that the code doesnt come back to this page
            splashscreen.this.finish();

        }
    }

}


