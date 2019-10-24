package com.example.clasesiete;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonaHolder extends RecyclerView.ViewHolder {
    private MainActivity activity;
    private int posicion;
    public TextView tvNombre;
    public TextView tvApellido;
    public TextView tvTelefono;
    public ImageView ivFoto;
    public String url;

    public PersonaHolder(@NonNull View itemView, MainActivity activity) {
        super(itemView);

        this.activity = activity;

        this.tvNombre = itemView.findViewById(R.id.tvNombre);
        this.tvApellido = itemView.findViewById(R.id.tvApellido);
        this.tvTelefono = itemView.findViewById(R.id.tvTelefono);



    }

    public void setPosicion(int posicion){
        this.posicion = posicion;
    }
}
