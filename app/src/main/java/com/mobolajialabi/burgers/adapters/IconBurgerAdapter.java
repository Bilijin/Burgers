package com.mobolajialabi.burgers.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobolajialabi.burgers.models.IconBurger;
import com.mobolajialabi.burgers.R;

import java.util.List;

public class IconBurgerAdapter extends RecyclerView.Adapter<IconBurgerAdapter.MyViewHolder> {
    private List<IconBurger> iconBurgers;

    public IconBurgerAdapter(List<IconBurger> iconBurgers) {
        this.iconBurgers = iconBurgers;
    }

    @NonNull
    @Override
    public IconBurgerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_burger,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IconBurgerAdapter.MyViewHolder holder, int position) {

        IconBurger iconBurger = iconBurgers.get(position);
        TextView name = holder.iconName;
        name.setText(iconBurger.getName());

        ImageView image = holder.iconImage;
        image.setImageResource(iconBurger.getIcon());

    }

    @Override
    public int getItemCount() {
        return iconBurgers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView iconName;
        ImageView iconImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iconName = itemView.findViewById(R.id.icon_name);
            iconImage = itemView.findViewById(R.id.icon_image);
        }
    }
}
