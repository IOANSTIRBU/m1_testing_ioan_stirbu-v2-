package com.m1_testing_ioan_stirbu.project.poo.javaSE.App;

import com.m1_testing_ioan_stirbu.project.poo.javaSE.App.Class.Periferico;
import com.m1_testing_ioan_stirbu.project.poo.javaSE.Enum.DaysAWeek;

import java.util.*;

public class PerifericoMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        System.out.println("Espero que se ejecute");
        //Gestion de errores de try-catch para que no nos salgan las excepciones innecesarias

        while (!salir) {
            /*Menu que imprime las opciones del 1 al 6 y lee un numero por teclado*/
            try {
                mostrarApp();
                mostrarMenu();

                int opc = sc.nextInt();

                switch (opc) {
                    case 1:
                        mostrarOpciones(opc);
                        mostrarListaPerif();
                        break;

                    case 2:
                        mostrarOpciones(opc);
                        registrarPerif();
                        break;

                    case 3:
                        mostrarOpciones(opc);
                        registrarNuevoPerif();
                        break;

                    case 4:
                        mostrarOpciones(opc);
                        borrarPeriferico();
                        break;

                    case 5:
                        mostrarOpciones(opc);
                        borrarTodosPerifericos();
                        break;

                    //Aqui esta el secreto o regalo como se quiera llamar he pensado usar Enum para practicarlos
                    case 6:
                        mostrarOpciones(opc);
                        quieresSalir();
                        break;
                    //Este caso lo que hace primero mostrar opciones luego llamar una funcion que se llama intTryParse que
                    //lo que hace es convertir de un Integer a String
                    case 7:
                        mostrarOpciones(opc);
                        String leer = sc.next();
                        opc = intTryParse(leer);
                        salirAppOpc(opc);
                        break;
                }

            } catch (InputMismatchException | InterruptedException ignore) {
                ignore.printStackTrace();
                System.out.println("Ha salido un error inesperado");
            }

        }
        sc.close();
    }

    //Se usa globalmente para todas las funciones los static
    static List<Periferico> numPerifericos = new ArrayList<>();
    //numPerifericos.add(new Periferico("Azul", 2.3, "Cascos-Ryzen", 45.3, true, new ArrayList<>()));
    static Scanner sc = new Scanner(System.in);

    //Se abre la App y Carga la App
    public static void mostrarApp() throws InterruptedException {
        System.out.println("Abriendo App de Kintek Technology...");
        Thread.sleep(2500);
        System.out.println("Cargando la App...(Por favor espere)" + "\n\n\n");
        Thread.sleep(2800);
    }

    public static void mostrarMenu() {
        /*Menu que imprime las opciones del 1 al 6 y lee un numero por teclado*/

        System.out.println("   Kintek Tecknology Menu");
        System.out.println("  ************************");
        System.out.println("");
        System.out.println("Opcion 1: Mostrar lista de perifericos en la cesta");
        System.out.println("Opcion 2: Registrar un periferico a la cesta");
        System.out.println("Opcion 3: Registrar un nuevo periferico a la cesta");
        System.out.println("Opcion 4: Borrar un periferico de la cesta");
        System.out.println("Opcion 5: Borrar todos los perifericos de la cesta");
        System.out.println("Opcion 6: Salir de la cesta y programa");
        System.out.println("Opcion 7: Salir del programa definitivamente");
        System.out.println("Elija una opcion por favor");
    }

    public static void mostrarOpciones(int opc) {
        switch (opc) {
            case 1:
                System.out.println("Has seleccionado la opcion 1: Mostrar lista de perifericos");
                break;
            case 2:
                System.out.println("Has seleccionado la opcion 2: Registrar un periferico a la cesta");
                break;
            case 3:
                System.out.println("Has seleccionado la opcion 3: Registrar un nuevo periferico");
                break;
            case 4:
                System.out.println("Has seleccionado la opcion 4: Borrar un periferico de la cesta por (color)");
                break;
            case 5:
                System.out.println("Has seleccionado la opcion 5: Borrar todos los perifericos de la cesta ");
                break;
            case 6:
                System.out.println("Has seleccionado la opcion 6: Salir de la cesta y del programa");
                break;
            case 7:
                System.out.println("Seguro que quiere salir del programa (Si--Pulsa 7) -(No--Pulsa 8)");
                break;

        }
    }


    private static void mostrarListaPerif() {

        if (numPerifericos.isEmpty()) {
            System.out.println("No existen perifericos");
        }

        for (Periferico num : numPerifericos) {
            System.out.println(num.toString());
        }

    }

    private static void registrarPerif() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el titulo del periferico a registrar en la cesta (por favor separelo con - es decir Asus-Mouse) ");
        String nombre = sc.next();
        sc.nextLine();

        //boolean encontrado = false;
        System.out.println("Digame el color del periferico");
        String color = sc.next();
        System.out.println("Digame un precio");
        double precio = sc.nextDouble();
        sc.nextLine();

        System.out.println("Dime el Tamaño del periferico a registrar en la cesta(por favor separelo con ,)");
        double tamanio = sc.nextDouble();
        sc.nextLine();
        System.out.println("Esta en promocion el periferico?  (true) o (false)");
        boolean promocion = sc.nextBoolean();
        sc.nextLine();

        System.out.println("Deseas acompañar con algunos perifericos mas? (true) o (false)");
        boolean deseaPerif = sc.nextBoolean();
        List<String> perifericos = new ArrayList<String>();
        if (deseaPerif) {
            System.out.println("Digame el numero de perifericos que quiere registrar a la cesta a acompañar en la cesta");
            int numPerif = sc.nextInt();

            for (int i = 0; i < numPerif; i++) {
                System.out.println("Introduce el periferico " + (i + 1));
                String contadorPerifericos = sc.next();
                perifericos.add(contadorPerifericos);
            }
        }
        Periferico p2 = new Periferico(color, tamanio, nombre, precio, promocion, perifericos);
        numPerifericos.add(p2);
        System.out.println(p2);

    }

    private static void registrarNuevoPerif() {
        registrarPerif();
    }

    private static void borrarPeriferico() {
        Scanner sc = new Scanner(System.in);
        boolean borrar = false;


        System.out.println("Digame el color del periferico que quiere borrar");
        String color = sc.next();
        Iterator<Periferico> iter = numPerifericos.iterator();
        while (iter.hasNext()) {
            Periferico colorPeriferico = iter.next();
            if (colorPeriferico.color.equals(color)) {
                iter.remove();
                borrar = true;
                System.out.println("Periferico borrado correctamente!");
                break;
            }


        }
        if (!borrar) {
            System.out.println("periferico no encontrado");
        }

    }

    private static void borrarTodosPerifericos() {

        System.out.println("Seguro que quieres borrar todos los perifericos existentes de la cesta?");
        System.out.println("Selecciona con (true(Si)) o (false(No))");
        boolean seleccionado = sc.nextBoolean();
        if (seleccionado) {
            numPerifericos.clear();
            System.out.println("Perifericos eliminados exitosamente!");
        }

    }

    private static void quieresSalir() {

        System.out.println("¡Aviso muy Importante! No salgas todavia que te hemos preparado algo");

        System.out.println("Digame un numero del 1 al 7 que indicara el dia de la semana");
        int opcRegalos = sc.nextInt();
        sc.nextLine();

        switch (opcRegalos) {

            case 1:
                System.out.println("Has elegido: " + DaysAWeek.LUNES);
                System.out.println("Felicidades! Te ganaste una Nintendo Switch");
                break;
            case 2:
                System.out.println("Has elegido: " + DaysAWeek.MARTES);
                System.out.println("Felicidades! Te ganaste una Play Station 4");
                break;
            case 3:
                System.out.println("Has elegido: " + DaysAWeek.MIERCOLES);
                System.out.println("Felicidades! Te ganaste una Xbox one S");
                break;
            case 4:
                System.out.println("Has elegido: " + DaysAWeek.JUEVES);
                System.out.println("Felicidades! Te ganaste una Play Station 5");
                break;
            case 5:
                System.out.println("Has elegido: " + DaysAWeek.VIERNES);
                System.out.println("Felicidades! Te ganaste un mando de la Play Station 4");
                break;
            case 6:
                System.out.println("Has elegido: " + DaysAWeek.SABADO);
                System.out.println("Felicidades! Te ganaste un mando de la Xbox One S");
                break;
            case 7:
                System.out.println("Has elegido: " + DaysAWeek.DOMINGO);
                System.out.println("Felicidades! Te ganaste el videojuego de Forza Horizon 5");
                break;
            default:
                System.out.println("Lo sentimos pero el numero introducido no es correcto, pruebe con otro");


        }

    }

    public static int salirAppOpc(int opc) {
        boolean salir = false;
        if (opc == 7) {
            salir = true;
            System.out.println("Hasta pronto :) ");
            System.out.println("HAS SALIDO EXITOSAMENTE DE LA CESTA DE PERIFERICOS");
            System.exit(0);

        } else if (opc == 8) {
            salir = false;

        }

        return opc;
    }


    // Metodo que pasa de un integer a String
    public static Integer intTryParse(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException ex) {
            return 0;
        }

    }
}
