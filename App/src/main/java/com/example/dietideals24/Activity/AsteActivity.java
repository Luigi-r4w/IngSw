package com.example.dietideals24.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietideals24.Adapter.ListaAdapter;
import com.example.dietideals24.Adapter.NotificaAdapter;
import com.example.dietideals24.Connection.ApiService;
import com.example.dietideals24.Connection.RetrofitClient;
import com.example.dietideals24.Entities.AstaInglese;
import com.example.dietideals24.Entities.Notifica;
import com.example.dietideals24.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsteActivity  extends AppCompatActivity {

    private String tipo, email, aste, categoria, parola;

    private ApiService service;

    public void onBackPressed() {
        Intent intent = new Intent(AsteActivity.this, HomeActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("tipo", tipo);
        startActivity(intent);
        finish();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.lista_aste_scene);

        tipo = getIntent().getSerializableExtra("tipo").toString();
        email = getIntent().getSerializableExtra("email").toString();
        aste = getIntent().getSerializableExtra("aste").toString();
        parola = getIntent().getSerializableExtra("parola").toString();
        categoria = getIntent().getSerializableExtra("categoria").toString();
        service = RetrofitClient.getInstance().create(ApiService.class);

        findViewById(R.id.button3).setOnClickListener(view -> {

            Intent intent = new Intent(AsteActivity.this, RicercaActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("tipo", tipo);
            startActivity(intent);
            finish();


        });

        if(aste.equals("tutte")){

            service.listaAste().enqueue(new Callback<ArrayList<AstaInglese>>() {
                @Override
                public void onResponse(Call<ArrayList<AstaInglese>> call, Response<ArrayList<AstaInglese>> response) {

                    if(response.body().isEmpty()){
                        Toast.makeText(AsteActivity.this, "Non ci sono aste", Toast.LENGTH_SHORT).show();
                    } else {

                        RecyclerView recView = findViewById(R.id.RView);

                        ListaAdapter adapter = new ListaAdapter(getBaseContext());
                        adapter.setLista(response.body(), tipo, email);

                        recView.setAdapter(adapter);
                        recView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                    }

                }

                @Override
                public void onFailure(Call<ArrayList<AstaInglese>> call, Throwable t) {
                    Toast.makeText(AsteActivity.this, "Non ci sono aste", Toast.LENGTH_SHORT).show();

                }
            });

        } else if (aste.equals("mie")) {

            service.listaAsteUtente(email).enqueue(new Callback<ArrayList<AstaInglese>>() {
                @Override
                public void onResponse(Call<ArrayList<AstaInglese>> call, Response<ArrayList<AstaInglese>> response) {

                    if(response.body().isEmpty()){
                        Toast.makeText(AsteActivity.this, "Non ci sono aste", Toast.LENGTH_SHORT).show();
                    } else {

                        RecyclerView recView = findViewById(R.id.RView);

                        ListaAdapter adapter = new ListaAdapter(getBaseContext());
                        adapter.setLista(response.body(), tipo, email);

                        recView.setAdapter(adapter);
                        recView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                    }

                }

                @Override
                public void onFailure(Call<ArrayList<AstaInglese>> call, Throwable t) {
                    Toast.makeText(AsteActivity.this, "Non ci sono aste", Toast.LENGTH_SHORT).show();

                }
            });

        } else {

            service.listaAsteRA(categoria, parola).enqueue(new Callback<ArrayList<AstaInglese>>() {

                @Override
                public void onResponse(Call<ArrayList<AstaInglese>> call, Response<ArrayList<AstaInglese>> response) {

                    if(response.body().isEmpty()){
                        Toast.makeText(AsteActivity.this, "Non ci sono aste", Toast.LENGTH_SHORT).show();
                    } else {

                        RecyclerView recView = findViewById(R.id.RView);

                        ListaAdapter adapter = new ListaAdapter(getBaseContext());
                        adapter.setLista(response.body(), tipo, email);

                        recView.setAdapter(adapter);
                        recView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                    }

                }

                @Override
                public void onFailure(Call<ArrayList<AstaInglese>> call, Throwable t) {
                    Toast.makeText(AsteActivity.this, "Non ci sono aste", Toast.LENGTH_SHORT).show();

                }
            });

        }

    }
}
