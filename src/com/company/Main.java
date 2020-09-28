package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


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
                    try {
                        FileOutputStream fos = new FileOutputStream (fichero, true);
                        ObjectOutputStream oos = new ObjectOutputStream (fos);


                        //Variables introducir fichero
                        int numDepartamento;
                        String nombre;
                        String localidad;


                        // para que no haya conflicto al introducir con el mismo escaner Strings


                        //Escritura en el fichero
                        System.out.println("Introduzca el numero de departamento");
                        numDepartamento = sc.nextInt();

                        System.out.println("Nombre del departamento");
                        nombre = sc2.nextLine();

                        System.out.println("Localidad del departamento");
                        localidad = sc2.nextLine();
                        System.out.println("Grabo Ficheros");
                        //añadir datos al fichero
                        departamento = new Departamento(nombre, localidad, numDepartamento);
                        oos.writeObject(departamento);
                        System.out.println("Grabados");

                        oos.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    break;






                case 2:
                    try {
                    FileInputStream fis = new FileInputStream("Departamentos.dat");
                    ObjectInputStream ois = new ObjectInputStream(fis);

                    int i=1;
                        while (true) { // lectura del fichero
                            departamento = (Departamento) ois.readObject(); // leer un departamento
                            System.out.println(i + "=>");
                            i++;
                            System.out.println("Nombre: " + departamento.getNombre() + " Localidad: " + departamento.getLocalidad() + " Numero de departamento: " + departamento.getNumDepartamento());


                        }

                    }
                    catch(FileNotFoundException ex){
                        System.out.println("File not found");
                    }
                    catch(IOException ex){
                        System.out.println("io Exception");
                    }
                    catch(ClassNotFoundException ex){
                        System.out.println("Class not found");
                    }

                break;





                case 4:
                    System.out.println("Saliendo");
                    salir=true;
                    break;
                default:
            }
        }









        //lectura fichero


    }
}
