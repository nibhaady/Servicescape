package com.example.service_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class profReg extends AppCompatActivity implements View.OnClickListener {
    Button btnclean,btndel,btnmech,register,btnplumb,btnsaloon,btnmedi,btnbank,btntransport,btnvet,btngroc,btnschool,btnfuel,btnchef,btncare;
    EditText agency,address,contact,desc,passcode;
    TextView heading,name,pnum,add,descri,code;
    DBService DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_reg);
        btnclean=findViewById(R.id.btnclean);
        btndel=findViewById(R.id.btndel);
        btnmech=findViewById(R.id.btnmech);
        btnplumb=findViewById(R.id.btnplumb);
        btnsaloon=findViewById(R.id.btnsaloon);
        btnmedi=findViewById(R.id.btnmedical);
        btnbank=findViewById(R.id.btnbank);
        btntransport=findViewById(R.id.btntransport);
        btnvet=findViewById(R.id.btnvet);
        btngroc=findViewById(R.id.btngroc);
        btnschool=findViewById(R.id.btnschool);
        btnfuel=findViewById(R.id.btnfuel);
        btnchef=findViewById(R.id.btnchef);
        btncare=findViewById(R.id.btncare);
        register=findViewById(R.id.Register);
        btnclean.setOnClickListener(this);
        btndel.setOnClickListener(this);
        btnmech.setOnClickListener(this);
        btnplumb.setOnClickListener(this);
        btnsaloon.setOnClickListener(this);
        btnmedi.setOnClickListener(this);
        btnbank.setOnClickListener(this);
        btntransport.setOnClickListener(this);
        btnvet.setOnClickListener(this);
        btngroc.setOnClickListener(this);
        btnschool.setOnClickListener(this);
        btnfuel.setOnClickListener(this);
        btnchef.setOnClickListener(this);
        btncare.setOnClickListener(this);
        agency=findViewById(R.id.nameagency);
        agency.setEnabled(false);
        address=findViewById(R.id.address);
        address.setEnabled(false);
        contact=findViewById(R.id.number);
        contact.setEnabled(false);
        desc=findViewById(R.id.desc);
        desc.setEnabled(false);
        passcode=findViewById(R.id.passcode);
        passcode.setEnabled(false);
        heading=findViewById(R.id.heading);
        name=findViewById(R.id.name);
        add=findViewById(R.id.add);
        pnum=findViewById(R.id.pnum);
        descri=findViewById(R.id.descri);
        code=findViewById(R.id.code);
        code.setText("");
        pnum.setText(" ");
        name.setText(" ");
        descri.setText(" ");
        add.setText(" ");
        register.setEnabled(false);
        register.setText(" ");
        register.setBackground(Drawable.createFromPath("@color/cyan"));

        DB = new DBService(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT=agency.getText().toString();
                String contactTXT=contact.getText().toString();
                String addressTXT=address.getText().toString();
                String descTXT=desc.getText().toString();
                String headTXT=heading.getText().toString();
                String passTXT=passcode.getText().toString();
                if( nameTXT.length() == 0 )
                    Toast.makeText(getApplicationContext(), "Company Name is empty", Toast.LENGTH_SHORT).show();
                else if( contactTXT.length() == 0 )
                    Toast.makeText(getApplicationContext(), "Contact is empty", Toast.LENGTH_SHORT).show();
                else if( addressTXT.length() == 0 )

                    Toast.makeText(getApplicationContext(), "Address is empty", Toast.LENGTH_SHORT).show();
                else if( descTXT.length() == 0 )
                    Toast.makeText(getApplicationContext(), "Description is empty", Toast.LENGTH_SHORT).show();
                else if( passTXT.length() == 0 )
                    Toast.makeText(getApplicationContext(), "Password is empty", Toast.LENGTH_SHORT).show();
                else{
                    Cursor cur=DB.checkPassword(passTXT);
                    if(cur.getCount()>0){
                        if(headTXT=="Cleaning"){
                            Boolean checkinsertdata= DB.insertcleandata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){

                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
                                disable();
                            }


                            else{
                                Toast.makeText(profReg.this,"No matching password  ",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="Delivery"){
                            Boolean checkinsertdata=DB.insertdeldata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it);
                                disable();

                            }
                            else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="Mechanic"){
                            Boolean checkinsertdata=DB.insertmechdata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it);
                                disable();

                            }else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="Plumbing"){
                            Boolean checkinsertdata=DB.insertplumbdata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it);
                                disable();

                            }else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="Saloon"){
                            Boolean checkinsertdata=DB.insertsaloondata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it);
                                disable();

                            }else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="Medical"){
                            Boolean checkinsertdata=DB.insertmedidata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it);
                                disable();

                            }else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="Banking"){
                            Boolean checkinsertdata=DB.insertbankdata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it);
                                disable();

                            }else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="Transportation"){
                            Boolean checkinsertdata=DB.inserttransdata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it);
                                disable();

                            }else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="Veternary"){
                            Boolean checkinsertdata=DB.insertvetdata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it);
                                disable();

                            }else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="Grocery"){
                            Boolean checkinsertdata=DB.insertgrocdata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it
                                disable();

                            }else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="Tuition"){
                            Boolean checkinsertdata=DB.insertschdata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it);
                                disable();

                            }else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="Fuel"){
                            Boolean checkinsertdata=DB.insertfueldata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it);
                                disable();

                            }else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="Cook"){
                            Boolean checkinsertdata=DB.insertchefdata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it);
                                disable();

                            }else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }
                        }
                        else if(headTXT=="CareTaker"){
                            Boolean checkinsertdata=DB.insertcaredata(nameTXT,contactTXT,addressTXT,descTXT,passTXT);
                            if(checkinsertdata==true){
                                Toast.makeText(profReg.this,"Registration Successfull",Toast.LENGTH_SHORT).show();
//                            Intent it=new Intent(profReg.this,Dashboard.class);
//                            startActivity(it);
                                disable();


                            }else{
                                Toast.makeText(profReg.this,"Error! Retry",Toast.LENGTH_SHORT).show();

                            }

                    }

                    }
                    else{
                        Toast.makeText(profReg.this,"Invalid Password entry",Toast.LENGTH_LONG).show();
                    }
                }

            }

            private void disable() {

                agency.setText(" ");
                contact.setText(" ");
                address.setText(" ");
                desc.setText(" ");
                pnum.setText(" ");
                name.setText(" ");
                descri.setText(" ");
                add.setText(" ");
                heading.setText(" ");
                code.setText("");
                passcode.setText("");
                agency.setEnabled(false);
                address.setEnabled(false);
                contact.setEnabled(false);
                desc.setEnabled(false);
                register.setEnabled(false);
                passcode.setEnabled(false);
                register.setText(" ");
                register.setBackground(Drawable.createFromPath("@color/cyan"));
            }
        });


    }

    @Override
    public void onClick(View view) {
        if(view.equals(btnclean)){
            heading.setText("Cleaning");
            enable();


        }
        else if(view.equals(btndel)){
            heading.setText("Delivery");
            enable();


        }
        else if(view.equals(btnmech)){
            heading.setText("Mechanic");
            enable();


        }
        else if(view.equals(btnplumb)){
            heading.setText("Plumbing");
            enable();


        }
        else if(view.equals(btnsaloon)){
            heading.setText("Saloon");
            enable();


        }
        else if(view.equals(btnmedi)){
            heading.setText("Medical");
            enable();


        }
        else if(view.equals(btnbank)){
            heading.setText("Banking");
            enable();


        }
        else if(view.equals(btntransport)){
            heading.setText("Transportation");
            enable();


        }
        else if(view.equals(btnvet)){
            heading.setText("Veternary");
            enable();


        }
        else if(view.equals(btngroc)){
            heading.setText("Grocery");
            enable();


        }
        else if(view.equals(btnschool)){
            heading.setText("Tuition");
            enable();


        }
        else if(view.equals(btnfuel)){
            heading.setText("Fuel");
            enable();


        }
        else if(view.equals(btnchef)){
            heading.setText("Cook");
            enable();


        }
        else if(view.equals(btncare)){
            heading.setText("CareTaker");
            enable();


        }

    }

    private void enable() {
        agency.setEnabled(true);
        address.setEnabled(true);
        contact.setEnabled(true);
        desc.setEnabled(true);
        passcode.setEnabled(true);
        register.setEnabled(true);
        register.setText("Register");
        pnum.setText("Phone Number ");
        name.setText("Name of Agency ");
        descri.setText("Description ");
        add.setText("Address ");
        code.setText("Provide your password");
    }

}