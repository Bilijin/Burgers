package com.mobolajialabi.burgers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.ImageView;

import com.mobolajialabi.burgers.adapters.IconBurgerAdapter;
import com.mobolajialabi.burgers.adapters.MainBurgerAdapter;
import com.mobolajialabi.burgers.models.IconBurger;
import com.mobolajialabi.burgers.models.MainBurger;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView iconRecycler;
    RecyclerView mainRecycler;
    List<MainBurger> mainBurgers;
    List<IconBurger> iconBurgers;
    ImageView cartGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cartGo = findViewById(R.id.main_cart);

        iconRecycler = findViewById(R.id.icon_burger_recycler);
        mainRecycler = findViewById(R.id.main_burger_recycler);
        mainBurgers = new ArrayList<>();
        iconBurgers = new ArrayList<>();

        iconBurgers.add(new IconBurger(R.drawable.beef_burger_icon,getString(R.string.burgers)));
        iconBurgers.add(new IconBurger(R.drawable.noodles_icon,getString(R.string.noodles)));
        iconBurgers.add(new IconBurger(R.drawable.film_roll_icon,getString(R.string.rolls)));
        iconBurgers.add(new IconBurger(R.drawable.champagne_icon,getString(R.string.drinks)));
        iconBurgers.add(new IconBurger(R.drawable.beef_burger_icon,getString(R.string.burgers)));
        iconBurgers.add(new IconBurger(R.drawable.noodles_icon,getString(R.string.noodles)));
        iconBurgers.add(new IconBurger(R.drawable.film_roll_icon,getString(R.string.rolls)));
        iconBurgers.add(new IconBurger(R.drawable.champagne_icon,getString(R.string.drinks)));

        mainBurgers.add(new MainBurger(getString(R.string.chicken_burger),getString(R.string.flavoroso),getString(R.string.pricee),R.drawable.salmon_burger));
        mainBurgers.add(new MainBurger(getString(R.string.salmon_burger),getString(R.string.salty_squid),"550",R.drawable.cheese_burger));
        mainBurgers.add(new MainBurger(getString(R.string.beef_cheese),getString(R.string.masala),"600",R.drawable.beef_cheese_burger));
        mainBurgers.add(new MainBurger(getString(R.string.veggie_burger),getString(R.string.veggie_corner),"350",R.drawable.veggie_burger));
        mainBurgers.add(new MainBurger(getString(R.string.chicken_burger),getString(R.string.flavoroso),getString(R.string.pricee),R.drawable.salmon_burger));
        mainBurgers.add(new MainBurger(getString(R.string.salmon_burger),getString(R.string.salty_squid),"550",R.drawable.cheese_burger));
        mainBurgers.add(new MainBurger(getString(R.string.beef_cheese),getString(R.string.masala),"600",R.drawable.beef_cheese_burger));
        mainBurgers.add(new MainBurger(getString(R.string.veggie_burger),getString(R.string.veggie_corner),"350",R.drawable.veggie_burger));

        iconRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        iconRecycler.setAdapter(new IconBurgerAdapter(iconBurgers));

        MainBurgerAdapter mainBurgerAdapter = new MainBurgerAdapter(mainBurgers);

        mainRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mainRecycler.setAdapter(new MainBurgerAdapter(mainBurgers));

        cartGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });

    }
}