package com.example.ankita.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ankita on 05-Apr-18.
 */

public class adminlogin extends Activity {
    databasehelper helper = new databasehelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminlogin);
    }
    public void onadminsubmit (View v)
    {
        if (v.getId() == R.id.btnAdmin)
        {
            EditText a = (EditText)findViewById(R.id.adminusername);
            String str = a.getText().toString();

            EditText b = (EditText)findViewById(R.id.adminpass);
            String pass = b.getText().toString();

            String password = helper.searchpass(str);

            if (pass.equals(password))
            {
                Intent i = new Intent(adminlogin.this,admindashboard.class);
                i.putExtra("adminusername",str);
                startActivity(i);
            }
            else
            {
                Toast temp= Toast.makeText(adminlogin.this , "Username and Password Don't Match",Toast.LENGTH_SHORT);
                temp.show();
            }


        }
    }


}
