package notas;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Alumno> alumnos = new ArrayList<>();
        boolean salir = false;

        do {
            salir = menuPrincipal(alumnos);
        } while (!salir);

    }

    private static boolean menuPrincipal(ArrayList<Alumno> alumnos) {
        Scanner sc = new Scanner(System.in);

        boolean salir = false;

        System.out.println("1. Crear alumno");
        System.out.println("2. Mostrar todos los datos de los alumnos");
        System.out.println("3. Mostrar los datos nombre, apellido y edad de un alumno en concreto");
        System.out.println("4. Mostrar los datos de un alumno en concreto y la media de sus notas");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                Alumno alumno;
                alumno = crearAlumno();
                alumnos.add(alumno);
                break;
            case 2:
                mostrarAlumnos(alumnos);
                break;
            case 3:
                mostrarDatosAlumno(alumnos);
                break;
            case 4:
                mostrarDatosyNotasAlumno(alumnos);
                break;
            case 5:
                System.out.println("Saliendo de la aplicación.");
                salir = true;
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
        }

        return salir;
    }

    private static Alumno crearAlumno() {

        Scanner sc = new Scanner(System.in);
        int[] notas = new int[4];

        System.out.print("Ingrese el nombre del alumno: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese el apellido del alumno: ");
        String apellidos = sc.nextLine();

        System.out.print("Ingrese la edad del alumno: ");
        int edad = sc.nextInt();

        System.out.println("Ingrese las notas del alumno:");
        for (int i = 0; i < 4; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = sc.nextInt();
        }

        Alumno alumno = new Alumno(nombre, apellidos, edad, notas);

        return alumno;
    }


    private static void mostrarAlumnos(ArrayList<Alumno> alumnos) {
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");

        } else {
            System.out.println("\nDatos de todos los alumnos:");

            System.out.println(alumnos);

        }
    }

    private static void mostrarDatosAlumno(ArrayList<Alumno> alumnos) {
        Scanner sc = new Scanner(System.in);

        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            System.out.print("Ingrese el nombre del alumno a buscar: ");
            String nombreBuscar = sc.nextLine();

            boolean encontrado = false;
            for (Alumno alumno : alumnos) {
                if (alumno.getNombre().equalsIgnoreCase(nombreBuscar)) {
                    System.out.println("Nombre: " + alumno.getNombre() +
                            ", Apellido: " + alumno.getApellidos() +
                            ", Edad: " + alumno.getEdad());
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Alumno no encontrado.");
            }
        }
    }

    private static void mostrarDatosyNotasAlumno(ArrayList<Alumno> alumnos) {
        Scanner sc = new Scanner(System.in);

        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");

        } else {
            System.out.print("Ingrese el nombre del alumno a buscar: ");
            String nombreBuscar = sc.nextLine();
            boolean encontrado = false;
            for (Alumno alumno : alumnos) {
                if (alumno.getNombre().equalsIgnoreCase(nombreBuscar)) {
                    System.out.println(alumno);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Alumno no encontrado.");
            }
        }
    }


}