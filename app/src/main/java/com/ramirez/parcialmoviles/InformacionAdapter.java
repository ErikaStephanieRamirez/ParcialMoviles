package com.ramirez.parcialmoviles;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Erika on 02/05/2018.
 */

public class InformacionAdapter extends RecyclerView.Adapter<InformacionAdapter.InformacionViewHolder>{

    private Context contexto;
    private LayoutInflater inflater;
    private List<Informacion> informacion;



    public InformacionAdapter(Context contexto, List<Informacion> informacion) {
        this.contexto = contexto;
        this.informacion = informacion;
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
        holder.name.setText(informacion.get(position).getNombre());
        holder.img.setImageResource(informacion.get(position).getImg());

    }

    @Override
    public int getItemCount() {
        return informacion.size();
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

    public InformacionAdapter(List<Informacion> informacion){ this.informacion = informacion;}

}
