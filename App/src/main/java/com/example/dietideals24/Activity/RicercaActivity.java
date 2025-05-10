package com.example.dietideals24.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dietideals24.R;

public class RicercaActivity extends AppCompatActivity {

    private String tipo, email, aste, categoria, parola;


    public void onBackPressed() {
        Intent intent = new Intent(RicercaActivity.this, HomeActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("tipo", tipo);
        startActivity(intent);
        finish();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.ricerca_avanzata_scene);

        tipo = getIntent().getSerializableExtra("tipo").toString();
        email = getIntent().getSerializableExtra("email").toString();
        EditText categoriaText = findViewById(R.id.editTextCategoria2);
        EditText parolatxt = findViewById(R.id.editTextParola);

        findViewById(R.id.buttonCerca).setOnClickListener(v -> {
            categoria="null";
            parola="null";
            if (categoriaText.getText().toString().trim().length()>0){
                categoria = categoriaText.getText().toString();
            }
            if (parolatxt.getText().toString().trim().length()>0){
                parola = parolatxt.getText().toString();
            }
            aste = "RAvanzata";

            System.out.println("categoria: "+categoria+" parola:"+parola);

            Intent intent = new Intent(RicercaActivity.this, AsteActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("tipo", tipo);
            intent.putExtra("aste", aste);
            intent.putExtra("parola", parola);
            intent.putExtra("categoria", categoria);
            startActivity(intent);
            finish();
        });



    }

}
