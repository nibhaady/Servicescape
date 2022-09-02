package com.example.service_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class profDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    DrawerLayout drawerLayout;
    NavigationView nv;
    Toolbar toolbar;
    EditText pass,service;
    Button update, delete,confirmpass;
    DBService DB;
//    private Spinner service;
//    private static final String[] values = {"item 1", "item 2", "item 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_dashboard);
        drawerLayout = findViewById(R.id.draw_layout);
        nv = findViewById(R.id.navi_view);
        toolbar = findViewById(R.id.toolbar);
        nv.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nv.setNavigationItemSelectedListener(this);
        pass=findViewById(R.id.confirm);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        service=findViewById(R.id.service);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        DB = new DBService(this);
        update.setEnabled(false);
        delete.setEnabled(false);



//        update.setCursorVisible(false);
//        delete.setCursorVisible(false);
        confirmpass=findViewById(R.id.confirmpass);
        confirmpass.setOnClickListener(this);
//        service = (Spinner)findViewById(R.id.service);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(profDashboard.this,
//                android.R.layout.simple_spinner_item,values);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        service.setAdapter(adapter);
//        service.setOnItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent it;
        switch(item.getItemId()){
            case R.id.nav_reg:
                it=new Intent(profDashboard.this,profReg.class);
                startActivity(it);
                return true;
            case R.id.rate:
                it=new Intent(profDashboard.this,Rateus.class);
                startActivity(it);
                return true;
            case R.id.nav_logout:
                it=new Intent(profDashboard.this,login.class);
                startActivity(it);
                finish();
                return true;
            case R.id.share:
                it=new Intent(Intent.ACTION_SEND);
                it.setType("text/plain");
                String body="Download this App at";
                String sub="https://play.google.com/";
                String mes=body+" "+sub;
                it.putExtra(Intent.EXTRA_TEXT,mes);
                startActivity(Intent.createChooser(it,"Share To"));
                return true;
            case R.id.cs:
                String mail="serviscapeSupport@gmail.com";
                it=new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+mail));
                startActivity(it);
                return true;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        String confirmTXT=pass.getText().toString();
        Cursor cur=DB.getValid(confirmTXT);
        if(cur.getCount()>0){
            update.setEnabled(true);
            delete.setEnabled(true);

            service.setText("");
            pass.setText("");
        }
        else{
            Toast.makeText(profDashboard.this,"Invalid password",Toast.LENGTH_LONG).show();
        }

    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        String val=adapterView.getItemAtPosition(i).toString();
//        Toast.makeText(profDashboard.this,val,Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> adapterView) {
//
//    }
}