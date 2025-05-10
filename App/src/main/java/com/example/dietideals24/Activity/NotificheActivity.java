package com.example.dietideals24.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietideals24.Adapter.NotificaAdapter;
import com.example.dietideals24.Connection.ApiService;
import com.example.dietideals24.Connection.RetrofitClient;
import com.example.dietideals24.Entities.Notifica;
import com.example.dietideals24.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificheActivity extends AppCompatActivity {

    private String tipo;
    private String email;
    private ApiService service;


    public void onBackPressed() {
        Intent intent = new Intent(NotificheActivity.this, HomeActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("tipo", tipo);
        startActivity(intent);
        finish();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.notifica_scene);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("  Notifiche");

        tipo = getIntent().getSerializableExtra("tipo").toString();
        email = getIntent().getSerializableExtra("email").toString();
        service = RetrofitClient.getInstance().create(ApiService.class);

        if(tipo.equals("Compratore")){

            service.notifcheCompratore(email).enqueue(new Callback<ArrayList<Notifica>>() {
                @Override
                public void onResponse(Call<ArrayList<Notifica>> call, Response<ArrayList<Notifica>> response) {

                    if(response.body().isEmpty()){
                        Toast.makeText(NotificheActivity.this, "Non ci sono notifiche", Toast.LENGTH_SHORT).show();
                    } else {

                        RecyclerView recView = findViewById(R.id.RecyclerView);

                        NotificaAdapter adapter = new NotificaAdapter(getBaseContext());
                        adapter.setNotifiche(response.body(),email,tipo);

                        recView.setAdapter(adapter);
                        recView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                    }

                }

                @Override
                public void onFailure(Call<ArrayList<Notifica>> call, Throwable t) {
                    Toast.makeText(NotificheActivity.this, "Non ci sono notifiche", Toast.LENGTH_SHORT).show();

                }
            });

        } else {

            service.notifcheVenditore(email).enqueue(new Callback<ArrayList<Notifica>>() {
                @Override
                public void onResponse(Call<ArrayList<Notifica>> call, Response<ArrayList<Notifica>> response) {

                    if(response.body().isEmpty()){
                        Toast.makeText(NotificheActivity.this, "Non ci sono notifiche", Toast.LENGTH_SHORT).show();
                    } else {

                        RecyclerView esibizioniRecView = findViewById(R.id.RecyclerView);

                        NotificaAdapter adapter = new NotificaAdapter(getBaseContext());
                        adapter.setNotifiche(response.body(),email,tipo);

                        esibizioniRecView.setAdapter(adapter);
                        esibizioniRecView.setLayoutManager(new LinearLayoutManager(getBaseContext()));


                    }

                }

                @Override
                public void onFailure(Call<ArrayList<Notifica>> call, Throwable t) {
                    Toast.makeText(NotificheActivity.this, "Non ci sono notifiche", Toast.LENGTH_SHORT).show();

                }
            });

        }


    }
}