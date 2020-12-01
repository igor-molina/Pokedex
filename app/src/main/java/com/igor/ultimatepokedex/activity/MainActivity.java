package com.igor.ultimatepokedex.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.igor.ultimatepokedex.R;
import com.igor.ultimatepokedex.adapter.AdapterPokemons;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerPokemons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPokemons = findViewById(R.id.rclPokemons);

        //Configurando Adapter
        AdapterPokemons pokeAdapter = new AdapterPokemons();

        //Configurando RecyclerView dos Pokémons
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerPokemons.setLayoutManager(layoutManager);
        recyclerPokemons.setHasFixedSize(true);
        recyclerPokemons.setAdapter(pokeAdapter);
    }
}