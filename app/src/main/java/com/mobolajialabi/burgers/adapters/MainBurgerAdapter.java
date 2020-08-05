package com.mobolajialabi.burgers.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobolajialabi.burgers.DetailsActivity;
import com.mobolajialabi.burgers.R;
import com.mobolajialabi.burgers.models.MainBurger;

import java.util.List;

public class MainBurgerAdapter extends RecyclerView.Adapter<MainBurgerAdapter.MyViewHolder> {
    private List<MainBurger> mainBurgers;
    private Context context;

    public MainBurgerAdapter(List<MainBurger> mainBurgers){
        this.mainBurgers = mainBurgers;
    }

    @NonNull
    @Override
    public MainBurgerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_burger,parent,false);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, DetailsActivity.class));
            }
        });

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainBurgerAdapter.MyViewHolder holder, int position) {
        MainBurger mainBurger = mainBurgers.get(position);
        TextView dishName = holder.foodName;
        dishName.setText(mainBurger.getDishName());

        TextView groupName = holder.className;
        groupName.setText(mainBurger.getGeneralName());

        TextView price = holder.price;
        price.setText(mainBurger.getPrice());

        ImageView image = holder.img;
        image.setImageResource(mainBurger.getImage());
    }

    @Override
    public int getItemCount() {
        return mainBurgers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView foodName;
        public TextView className;
        public TextView price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.popular_img);
            foodName = itemView.findViewById(R.id.popular_name);
            className = itemView.findViewById(R.id.popular_class_name);
            price = itemView.findViewById(R.id.popular_price);

            context = itemView.getContext();
        }
    }

}
