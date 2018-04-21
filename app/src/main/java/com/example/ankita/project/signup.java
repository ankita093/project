package com.example.ankita.project;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ankita on 31-Mar-18.
 */

public class signup extends Activity
{
    databasehelper helper = new databasehelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

    }
    public void onsignupclick (View v)
    {
        if(v.getId() == R.id.bsignupbutton)
        {
            EditText name=(EditText)findViewById(R.id.TFname);
            EditText email=(EditText)findViewById(R.id.TFemail);
            EditText uname=(EditText)findViewById(R.id.TFuname);
            EditText pass1=(EditText)findViewById(R.id.TFpass1);
            EditText pass2=(EditText)findViewById(R.id.TFpass2);

            String namestr= name.getText().toString();
            String emailstr= email.getText().toString();
            String unamestr= uname.getText().toString();
            String pass1str= pass1.getText().toString();
            String pass2str= pass2.getText().toString();

            if(!pass1str.equals(pass2str))
            {
                //popup message
                Toast pass = Toast.makeText(signup.this , "Passwords Don't Match", Toast.LENGTH_SHORT);
                pass.show();
            }
            else
            {
                //insert te details into database
                contact c = new contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(unamestr);
                c.setPass(pass1str);

                helper.insertcontact(c);
            }
            Toast pass = Toast.makeText(signup.this , "Registered Successfully", Toast.LENGTH_SHORT);
            pass.show();

        }
    }
}