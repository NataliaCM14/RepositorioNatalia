public abstract class Persona {
    protected String nombre, apellidos, fechaNacimiento;
    protected int sueldoAnual;
    protected double motivacion;


    //GETTERS & SETTERS:

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getMotivacion() {
        return motivacion;
    }

    public void setMotivacion(double motivacion) {
        this.motivacion = motivacion;
    }

    public int getSueldoAnual() {
        return sueldoAnual;
    }

    public void setSueldoAnual(int sueldoAnual) {
        this.sueldoAnual = sueldoAnual;
    }


    //CONSTRUCTORES:

    public Persona(String nombre, String apellidos, String fechaNacimiento, int sueldoAnual, double motivacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldoAnual = sueldoAnual;
        this.motivacion = 5.0;
    }

    //MÉTODOS:

    public void mostrarDatos() {
        System.out.println(this.nombre + " " + this.apellidos);
        System.out.println("Cumpleaños: " + this.fechaNacimiento);
        System.out.println("Sueldo anual: " + this.sueldoAnual);
        System.out.println("Motivación: " + this.motivacion);
    }

    public void entrenar(){
        this.motivacion += 0.2;
    }

}
