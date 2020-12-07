package com.igor.ultimatepokedex.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.igor.ultimatepokedex.R;
import com.igor.ultimatepokedex.model.Pokemon;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

import java.util.List;

import static java.security.AccessController.getContext;

public class AdapterPokemons extends RecyclerView.Adapter<AdapterPokemons.MyViewHolder> {

    private List<Pokemon> pokemonList;
    private Context context;
    public AdapterPokemons(List<Pokemon> lista, Context context) {
        this.pokemonList = lista;
        this.context = context;
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
        holder.pokeName.setText(pokemon.getName());
        holder.pokeNum.setText(pokemon.getNum());
        holder.pokePeso.setText(pokemon.getWeight());
        holder.pokeAltura.setText(pokemon.getHeight());
        holder.pokeType.setText(pokemon.getType().toString());
        //new PictureDownloader(holder.pokeImage).execute(pokemon.getImg());
        //holder.pokeImage.setImageBitmap(pokemon.getImg());
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttpDownloader(context));
        builder.build().load(pokemon.getImg())
                .into(holder.pokeImage);
        //Picasso.with(context).load(pokemon.getImg())
          //  .into(holder.pokeImage);
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
            //pokeImage = itemView.findViewById(R.id.imgPokePic);
            pokeName = itemView.findViewById(R.id.txtPokeName);
            pokeNum = itemView.findViewById(R.id.txtPokeNum);
            pokeType = itemView.findViewById(R.id.txtPokeType);
            pokePeso = itemView.findViewById(R.id.txtPokePeso);
            pokeAltura = itemView.findViewById(R.id.txtPokeAltura);
            this.pokeImage = itemView.findViewById(R.id.imgPokePic);
        }
    }


}
