package com.example.examenparcial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>{
    public static class ViewHolder extends RecyclerView.ViewHolder{

       private TextView id,nombre,descripcion;
        ImageView imagenrevista;

        public ViewHolder(View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.txtId);
            nombre =(TextView)itemView.findViewById(R.id.txtNombre);
            descripcion =(TextView)itemView.findViewById(R.id.txtDescripcion);
            imagenrevista = itemView.findViewById(R.id.ivusuario);
        }
    }
    public List<Revistas> revistasListist;
    RequestManager option;
    public RecyclerViewAdaptador(List<Revistas> revistasListist){
           this.revistasListist = revistasListist;
    }
    @Override
    public RecyclerViewAdaptador.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario,parent,false);
        final RecyclerViewAdaptador.ViewHolder viewHolder = new RecyclerViewAdaptador.ViewHolder(view);
        option = Glide.with(viewHolder.imagenrevista.getContext());
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerViewAdaptador.ViewHolder holder, int position) {
        holder.id.setText((revistasListist.get(position).getId()));
        holder.nombre.setText((revistasListist.get(position).getName()));
        holder.descripcion.setText((revistasListist.get(position).getDescription()));
        option.load(revistasListist.get(position).getPortada()).centerCrop().into(holder.imagenrevista);
    }
    @Override
    public int getItemCount() {
        return revistasListist.size();
    }
}
