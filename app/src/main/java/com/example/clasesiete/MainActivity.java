package com.example.clasesiete;

import android.app.Person;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    public static List<Persona> personas;

    PersonaAdapter adapter;
    RecyclerView rv;

    Handler handlerPersonas;
    Handler handlerImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personas = new ArrayList<Persona>();
        for(int i=0;i<5;i++){
            Persona p = new Persona("Juan"+ i, "Perez" + i, "654654654", "image");
            personas.add(p);
        }

        this.rv = this.findViewById(R.id.rv);
        this.adapter = new PersonaAdapter(personas, this);
        rv.setAdapter(adapter);

        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);


        this.handlerPersonas = new Handler(this);
        MiHilo miHilo  = new MiHilo(this.handlerPersonas);
        miHilo.start(); // -> Se lanza en paralelo


    }

    public void buscarImagen(String url, int posicion){
        this.handlerImagen = new Handler(this);
        OtroHilo otroHilo  = new OtroHilo(this.handlerImagen, url, posicion);
        otroHilo.start(); // -> Se lanza en paralelo
    }

    @Override
    public boolean handleMessage(@NonNull Message message) {
        if(message.getTarget() == this.handlerPersonas){
            personas = (ArrayList<Persona>) message.obj;

            //this.adapter.notifyDataSetChanged();
            String personasString = "";
            if(personas != null){
                for(int i=0; i<personas.size(); i++){
                    Log.d("persona", personas.get(i).toString());
                    personasString += " " + personas.get(i).toString();
                    /*
                      TODO
                     * esto no va acá sino en el bind del view holder
                     * cada holder debe crear un hilo.
                     * En el recycle view, si ya tomamos la foto la guardamos en una variable,
                     * si esa variable está cargada consumimos esa variable
                    */
                    buscarImagen(personas.get(i).getFoto(), i);
                }

            }
        } else {
            JSONObject obj = (JSONObject) message.obj;
            byte[] byteArray = new byte[0];
            try {
                Log.d("imagen", obj.get("imagen").toString());
                byteArray = (byte[]) obj.get("imagen");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if(byteArray != null) {
                Bitmap imagen = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            }
        }


        return false;
    }
}
