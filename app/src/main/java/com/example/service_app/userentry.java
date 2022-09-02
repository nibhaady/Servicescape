package com.example.service_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class userentry extends AppCompatActivity {
    Button call;
    TextView phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userentry);
//        call=(Button) findViewById(R.id.call);
//        phone=findViewById(R.id.txtcontact);
//        call.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View view) {
//        String contactnum=phone.getText().toString();
//        String s="tel:" +contactnum;
//        Intent it=new Intent(Intent.ACTION_CALL);
//        it.setData(Uri.parse(s));
//        startActivity(it);
//    }
}