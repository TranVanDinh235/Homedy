package com.example.homedy.Home;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.homedy.ARealEstate.ARealEstateActivity;
import com.example.homedy.R;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RecyclerViewHomeAdapter extends RecyclerView.Adapter<RecyclerViewHomeAdapter.ViewHolder> {
    private final String POSITION = "key_position";
    ArrayList<HomeItem> homeItems = HomeItem.getExameHome();
    @NonNull
    @Override
    public RecyclerViewHomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_home_item, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHomeAdapter.ViewHolder viewHolder, int i) {
        HomeItem homeItem = homeItems.get(i);
        ImageView imageView = viewHolder._homeImageView;
        TextView textView = viewHolder._rentHomeTextView;
        TextView textView1 = viewHolder._titleHomeTextView;
        TextView textView2 = viewHolder._addressHomeTextView;
        TextView textView3 = viewHolder._timeHomeTextView;
        TextView textView4 = viewHolder._areaHomeTextView;

        imageView.setImageResource(homeItem.getImage());
        String rent = homeItem.getRent() + " triệu";
        textView.setText(rent);
        textView1.setText(homeItem.getTitle());
        textView2.setText(homeItem.getAddress());
        String time = "Đăng " + homeItem.getTime() + " giờ trước";
        textView3.setText(time);
        String area = homeItem.getArea() + " m2";
        textView4.setText(area);
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView _homeImageView;
        public TextView _titleHomeTextView;
        public TextView _rentHomeTextView;
        public TextView _addressHomeTextView;
        public TextView _timeHomeTextView;
        public TextView _areaHomeTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            _homeImageView = (ImageView) itemView.findViewById(R.id.imv_home_image);
            _timeHomeTextView = (TextView) itemView.findViewById(R.id.txt_home_time);
            _titleHomeTextView =(TextView) itemView.findViewById(R.id.txt_home_title);
            _rentHomeTextView = (TextView) itemView.findViewById(R.id.txt_home_rent);
            _addressHomeTextView = (TextView) itemView.findViewById(R.id.txt_home_address);
            _areaHomeTextView = (TextView) itemView.findViewById(R.id.txt_home_area);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), ARealEstateActivity.class);
            intent.putExtra(POSITION, getLayoutPosition());
            v.getContext().startActivity(intent);

        }
    }
}
