package com.example.smallsamples;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ClickAdapter extends RecyclerView.Adapter<ClickAdapter.ClickViewHolder> {

    List listPostion;
    IClickPostion clickPostion;

    public ClickAdapter(List listPostion) {
        this.listPostion = listPostion;
    }

    interface IClickPostion {
        void getClickedPostion(int position);
    }

    @NonNull
    @Override
    public ClickViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ClickViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClickViewHolder holder, int position) {
        holder.tvposition.setText(position + "");
      //  clickPostion.getClickedPostion(position);
    }

    @Override
    public int getItemCount() {
        return listPostion.size();
    }

    public void setClickedPosition(IClickPostion clickPostion) {
        this.clickPostion = clickPostion;
    }

    public class ClickViewHolder extends RecyclerView.ViewHolder {

        TextView tvposition;
        ConstraintLayout constraintLayout;

        public ClickViewHolder(@NonNull View itemView) {
            super(itemView);
            tvposition = itemView.findViewById(R.id.tv_position);
            constraintLayout = itemView.findViewById(R.id.constraint_position);
            constraintLayout.setOnClickListener(v -> clickPostion.getClickedPostion(getAdapterPosition()));
        }


    }
}
