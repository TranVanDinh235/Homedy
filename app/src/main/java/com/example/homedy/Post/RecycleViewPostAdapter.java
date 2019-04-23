package com.example.homedy.Post;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.homedy.Home.HomeItem;
import com.example.homedy.R;

import java.lang.ref.WeakReference;
import java.util.ArrayList;


public class RecycleViewPostAdapter extends RecyclerView.Adapter<RecycleViewPostAdapter.ViewHolder>{

    private final ClickListener listener;

    private ItemDeleteClickListener itemDeleteClickListener;

    private final ArrayList<HomeItem> homeItems;

    public RecycleViewPostAdapter(ArrayList<HomeItem> homeItems, ClickListener listener, ItemDeleteClickListener itemDeleteClickListener){
        this.listener = listener;
        this.homeItems = homeItems;
        this.itemDeleteClickListener = itemDeleteClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reycycler_post_item, viewGroup,false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        HomeItem homeItem = homeItems.get(i);
        ImageView imageView = viewHolder._postImageView;
        TextView textView = viewHolder._rentPostTextView;
        TextView textView1 = viewHolder._titlePostTextView;
        TextView textView2 = viewHolder._addressPostTextView;
        TextView textView3 = viewHolder._timePostTextView;
        TextView textView4 = viewHolder._areaPostTextView;

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

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView _postImageView;
        private TextView _titlePostTextView;
        private TextView _rentPostTextView;
        private TextView _addressPostTextView;
        private TextView _timePostTextView;
        private TextView _areaPostTextView;
        private ImageButton _modifyPostButton;
        private ImageButton _sharePostButton;
        private ImageButton _deletePostButton;

        private WeakReference<ClickListener> listenerRef;

        public ViewHolder(@NonNull View itemView, ClickListener clickListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            listenerRef = new WeakReference<>(clickListener);
            _postImageView = (ImageView) itemView.findViewById(R.id.imv_post_image);
            _titlePostTextView = (TextView) itemView.findViewById(R.id.txt_post_title);
            _timePostTextView =(TextView) itemView.findViewById(R.id.txt_post_time);
            _rentPostTextView = (TextView) itemView.findViewById(R.id.txt_post_rent);
            _addressPostTextView = (TextView) itemView.findViewById(R.id.txt_post_address);
            _areaPostTextView = (TextView) itemView.findViewById(R.id.txt_post_area);
            _modifyPostButton = (ImageButton) itemView.findViewById(R.id.btn_post_modify);
            _sharePostButton = (ImageButton) itemView.findViewById(R.id.btn_post_share);
            _deletePostButton = (ImageButton) itemView.findViewById(R.id.btn_post_delete);

            _modifyPostButton.setOnClickListener(this);
            _sharePostButton.setOnClickListener(this);
            _deletePostButton.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == _modifyPostButton.getId()){
                Toast.makeText(v.getContext(), "modify press",Toast.LENGTH_LONG).show();
            }else if(v.getId() == _sharePostButton.getId()){
                Toast.makeText(v.getContext(), "share press", Toast.LENGTH_LONG).show();
            }else if(v.getId() == _deletePostButton.getId()){
                if(itemDeleteClickListener.onItemDeleteClick()) {
                    removeAt(getAdapterPosition());
                    Toast.makeText(v.getContext(), "Đã xoá một bài đăng", Toast.LENGTH_LONG).show();
                }
            } else {
            }

            listenerRef.get().onPostitionClick(getAdapterPosition());
        }

    }

    public void removeAt(int position) {
        homeItems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, homeItems.size());
    }

    public interface ItemDeleteClickListener{
        boolean onItemDeleteClick();
    }
}
