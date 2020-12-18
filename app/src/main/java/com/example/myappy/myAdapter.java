package com.example.myappy;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


// instantiates view for layout in main activity
public class myAdapter extends BaseAdapter implements ListAdapter{

        // intializes variables
        Context context;
        protected ArrayList<String> rTitle = new ArrayList<>();
        protected ArrayList<String> rDesc = new ArrayList<>();
        protected int imgs;
        protected ClassList listing;

        // sets variables to inputted
        public myAdapter(Context c, int imgs, ClassList list) {
            super();
            this.context = c;
            this.imgs = imgs;
            this.listing = list;

            GetData(listing); // get ClassName and Descrip from list
            notifyDataSetChanged();
        }

        // gets variables from Class List and sets them into ArrayLists
        public void GetData(ClassList list){
            for(int i = 0; i < list.getSize(); i++){
                 rTitle.add(list.get(i).getClassName());
                 rDesc.add(list.get(i).getClassDescrip());
            }
        }

        // getters taht came with addapter class
        @Override
        public int getCount() {
            return rTitle.size();
        } // returns number of classes theoretically

        @Override
        public Object getItem(int pos) {
            return rTitle.get(pos);
        } // returns value at title array

        @Override
        public long getItemId(int pos) {
            return pos;
        }

        // instantiates view for each class into a row using row layout
        @NonNull
        @Override
        public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View row = layoutInflater.inflate(R.layout.rows, parent, false);

            // sets views to layout
            ImageView images = row.findViewById(R.id.image);
            TextView title = row.findViewById(R.id.textView1);
            TextView subTitle = row.findViewById(R.id.textView2);
            // sets view to layout
            images.setImageResource(imgs);
            title.setText(rTitle.get(position));
            subTitle.setText(rDesc.get(position));

            // initializes button to view classes TaskList
            Button viewButton = row.findViewById(R.id.viewButton);
            // when clicked changes to ClassView activity and gives title and list
            viewButton.setOnClickListener(v -> {
                Intent intent = new Intent(context, ClassView.class );
                intent.putExtra("ClassName", rTitle.get(position));// used for title in class task view
                //listing.get position returns class, .getTasksforClass returns TaskList for a class
                intent.putExtra("listing", listing.get(position)); // gives class to ClassView
                context.startActivity(intent);
            });

            //initializes button to delete Class
            Button DelButton = row.findViewById(R.id.deleteButton);
            // when clicked, Calls removeClass fucntion in ClassList
            // removes from arrays too
            DelButton.setOnClickListener(v -> {
                // listing.get(position) == a specific Class in the classList
                listing.removeClass(listing.get(position)); //removes from Classlist instead
                rTitle.remove(position);
                rDesc.remove(position);
                notifyDataSetChanged();
            });
            return row;

        }
    }

