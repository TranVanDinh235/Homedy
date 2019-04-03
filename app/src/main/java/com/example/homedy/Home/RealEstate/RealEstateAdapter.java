package com.example.homedy.Home.RealEstate;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homedy.ARealEstate.ARealEstateActivity;
import com.example.homedy.Home.ItemClickListener;
import com.example.homedy.R;

import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class RealEstateAdapter extends RecyclerView.Adapter<RealEstateAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView nametextView;
        public TextView pricetextView;
        public TextView yearTextView;
        public TextView locationTextView;
        public TextView addressTextView;
        public ImageView imageView;

        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView){
            super(itemView);
            nametextView = (TextView) itemView.findViewById(R.id.name_real_estate);
            pricetextView = (TextView) itemView.findViewById(R.id.price_real_estate);
            yearTextView = (TextView) itemView.findViewById(R.id.year_real_estate);
            addressTextView = (TextView) itemView.findViewById(R.id.address_real_estate);
            locationTextView = (TextView) itemView.findViewById(R.id.location_real_eatate);
            imageView = (ImageView) itemView.findViewById(R.id.img_real_estate);
            itemView.setOnClickListener(this);
        }

        public void setItemClickListener(ItemClickListener itemClickListener ){
            this.itemClickListener = itemClickListener;
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v,getAdapterPosition(),false);
        }
    }
    private List<RealEstate> realEstates;
    private Context context;

    public RealEstateAdapter(List<RealEstate> realEstates, Context context){
        this.realEstates = realEstates;
        this.context = context;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.recycler_item1, viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final RealEstate realEstate = realEstates.get(i);
        TextView textView1 = viewHolder.nametextView;
        TextView textView2 = viewHolder.pricetextView;
        TextView textView3 = viewHolder.yearTextView;
        TextView textView4 = viewHolder.locationTextView;
        TextView textView5 = viewHolder.addressTextView;
        ImageView imageView = viewHolder.imageView;

        textView1.setText(realEstate.getName());
        textView2.setText(realEstate.getPrice());
        final Integer integer = realEstate.getYear();
        textView3.setText(integer.toString());
        textView4.setText(realEstate.getLocation());
        textView5.setText(realEstate.getAddress());
        imageView.setImageResource(realEstate.getImage());

        viewHolder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Context con = view.getContext();
                if(!isLongClick){
                    Intent intent = new Intent(con, ARealEstateActivity.class);
                    con.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return realEstates.size();
    }

}
