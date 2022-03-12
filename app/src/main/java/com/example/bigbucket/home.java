package com.example.bigbucket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    MaterialToolbar toolbar;
    Button logout;
    FirebaseAuth mAuth;
    GridView gridView;
    String[] categorynames = {"Fruits", "Vegetables", "Food Grains", "Oil & Masala", "Beverages", "Snacks", "Dairy", "Combo"};
    int[] categoryimages = {R.drawable.fruit, R.drawable.vegetables, R.drawable.foodgrains, R.drawable.oilmasala, R.drawable.beverage, R.drawable. snacks, R.drawable.dairy, R.drawable.combo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gridView = findViewById(R.id.gridview);
        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(new Intent(home.this, fruit_List.class));
                } else if (position == 1) {
                    startActivity(new Intent(home.this, vegetable_list.class));
                } else if (position == 2) {
                    startActivity(new Intent(home.this, foodgrain_list.class));
                } else if (position == 3) {
                    startActivity(new Intent(home.this, oilmasala_list.class));
                } else if (position == 4) {
                    startActivity(new Intent(home.this, beverages_list.class));
                } else if (position == 5) {
                    startActivity(new Intent(home.this, snacks_list.class));
                } else if (position == 6) {
                    startActivity(new Intent(home.this, dairy_list.class));
                } else if (position == 7) {
                    startActivity(new Intent(home.this, combo.class));
                }
            }
        });

        mAuth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(View -> {
            mAuth.signOut();
            Toast.makeText(home.this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(home.this, FirstPage.class));
        });

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navhome);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.navcat) {
                startActivity(new Intent(home.this, categories.class));
            }
            if(item.getItemId() == R.id.navwish) {
                startActivity(new Intent(home.this, wishlist.class));
            }
            if(item.getItemId() == R.id.navcart) {
                startActivity(new Intent(home.this, cart.class));
            }

            return true;
        });

        toolbar = findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item)
    {
        drawerLayout.closeDrawer(GravityCompat.START);

        if(item.getItemId() == R.id.navorder) {
            startActivity(new Intent(home.this, my_orders.class));
        }
        if(item.getItemId() == R.id.navcombo) {
            startActivity(new Intent(home.this, combo.class));
        }
        if(item.getItemId() == R.id.navnoti) {
            startActivity(new Intent(home.this, my_notifications.class));
        }
        if(item.getItemId() == R.id.navcoupon) {
            startActivity(new Intent(home.this, coupons.class));
        }
        if(item.getItemId() == R.id.navorderdetails) {
            startActivity(new Intent(home.this, order_details.class));
        }
        if(item.getItemId() == R.id.navordertrack) {
            startActivity(new Intent(home.this, track_order.class));
        }

        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return categoryimages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.grid_item, null);

            TextView name = view.findViewById(R.id.namev);
            ImageView image = view.findViewById(R.id.imagev);

            name.setText(categorynames[position]);
            image.setImageResource(categoryimages[position]);

            return view;
        }
    }
}