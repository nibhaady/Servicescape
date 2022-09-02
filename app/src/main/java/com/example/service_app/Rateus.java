package com.example.service_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Rateus extends AppCompatActivity implements View.OnClickListener {
    Button ratesub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rateus);

        ratesub=findViewById(R.id.ratesub);
        ratesub.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getBaseContext(),"Thank you for your feedback",Toast.LENGTH_LONG).show();
    }
}