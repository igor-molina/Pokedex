package com.igor.ultimatepokedex.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.igor.ultimatepokedex.R;
import com.igor.ultimatepokedex.model.Pokemon;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AdapterPokemons extends RecyclerView.Adapter<AdapterPokemons.MyViewHolder> {

    private List<Pokemon> pokemonList;
    public AdapterPokemons(List<Pokemon> lista) {
        this.pokemonList = lista;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // cria visualização do elemento
        View pokemonLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_pokemon_lista, parent, false);

        return new MyViewHolder(pokemonLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { // cria exibição dos itens
        Pokemon pokemon = pokemonList.get(position);
        //holder.pokeImage.setImageDrawable("Foto do pokemon baixada");
        holder.pokeName.setText(pokemon.getName());
        holder.pokeNum.setText(pokemon.getNum());
        holder.pokePeso.setText(pokemon.getWeight());
        holder.pokeAltura.setText(pokemon.getHeight());
        //holder.pokeType.setText(pokemon.getType());
        holder.pokeType.setText(pokemon.getType().toString());
        new PictureDownloader(holder.pokeImage).execute(pokemon.getImg());
        //holder.pokeImage.setImageBitmap(pokemon.getImg());
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView pokeNum;
        TextView pokeName;
        ImageView pokeImage;
        TextView pokeType;
        TextView pokeAltura;
        TextView pokePeso;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pokeImage = itemView.findViewById(R.id.imgPokePic);
            pokeName = itemView.findViewById(R.id.txtPokeName);
            pokeNum = itemView.findViewById(R.id.txtPokeNum);
            pokeType = itemView.findViewById(R.id.txtPokeType);
            pokePeso = itemView.findViewById(R.id.txtPokePeso);
            pokeAltura = itemView.findViewById(R.id.txtPokeAltura);
        }
    }

    private class PictureDownloader extends AsyncTask<String, Void, Bitmap> {
        ImageView imgViewPokemon;
        public PictureDownloader(ImageView imgViewPokemon){
            this.imgViewPokemon = imgViewPokemon;
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            String url = urls[0];
            Bitmap pic = null;

            try{
                InputStream inputStream = new URL(url).openStream();
                pic = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return pic;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imgViewPokemon.setImageBitmap(bitmap);
        }
    }

}
