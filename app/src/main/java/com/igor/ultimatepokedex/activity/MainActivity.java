package com.igor.ultimatepokedex.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.igor.ultimatepokedex.R;
import com.igor.ultimatepokedex.adapter.AdapterPokemons;
import com.igor.ultimatepokedex.api.Conexao;
import com.igor.ultimatepokedex.api.ConsumirJson;
import com.igor.ultimatepokedex.model.Pokemon;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerPokemons;
    private List<Pokemon> pokemonList = new ArrayList<>();
    private ImageView imgViewPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerPokemons = findViewById(R.id.rclPokemons);
        imgViewPokemon = findViewById(R.id.imgPokePic);

        Task task = new Task();
        task.execute("https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/pokedex.json");

    }


    private class Task extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            String retorno = Conexao.getDados(strings[0]);
            return retorno;
        }

        @Override
        protected void onPostExecute(String s){
            pokemonList = ConsumirJson.jsonData(s);
            AdapterPokemons pokeAdapter = new AdapterPokemons(pokemonList, getApplicationContext());
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerPokemons.setLayoutManager(layoutManager);
            recyclerPokemons.setHasFixedSize(true);
            recyclerPokemons.setAdapter(pokeAdapter);
        }
    }

}