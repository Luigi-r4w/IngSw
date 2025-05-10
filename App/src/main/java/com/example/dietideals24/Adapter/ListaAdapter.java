package com.example.dietideals24.Adapter;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietideals24.Activity.AsteActivity;
import com.example.dietideals24.Activity.HomeActivity;
import com.example.dietideals24.Activity.InfoAstaActivity;
import com.example.dietideals24.Entities.AstaInglese;
import com.example.dietideals24.R;

import java.util.ArrayList;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder>{

    private final Context context;

    private String tipo;
    private String email;
    private ArrayList<AstaInglese> aste = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setLista(ArrayList<AstaInglese> aste, String tipo, String email) {
        this.aste = aste;
        this.tipo = tipo;
        this.email = email;
        notifyDataSetChanged();
    }

    public ListaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_aste_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nome.setText(aste.get(position).getNome());

        holder.utente.setText(aste.get(position).getUtente());

        if(!aste.get(position).getFoto().equals("Error"))
            holder.immagineView.setImageBitmap(decodeBase64ToBitmap(aste.get(position).getFoto()));

        holder.parent.setOnClickListener(v -> {

            Intent intent = new Intent(context, InfoAstaActivity.class);
            intent.putExtra("id", aste.get(position).getId());
            intent.putExtra("email", email);
            intent.putExtra("tipo", tipo);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return aste.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final CardView parent;

        private final ImageView immagineView;

        private final TextView nome, utente;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.card);

            immagineView = itemView.findViewById(R.id.immagineView);

            nome = itemView.findViewById(R.id.nomeTxt);

            utente = itemView.findViewById(R.id.utenteTxt);


        }
    }

    private Bitmap decodeBase64ToBitmap(String base64String) {
        byte[] decodedString = Base64.decode(base64String, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }
}
