package com.example.service_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class userRegistration extends AppCompatActivity {
    Button Signin;
    EditText name, address, contact, password, confirm;
    DBService DB;
    String regularExpression =
            "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{4,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        name = findViewById(R.id.name_txt);
        contact = findViewById(R.id.number_txt);
        address = findViewById(R.id.address);
        password = findViewById(R.id.password);
        confirm = findViewById(R.id.confirmpassword);
        Signin = findViewById(R.id.signin);



        DB = new DBService(this);

        Signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nameTXT=name.getText().toString();
                String contactTXT=contact.getText().toString();
                String addressTXT=address.getText().toString();
                String passTXT=password.getText().toString();
                String confirmTXT=confirm.getText().toString();

                if( nameTXT.length() == 0 )
                    Toast.makeText(getApplicationContext(), "User name is empty", Toast.LENGTH_SHORT).show();
                else if( contactTXT.length() == 0 )
                    Toast.makeText(getApplicationContext(), "Contact is empty", Toast.LENGTH_SHORT).show();
                else if( addressTXT.length() == 0 )

                    Toast.makeText(getApplicationContext(), "Address is empty", Toast.LENGTH_SHORT).show();
                else if( passTXT.length() == 0 )
                    Toast.makeText(getApplicationContext(), "Password is empty", Toast.LENGTH_SHORT).show();
                else if( confirmTXT.length() == 0 )
                    Toast.makeText(getApplicationContext(), "Please Confirm your Password", Toast.LENGTH_LONG).show();
                else if(!validatePassword(passTXT)){
                    Toast.makeText(getApplicationContext(), "Password must contain atleast 1 digit and 1 special character ", Toast.LENGTH_SHORT).show();

                }
                else if(!passTXT.equals(confirmTXT)){
                    Toast.makeText(getApplicationContext(), "Password is not  Matching", Toast.LENGTH_SHORT).show();

                }

                else{
                    Boolean checkinsertdata= DB.insertuserdata(nameTXT,contactTXT,addressTXT,passTXT,confirmTXT);
                    if(checkinsertdata==true){
//                        Intent it=new Intent(userRegistration.this,Dashboard.class);
//                        startActivity(it);
                        name.setText(" ");
                        contact.setText(" ");
                        address.setText(" ");
                        password.setText("");
                        confirm.setText("");
                        Toast.makeText(userRegistration.this,"SignUp Successfull",Toast.LENGTH_SHORT).show();
                        Intent it=new Intent(userRegistration.this,login.class);
                        startActivity(it);
                        finish();


                    }
                    else{
                        Toast.makeText(userRegistration.this,"Error! Retry Signing Up  ",Toast.LENGTH_SHORT).show();

                    }

                }

            }

            private boolean validatePassword(String passTXT) {
                Pattern pattern = Pattern.compile(regularExpression);
                Matcher matcher = pattern.matcher(passTXT);
                return matcher.matches();

            }

            private void sendMessage() {
                String namesms=name.getText().toString();
                String sms=contact.getText().toString();
//                String MsgTXT=namesms+sms;
                try{
//                    SmsManager manage= SmsManager.getDefault();
                    SmsManager manage= SmsManager.getDefault();
                    manage.sendTextMessage("9141053921",null,"Your secret code: ",null,null);
                }
                catch (Exception e){
                    Toast.makeText(userRegistration.this,"Error",Toast.LENGTH_SHORT).show();

                }


            }

        });

    }


}