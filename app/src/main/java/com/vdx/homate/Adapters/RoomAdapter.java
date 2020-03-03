package com.vdx.homate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vdx.homate.R;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.ViewHolder> {

    private Context context;

    public RoomAdapter(Context context) {
        this.context = context;
    }

    private String[] electoronics_name = {"Light", "Computer", "Lamp", "Fan",};
    private int[] electronics_images = {R.drawable.lightbulb, R.drawable.computer, R.drawable.desk_lamp, R.drawable.fan};


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.room_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = electoronics_name[position];
        holder.item_name.setText(name);
        holder.item_image.setBackground(context.getResources().getDrawable(electronics_images[position]));
    }

    @Override
    public int getItemCount() {
        return electoronics_name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView item_name;
        private ImageView item_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_image = itemView.findViewById(R.id.item_image);


        }
    }
}
