package com.example.dietideals24.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietideals24.Activity.InfoAstaActivity;
import com.example.dietideals24.Connection.ApiService;
import com.example.dietideals24.Connection.RetrofitClient;
import com.example.dietideals24.Entities.AstaInglese;
import com.example.dietideals24.Entities.Notifica;
import com.example.dietideals24.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificaAdapter extends RecyclerView.Adapter<NotificaAdapter.ViewHolder>{

    private final Context context;

    private String email;
    private String tipo;
    private ArrayList<Notifica> notifiche = new ArrayList<>();

    private ApiService service;

    @SuppressLint("NotifyDataSetChanged")
    public void setNotifiche(ArrayList<Notifica> notifiche, String email, String tipo) {
        this.notifiche = notifiche;
        this.email=email;
        this.tipo=tipo;
        notifyDataSetChanged();
    }

    public NotificaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notifiche_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        final String[] nomeAsta = new String[1];

        service = RetrofitClient.getInstance().create(ApiService.class);

        service.infoAsta(String.valueOf(notifiche.get(position).getAsta())).enqueue(new Callback<AstaInglese>() {
            @Override
            public void onResponse(Call<AstaInglese> call, Response<AstaInglese> response) {

                nomeAsta[0] = response.body().getNome();

                if (notifiche.get(position).getCompratore().equals("asta fallita")){
                    holder.nomeTxt.setText("Asta fallita");
                    holder.immagineView.setImageResource(R.drawable.notifiche2);
                } else {
                    holder.Txt.setText("Si aggiudica l'asta " + notifiche.get(position).getCompratore());
                    holder.immagineView.setImageResource(R.drawable.notifiche);
                }

                holder.astaTxt.setText("Asta: "+nomeAsta[0]);
                
                holder.parent.setOnClickListener(v -> {

                    Intent intent = new Intent(context, InfoAstaActivity.class);
                    intent.putExtra("id", String.valueOf(notifiche.get(position).getAsta()) );
                    intent.putExtra("email", email);
                    intent.putExtra("tipo", tipo);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                });

            }

            @Override
            public void onFailure(Call<AstaInglese> call, Throwable t) {}
        });





    }

    @Override
    public int getItemCount() {
        return notifiche.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final CardView parent;

        private final TextView nomeTxt;
        private final TextView astaTxt;
        private final TextView Txt;

        private final ImageView immagineView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.layoutNotifiche);

            immagineView = itemView.findViewById(R.id.immagineView);
            nomeTxt = itemView.findViewById(R.id.nomeTxt);
            Txt = itemView.findViewById(R.id.Txt);
            astaTxt = itemView.findViewById(R.id.astaTxt);


        }
    }
}
