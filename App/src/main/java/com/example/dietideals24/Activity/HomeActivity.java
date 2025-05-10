package com.example.dietideals24.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.dietideals24.R;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private String tipo;
    private String email;

    public void onBackPressed() {}

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.home_scene);
        tipo = getIntent().getSerializableExtra("tipo").toString();
        email = getIntent().getSerializableExtra("email").toString();
        if (tipo.equals("Compratore")){
            findViewById(R.id.button5).setVisibility(View.INVISIBLE);
            findViewById(R.id.leMieAsteButton).setVisibility(View.INVISIBLE);
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        NavigationView navigationView = findViewById(R.id.navView);
        drawerLayout = findViewById(R.id.home);

        toolbar.setTitle("Home");
        setSupportActionBar(toolbar);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_, R.string.close_);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();

        findViewById(R.id.AsteButton).setOnClickListener(view ->{
            Intent intent = new Intent(HomeActivity.this, AsteActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("tipo", tipo);
            intent.putExtra("aste", "tutte");
            intent.putExtra("parola", "null");
            intent.putExtra("categoria", "null");
            startActivity(intent);
            finish();
        });

        findViewById(R.id.leMieAsteButton).setOnClickListener(view ->{
            Intent intent = new Intent(HomeActivity.this, AsteActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("tipo", tipo);
            intent.putExtra("aste", "mie");
            intent.putExtra("parola", "null");
            intent.putExtra("categoria", "null");
            startActivity(intent);
            finish();
        });

        findViewById(R.id.button5).setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, NuovaAstaActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("tipo", tipo);
            startActivity(intent);
            finish();
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_profile: {
                Intent intent = new Intent(HomeActivity.this, ProfiloActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("utente", email);
                intent.putExtra("tipo", tipo);
                intent.putExtra("from", "home");
                startActivity(intent);
                break;
            }
            case R.id.menu_notifiche: {
                Intent intent = new Intent(HomeActivity.this, NotificheActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("tipo", tipo);
                startActivity(intent);
                break;
            }
            case R.id.menu_logout: {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
