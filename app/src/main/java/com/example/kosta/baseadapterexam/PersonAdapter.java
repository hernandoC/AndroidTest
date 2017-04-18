package com.example.kosta.baseadapterexam;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kosta.baseadapterexam.domain.Person;

import java.util.List;


/**
 * Created by kosta on 2017-04-18.
 */

public class PersonAdapter extends BaseAdapter {

    private Context context;
    private List<Person> personList;

    private LayoutInflater inflater;

    public PersonAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;

        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int position) {
        return personList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        data와 view의 mapping

//        (1) Dumb 방식

//        View item = inflater.inflate(R.layout.list_item, null);
//        TextView name = (TextView)item.findViewById(R.id.name);
//        TextView phone = (TextView)item.findViewById(R.id.phone);
//        TextView address = (TextView)item.findViewById(R.id.address);
//        ImageView img = (ImageView)item.findViewById(R.id.image);
//
//        name.setText(personList.get(position).getName());
//        phone.setText(personList.get(position).getPhone());
//        address.setText(personList.get(position).getAddress());
//        img.setImageResource(R.mipmap.ic_launcher);
//
//        Log.d("get", "Check");


//      (2)Recycle 방식

//        View item = convertView;
//        if(item == null){
//            item = inflater.inflate(R.layout.list_item, null);
//        }
//
//        TextView name = (TextView)item.findViewById(R.id.name);
//        TextView phone = (TextView)item.findViewById(R.id.phone);
//        TextView address = (TextView)item.findViewById(R.id.address);
//        ImageView img = (ImageView)item.findViewById(R.id.image);
//
//        name.setText(personList.get(position).getName());
//        phone.setText(personList.get(position).getPhone());
//        address.setText(personList.get(position).getAddress());
//        img.setImageResource(R.mipmap.ic_launcher);

//        (3)View Holder 방식

        View item = convertView;
        Holder holder = null;

        if(item == null){
            item = inflater.inflate(R.layout.list_item, null);
            holder = new Holder();
            holder.name= (TextView)item.findViewById(R.id.name);
            holder.phone = (TextView)item.findViewById(R.id.phone);
            holder.address = (TextView)item.findViewById(R.id.address);
            holder. img = (ImageView)item.findViewById(R.id.image);

            item.setTag(holder);
        }else{
            holder = (Holder)item.getTag();
        }
        holder.name.setText(personList.get(position).getName());
        holder.phone.setText(personList.get(position).getPhone());
        holder.address.setText(personList.get(position).getAddress());
        holder.img.setImageResource(R.mipmap.ic_launcher);


        return item;
    }

    private class Holder{
        TextView name;
        TextView phone;
        TextView address;
        ImageView img;
    }

}
