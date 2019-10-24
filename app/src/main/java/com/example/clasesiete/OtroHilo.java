package com.example.clasesiete;

import android.os.Handler;
import android.os.Message;

import org.json.JSONException;
import org.json.JSONObject;

public class OtroHilo extends Thread {
    private Handler handler;
    private String url;
    private int posicion;

    public OtroHilo(Handler handler, String url, int posicion){
        this.handler = handler;
        this.url = url;
        this.posicion = posicion;
    }

    @Override
    public void run() {
        HttpManager manager = new HttpManager();
        byte[] imagen = manager.obtenerImagen(url);
        Message message = new Message();
        message.obj = new JSONObject();
        try {
            ((JSONObject) message.obj).put("posicion", this.posicion);
            ((JSONObject) message.obj).put("imagen", imagen);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.handler.sendMessage(message);
    }
}
