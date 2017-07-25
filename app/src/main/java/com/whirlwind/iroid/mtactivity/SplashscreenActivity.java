package com.whirlwind.iroid.mtactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * Created by Acer on 24-Jul-17.
 */

public class SplashscreenActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

       /* getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getActionBar().hide();*/

        setContentView(R.layout.activity_splashscreen);

    Thread timerThread = new Thread(){
        public void run(){
            try{
                sleep(4000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }finally{
                Intent intent = new Intent(SplashscreenActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }
    };
        timerThread.start();
}

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}

