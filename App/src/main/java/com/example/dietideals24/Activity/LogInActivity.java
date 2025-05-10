package com.example.dietideals24.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.dietideals24.Connection.ApiService;
import com.example.dietideals24.Connection.RetrofitClient;

import com.example.dietideals24.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LogInActivity  extends AppCompatActivity {


    private  ApiService service;

    public void onBackPressed() {
        Intent intent = new Intent(LogInActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.login_scene);
        String tipoUtente = getIntent().getSerializableExtra("tipo").toString();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("  Log In");
        EditText email = findViewById(R.id.editTextEmail);
        EditText pass = findViewById(R.id.editTextPassword);
        findViewById(R.id.button).setOnClickListener(view -> {
            if (email.getText().toString().isEmpty() | pass.getText().toString().isEmpty()){
                Toast.makeText(LogInActivity.this, "Ci sono dei campi vuoti", Toast.LENGTH_SHORT).show();
            } else {
                login(email.getText().toString(), pass.getText().toString(), tipoUtente);
            }

        });
    }

    public  void login(String mail, String pass, String tipoUtente) {

        service = RetrofitClient.getInstance().create(ApiService.class);
        if(tipoUtente.equals("Compratore")){
            Call<Boolean> call = service.checkCompratore(mail, pass);
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if(response.body()){
                        Intent intent = new Intent(LogInActivity.this, HomeActivity.class);
                        intent.putExtra("email", mail);
                        intent.putExtra("tipo", tipoUtente);
                        startActivity(intent);
                        finish();
                    } else{
                        Toast.makeText(LogInActivity.this, "Utente non trovato", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    Toast.makeText(LogInActivity.this, "Utente non trovato", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            service.checkVenditore(mail, pass).enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    if(response.body()){
                        Intent intent = new Intent(LogInActivity.this, HomeActivity.class);
                        intent.putExtra("email", mail);
                        intent.putExtra("tipo", tipoUtente);
                        startActivity(intent);
                        finish();
                    } else{
                        Toast.makeText(LogInActivity.this, "Utente non trovato", Toast.LENGTH_SHORT).show();
                    }
                }
                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                    Toast.makeText(LogInActivity.this, "Utente non trovato", Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

}
