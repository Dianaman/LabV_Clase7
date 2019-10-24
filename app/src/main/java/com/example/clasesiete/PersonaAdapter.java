package com.example.clasesiete;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaHolder> {
    private MainActivity activity;
    private List<Persona> personas;

    public PersonaAdapter(List<Persona> personas, MainActivity activity) {
        this.activity = activity;
        this.personas = personas;
    }

    @NonNull
    @Override
    public PersonaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.persona, parent, false);
        PersonaHolder holder = new PersonaHolder(v, this.activity);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull PersonaHolder holder, int position) {
        Persona p = this.personas.get(position);
        holder.tvApellido.setText(p.getApellido());
        holder.tvNombre.setText(p.getNombre());
        holder.tvTelefono.setText(p.getTelefono());
        holder.setPosicion(position);
    }

    @Override
    public int getItemCount() {
        return this.personas.size();
    }
}
