package com.example.ankita.project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ankita on 31-Mar-18.
 */

public class dashboard extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        String username = getIntent().getStringExtra("Username");
        TextView tv=(TextView)findViewById(R.id.TVusername);
        tv.setText(username);
    }
}
