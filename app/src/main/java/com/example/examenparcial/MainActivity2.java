package com.example.examenparcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdaptador recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle bundle = this.getIntent().getExtras();
        recyclerView =(RecyclerView)findViewById(R.id.rvusuarios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        gsonrevistas();
    }
    public List<Revistas> obtenerevista(){
        List<Revistas> revistas = new ArrayList<>();
        return revistas;
    }
    private void gsonrevistas() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://revistas.uteq.edu.ec/ws/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        Servidor svr = retrofit.create(Servidor.class);
        Call<List<Revistas>> call = svr.getRevistas();
        call.enqueue(new Callback<List<Revistas>>() {
            @Override
            public void onResponse(Call<List<Revistas>> call, Response<List<Revistas>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<Revistas> postRevistas = response.body();
                recyclerViewAdapter = new RecyclerViewAdaptador(postRevistas);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
            @Override
            public void onFailure(Call<List<Revistas>> call, Throwable t) {
                Log.e("KR","aqui");
            }
        });
    }
}