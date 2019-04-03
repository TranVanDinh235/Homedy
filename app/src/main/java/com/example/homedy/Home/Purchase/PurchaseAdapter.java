package com.example.homedy.Home.Purchase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homedy.R;

import java.util.List;

public class PurchaseAdapter extends RecyclerView.Adapter<PurchaseAdapter.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvPrice;
        public TextView tvLocation;
        public TextView tvTime;
        public TextView tvName;
        public TextView tvAddress;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPrice = (TextView) itemView.findViewById(R.id.price_purchase);
            tvLocation = (TextView) itemView.findViewById(R.id.location_purchase);
            tvTime = (TextView) itemView.findViewById(R.id.time_purchase);
            tvName = (TextView) itemView.findViewById(R.id.name_purchase);
            tvAddress = (TextView) itemView.findViewById(R.id.address_purchase);
            imageView = (ImageView) itemView.findViewById(R.id.img_purchase);
        }
    }

    private List<Purchase> purchases;

    public PurchaseAdapter(List<Purchase> purchases){this.purchases = purchases;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_item2, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Purchase purchase = purchases.get(i);
        ImageView imageView = viewHolder.imageView;
        TextView textView1 = viewHolder.tvPrice;
        TextView textView2 = viewHolder.tvLocation;
        TextView textView3 = viewHolder.tvTime;
        TextView textView4 = viewHolder.tvName;
        TextView textView5 = viewHolder.tvAddress;

        imageView.setImageResource(purchase.getImage());
        textView1.setText(purchase.getPrice());
        textView2.setText(purchase.getLocation());
        Integer time = purchase.getTime();
        textView3.setText(time.toString());
        textView4.setText(purchase.getName());
        textView5.setText(purchase.getAddress());
    }

    @Override
    public int getItemCount() {
        return purchases.size();
    }
}
