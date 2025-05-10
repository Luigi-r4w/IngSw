package com.example.dietideals24.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dietideals24.Connection.ApiService;
import com.example.dietideals24.Connection.RetrofitClient;
import com.example.dietideals24.Entities.Offerta;
import com.example.dietideals24.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OffertaActivity extends AppCompatActivity {

    private String tipo;
    private String id;
    private String email;

    private String offertaAtt, soglia;

    private Integer offertaMin;
    private ApiService service;

    public void onBackPressed() {
        Intent intent = new Intent(OffertaActivity.this, InfoAstaActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("tipo", tipo);
        intent.putExtra("id", id);
        startActivity(intent);
        finish();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.offerta_scene);

        service = RetrofitClient.getInstance().create(ApiService.class);
        tipo = getIntent().getSerializableExtra("tipo").toString();
        email = getIntent().getSerializableExtra("email").toString();
        id = getIntent().getSerializableExtra("id").toString();
        offertaAtt = getIntent().getSerializableExtra("offertaAtt").toString();
        soglia = getIntent().getSerializableExtra("soglia").toString();
        offertaMin = Integer.valueOf(offertaAtt)+Integer.valueOf(soglia);

        EditText offerta = findViewById(R.id.editTextOfferta);
        EditText rialzo = findViewById(R.id.editTextRialzo);
        EditText valoreOfferta = findViewById(R.id.editTextMiaOfferta);

        offerta.setText(offertaAtt.toString());
        rialzo.setText(offertaMin.toString());


        findViewById(R.id.buttonOfferta).setOnClickListener(v -> {

            if((Integer.valueOf(String.valueOf(valoreOfferta.getText())))>=offertaMin) {

                Offerta newOfferta = new Offerta();
                newOfferta.setOfferta(Integer.valueOf(String.valueOf(valoreOfferta.getText())));
                newOfferta.setAsta(Integer.valueOf(id));
                newOfferta.setUtente(email);
                service.newOfferta(newOfferta).enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                        onBackPressed();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        onBackPressed();
                    }
                });

            } else {
                Toast.makeText(OffertaActivity.this, "Offerta troppo bassa", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
