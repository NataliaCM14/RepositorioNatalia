import java.util.ArrayList;

public class Liga {

    private String nombre;
    private int numEquipos;
    private ArrayList<Equipo> equipos;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumEquipos() {
        return numEquipos;
    }

    public void setNumEquipos(int numEquipos) {
        this.numEquipos = numEquipos;
    }

    public ArrayList<Equipo> getEquiposDeLaLiga() {
        return equipos;
    }

    public void setEquiposDeLaLiga(ArrayList<Equipo> equiposDeLaLiga) {
        this.equipos = equiposDeLaLiga;
    }

    public Liga(String nombre, int numEquipos) {
        this.nombre = nombre;
        this.numEquipos = numEquipos;
        this.equipos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "LIGA " + nombre + ", número de Equipos: " + numEquipos + ", Equipos participantes: " + equipos;
    }

    public void agregarEquipo(Equipo equipo){
        equipos.add(equipo);
    }
    public void jugarLiga(){

        for (int i = 0; i < equipos.size(); i++) {

            for (int j = i + 1; j < equipos.size(); j++) {  //j = i + 1 para evitar jugar dos veces el mismo partido
                equipos.get(i).jugarPartido(equipos.get(j));
                equipos.get(j).jugarPartido(equipos.get(i));  //Se repite para que un partido cuente para ambos equipos
            }
        }
    }

    public void mostrarResultados() {

        for (Equipo equipo : equipos) {
            System.out.println("'" + equipo.getNombre() + "'");
            System.out.println("Puntos: " + equipo.getPuntos());
            System.out.println("Partidos disputados: " + equipo.getPartidosDisputados());
            System.out.println("Goles a favor: " + equipo.getGolesFavor());
            System.out.println("Goles en contra: " + equipo.getGolesContra());
            System.out.println("------------------------");
        }
    }
}
