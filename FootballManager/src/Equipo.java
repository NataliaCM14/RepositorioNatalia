import java.util.ArrayList;

public class Equipo implements Comparable<Equipo>{
    private static int nextId = 1;
    private String nombre, ciudad, presidente;
    private int id, anioFundacion, puntos, partidosDisputados, golesFavor, golesContra;
    private Entrenador entrenador;
    private ArrayList<Jugador> jugadores;


    public Equipo(int id, String nombre, String ciudad, String presidente, int anioFundacion) {
        this.id = nextId++;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.presidente = presidente;
        this.anioFundacion = anioFundacion;
        this.entrenador = null;
        this.jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPresidente() {
        return presidente;
    }

    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores_del_equipo) {
        this.jugadores = jugadores_del_equipo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartidosDisputados() {
        return partidosDisputados;
    }

    public void setPartidosDisputados(int partidosDisputados) {
        this.partidosDisputados = partidosDisputados;
    }

    public int getGolesFavor() {
        return golesFavor;
    }

    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    public int getGolesContra() {
        return golesContra;
    }

    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    @Override
    public String toString() {
        return "'" + nombre + "': Ciudad: " + ciudad + ", Presidente: " + presidente + ", Año de fundación: " + anioFundacion + ", Entrenador: " + entrenador + ", Jugadores: " + jugadores ;
    }

    public void mostrarDatosEquipo() {
        System.out.println("'" + this.nombre + "'");
        System.out.println("Ciudad: " + this.ciudad);
        System.out.println("Presidente: " + this.presidente);
        System.out.println("Año de fundación: " + this.anioFundacion);
        System.out.println("Entrenador: " + this.entrenador);
        System.out.println("Jugadores:");
        for (Jugador jugador : this.jugadores) {
            System.out.println(jugador) ;
        }
        System.out.println("------------------");
    }

    public boolean quitarJugador(Jugador jugador) {
        return jugadores.remove(jugador);
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public double calcularCalidadMedia() {
        double sumaCalidades = 0.0;

        if (jugadores.isEmpty()) { //Si un equipo no tiene jugadores, se devuelve la calidad como 0
            return 0.0;
        }

        for (Jugador jugador : jugadores) {
            sumaCalidades += jugador.getCalidad(); //Se suma la calidad de todos los jugadores del equipo
        }

        return (double) sumaCalidades / jugadores.size(); //Se devuelve la suma de todas las calidades dividida por el número de jugadores
    }


    public void jugarPartido(Equipo rival) {
        int golesLocal = 0;
        int golesVisitante = 0;

        //goles para el equipo local:
        for (Jugador jugador : jugadores) {
            golesLocal += jugador.generarGol();
        }
        //goles para el equipo contrario:
        for (Jugador jugador : rival.jugadores) {
            golesVisitante += jugador.generarGol();
        }

        //suma de los partidos disputados:
        partidosDisputados++;

        //total de puntos dependiendo de si se gana, se empata o se pierde:
        if (golesLocal > golesVisitante) {
            puntos += 3;
        } else if (golesLocal == golesVisitante) {
            puntos += 1;
        }

        golesFavor += golesLocal;
        golesContra += golesVisitante;
    }

        @Override
        public int compareTo(Equipo o) {
            return 0;
        }
    {
}
}
