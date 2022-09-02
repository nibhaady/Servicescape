package com.example.service_app;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptor extends RecyclerView.Adapter<Adaptor.MyViewHolder> {
    private Context context;
    private ArrayList agname,contact,address,description;



    public Adaptor(Context context, ArrayList agname, ArrayList contact, ArrayList address, ArrayList description) {
        this.context = context;
        this.agname = agname;
        this.contact = contact;
        this.address = address;
        this.description = description;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.activity_userentry,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.agname.setText(String.valueOf(agname.get(position)));
        holder.contact.setText(String.valueOf(contact.get(position)));
        holder.address.setText(String.valueOf(address.get(position)));
        holder.description.setText(String.valueOf(description.get(position)));
    }

    @Override
    public int getItemCount() {
        return agname.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView agname,contact,address,description;
        Button phone;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            agname =itemView.findViewById(R.id.txtagname);
            contact =itemView.findViewById(R.id.txtcontact);
            address =itemView.findViewById(R.id.txtaddress);
            description =itemView.findViewById(R.id.txtdescription);

            phone=itemView.findViewById(R.id.call);
            phone.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            String contactNum=contact.getText().toString();
            Intent it=new Intent(Intent.ACTION_DIAL);
            it.setData(Uri.parse("tel:"+contactNum));
            context.startActivity(it);
        }
    }
}
