package com.whirlwind.iroid.mtactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.whirlwind.iroid.mtactivity.storage.AppStorage;
import com.whirlwind.iroid.mtactivity.storage.AppstorageFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mbtnsignin = null;
    private EditText metusername = null;
    private EditText metpassword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if (AppstorageFactory.isUserLogged(this)) {
            gotoActivity();

        }


        setContentView(R.layout.activity_main);
        metusername = (EditText) findViewById(R.id.etusername);
        metpassword = (EditText) findViewById(R.id.etpassword);
        mbtnsignin = (Button) findViewById(R.id.btnsignin);

        mbtnsignin.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        String usernamedetail = AppstorageFactory.getUsername(this);
        String userpassworddetail = AppstorageFactory.getPassword(this);


        if (metusername.getText().toString().equals("") || metpassword.getText().toString().equals("")) {
            Toast.makeText(this, "Please fill your essentials", Toast.LENGTH_SHORT).show();
        } else if (usernamedetail.equals(metusername.getText().toString()) &&
                (userpassworddetail.equals(metpassword.getText().toString()))) {
            Intent intent = new Intent(this, UserdetailsActivity.class);
            intent.putExtra("detailsUsername", usernamedetail);
            intent.putExtra("detailsPassword", userpassworddetail);
            startActivity(intent);
            Toast.makeText(this, "Login Success Second time", Toast.LENGTH_SHORT).show();
            finish();
        } else {

            saveToPref();
            Intent intent = new Intent(this, UserdetailsActivity.class);
            intent.putExtra("detailsUsername", metusername.getText().toString());
            intent.putExtra("detailsPassword", metpassword.getText().toString());
            startActivity(intent);
            Toast.makeText(this, "Login Success First time", Toast.LENGTH_SHORT).show();

            finish();
        }

    }



    private void gotoActivity() {

        String username = AppstorageFactory.getUsername(this);
        String password = AppstorageFactory.getPassword(this);

        Intent intent = new Intent(this, UserdetailsActivity.class);
        intent.putExtra("detailsUsername", username);
        intent.putExtra("detailsPassword", password);
        startActivity(intent);
        finish();
    }

    private void saveToPref() {

        AppstorageFactory.insertUsername(metusername.getText().toString(), this);
        AppstorageFactory.insertPassword(metpassword.getText().toString(), this);
        AppstorageFactory.setUserLogged(true, this);

    }
}



