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
import com.example.dietideals24.Entities.Compratore;
import com.example.dietideals24.Entities.Venditore;
import com.example.dietideals24.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private ApiService service;

    public void onBackPressed() {
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.signup_scene);
        String tipo = getIntent().getSerializableExtra("tipo").toString();
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("  Sign Up");
        EditText nome = findViewById(R.id.editTextNome);
        EditText email = findViewById(R.id.editTextEmail);
        EditText pass = findViewById(R.id.editTextPassword);


        findViewById(R.id.button2).setOnClickListener(view -> {
            if (nome.getText().toString().isEmpty() | email.getText().toString().isEmpty() | pass.getText().toString().isEmpty()){
                Toast.makeText(SignUpActivity.this, "Ci sono dei campi vuoti", Toast.LENGTH_SHORT).show();
            } else {
                service = RetrofitClient.getInstance().create(ApiService.class);
                if (tipo.equals("Compratore")) {

                    Compratore user = new Compratore();
                    user.setNome(nome.getText().toString());
                    user.setEmail(email.getText().toString());
                    user.setPassword(pass.getText().toString());

                    service.newCompratore(user).enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                                Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                                intent.putExtra("email", email.getText().toString());
                                intent.putExtra("tipo", tipo);
                                startActivity(intent);
                                finish();
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                            intent.putExtra("email", email.getText().toString());
                            intent.putExtra("tipo", tipo);
                            startActivity(intent);
                            finish();
                        }
                    });
                } else {

                    Venditore user = new Venditore((nome.getText().toString()), email.getText().toString(), pass.getText().toString());
                    service.newVenditore(user).enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                                Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                                intent.putExtra("email", email.getText().toString());
                                intent.putExtra("tipo", tipo);
                                startActivity(intent);
                                finish();
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {
                            Intent intent = new Intent(SignUpActivity.this, LogInActivity.class);
                            intent.putExtra("email", email.getText().toString());
                            intent.putExtra("tipo", tipo);
                            startActivity(intent);
                            finish();                        }
                    });
                }
            }
        });
    }

}
