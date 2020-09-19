package com.example.examenparcial.RecyclerViewAdaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.examenparcial.R;
import java.util.ArrayList;

public class RecyclerViewAdaptadorEdicion extends RecyclerView.Adapter<RecyclerViewAdaptadorEdicion.ViewHolder> {
    private Context edicioncon ;
    private ArrayList<com.example.examenparcial.Secciones.Edicion> edicionlist ;
    public RecyclerViewAdaptadorEdicion(Context context, ArrayList<com.example.examenparcial.Secciones.Edicion> edicionListist){
        edicioncon= context;
        edicionlist = edicionlist;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tittle, doi,abstracte,date,urlPDF,urlHTML,keywords,section,autores;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tittle= itemView.findViewById(R.id.txtitle);
            doi= itemView.findViewById(R.id.txtdoi);
            abstracte= itemView.findViewById(R.id.txtDescripcion);
            date= itemView.findViewById(R.id.txtdate);
            autores= itemView.findViewById(R.id.txtautores);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(edicioncon);
        View item = inflater.inflate(R.layout.item_articulos,parent , false);
         return new RecyclerViewAdaptadorEdicion.ViewHolder(item);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tittle.setText(edicionlist.get(position).gettittle());
        holder.doi.setText(edicionlist.get(position).getdoi());
        holder.abstracte.setText(edicionlist.get(position).getabstracte());
        holder.date.setText(edicionlist.get(position).getdate());
        holder.autores.setText(edicionlist.get(position).getautores());
    }

    @Override
    public int getItemCount() {
        return edicionlist.size();
    }


}
