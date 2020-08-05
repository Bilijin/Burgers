package com.mobolajialabi.burgers.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobolajialabi.burgers.R;
import com.mobolajialabi.burgers.models.CartBurger;

import java.text.NumberFormat;
import java.util.List;

public class CartBurgerAdapter extends RecyclerView.Adapter<CartBurgerAdapter.MyViewHolder> {
    private List<CartBurger> cartBurgers;

    public CartBurgerAdapter(List<CartBurger> cartBurgers) {
        this.cartBurgers = cartBurgers;
    }

    @NonNull
    @Override
    public CartBurgerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartBurgerAdapter.MyViewHolder holder, int position) {
        CartBurger cartBurger = cartBurgers.get(position);

        TextView textView = holder.name;
        textView.setText(cartBurger.getName());

        ImageView imageView = holder.imageView;
        imageView.setImageResource(cartBurger.getImage());

        final String pp = cartBurger.getPrice();
        holder.price.setText(NumberFormat.getCurrencyInstance().format(Integer.parseInt(pp)));

        final TextView quantity = holder.count;

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p = Integer.parseInt((String) quantity.getText());
                if (p < 20){
                    p = p + 1;

                    int amt = Integer.parseInt(pp) * p;
                    String aa = NumberFormat.getCurrencyInstance().format(amt);
                    holder.price.setText(aa);
                    holder.count.setText(String.valueOf(p));
                }
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p = Integer.parseInt((String) quantity.getText());
                if (p > 1){
                    p = p - 1;

                    int amt = Integer.parseInt(pp) * p;
                    holder.price.setText(String.valueOf(amt));
                    String aa = NumberFormat.getCurrencyInstance().format(amt);
                    holder.price.setText(aa);
                    holder.count.setText(String.valueOf(p));
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartBurgers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView price;
        ImageView plus;
        ImageView minus;
        TextView name;
        TextView count;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.cart_img);
            price = itemView.findViewById(R.id.cart_price);
            plus = itemView.findViewById(R.id.plus);
            minus = itemView.findViewById(R.id.minus);
            name = itemView.findViewById(R.id.cart_name);
            count = itemView.findViewById(R.id.count);
        }
    }
}
