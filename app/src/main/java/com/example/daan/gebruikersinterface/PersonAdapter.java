package com.example.daan.gebruikersinterface;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daan.gebruikersinterface.Person;
import com.example.daan.gebruikersinterface.R;

import java.util.ArrayList;

/**
 * Created by dkroeske on 8/29/15.
 */
public class PersonAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater mInflator;
    ArrayList mPersonArrayList;

    public PersonAdapter(Context context, LayoutInflater layoutInflater, ArrayList<Person> personArrayList)
    {
        mContext = context;
        mInflator = layoutInflater;
        mPersonArrayList = personArrayList;
    }

    @Override
    public int getCount() {
        int size = mPersonArrayList.size();
        Log.i("getCount()","=" + size);
        return size;
    }

    @Override
    public Object getItem(int position) {
        Log.i("getItem()","");
        return mPersonArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        // Create new of gebruik een al bestaande (recycled by Android)
        if(convertView == null) {

            //
            convertView = mInflator.inflate(R.layout.lijst, null);

            //
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            viewHolder.age = (TextView) convertView.findViewById(R.id.age);
            viewHolder.email = (TextView) convertView.findViewById(R.id.email);

            //
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // En nu de viewHolder invullen met de juiste persons
        Person person = (Person) mPersonArrayList.get(position);

        viewHolder.name.setText(person.name);
        viewHolder.imageView.setImageBitmap(person.bitmap);
        viewHolder.email.setText(person.email);
        viewHolder.age.setText(person.age);


        return convertView;
    }

    // Holds all data to the view. Wordt evt. gerecycled door Android
    private static class ViewHolder {
        public ImageView imageView;
        public TextView name;
        public TextView age;
        public TextView email;
    }
}
