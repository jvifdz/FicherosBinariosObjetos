package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws java.io.IOException, ClassNotFoundException {


        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while(!salir) {

            System.out.println("1. Introducir departamento");
            System.out.println("2. Mostrar departamentos");
            System.out.println("3. Mostrar un departamento especifico");
            System.out.println("4. Salir");

            System.out.println("Escribe una de las opciones");
            opcion = sc.nextInt();
            //creacion fichero binario
            File fichero = new File("Departamentos.dat");
            Departamento departamento;

            switch (opcion) {
                case 1:
                    //escritura
                    FileOutputStream fos = new FileOutputStream (fichero, true);
                    ObjectOutputStream oos = new ObjectOutputStream (fos);

                    //Variables introducir fichero
                    int numDepartamento;
                    String nombre;
                    String localidad;



                    // para que no haya conflicto al introducir con el mismo escaner Strings


                    //Escritura en el fichero
                    System.out.println("Introduzca el numero de departamento");
                    numDepartamento=sc.nextInt();

                    System.out.println("Nombre del departamento");
                    nombre= sc2.nextLine();

                    System.out.println("Localidad del departamento");
                    localidad= sc2.nextLine();
                    System.out.println("Grabo Ficheros");

                    //Añado los nombres de los departamentos en un Array
                    String nombres[]={nombre};
                    String localidades[]={localidad};
                    int numeroDepartamentos[]={numDepartamento};

                    for (int i=0; i<nombres.length; i++) {

                        departamento = new Departamento(nombres[i], localidades[i],numeroDepartamentos[i]);
                        oos.writeObject(departamento);
                        System.out.println("Grabados");

                    }
                    oos.close();

                    break;






                case 2:

                    FileInputStream fis = new FileInputStream(fichero);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    Object aux = ois.readObject();
                    System.out.println("Hola");
                    int i=1;
                    try {
                        System.out.println("Hola2");
                        while (true) { // lectura del fichero
                            System.out.println("Hola22");
                            departamento = (Departamento) ois.readObject(); // leer un departamento
                            System.out.println(i + "=>");
                            i++;
                            System.out.println("Nombre: " + departamento.getNombre() + "Localidad: " + departamento.getLocalidad() + "Numero de departamento: " + departamento.getNumDepartamento());
                        }
                    }catch(IOException io){

                    }finally {
                        ois.close();
                    }
                break;


                case 4:
                    salir=true;
                    break;
                default:
            }
        }









        //lectura fichero


    }
}
