package com.example.clasesiete;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class Parseador {


    public static ArrayList<Persona> parser(String s) {
        ArrayList<Persona> personas = new ArrayList<Persona>();

        XmlPullParser parser = Xml.newPullParser();

        try {
            parser.setInput(new StringReader(s));
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }

        int event = 0;
        try {
            event = parser.getEventType();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        while (event != XmlPullParser.END_DOCUMENT) {
            switch (event) {
                //case XmlPullParser.START_DOCUMENT:
                case XmlPullParser.START_TAG:
                    String tag = parser.getName();

                    if (tag.equals("Persona")) {
                        //String texto = parser.nextText();
                        //next text devuelve toda la info entre los los tags de apertura y cierre,
                        //al menos un string vacio

                        String nombre = parser.getAttributeValue(null, "nombre");
                        String apellido = parser.getAttributeValue(null, "apellido");
                        String telefono = parser.getAttributeValue(null, "tel");
                        String foto = "";
                        try {
                            foto = parser.nextText();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (XmlPullParserException e) {
                            e.printStackTrace();
                        }
                        Log.d("nombre", nombre);
                        Log.d("apellido", apellido);
                        Log.d("telefono", telefono);
                        Log.d("foto", foto);

                        Persona p = new Persona(nombre, apellido, telefono, foto);
                        personas.add(p);
                    }
                    //case XmlPullParser.END_TAG:
            }
            try {
                event = parser.next();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }


        return personas;
    }


}
