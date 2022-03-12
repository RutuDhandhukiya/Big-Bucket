package com.example.bigbucket;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class categories extends AppCompatActivity {

    MaterialToolbar toolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navcat);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.navhome) {
                startActivity(new Intent(categories.this, home.class));
                finish();
            }
            if(item.getItemId() == R.id.navwish) {
                startActivity(new Intent(categories.this, wishlist.class));
                finish();
            }
            if(item.getItemId() == R.id.navcart) {
                startActivity(new Intent(categories.this, cart.class));
                finish();
            }

            return true;
        });
    }
}