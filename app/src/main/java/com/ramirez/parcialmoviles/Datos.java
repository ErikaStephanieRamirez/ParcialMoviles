package com.ramirez.parcialmoviles;

import android.net.Uri;

import java.io.Serializable;

/**
 * Created by Karla on 29/04/2018.
 */

public class Datos implements Serializable {
    private String ID, nombre, numero, direccion, correo, cumple;
    private Uri img;

    public Datos() {
    }

    public Datos(String ID, String nombre, String numero, String direccion, String correo, String cumple, Uri img) {
        this.ID = ID;
        this.nombre = nombre;
        this.numero = numero;
        this.direccion = direccion;
        this.correo = correo;
        this.cumple = cumple;
        this.img = img;
    }


    public Datos(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCumple() {
        return cumple;
    }

    public void setCumple(String cumple) {
        this.cumple = cumple;
    }

    public Datos(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Uri getImg() {
        return img;
    }

    public void setImg(Uri img) {
        this.img = img;
    }
}
