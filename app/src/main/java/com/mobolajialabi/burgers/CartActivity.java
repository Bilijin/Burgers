package com.mobolajialabi.burgers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobolajialabi.burgers.adapters.CartBurgerAdapter;
import com.mobolajialabi.burgers.models.CartBurger;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    RecyclerView cartRecyclerView;
    List<CartBurger> cartBurgers;
    ImageView cartBack;
    TextView price;
    TextView price2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        price = findViewById(R.id.sub_price);
        price2 = findViewById(R.id.tot_price);

        cartBack = findViewById(R.id.cart_back);
        cartBurgers = new ArrayList<>();

        cartBurgers.add(new CartBurger(R.drawable.cheese_burger,"450",getString(R.string.chicken_burger)));
        cartBurgers.add(new CartBurger(R.drawable.french_fries,"250",getString(R.string.chicken_burger)));
        cartBurgers.add(new CartBurger(R.drawable.pizza_cabonara,"600",getString(R.string.chicken_burger)));

        cartRecyclerView = findViewById(R.id.cart_recycler);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        cartRecyclerView.setAdapter(new CartBurgerAdapter(cartBurgers));

        cartBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this,MainActivity.class));
            }
        });

        price.setText(NumberFormat.getCurrencyInstance().format(Integer.parseInt(price.getText().toString())));
        price2.setText(NumberFormat.getCurrencyInstance().format(Integer.parseInt(price2.getText().toString())));

//        for (int i = 0;i<cartBurgers.size();i++) {
//            String p = cartBurgers.get(i).getPrice();
//        }
    }
}