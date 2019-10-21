 package com.example.aquahd;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.provider.PicassoProvider;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    Context context;
    ArrayList<List> eventLists = new ArrayList<>();



    public Adapter(Context c, ArrayList<List> e){
        context = c;
        eventLists = e;
    }

    public Adapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        DatabaseReference mDatabaseRef = FirebaseDatabase.getInstance().getReference("Category");

        List list = eventLists.get(i);
            viewHolder.name.setText(list.getmName());
            viewHolder.price.setText(list.getAdd());
            PicassoProvider.get().load(list.getimageUrl()).into(viewHolder.product_img);

    }

    @Override
    public int getItemCount() {
        return eventLists.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, price;
        ImageView product_img;
        public ViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.product_name);
            price = view.findViewById(R.id.product_price);
            product_img = view.findViewById(R.id.product);

        }
    }
}
