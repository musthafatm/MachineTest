package com.whirlwind.iroid.mtactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.whirlwind.iroid.mtactivity.storage.AppstorageFactory;

public class UserdetailsActivity extends AppCompatActivity {


    private TextView mtvdetailsuser = null;
    private TextView mtvdetailspassword = null;

    Switch mbtnswitch = null;

    private String detail1 = null;
    private String detail2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userdetails);

        mtvdetailsuser = (TextView) findViewById(R.id.tvdetailsuser);
        mtvdetailspassword = (TextView) findViewById(R.id.tvdetailspassword);

        mbtnswitch = (Switch) findViewById(R.id.btnswitch);

        //This is passing data by intent else we can just do getintent() and then retake user and password from shrdprfrnce using
        //getusername() and getpassword() here.

        Bundle extras = getIntent().getExtras();
        detail1= extras.getString("detailsUsername");
        detail2= extras.getString("detailsPassword");

        mtvdetailsuser.setText(detail1);
        mtvdetailspassword.setText(detail2);

        mbtnswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Toast.makeText(UserdetailsActivity.this, "Auto Login is now OFF", Toast.LENGTH_LONG).show();
               // AppstorageFactory.clearAll(UserdetailsActivity.this);

                AppstorageFactory.setUserLogged(false, UserdetailsActivity.this);


            }

        });


    }
}
