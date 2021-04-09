package com.example.andoidproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.andoidproject.db.DatabaseClient;
import com.example.andoidproject.db.User;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Vector;

public class MyAdapter extends ArrayAdapter<User> {

    MyAdapter(Context c, List<User> userList){
        super(c, R.layout.template_compte, userList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Récupération du User
        final User user = getItem(position);

        // Charge le template XML
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.template_compte, parent, false);

        // Récupération des objets graphiques dans le template
        TextView textViewTask = (TextView) rowView.findViewById(R.id.textViewPrenom);
        TextView textViewDesc = (TextView) rowView.findViewById(R.id.textViewNom);

        //
        textViewTask.setText(user.getPrenom());
        textViewDesc.setText(user.getNom());

        //
        return rowView;
    }
}
