package com.example.dietideals24.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dietideals24.Connection.ApiService;
import com.example.dietideals24.Connection.RetrofitClient;
import com.example.dietideals24.Entities.AstaInglese;
import com.example.dietideals24.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.Toast;


public class InfoAstaActivity extends AppCompatActivity {

    private String tipo;
    private String id;
    private String email;
    private String offerta, soglia;

    private ApiService service;

    private Integer scaduta, ultimaOfferta;


    public void onBackPressed() {
        Intent intent = new Intent(InfoAstaActivity.this, HomeActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("tipo", tipo);
        startActivity(intent);
        finish();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.info_asta_scene);

        tipo = getIntent().getSerializableExtra("tipo").toString();
        email = getIntent().getSerializableExtra("email").toString();
        id = getIntent().getSerializableExtra("id").toString();
        service = RetrofitClient.getInstance().create(ApiService.class);

        EditText nome = findViewById(R.id.editTextNome);
        EditText categoria = findViewById(R.id.editTextCategoria);
        EditText offMin = findViewById(R.id.editTextOfferta);
        EditText sogRial = findViewById(R.id.editTextRialzo);
        EditText intTemp = findViewById(R.id.editTextTempo);
        EditText bio = findViewById(R.id.editTextInfo);
        ImageView foto = findViewById(R.id.imageView2);
        EditText utente = findViewById(R.id.UserTextInfo);

        utente.setOnClickListener(v -> {

            Intent intent = new Intent(InfoAstaActivity.this, ProfiloActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("utente", utente.getText().toString());
            intent.putExtra("tipo", tipo);
            intent.putExtra("from", "asta");
            intent.putExtra("id",id);
            startActivity(intent);

        });


        if(tipo.equals("Venditore") ){
            findViewById(R.id.buttonFaiOfferta).setVisibility(View.INVISIBLE);
        }


        service.infoAsta(id).enqueue(new Callback<AstaInglese>() {
            @Override
            public void onResponse(Call<AstaInglese> call, Response<AstaInglese> response) {

                nome.setText(response.body().getNome());
                categoria.setText(response.body().getCategoria());
                offMin.setText(response.body().getOffertaMinima().toString());
                sogRial.setText(response.body().getSogliaDiRialzo().toString());
                intTemp.setText(response.body().getIntervalloDiTempo().toString());
                bio.setText(response.body().getDescrizione());
                utente.setText(response.body().getUtente());
                scaduta= Integer.valueOf(response.body().getScaduta());
                ultimaOfferta=response.body().getUltimaOfferta();
                soglia=sogRial.getText().toString();
                if(!response.body().getFoto().equals("Error"))
                    foto.setImageBitmap(decodeBase64ToBitmap(response.body().getFoto()));

                check();
            }

            @Override
            public void onFailure(Call<AstaInglese> call, Throwable t) {
                onBackPressed();

            }
        });

        findViewById(R.id.buttonFaiOfferta).setOnClickListener(v -> {

            offerta=offMin.getText().toString();

            if (!(ultimaOfferta==0)) {
                service.valoreOfferta(ultimaOfferta).enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {

                        offerta = response.body().toString();
                        goToOfferta();

                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        offerta = offMin.getText().toString();
                        goToOfferta();

                    }
                });
            } else {
                goToOfferta();
            }



        });

    }

    public void goToOfferta(){
        Intent intent = new Intent(InfoAstaActivity.this, OffertaActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("tipo", tipo);
        intent.putExtra("offertaAtt", offerta);
        intent.putExtra("soglia", soglia);
        intent.putExtra("id",id);
        startActivity(intent);
        finish();
    }

    private Bitmap decodeBase64ToBitmap(String base64String) {
        byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    public void check(){
        if(tipo.equals("Venditore") || scaduta.intValue() == 1){
            findViewById(R.id.buttonFaiOfferta).setVisibility(View.INVISIBLE);
        }
    }

}
