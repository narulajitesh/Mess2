package com.example.jiteshnarula.mess;

import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 29/10/2017.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.MyViewHolder>{
    ArrayList<String> name, phonenumber;
    Activity context;
    public LayoutInflater layoutInflater;
    public ContactsAdapter(FragmentActivity activity, ArrayList<String> name, ArrayList<String> phonenumber) {
        context = activity;
        this.name = name;
        this.phonenumber = phonenumber;
        this.layoutInflater = LayoutInflater.from(context);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, PhoneNumber;
        public MyViewHolder(View view) {
            super(view);
           name = (TextView) view.findViewById(R.id.name);
          PhoneNumber = (TextView) view.findViewById(R.id.phone);


        }
    }

    @Override
    public ContactsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contacts_adapter_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.MyViewHolder holder, int position) {
        holder.name.setText((CharSequence) this.name.get(position));
        holder.PhoneNumber.setText((CharSequence) this.phonenumber.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }
}
