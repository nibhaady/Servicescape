package com.example.service_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    CardView clean,plumbing,delivery,mechanic,saloon,medical,banking,transport,veternary,grocery,school,nanny,chef,fuel;
    DrawerLayout drawerLayout;
    NavigationView nv;
    Toolbar toolbar;
    private long onback;
    private Toast backToast;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        clean=(CardView) findViewById(R.id.clean);
        clean.setOnClickListener(this);
        plumbing=(CardView) findViewById(R.id.plumbing);
        plumbing.setOnClickListener(this);
        delivery=(CardView) findViewById(R.id.delivery);
        delivery.setOnClickListener(this);
        mechanic=(CardView) findViewById(R.id.mechanic);
        mechanic.setOnClickListener(this);
        saloon=(CardView) findViewById(R.id.saloon);
        saloon.setOnClickListener(this);
        medical=(CardView) findViewById(R.id.medical);
        medical.setOnClickListener(this);
        banking=(CardView) findViewById(R.id.banking);
        banking.setOnClickListener(this);
        transport=(CardView) findViewById(R.id.transport);
        transport.setOnClickListener(this);
        veternary=(CardView) findViewById(R.id.veternary);
        veternary.setOnClickListener(this);
        grocery=(CardView) findViewById(R.id.grocery);
        grocery.setOnClickListener(this);
        school=(CardView) findViewById(R.id.school);
        school.setOnClickListener(this);
        nanny=(CardView) findViewById(R.id.caretaker);
        nanny.setOnClickListener(this);
        chef=(CardView) findViewById(R.id.chef);
        chef.setOnClickListener(this);
        fuel=(CardView) findViewById(R.id.fuel);
        fuel.setOnClickListener(this);


        drawerLayout=findViewById(R.id.draw_layout);
        nv=findViewById(R.id.navi_view);

        nv.setNavigationItemSelectedListener(this);

        toolbar=findViewById(R.id.toolbar);
        nv.bringToFront();
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }
        else{
            super.onBackPressed();
            finish();

        }



    }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.clean:
                i=new Intent(this,Clean.class);
                startActivity(i);
                break;
            case R.id.delivery:
                i=new Intent(this,Delivery.class);
                startActivity(i);
                break;
            case R.id.mechanic:
                i=new Intent(this,Mechanic.class);
                startActivity(i);
                break;
            case R.id.plumbing:
                i=new Intent(this,Plumbing.class);
                startActivity(i);
                break;
            case R.id.saloon:
                i=new Intent(this,Saloon.class);
                startActivity(i);
                break;
            case R.id.medical:
                i=new Intent(this,Medical.class);
                startActivity(i);
                break;
            case R.id.banking:
                i=new Intent(this,Banking.class);
                startActivity(i);
                break;
            case R.id.transport:
                i=new Intent(this,Transport.class);
                startActivity(i);
                break;
            case R.id.veternary:
                i=new Intent(this,Veternary.class);
                startActivity(i);
                break;
            case R.id.grocery:
                i=new Intent(this,Grocery.class);
                startActivity(i);
                break;
            case R.id.school:
                i=new Intent(this,Tuition.class);
                startActivity(i);
                break;
            case R.id.fuel:
                i=new Intent(this,Fuel.class);
                startActivity(i);
                break;
            case R.id.chef:
                i=new Intent(this,Chef.class);
                startActivity(i);
                break;

            case R.id.caretaker:
                i=new Intent(this,CareTaker.class);
                startActivity(i);
                break;
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent it;
        switch(item.getItemId()){
            case R.id.nav_login:
                it=new Intent(Dashboard.this,login.class);
                startActivity(it);
                return true;
            case R.id.nav_regis:
                it=new Intent(Dashboard.this,userRegistration.class);
                startActivity(it);
                return true;
            case R.id.rate:
                it=new Intent(Dashboard.this,Rateus.class);
                startActivity(it);
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
        }
        return true;

    }



}