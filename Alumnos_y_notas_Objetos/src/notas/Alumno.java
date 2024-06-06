package notas;

import java.util.Arrays;

public class Alumno {

    //ATRIBUTOS:
    private String nombre;
    private String apellidos;
    private int edad;
    private int[] notas;

    //CONSTRUCTORES:

    public Alumno() {

    }
    public Alumno(String nombre, String apellidos, int edad, int[] notas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.notas = notas;
    }


    //GETTERS:
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public int[] getNotas() {
        return notas;
    }



    //SETTERS:
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setNotas(int[] notas) {
        this.notas = notas;
    }


    //MÉTODOS:
    public void getNotaMedia() {
        int sum = 0;
        int nota_media;

        for (int nota : notas) {
            sum += nota;
        }

        nota_media = sum/notas.length;

        System.out.println("\nLa nota media del alumno es: " + nota_media);
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Apellidos: " + apellidos + "\n" +
                "Edad: " + edad + "\n" +
                "Notas: " + Arrays.toString(notas) + "\n";
    }
}
