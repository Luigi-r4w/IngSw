package com.example.dietideals24.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dietideals24.R;

import java.util.ArrayList;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner tipoUtente;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.start_scene);

        if (isNetworkAvailable()) {
            Toast.makeText(this, "Connessione di rete attiva", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Connessione di rete non disponibile", Toast.LENGTH_SHORT).show();
        }


        tipoUtente = findViewById(R.id.spinner);
        ArrayList<String> tipo = new ArrayList<>();
        tipo.add("Compratore");
        tipo.add("Venditore");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,  android.R.layout.simple_spinner_item, tipo );
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        tipoUtente.setAdapter(adapter);

        findViewById(R.id.logInButton).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LogInActivity.class);
            intent.putExtra("tipo",tipoUtente.getSelectedItem().toString());
            startActivity(intent);
            finish();
        });
        findViewById(R.id.singUpButton).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            intent.putExtra("tipo",tipoUtente.getSelectedItem().toString());
            startActivity(intent);
            finish();
        });
    }


    // Metodo per verificare la disponibilità della connessione di rete
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }
}
