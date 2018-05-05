package com.ramirez.parcialmoviles;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Erika on 02/05/2018.
 */

public class DatosAdapter extends RecyclerView.Adapter<DatosAdapter.InformacionViewHolder>{

    private Context contexto;
    private LayoutInflater inflater;
    private List<Datos> datos;
    private List<Datos> datos2;



    public DatosAdapter(Context contexto, List<Datos> informacion) {
        this.contexto = contexto;
        this.datos = informacion;
    }

    @Override
    public InformacionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(contexto);
        View view = inflater.inflate(R.layout.card_view,parent,false);
        InformacionViewHolder informacionViewHolder = new InformacionViewHolder(view);
        return informacionViewHolder;
    }

    @Override
    public void onBindViewHolder(final InformacionViewHolder holder, final int position) {

        holder.name.setText(datos.get(position).getNombre());
        holder.img.setImageResource(datos.get(position).getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("tag",datos.get(position).getNombre());
                Log.d("tag",datos.get(position).getNumero());

               Intent info= new Intent(view.getContext(),Main2Activity.class);
                Bundle box = new Bundle();
                box.putSerializable("KEY",datos.get(position));
                info.putExtras(box);
                contexto.startActivity(info);
            }
        });

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public static class InformacionViewHolder extends RecyclerView.ViewHolder{

        CardView card;
        TextView name;
        ImageView img;

        public InformacionViewHolder(View itemView){
            super(itemView);
            card = itemView.findViewById(R.id.card_view);
            name = itemView.findViewById(R.id.name);
            img = itemView.findViewById(R.id.img);

        }
    }

    public DatosAdapter(List<Datos> informacion){ this.datos = informacion;}

}
