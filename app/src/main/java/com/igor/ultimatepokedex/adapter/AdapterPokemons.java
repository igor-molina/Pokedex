package com.igor.ultimatepokedex.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.igor.ultimatepokedex.R;

public class AdapterPokemons extends RecyclerView.Adapter<AdapterPokemons.MyViewHolder> {


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // cria visualização do elemento
        View pokemonLista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_pokemon_lista, parent, false);

        return new MyViewHolder(pokemonLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { // cria exibição dos itens
        //holder.pokeImage.setImageDrawable("Foto do pokemon baixada");
        holder.pokeName.setText("Nome do pokemon consumido do Json");
        holder.pokeNum.setText("Numero do pokemon consumido do Json");
        holder.pokePeso.setText("Peso do pokemon consumido do Json");
        holder.pokeAltura.setText("Altura do pokemon consumido do Json");
        holder.pokeType.setText("Tipo do pokemon consumido do Json");
    }

    @Override
    public int getItemCount() {
        return 151;
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

}
