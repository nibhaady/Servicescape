package com.example.service_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText username,password;
    Button login;
    DBService DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.name_txt);
        password=findViewById(R.id.password_txt);
        login=findViewById(R.id.login);
        login.setOnClickListener(this);
        DB = new DBService(this);

    }

    @Override
    public void onClick(View view) {
        String uTXT=username.getText().toString();
        String pTXT=password.getText().toString();
            Cursor cursor=DB.checkuser(uTXT,pTXT);
            if(cursor.getCount()>0){
                Toast.makeText(login.this,"Login Succesfull",Toast.LENGTH_LONG).show();
                Intent it=new Intent(login.this,profDashboard.class);
                startActivity(it);
                finish();
                username.setText("");
                password.setText("");

            }
            else{
            Toast.makeText(login.this,"Invalid password or username",Toast.LENGTH_LONG).show();

        }





    }
}