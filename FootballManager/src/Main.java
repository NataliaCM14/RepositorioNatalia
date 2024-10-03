import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList <Persona> personas = new ArrayList<>();
        ArrayList <Equipo> equipos = new ArrayList<>();

        //Entrenadores:
        Entrenador e1 = new Entrenador("Seymour","Hillman", "4 de febrero",5616722,5.0,0,3,true);
        Entrenador e2 = new Entrenador("Ray","Dark", "20 de mayo",6669758,5.0,0,8,true);
        Entrenador e3 = new Entrenador("Takayama","Snow", "10 de enero",6385893,5.0,0,8,false);

        //Otros entrenadores disponibles para asignar por el usuario desde el array de personas:
        personas.add(new Entrenador("Takayama","Snow", "10 de enero",6385893,5.0,0,8,false));
        personas.add(new Entrenador("Astero","Black", "24 de julio",7893402,5.0,0,8,false));

        //Jugadores del Raimon:
        Jugador j1 = new Jugador("Mark","Evans","22 de agosto",0,5.0,0,1,0.0,"POR");
        Jugador j2 = new Jugador("Nathan","Swift","1 de febrero",0,5.0,0,2,0.0,"DEF");
        Jugador j3 = new Jugador("Jack","Wallside","28 de julio",0,5.0,0,3,0.0,"DEF");
        Jugador j4 = new Jugador("Jim","Wraith","28 de julio",0,5.0,0,4,0.0,"DEF");
        Jugador j5 = new Jugador("Tod","Ironside","28 de julio",0,5.0,0,5,0.0,"DEF");

        //Jugadores de la Royal Academy:
        Jugador j6 = new Jugador("Joseph","King","14 de abril",0,5.0,0,1,0.0,"POR");
        Jugador j7 = new Jugador("Peter","Drent","11 de febrero",0,5.0,0,2,0.0,"DEF");
        Jugador j8 = new Jugador("Ben","Simmons","9 de marzo",0,5.0,0,3,0.0,"DEF");
        Jugador j9 = new Jugador("Alan","Master","7 de febrero",0,5.0,0,4,0.0,"DEF");
        Jugador j10 = new Jugador("Jude","Sharp","14 de abril",0,5.0,0,5,0.0,"MED");

        //Jugadores del Instituto Alpino:
        Jugador j11 = new Jugador("Shawn","Froste","22 de diciembre",0,5.0,0,9,0.0,"DEL");
        Jugador j12 = new Jugador("Aiden","Froste","22 de febrero",0,5.0,0,17,0.0,"DEL");
        Jugador j13 = new Jugador("Adam","Ropes","10 de julio",0,5.0,0,1,0.0,"POR");
        Jugador j14 = new Jugador("Milton","Bindings","4 de marzo",0,5.0,0,3,0.0,"DEF");
        Jugador j15 = new Jugador("Maddox","Rock","12 de octubre",0,5.0,0,7,0.0,"MED");

        //Otros jugadores disponibles para fichar por el usuario desde el array de personas:
        personas.add(new Jugador("Axel","Blaze","30 de mayo",0,5.0,0,10,0.0,"DEL"));
        personas.add(new Jugador("Erik","Eagle","1 de enero",0,5.0,0,16,0.0,"MED"));
        personas.add(new Jugador("Byron","Love","17 de mayo",0,5.0,0,10,0.0,"MED"));

        //Equipos:
        Equipo equipo1 = new Equipo(0, "Raimon","Tokio","Sonny Raimon",1980);
        Equipo equipo2 = new Equipo(0, "Royal Academy","Tokio","Stephen Black",1970);
        Equipo equipo3 = new Equipo(0,"Instituto Alpino","Sapporo","Alpine Hakuren",1960);

        //Adición de los equipos al ArrayList de equipos:
        equipos.add(equipo1);
        equipos.add(equipo2);
        equipos.add(equipo3);

        //Otros equipos disponibles en el arraylist de equipos:
        equipos.add(new Equipo(0,"Génesis","Yokohama","Gaia Alien",1950));
        equipos.add(new Equipo(0,"Epsilon","Yokohama","Venus Planetaria",1960));

        //Asignación de los entrenadores a los tres primeros equipos creados:
        equipo1.setEntrenador(e1);
        equipo2.setEntrenador(e2);
        equipo3.setEntrenador(e3);

        //Asignación de los jugadores a los tres primeros equipos creados:
        equipo1.agregarJugador(j1);
        equipo1.agregarJugador(j2);
        equipo1.agregarJugador(j3);
        equipo1.agregarJugador(j4);
        equipo1.agregarJugador(j5);

        equipo2.agregarJugador(j6);
        equipo2.agregarJugador(j7);
        equipo2.agregarJugador(j8);
        equipo2.agregarJugador(j9);
        equipo2.agregarJugador(j10);

        equipo3.agregarJugador(j11);
        equipo3.agregarJugador(j12);
        equipo3.agregarJugador(j13);
        equipo3.agregarJugador(j14);
        equipo3.agregarJugador(j15);


        //Aplicación:
        boolean exit;
        do {
            exit = mainMenu(personas, equipos);
        }while(!exit);

    }
    private static boolean mainMenu(ArrayList<Persona> personas, ArrayList<Equipo> equipos) {
        Scanner scan = new Scanner(System.in);
        boolean exit = false;
        int option;

        System.out.println("\n☆★ ︎Politècnics Football Manager ︎★☆");
        System.out.println("1- Ver clasificación de la Liga");
        System.out.println("2- Gestionar equipo");
        System.out.println("3- Dar de alta a un equipo");
        System.out.println("4- Dar de alta a un jugador o entrenador");
        System.out.println("5- Consultar datos de un equipo");
        System.out.println("6- Consultar datos de un jugador");
        System.out.println("7- Disputar una nueva liga");
        System.out.println("8- Realizar sesión de entrenamiento");
        System.out.println("9- Cargar datos de un equipo");
        System.out.println("10- Guardar datos de un equipo");
        System.out.println("11- Cargar mercado de fichajes");
        System.out.println("0- Salir");

        option = scan.nextInt();

        switch(option){
            case 0:
                System.out.println("Saliendo de la aplicación...");
                exit = true;
                break;
            case 1:
                System.out.println("Viendo clasificación de la liga...");
                break;
            case 2:
                gestionEquipo(personas, equipos);
                break;
            case 3:
                altaEquipo(equipos);
                break;
            case 4:
                altaPersona(personas);
                break;
            case 5:
                consultarEquipo(equipos);
                break;
            case 6:
                consultarJugador(personas, equipos);
                break;
            case 7:
                crearLiga(equipos);
                break;
            case 8:
                entrenamiento(personas, equipos);
                break;
            case 9:
                System.out.println("Cargando datos de un equipo...");
                break;
            case 10:
                System.out.println("Guardando datos de un equipo...");
                break;
            case 11:
                mercadoDeFichajes(personas);
                break;
        }

        return exit;
    }


    private static void gestionEquipo(ArrayList<Persona> personas, ArrayList<Equipo> equipos) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el nombre del equipo:");
        String nombre;
        nombre = scan.nextLine();

        Equipo equipoEncontrado = buscarEquipo(equipos, nombre); //El resultado del método 'buscarEquipo' se guardará como objeto en equipoEncontrado
        //El buscarEquipo lo hago por separado porque este mismo método de comprobar que un equipo existe se reutiliza en otros métodos a parte de gestionEquipo

        if (equipoEncontrado != null) { //Si se encontró el equipo, es decir, si equipoEncontrado no está null, nos lleva al submenú de gestionar equipos
            submenuGestionEquipo(personas, equipos, nombre, equipoEncontrado);
        } else {
            System.out.println("Equipo no encontrado.\n");
        }
    }

    private static Equipo buscarEquipo(ArrayList<Equipo> equipos, String nombre) {

        for (Equipo equipo : equipos) {
            if (equipo.getNombre().equals(nombre)) {
                return equipo;  //Si el equipo es encontrado recorriendo el array de equipos es devuelto y guardado en el objeto equipoEncontrado
            }
        }
        return null;  //Si el equipo no es encontrado se devuelve en null
    }

    private static void submenuGestionEquipo(ArrayList<Persona> personas, ArrayList<Equipo> equipos, String nombre, Equipo equipoEncontrado) {
        Scanner scan = new Scanner(System.in);

        System.out.println("1- Dar de baja el equipo");
        System.out.println("2- Modificar presidente");
        System.out.println("3- Destituir entrenador");
        System.out.println("4- Fichar jugador o entrenador");
        System.out.println("5- Transferir jugador");
        System.out.println("0- Volver al menú principal");

        int option2 = scan.nextInt();

        switch (option2) {
            case 0:
                mainMenu(personas, equipos);
                break;
            case 1:
                borrarEquipo(personas, equipos, nombre, equipoEncontrado);
                break;
            case 2:
                modificarPresidente(equipoEncontrado);
                break;
            case 3:
                destituirEntrenador(personas, equipoEncontrado);
                break;
            case 4:
                decidirFicharJugadorOEntrenador(personas, equipoEncontrado);
                break;
            case 5:
                transferirJugador(equipos, equipoEncontrado);
                break;
        }
    }

    ///////////// MÉTODOS DEL SUBMENÚ GESTIONAR EQUIPO /////////////
    private static void borrarEquipo(ArrayList<Persona> personas, ArrayList<Equipo> equipos, String nombre, Equipo equipoEncontrado) {
        Scanner scan = new Scanner(System.in);
        boolean exit;
        Equipo equipoBorrado = null;

        do {
            exit = false;
            System.out.println("¿Seguro que quieres borrar el equipo?");
            System.out.println("1. Sí");
            System.out.println("2. Cancelar");
            int respuesta = scan.nextInt();

            if (respuesta == 1) {
                System.out.println("Borrando el equipo...");

                //Sistema para borrar el equipo:
                for (Equipo equipo : equipos) {
                    if (Objects.equals(equipo.getNombre(), nombre)) { //Se busca un objeto en el array de equipos que tenga el mismo nombre que el equipo introducido
                        equipoBorrado = equipo; //Si lo encuentra, traslada sus datos a equipoBorrado, que es un objeto que empieza como null
                        exit = true;
                    }
                }
            } else if (respuesta == 2) {
                submenuGestionEquipo(personas, equipos, nombre, equipoEncontrado); //Si le da a Cancelar, se vuelve al submenú
                exit = true;
            } else {
                System.out.println("Opción incorrecta. Inténtalo de nuevo."); //Por si se introduce una opción que no existe, se repite el do while
            }
        } while (!exit);

        if (equipoBorrado != null) { //Si el equipo fue encontrado, equipoBorrado no estará en null. Si no fue encontrado, seguirá en null
            equipos.remove(equipoBorrado); //Por lo tanto, si no está en null, se borra con remove()
            System.out.println("Equipo borrado con éxito.");

            System.out.println("Equipos actuales:");
            for (Equipo equipo: equipos) {
                equipo.mostrarDatosEquipo();
            }
        }

    }

    private static void modificarPresidente(Equipo equipoEncontrado) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce el nombre del nuevo presidente: ");
        String nuevoPresidente = scan.nextLine();

        if (Objects.equals(equipoEncontrado.getPresidente(), nuevoPresidente)) { //Si el presidente del equipo elegido es el mismo que el introducido:
            System.out.println("Esta persona ya es el presidente del equipo.");
        } else { //Si no es así, se asigna el introducido como el nuevo presidente:
            equipoEncontrado.setPresidente(nuevoPresidente);
            System.out.println("El nuevo presidente ha sido asignado.");
            System.out.println(equipoEncontrado);
        }

    }

    private static void destituirEntrenador(ArrayList<Persona> personas, Equipo equipoEncontrado) {
        Scanner scan = new Scanner(System.in);
        boolean exit;

        do {
            exit = false;
            System.out.println("¿Seguro que quieres destituir al entrenador?");
            System.out.println("1. Sí");
            System.out.println("2. Cancelar");
            int respuesta = scan.nextInt();

            if (respuesta == 1) {
                personas.add(equipoEncontrado.getEntrenador()); //Se traslada/devuelve el entrenador del equipo elegido al array de personas
                equipoEncontrado.setEntrenador(null);
                System.out.println("Entrenador destituido.");
                equipoEncontrado.mostrarDatosEquipo();
                exit = true;
            } else if (respuesta == 2) { //Si se da a cancelar, volvemos al menú
                exit = true;
            } else {
                System.out.println("Opción incorrecta. Inténtalo de nuevo.");
            }
        } while (!exit);

    }

    private static void decidirFicharJugadorOEntrenador(ArrayList<Persona> personas, Equipo equipoEncontrado) {
        Scanner scan = new Scanner(System.in);
        boolean exit;

        do {
            exit = false;
            System.out.println("\n¿Quieres fichar a un jugador o a un entrenador?");
            System.out.println("1. Jugador");
            System.out.println("2. Entrenador");
            System.out.println("3. Cancelar");
            int respuesta = scan.nextInt();

            if (respuesta == 1) {
                exit = ficharJugador(personas, equipoEncontrado);

            } else if (respuesta == 2) {
                exit = ficharEntrenador(personas, equipoEncontrado);

            } else if (respuesta == 3) {
                exit = true;

            } else {
                System.out.println("Opción incorrecta. Inténtalo de nuevo.");
            }

        } while (!exit);

    }

    private static boolean ficharJugador(ArrayList<Persona> personas, Equipo equipoEncontrado) {
        Scanner scan = new Scanner(System.in);
        boolean encontrado = false;
        int id;
        int index = -1;
        /*index se utilizará para guardar el índice del jugador que se quiere fichar en la lista de personas
        para luego poder eliminarlo de esa lista, después de haberlo añadido al array de jugadores del equipo.
        Lo inicializamos como -1 porque es un número no válido en un array, para marcar que no ha sido encontrado todavía.*/

        System.out.println("Jugadores disponibles para fichar:");
        for (Persona persona : personas) {
            if (persona instanceof Jugador) { //instanceof para hacer sout de solo las personas de tipo Jugador
                System.out.println(persona);
            }
        }

        System.out.println("Introduce el ID del jugador a fichar: ");
        id = scan.nextInt();

        for (int i = 0; i < personas.size(); i++) { //utilizamos un loop for i para poder utilizar la variable i junto con la variable index

            Persona persona = personas.get(i); //obtiene el objeto Persona en la posición i, la cual cambia de posición cada vez que hace el loop

            if (persona instanceof Jugador && ((Jugador) persona).getId() == id) { //se verifica si el objeto Persona es de tipo Jugador y si su ID coincide con el ID proporcionado.

                equipoEncontrado.agregarJugador((Jugador) persona); //Cuando la condición if se cumple, el jugador se guarda en el array de jugadores del equipo escogido
                index = i; //También se asigna la posición del jugador en cuestión a la variable index
                encontrado = true; //se marca que el jugador fue encontrado (y asignado a un equipo)
            }
        }

        if (encontrado) { //si el jugador fue encontrado...
            personas.remove(index);  //...se elimina el jugador del array de personas en la posición index que se guardó y se muestran los resultados
            System.out.println("Jugador fichado correctamente.");
            System.out.println("Equipo actual:");
            System.out.println(equipoEncontrado);

            System.out.println("\nJugadores disponibles para fichar ahora:");
            for (Persona p : personas) {
                if (p instanceof Jugador) {
                    System.out.println(p);
                }
            }
        } else { //si el jugador no fue encontrado:
            System.out.println("No hay ningún jugador con ese ID.");
        }


        return encontrado; //si se devuelve true hacemos que el loop del método anterior (ficharJugadorEntrenador) termine y nos devuelva al menú principal.
        //si se devuelve false hacemos que el loop del método anterior se repita
    }

    private static boolean ficharEntrenador(ArrayList<Persona> personas, Equipo equipoEncontrado) {
        Scanner scan = new Scanner(System.in);
        boolean encontrado = false;
        int id;
        int index = -1;

        System.out.println("Entrenadores disponibles para fichar:");
        for (Persona persona : personas) {
            if (persona instanceof Entrenador) {
                System.out.println(persona);
            }
        }

        System.out.println("Introduce el ID del entrenador a fichar: ");
        id = scan.nextInt();

        for (int i = 0; i < personas.size(); i++) {
            Persona persona = personas.get(i);
            if (persona instanceof Entrenador && ((Entrenador) persona).getId() == id) {
                equipoEncontrado.setEntrenador((Entrenador) persona);
                index = i;
                encontrado = true;
            }
        }

        if (encontrado) {
            personas.remove(index);
            System.out.println("︎Entrenador fichado correctamente.");
            System.out.println("Equipo actual:");
            System.out.println(equipoEncontrado);

            System.out.println("\nEntrenadores disponibles para fichar ahora:");
            for (Persona p : personas) {
                if (p instanceof Entrenador) {
                    System.out.println(p);
                }
            }
        } else {
            System.out.println("No hay ningún entrenador con ese ID.");
        }

        return encontrado;
    }

    private static void transferirJugador(ArrayList<Equipo> equipos, Equipo equipoEncontrado) {
        Scanner scan = new Scanner(System.in);
        Equipo equipoDestino = null;

        System.out.println("Jugadores del equipo:");
        for (Jugador jugador : equipoEncontrado.getJugadores()) {
            System.out.println("ID: " + jugador.getId() + " " + jugador.getNombre() + " " + jugador.getApellidos());
        }

        System.out.println("Seleccione el ID del jugador que quiere transferir:");
        int idJugador = scan.nextInt();
        scan.nextLine();

        Jugador jugadorSeleccionado = null;
        for (Jugador jugador : equipoEncontrado.getJugadores()) {
            if (jugador.getId() == idJugador) {
                jugadorSeleccionado = jugador;
            }
        }

        if (jugadorSeleccionado != null && jugadorSeleccionado.esTransferible()) {
            System.out.println("Introduce el nombre del equipo al que quiere transferir al jugador:");
            String nombre = scan.nextLine();

            for (Equipo equipo : equipos) {
                if (Objects.equals(equipo.getNombre(), nombre)) {
                    equipoDestino = equipo;
                }
            }

            if (equipoDestino != null) {
                jugadorSeleccionado.transferirAEquipo(equipoDestino, equipoEncontrado);
            } else {
                System.out.println("Equipo de destino no encontrado.");
            }

        } else {
            System.out.println("El jugador seleccionado no es transferible o no existe.");
        }
    }
    /////////////////////////Fin de los métodos del submenú Gestionar Equipo/////////////////////////

    private static void altaEquipo(ArrayList<Equipo> equipos) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce los datos del equipo:");
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();

        Equipo equipoEncontrado = buscarEquipo(equipos, nombre);

        if (equipoEncontrado != null) {
            System.out.println("El equipo ya existe.");
            altaEquipo(equipos);
        } else {
            System.out.print("Ciudad: ");
            String ciudad = scan.nextLine();

            System.out.print("Presidente: ");
            String presidente = scan.nextLine();

            System.out.print("Año de fundación: ");
            int anioFundacion = scan.nextInt();

            Equipo equipo = new Equipo(0, nombre, ciudad, presidente, anioFundacion);
            equipos.add(equipo);

            System.out.println("El equipo fue añadido con éxito.\n");
            equipo.mostrarDatosEquipo();
        }

    }

    private static void altaPersona(ArrayList<Persona> personas) {
        Scanner scan = new Scanner(System.in);
        int option;
        System.out.println("Quieres dar de alta a un jugador o a un entrenador?");
        System.out.println("1- Dar de alta a un jugador");
        System.out.println("2- Dar de alta a un entrenador");

        option = scan.nextInt();
        scan.nextLine();

        System.out.println("Introduce los datos:");
        System.out.print("Nombre: ");
        String nombre = scan.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = scan.nextLine();

        System.out.print("Cumpleaños: (Introducir como: '<día> de <mes>') ");
        String fechaNacimiento = scan.nextLine();

        System.out.print("Sueldo anual: ");
        int sueldo = scan.nextInt();
        scan.nextLine();

        if (option == 1) {

            System.out.print("Dorsal: ");
            int dorsal = scan.nextInt();
            scan.nextLine();

            System.out.print("Posición: (Introducir: POR, DEF, MED o DEL) ");
            String posicion = scan.nextLine();

            Jugador jugador = new Jugador(nombre, apellidos, fechaNacimiento, 5, sueldo, 0, 0, dorsal, posicion);
            personas.add(jugador);
            System.out.println("\nEl jugador fue añadido con éxito.\n");

            jugador.mostrarDatos();

        } else if (option == 2) {

            System.out.print("Seleccionador nacional: (Introducir como 'true' o 'false') ");
            String seleccionador = scan.nextLine();
            boolean selecNacional = Boolean.parseBoolean(seleccionador);

            Entrenador entrenador = new Entrenador(nombre, apellidos, fechaNacimiento, 5, sueldo, 0, 0, selecNacional);
            personas.add(entrenador);
            System.out.println("\nEl entrenador fue añadido con éxito.\n");

            entrenador.mostrarDatos();
        }
    }

    private static void consultarEquipo(ArrayList<Equipo> equipos) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el nombre del equipo a consultar: ");
        String nombre;
        nombre = scan.nextLine();

        Equipo equipoEncontrado = buscarEquipo(equipos, nombre);

        if (equipoEncontrado != null) {
            equipoEncontrado.mostrarDatosEquipo();
        } else {
            System.out.println("Equipo no encontrado.\n");
        }
    }

    private static void consultarJugador(ArrayList<Persona> personas, ArrayList<Equipo> equipos) {
        Scanner scan = new Scanner(System.in);
        String nombreJugador;
        int dorsal;
        boolean jugadorEncontrado = false;

        System.out.println("De qué equipo forma parte el jugador a consultar?");
        System.out.print("Nombre del equipo: ");
        String nombre = scan.nextLine();

        Equipo equipoEncontrado = buscarEquipo(equipos, nombre);

        if (equipoEncontrado != null) {
            System.out.print("Introduce el nombre del jugador a consultar: ");
            nombreJugador = scan.nextLine();

            System.out.print("Introduce el número de su dorsal: ");
            dorsal = scan.nextInt();

            //búsqueda de si el jugador existe en el equipo en cuestión:

            for (Jugador jugador : equipoEncontrado.getJugadores()) {
                if (jugador.getNombre().equals(nombreJugador) && jugador.getDorsal() == dorsal) {
                    jugador.mostrarDatos();
                    jugadorEncontrado = true;
                }
            }

            if (!jugadorEncontrado) {
                System.out.println("Jugador no encontrado.");
            }

        } else {
            System.out.println("El equipo no existe.");
            mainMenu(personas, equipos);
        }
    }

    private static void crearLiga(ArrayList<Equipo> equipos) {
        Scanner scan = new Scanner(System.in);
        int numEquipos;
        boolean ligaPosible;

        System.out.println("Qué nombre quieres darle a la liga?");
        System.out.print("Nombre: ");
        String nombreLiga = scan.nextLine();

        do {
            ligaPosible = false;
            System.out.print("Cuántos equipos van a disputar en " + nombreLiga + "? ");
            numEquipos = scan.nextInt();
            scan.nextLine();

            if (numEquipos > equipos.size()) {
                System.out.println("Hay " + equipos.size() + " equipos disponibles. Prueba otra cifra.");
            } else if (numEquipos < 3) {
                System.out.println("No se puede crear una liga con menos de 3 equipos.");
            } else {
                ligaPosible = true;
            }
        } while (!ligaPosible);

        Liga liga = new Liga(nombreLiga, numEquipos);
        System.out.println("Se ha creado la liga " + nombreLiga);

        System.out.println("\nAhora elige los equipos que la van a disputar.");
        System.out.println("EQUIPOS DISPONIBLES:\n");

        for (Equipo equipo: equipos) {
            equipo.mostrarDatosEquipo();
        }

        ArrayList<String> nombresEquipos = new ArrayList<>(); //Este array se utiliza para tener constancia de los nombres de los equipos que se van a añadir, para que no se repitan
        System.out.println("Qué equipos van a disputar en esta liga? ");

        for (int i = 0; i < numEquipos; i++) {
            String nombre;
            boolean encontrado = false;

            do{
                System.out.print("Equipo " + (i + 1) + ": ");
                nombre = scan.nextLine();

                //Verificación de si el nombre ya ha sido introducido:
                if (nombresEquipos.contains(nombre)) { //Se comprueba si en el array de nombres de equipos añadidos existe el nombre o no
                    System.out.println("El equipo " + nombre + " ya ha sido introducido. Por favor, ingrese otro equipo.");

                } else {
                    Equipo equipoEncontrado = buscarEquipo(equipos, nombre); //Se busca si el equipo con el nombre introducido existe y si es así se guarda en equipoEncontrado
                    if (equipoEncontrado != null) { //Si el equipo existe se añade al array de equipos de la liga
                        liga.agregarEquipo(equipoEncontrado);
                        nombresEquipos.add(nombre);  //Se agrega el nombre del equipo al array de nombres de equipo ya añadidos.
                        encontrado = true;
                    } else {
                        System.out.println("Equipo no existe. Prueba otra vez.");
                    }
                }

            } while(!encontrado);
        }

        //Disputa de los partidos de la liga:
        liga.jugarLiga();
        System.out.println("\nLa liga de " + liga.getNombre() + " se ha disputado con éxito!\n");

        //Muestra de resultados:
        System.out.println("RESULTADOS:\n");
        liga.mostrarResultados();
    }

    private static void entrenamiento(ArrayList<Persona> personas, ArrayList<Equipo> equipos) {
        System.out.println("Realizando sesión de entrenamiento...");

        //Entreno para los jugadores y entrenadores guardados en el array de personas:
        for (Persona persona : personas) {

            persona.entrenar();

            if (persona instanceof Entrenador entrenador) { //Comprueba si la persona es un Entrenador y lleva a cabo su método
                entrenador.incrementarSueldo();

            } else {
                Jugador jugador = (Jugador) persona;  //Si no es un entrenador, convierte el tipo de objeto de persona a Jugador y lleva a cabo su método
                jugador.cambiarPosicion();
            }
        }

        //Entreno para los jugadores y entrenadores guardados en cada equipo:
        for (Equipo equipo : equipos) {
            for (Jugador jugador : equipo.getJugadores()) { //Se recorre el array de jugadores de todos los equipos y se ejecutan los métodos para cada uno
                jugador.entrenar();
                jugador.cambiarPosicion();
            }
            Entrenador entrenador = equipo.getEntrenador(); //Se guarda el entrenador de cada equipo en este objeto de entrenador para ejecutar los métodos:
            if (entrenador != null) { //Por si un equipo no tiene entrenador, para que el programa no se bloquea
                entrenador.entrenar();
                entrenador.incrementarSueldo();
            }
        }
    }

    private static void mercadoDeFichajes(ArrayList<Persona> personas) {
        System.out.println("Personas disponibles a fichar:");
        for (Persona persona: personas) { //se muestran todas las personas en el array de personas porque son los que no están en equipos:
            persona.mostrarDatos();
        }
    }

}