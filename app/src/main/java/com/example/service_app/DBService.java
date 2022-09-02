package com.example.service_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class DBService extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="ServiceDB";
    private static final int DATABASE_VERSION=1;
    CardView clean,plumbing,delivery,mechanic,saloon,medical,banking,transport,veternary,grocery,school,nanny,chef;


    public DBService(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table userDetails(id integer PRIMARY KEY AUTOINCREMENT,name Text, contact Text,address Text,password Text,confirm Text)");
        DB.execSQL("create Table cleanDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");
        DB.execSQL("create Table delDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");
        DB.execSQL("create Table mechDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");
        DB.execSQL("create Table plumbDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");
        DB.execSQL("create Table saloonDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");
        DB.execSQL("create Table mediDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");


        DB.execSQL("create Table bankDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");
        DB.execSQL("create Table transDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");
        DB.execSQL("create Table vetDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");
        DB.execSQL("create Table grocDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");
        DB.execSQL("create Table schDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");
        DB.execSQL("create Table fuelDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");
        DB.execSQL("create Table chefDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");
        DB.execSQL("create Table careDetails(id integer PRIMARY KEY AUTOINCREMENT,agname TEXT,contact Text,address Text,descrip Text,password Text)");



    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists userDetails");
        DB.execSQL("drop Table if exists cleanDetails");
        DB.execSQL("drop Table if exists delDetails");
        DB.execSQL("drop Table if exists mechDetails");
        DB.execSQL("drop Table if exists plumbDetails");
        DB.execSQL("drop Table if exists saloonDetails");
        DB.execSQL("drop Table if exists mediDetails");
        DB.execSQL("drop Table if exists bankDetails");
        DB.execSQL("drop Table if exists transDetails");
        DB.execSQL("drop Table if exists vetDetails");
        DB.execSQL("drop Table if exists schDetails");
        DB.execSQL("drop Table if exists fuelDetails");
        DB.execSQL("drop Table if exists chefDetails");
        DB.execSQL("drop Table if exists careDetails");
        onCreate(DB);

    }
    public Boolean insertuserdata(String name,String contact,String address,String password,String confirm){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",name);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("password",password);
        contentValues.put("confirm",confirm);
        long result=DB.insert("userDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertcleandata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("cleanDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertdeldata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("delDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertmechdata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("mechDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertplumbdata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("plumbDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertsaloondata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("saloonDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertmedidata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("mediDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertbankdata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("bankDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean inserttransdata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("transDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertvetdata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("vetDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertgrocdata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("grocDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertschdata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("schDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertfueldata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("fuelDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertchefdata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("chefDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
    public Boolean insertcaredata(String agname,String contact,String address,String descrip,String password){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("agname",agname);
        contentValues.put("contact",contact);
        contentValues.put("address",address);
        contentValues.put("descrip",descrip);
        contentValues.put("password",password);
        long result=DB.insert("careDetails",null,contentValues);
        if(result==-1){
            return false;
        }
        else
            return true;


    }
//    public ArrayList<ServiceModel> fetchDetails(){
//        SQLiteDatabase DB=this.getReadableDatabase();
//        Cursor cursor=DB.rawQuery("select * from cleanDetails",null);
//        ArrayList<ServiceModel> arrservice=new ArrayList<>();
//        while(cursor.moveToNext()){
//            ServiceModel model=new ServiceModel();
//            model.id=cursor.get
//        }
//    }
    public Cursor getClean(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from cleanDetails",null);
        return cursor;
    }
    public Cursor getDelivery(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from delDetails",null);
        return cursor;
    }
    public Cursor getMechanic(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from mechDetails",null);
        return cursor;
    }
    public Cursor getPlumber(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from plumbDetails",null);
        return cursor;
    }
    public Cursor getSaloon(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from saloonDetails",null);
        return cursor;
    }
    public Cursor getMedical(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from mediDetails",null);
        return cursor;
    }
    public Cursor getBanking(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from bankDetails",null);
        return cursor;
    }
    public Cursor getTransport(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from transDetails",null);
        return cursor;
    }
    public Cursor getVet(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from vetDetails",null);
        return cursor;
    }
    public Cursor getGrocery(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from grocDetails",null);
        return cursor;
    }
    public Cursor getSchool(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from schDetails",null);
        return cursor;
    }
    public Cursor getFuel(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from fuelDetails",null);
        return cursor;
    }
    public Cursor getChef(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from chefDetails",null);
        return cursor;
    }
    public Cursor getCare(){
        SQLiteDatabase DB= this.getWritableDatabase();
        Cursor cursor =DB.rawQuery("Select * from careDetails",null);
        return cursor;
    }

    public Cursor checkuser(String v1,String v2){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from userDetails where name=? and password=?",new String[] {v1,v2});
        return cursor;

    }
    public Cursor checkPassword(String pass){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from userDetails where password=?",new String[] {pass});
        return cursor;
    }
    public Cursor getValid(String pass){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from userDetails where password=?",new String[] {pass});
        return cursor;

    }



    }
