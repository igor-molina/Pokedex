package com.igor.ultimatepokedex.api;

import android.util.Log;

import com.igor.ultimatepokedex.model.Pokemon;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConsumirJson {

    public static List<Pokemon> jsonData(String conteudo) {

        /*for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Upload upload = postSnapshot.getValue(Upload.class);
                    uploads.add(upload);
                }*/

        try {
            List<Pokemon> pokemonList = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(conteudo);

            JSONArray jsonArray = jsonObject.getJSONArray("pokemon");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject pokeAtual = jsonArray.getJSONObject(i);
                JSONArray typeList = pokeAtual.getJSONArray("type");
                List<String> pokeTypes = new ArrayList<>();

                for(int j = 0; j < typeList.length(); j++){
                    pokeTypes.add(typeList.getString(j));
                }

                        Pokemon pokemon = new Pokemon(
                        pokeAtual.getString("img"),
                        pokeAtual.getString("name"),
                        pokeAtual.getString("num"),
                        pokeAtual.getString("weight"),
                        pokeAtual.getString("height"),
                        pokeTypes);

                pokemonList.add(pokemon);
            }
            return pokemonList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}

