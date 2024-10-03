public class Entrenador extends Persona{

    private static int nextId = 1;
    private int id, numTorneosGanados;
    private boolean selecNacional;


    //GETTERS & SETTERS:

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumTorneosGanados() {
        return numTorneosGanados;
    }

    public void setNumTorneosGanados(int numTorneosGanados) {
        this.numTorneosGanados = numTorneosGanados;
    }

    public boolean isSelecNacional() {
        return selecNacional;
    }

    public void setSelecNacional(boolean selecNacional) {
        this.selecNacional = selecNacional;
    }


    //CONSTRUCTORES:

    public Entrenador(String nombre, String apellidos, String fechaNacimiento, int sueldoAnual, double motivacion, int id, int numTorneosGanados, boolean selecNacional) {
        super(nombre, apellidos, fechaNacimiento, sueldoAnual, motivacion);
        this.id = nextId++;
        this.numTorneosGanados = numTorneosGanados;
        this.selecNacional = selecNacional;
    }


    //MÉTODOS

    @Override
    public String toString() {
        return "ID: " + id + ", " + nombre + " " + apellidos + ", Cumpleaños: " + fechaNacimiento + ", Nivel de motivación: " + motivacion + ", Sueldo anual: " + sueldoAnual + ", Torneos ganados: " + numTorneosGanados + ", Seleccionador Nacional: " + selecNacional;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Entrenador:");
        System.out.println("ID: " + this.id);
        super.mostrarDatos();
        System.out.println("Torneos ganados: " + this.numTorneosGanados);
        System.out.println("Seleccionador nacional: " + this.selecNacional);
        System.out.println("------------------");
    }

    @Override
    public void entrenar() {
        if (this.selecNacional) {  //Si es seleccionador nacional se aumenta por 0.3
            this.motivacion += 0.3;
        } else {
            this.motivacion += 0.15;
        }

        System.out.println("La motivación del entrenador " + this.nombre + " " + this.apellidos + " ha aumentado a " + this.motivacion + " puntos.");
    }

    public void incrementarSueldo() {
        double aumento = this.sueldoAnual * 0.0005; //Se incrementa el sueldo por 0,5% del actual
        this.sueldoAnual += aumento;
        System.out.println("Su sueldo ha aumentado a " + this.sueldoAnual + " de yenes.\n");
    }

}
