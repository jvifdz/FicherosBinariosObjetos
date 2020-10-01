package com.company;

import java.io.Serializable;

/**
 * Clase Vehiculo
 *
 * Contiene informacion de un vehiculo
 *
 * @author JviFdz
 * @version 1.0
 */
public class Departamento implements Serializable{

    //Atributos

    /**
     * Nombre del departamento
     */
    private String Nombre;

    /**
     * Localidad del departamento
     */
    private String Localidad;


    /**
     * numero del departamento
     */
    private int numDepartamento;

    public Departamento(String nombre, String localidad, int numDepartamento) {
        Nombre = nombre;
        Localidad = localidad;
        this.numDepartamento = numDepartamento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public int getNumDepartamento() {
        return numDepartamento;
    }

    public void setNumDepartamento(int numDepartamento) {
        this.numDepartamento = numDepartamento;
    }
}