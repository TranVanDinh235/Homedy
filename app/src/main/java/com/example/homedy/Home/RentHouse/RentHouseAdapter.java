package com.example.homedy.Home.RentHouse;

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

public class RentHouseAdapter extends RecyclerView.Adapter<RentHouseAdapter.ViewHolder> {
    private List<RentHouse> rentHouses;

    public RentHouseAdapter(List<RentHouse> rentHouses){this.rentHouses = rentHouses;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_item3, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        RentHouse rentHouse = rentHouses.get(i);
        ImageView imageView = viewHolder.imageView;
        TextView textView1 = viewHolder.tvPrice;
        TextView textView2 = viewHolder.tvLocation;
        TextView textView3 = viewHolder.tvTime;
        TextView textView4 = viewHolder.tvName;
        TextView textView5 = viewHolder.tvAddress;

        imageView.setImageResource(rentHouse.getImage());
        textView1.setText(rentHouse.getPrice());
        textView2.setText(rentHouse.getLocation());
        Integer time = rentHouse.getTime();
        textView3.setText(time.toString());
        textView4.setText(rentHouse.getName());
        textView5.setText(rentHouse.getAddress());

    }

    @Override
    public int getItemCount() {
        return rentHouses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvPrice;
        public TextView tvLocation;
        public TextView tvTime;
        public TextView tvName;
        public TextView tvAddress;
        public ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPrice = (TextView) itemView.findViewById(R.id.price_rent_house);
            tvLocation = (TextView) itemView.findViewById(R.id.location_rent_house);
            tvTime = (TextView) itemView.findViewById(R.id.time_rent_house);
            tvName = (TextView) itemView.findViewById(R.id.name_rent_house);
            tvAddress = (TextView) itemView.findViewById(R.id.address_rent_house);
            imageView = (ImageView) itemView.findViewById(R.id.img_rent_house);
        }
    }

}
