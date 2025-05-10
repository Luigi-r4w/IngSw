package com.example.dietideals24.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;


public class NuovaAstaActivity extends AppCompatActivity {

    private String tipo;
    private String email;
    private ApiService service;

    private ImageView imageView;

    public void onBackPressed() {
        Intent intent = new Intent(NuovaAstaActivity.this, HomeActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("tipo", tipo);
        startActivity(intent);
        finish();
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.nouva_asta_menu_scene);
        tipo = getIntent().getSerializableExtra("tipo").toString();
        email = getIntent().getSerializableExtra("email").toString();

        findViewById(R.id.leMieAsteButton).setOnClickListener(v->{
            this.setContentView(R.layout.nuova_asta_scene);

            EditText nome = findViewById(R.id.editTextNome);
            EditText categoria = findViewById(R.id.editTextCategoria);
            EditText offertaMinima = findViewById(R.id.editTextOfferta);
            EditText descrizione = findViewById(R.id.editTextInfo);
            imageView = findViewById(R.id.imageView2);
            EditText interalloTemp = findViewById(R.id.editTextTempo);
            EditText soglia = findViewById(R.id.editTextRialzo);

            imageView.setOnClickListener(gallery -> {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                galleryLauncher.launch(pickPhoto);
            });

            findViewById(R.id.buttonConferma).setOnClickListener(c->{

                Bitmap bitmap = getBitmapFromImageView(imageView);

                String encodedImage;

                if (bitmap != null) {
                    // Convertire l'immagine in una stringa Base64
                    encodedImage = encodeImageToBase64(bitmap);
                    // Puoi ora inserire encodedImage in un array o usarla come preferisci
                    System.out.println(encodedImage);
                } else {
                    // Gestisci il caso in cui l'ImageView non contiene un'immagine valida
                    encodedImage = "Error";
                }

                AstaInglese asta = new AstaInglese();
                asta.setNome(nome.getText().toString());
                asta.setCategoria(categoria.getText().toString());
                asta.setDescrizione(descrizione.getText().toString());
                asta.setFoto(encodedImage);
                asta.setUtente(email);
                asta.setOffertaMinima(Integer.valueOf(offertaMinima.getText().toString()));
                asta.setIntervalloDiTempo(Integer.valueOf(interalloTemp.getText().toString()));
                asta.setSogliaDiRialzo(Integer.valueOf(soglia.getText().toString()));

                service = RetrofitClient.getInstance().create(ApiService.class);
                Call<Boolean> call = service.newAsta(asta);
                call.enqueue(new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> response) {

                        onBackPressed();

                    }
                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {

                        onBackPressed();
                    }
                });
            });

        });




    }

    private ActivityResultLauncher<Intent> galleryLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Uri selectedImage = result.getData().getData();
                    imageView.setImageURI(selectedImage);
                }
            });

    private byte[] convertBitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private String encodeImageToBase64(Bitmap bitmap) {
        byte[] byteArray = convertBitmapToByteArray(bitmap);
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    private Bitmap getBitmapFromImageView(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

}
