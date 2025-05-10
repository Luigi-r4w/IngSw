package com.example.dietideals24.Connection;

import com.example.dietideals24.Entities.AstaInglese;
import com.example.dietideals24.Entities.Compratore;
import com.example.dietideals24.Entities.Notifica;
import com.example.dietideals24.Entities.Offerta;
import com.example.dietideals24.Entities.Venditore;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {

    @GET("/venditore/{mail}/{pass}")
    Call<Boolean> checkVenditore(@Path("mail") String mail, @Path("pass") String pass);

    @GET("/compratore/{mail}/{pass}")
    Call<Boolean> checkCompratore(@Path("mail") String mail, @Path("pass") String pass);

    @POST("/venditore/")
    Call<Boolean> newVenditore(@Body Venditore request);

    @POST("/compratore/")
    Call<Boolean> newCompratore(@Body Compratore request);

    @GET("/notifica/venditore/{mail}")
    Call<ArrayList<Notifica>> notifcheVenditore(@Path("mail") String mail);

    @GET("/notifica/compratore/{mail}")
    Call<ArrayList<Notifica>> notifcheCompratore(@Path("mail") String mail);

    @GET("/compratore/{mail}")
    Call<Compratore> getCompratore(@Path("mail") String mail);

    @GET("/venditore/{mail}")
    Call<Venditore> getVenditore(@Path("mail") String mail);

    @POST("/compratore/update")
    Call<Boolean> updateCompratore(@Body Compratore request);

    @POST("/venditore/update")
    Call<Boolean> updateVenditore(@Body Venditore request);

    @POST("/asta/")
    Call<Boolean> newAsta(@Body AstaInglese astaInglese);

    @GET("/asta/")
    Call<ArrayList<AstaInglese>> listaAste();

    @GET("/asta/lista/{email}")
    Call<ArrayList<AstaInglese>> listaAsteUtente(@Path("email")String email);

    @GET("/asta/{categoria}/{parola}")
    Call<ArrayList<AstaInglese>> listaAsteRA(@Path("categoria") String categoria, @Path("parola") String parola);

    @GET("/asta/info/{id}")
    Call<AstaInglese> infoAsta(@Path("id")String id);

    @POST("/offerta/")
    Call<Boolean> newOfferta(@Body Offerta offerta);

    @GET("/offerta/offerta/{id}")
    Call<Integer> valoreOfferta(@Path("id") Integer id);

}
