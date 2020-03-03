package com.vdx.homate.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vdx.homate.R;
import com.vdx.homate.RoomsActivity;

public class ButtonAdapter extends RecyclerView.Adapter<ButtonAdapter.ViewHolder> {

    private String[] button_name = {"Living Room", "Office", "Main Room", "Kitchen", "Balcony", "Washroom"};
    private int[] button_images = {R.drawable.lightbulb, R.drawable.computer, R.drawable.desk_lamp, R.drawable.fan};

    private Context context;

    public ButtonAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rooms_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name = button_name[position];
        holder.btn_name.setText(name);
        final Intent intent = new Intent(context, RoomsActivity.class);
        intent.putExtra("room_name", name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return button_name.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView btn_image;
        private TextView btn_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_name = itemView.findViewById(R.id.room_name);
        }
    }
}
