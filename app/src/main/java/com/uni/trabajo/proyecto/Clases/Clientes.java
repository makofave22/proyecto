package com.uni.trabajo.proyecto.Clases;

/**
 * Created by Makofave on 25/04/2018.
 */

public class Clientes
{
    private String id,nombre,apellido,direccion,correo;

    public Clientes() {
        this.id = "";
        this.nombre = "";
        this.apellido="";
        this.direccion="";
        this.correo="";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo= correo;
    }

    @Override
    public String toString() {
        return
                "id='" + id + '\'' +
                "\n nombre='" + nombre + '\'' +
                "\n apellido='" + apellido + '\'' +
                "\n direccion='" + direccion + '\'' +
                "\n correo='" + correo + '\''+"\n \n";
    }
}
