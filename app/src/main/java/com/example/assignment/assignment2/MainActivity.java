package com.example.assignment.assignment2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextUrl;
    private EditText editTextPhone;
    private Button btnUrl;
    private Button btnRing;
    private Button btnCloseApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setLogo(R.mipmap.ic_launcher);
            actionBar.setDisplayUseLogoEnabled(true);
        }

        editTextUrl=(EditText)findViewById(R.id.edit_text_url);
        editTextPhone=(EditText)findViewById(R.id.edit_text_phone);

        btnUrl=(Button)findViewById(R.id.btn_launch);
        btnUrl.setOnClickListener(this);
        btnRing=(Button)findViewById(R.id.btn_ring);
        btnRing.setOnClickListener(this);
        btnCloseApp=(Button)findViewById(R.id.btn_close_app);
        btnCloseApp.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id=view.getId();

        switch (id) {
            case R.id.btn_launch:
                String url = editTextUrl.getText().toString();
                Intent urlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                Intent urlChooserIntent = Intent.createChooser(urlIntent, "Choose browser of your choice");
                startActivity(urlChooserIntent);
                break;

            case R.id.btn_ring:
                String phone_num = editTextPhone.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + phone_num));
                startActivity(callIntent);
                break;

            case R.id.btn_close_app:
                MainActivity.this.finish();
                break;


        }

    }
}
