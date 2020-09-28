package com.company;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        //variable escritura
        MiObjectOutputStream moos = null;

        //variable lectura
        FileInputStream fis= null;
        ObjectInputStream ois= null;

        while(!salir) {

            System.out.println("1. Introducir departamento");
            System.out.println("2. Mostrar departamentos");
            //System.out.println("3. Mostrar un departamento especifico");
            System.out.println("4. Salir");

            System.out.println("Escribe una de las opciones");
            opcion = sc.nextInt();
            //creacion fichero binario
            File fichero = new File("Departamentos.dat");
            Departamento departamento;

            //declaracion variables escritura


                    switch (opcion) {
                case 1:
                    //flujos de escritura
                    try {



                        //Variables introducir fichero
                        int numDepartamento;
                        String nombre;
                        String localidad;

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

                        if(fichero.exists()){

                            moos=new MiObjectOutputStream(new FileOutputStream(fichero, true));
                            moos.writeObject(departamento);
                            moos.close();
                        }else{
                            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fichero));
                            oos.writeObject(departamento);
                            oos.close();
                        }

                        System.out.println("Grabados");


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    break;






                case 2:
                    try {
                        //flujos de lectura


                        fis = new FileInputStream("Departamentos.dat");
                        ois = new ObjectInputStream(fis);

                    int i=1;
                        while (true) {
                            // lectura del fichero
                            departamento = (Departamento) ois.readObject(); // leer un departamento
                            System.out.println(i + "=>");
                            i++;
                            System.out.println("Nombre: " + departamento.getNombre() + " Localidad: "
                                    + departamento.getLocalidad() + " Numero de departamento: "
                                    + departamento.getNumDepartamento());


                        }

                    }
                    catch(FileNotFoundException ex){
                        System.out.println("File not found");
                    }
                    catch(IOException ex){
                        //System.out.println("io Exception");
                    }
                    catch(ClassNotFoundException ex){
                        System.out.println("Class not found");
                    }finally {

                    }

                    break;





               // case 3:
               //     break;




                case 4:
                    System.out.println("Saliendo");
                    salir=true;
                    break;
                default:
            }
        }
    }
}
