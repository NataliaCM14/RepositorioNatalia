import java.util.Comparator;
import java.util.Random;
public class Jugador extends Persona implements Transferible, Comparable<Jugador> {
    private static int nextId = 1;
    private int id, dorsal;
    private double calidad;
    private String posicion;


    //GETTERS & SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCalidad() {
        return calidad;
    }

    public void setCalidad(double calidad) {
        this.calidad = calidad;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }


    //CONSTRUCTORES

    public Jugador(String nombre, String apellidos, String fechaNacimiento, int sueldoAnual, double motivacion, int id, int dorsal, double calidad, String posicion) {
        super(nombre, apellidos, fechaNacimiento, sueldoAnual, motivacion);
        this.id = nextId++;
        this.dorsal = dorsal;
        this.calidad = generarCalidadRandom();
        this.posicion = posicion;
    }

    //MÉTODOS
    private int generarCalidadRandom() {
        Random random = new Random();
        return random.nextInt(71) + 30;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + nombre + " " + apellidos + ", Cumpleaños: " + fechaNacimiento + ", Nivel de motivación: " + motivacion + ", Sueldo anual: " + sueldoAnual + ", Calidad: " + calidad + ", Dorsal: " + dorsal + ", Posición: " + posicion;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Jugador:");
        System.out.println("ID: " + this.id);
        super.mostrarDatos();
        System.out.println("Dorsal: " + this.dorsal);
        System.out.println("Calidad: " + this.calidad);
        System.out.println("Posición: " + this.posicion);
        System.out.println("------------------");
    }

    @Override
    public void entrenar() {
        super.entrenar();

        Random random = new Random();
        double probabilidad = random.nextDouble(); //Se genera una probabilidad en double entre 0.0 (mínimo) y 1.0 (máximo)

        if(probabilidad < 0.7) {
            this.calidad += 0.1;
        } else if (probabilidad < 0.9) {
            this.calidad += 0.2;
        } else {
            calidad += 0.3;
        }

        System.out.println("La calidad de " + this.nombre + " " + this.apellidos + " ha aumentado a " + calidad);
    }

    public void cambiarPosicion() {

        Random random1 = new Random();
        String[] posiciones = {"POR", "DEF", "MED", "DEL"};
        boolean cambioPosicion = false;

        if (random1.nextDouble() < 0.05) { //Se comprueba si se cumple el 5% de posibilidad de cambiar de posición
            Random random2 = new Random();
            int indice = random2.nextInt(posiciones.length); //Se genera un número random entre las posiciones del array de posiciones (4)
            posicion = posiciones[indice]; //Se utiliza el nombre escogido para asignar una posición del array
            cambioPosicion = true;
        }

        this.calidad += 1.0;

        if (cambioPosicion) {
            System.out.println("Su posición ha cambiado a " + this.posicion + " y su calidad a aumentado a " + this.calidad + " puntos.\n");
        } else {
            System.out.println("Su posición no ha cambiado y su calidad a aumentado a " + this.calidad + " puntos.\n");
        }

    }

    public int generarGol() {
        int maxGolesPorJugador = 5;

        int golesGenerados = (int) (Math.random() * this.calidad); //Se genera un número de goles random y se multiplica por la calidad del jugador
        return Math.min(golesGenerados, maxGolesPorJugador); //Se limita el máx. de goles por jugador a 5
    }

    @Override
    public boolean esTransferible() {
        return this.motivacion >= 4;
    }

    @Override
    public void transferirAEquipo(Equipo equipoDestino, Equipo equipoOrigen) {
        if (esTransferible()) {
            if (equipoOrigen.quitarJugador(this)) {
                equipoDestino.agregarJugador(this);
                System.out.println(this.nombre + " fue transferido al equipo " + equipoDestino.getNombre());
            } else {
                System.out.println("El jugador no pertenece a este equipo.");
            }
        } else {
            System.out.println("El jugador no puede ser transferido si su motivación está por debajo de 60 puntos");
        }
    }

    @Override
    public int compareTo(Jugador o) {
        return this.apellidos.compareTo(o.apellidos);
    }
}
