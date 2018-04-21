package com.example.ankita.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    databasehelper helper = new databasehelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onclick(View v)
    {
        if (v.getId() == R.id.blogin)
        {
            EditText a = (EditText)findViewById(R.id.TFusername);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.TFpassword);
            String pass = b.getText().toString();

            String password = helper.searchpass(str);

            if (pass.equals(password))
            {
                Intent i = new Intent(MainActivity.this,dashboard.class);
                i.putExtra("Username",str);
                startActivity(i);
            }
            else
            {
                Toast temp= Toast.makeText(MainActivity.this , "Username and Password Don't Match",Toast.LENGTH_SHORT);
                temp.show();
            }


        }
        if (v.getId() == R.id.bsignup)
        {
            Intent i = new Intent(MainActivity.this,signup.class);
            startActivity(i);
        }
        if ((v.getId() == R.id.btnAdmin))
        {
            Intent i = new Intent(MainActivity.this,adminlogin.class);
            startActivity(i);
        }
    }
}
