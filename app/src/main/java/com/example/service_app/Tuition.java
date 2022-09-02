package com.example.service_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Tuition extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<String> agname,contact,address,description;
    DBService DB;
    Adaptor adaptor;
    Button calling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuition);
        DB=new DBService(this);
        agname=new ArrayList<>();
        contact=new ArrayList<>();
        address=new ArrayList<>();
        description=new ArrayList<>();
        rv=findViewById(R.id.recy);
//        calling=findViewById(R.layout.call);
        adaptor=new Adaptor(this,agname,contact,address,description);
        rv.setAdapter(adaptor);
        rv.setLayoutManager(new LinearLayoutManager(this));
        displayEntry();
    }
    private void displayEntry() {
        Cursor cursor=DB.getSchool();
        if(cursor.getCount()==0){
            Toast.makeText(Tuition.this,"No Entry Exists",Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                agname.add(cursor.getString(1));
                contact.add(cursor.getString(2));
                address.add(cursor.getString(3));
                description.add(cursor.getString(4));
            }
        }

    }
}