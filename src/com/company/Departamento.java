package com.company;

import java.io.Serializable;

/**
 * Clase persona con varios datos sobre una persona y su mascota.
 * @author Javier Abellán.
 *
 */
public class Departamento implements Serializable
{
    public String nombre;
    public String localidad;
    public int numDepartamento;


    public Departamento(String nombre, String localidad, int numDepartamento) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.numDepartamento = numDepartamento;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getNumDepartamento() {
        return numDepartamento;
    }

    public void setNumDepartamento(int numDepartamento) {
        this.numDepartamento = numDepartamento;
    }
}