package com.example.examenparcial.RecyclerViewAdaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.examenparcial.R;
import com.example.examenparcial.Revistas;

import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder{
       private TextView nombre,descripcion;
        ImageView imagenrevista;
        public ViewHolder(View itemView) {
            super(itemView);
            nombre =(TextView)itemView.findViewById(R.id.txtNombre);
            descripcion =(TextView)itemView.findViewById(R.id.txtDescripcion);
            imagenrevista = itemView.findViewById(R.id.ivusuario);
        }
    }
    private Context revistacon;
    public List<Revistas> revistasListist;
      public RecyclerViewAdaptador(Context context, List<Revistas> revistasList) {
        revistacon=context;
        revistasListist = revistasList;
    }

    @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(revistacon);
            View view = inflater.inflate(R.layout.item_usuario,parent,false);
            ViewHolder viewHolder= new ViewHolder(view);
            return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewAdaptador.ViewHolder holder, int position) {
        holder.nombre.setText((revistasListist.get(position).getName()));
        holder.descripcion.setText((revistasListist.get(position).getDescription()));
         Glide.with(holder.imagenrevista.getContext()).load(revistasListist.get(position).getPortada()).into(holder.imagenrevista);
    }
    @Override
    public int getItemCount() {
        return revistasListist.size();
    }
}
