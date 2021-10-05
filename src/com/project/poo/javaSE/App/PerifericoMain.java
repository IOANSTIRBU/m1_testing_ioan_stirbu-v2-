package com.project.poo.javaSE.App;

import com.project.poo.javaSE.App.Class.Periferico;
import com.project.poo.javaSE.Enum.DaysAWeek;

import java.util.*;

public class PerifericoMain {

    public static void main(String[] args) {


        //Creamos el ArrayList que es una demo para no tenerlo vacio
        List<Periferico> numPerifericos = new ArrayList<>();
        numPerifericos.add(new Periferico("Azul", 2.3, "Cascos-Ryzen", 45.3, true,  new ArrayList<>()));

        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        //Gestion de errores de try-catch para que no nos salgan las excepciones innecesarias
        try {
            mostrarApp();
            while (!salir) {
                /*Menu que imprime las opciones del 1 al 6 y lee un numero por teclado*/
                mostrarMenu();
                int opc = sc.nextInt();

                /*Se va a evaluar la opcion elegida
                 * */

                switch (opc) {
                    case 1:

                        mostrarOpciones(opc);
                        //Comprobamos si existen perifericos y sino existen crearlos con la segunda opcion del menu
                        if (numPerifericos.isEmpty()) {
                            System.out.println("No existen perifericos");
                        }

                        for (Periferico num : numPerifericos) {
                            System.out.println(num.toString());
                        }
                        break;

                    case 2:
                        mostrarOpciones(opc);

                        //He intentado hacer funciones con todos los casos pero solo he conseguido hacer las funciones void
                        //Es decir si ves que se repite el caso 2 y el 3 es porque no he encontrado la manera de hacerlo
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

                        Periferico p1 = new Periferico(color, tamanio, nombre,precio,promocion, perifericos);
                        numPerifericos.add(p1);
                        System.out.println(p1);

                        break;

                    case 3:
                        mostrarOpciones(opc);

                        System.out.println("Dime el titulo del periferico a registrar en la cesta(por favor separelo con - es decir Asus-Mouse) ");
                        nombre = sc.next();
                        sc.nextLine();

                        //boolean encontrado = false;
                        System.out.println("Digame el color del periferico");
                        color = sc.next();
                        System.out.println("Dime el Tamaño del periferico a registrar en la cesta(por favor separelo con ,)");
                        tamanio = sc.nextDouble();
                        //sc.nextLine();

                        System.out.println("Esta en promocion el periferico?  (true) o (false)");
                        promocion = sc.nextBoolean();
                        sc.nextLine();

                        System.out.println("Digame el precio del periferico a buscar");
                        precio = sc.nextDouble();
                        sc.nextLine();


                        System.out.println("Deseas acompañar con algunos perifericos mas? (true) o (false)");
                        deseaPerif = sc.nextBoolean();
                        List<String> perifericosOtro = new ArrayList<String>();
                        if (deseaPerif) {
                            System.out.println("Digame el numero de perifericos que quiere registrar a la cesta a acompañar en la cesta");
                            int numPerif = sc.nextInt();

                            for (int i = 0; i < numPerif; i++) {
                                System.out.println("Introduce el periferico " + (i + 1));
                                String contadorPerifericos = sc.next();
                                perifericosOtro.add(contadorPerifericos);
                            }
                        }

                        Periferico p2 = new Periferico(color, tamanio, nombre, precio,promocion, perifericosOtro);
                        numPerifericos.add(p2);
                        System.out.println(p2);


                        break;

                        //Aqui he iterrado el ArrayList del numero de perifericos para que se pueda borrar por el color
                    case 4:
                        boolean borrar = false;
                        mostrarOpciones(opc);
                        System.out.println("Digame el color del periferico que quiere borrar");
                        color = sc.next();
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
                        if (!borrar){
                            System.out.println("periferico no encontrado");
                        }



                        break;


                    case 5:
                        mostrarOpciones(opc);
                        System.out.println("Seguro que quieres borrar todos los perifericos existentes de la cesta?");
                        System.out.println("Selecciona con (true(Si)) o (false(No))");
                        boolean seleccionado = sc.nextBoolean();
                        if (seleccionado) {
                            numPerifericos.clear();
                            System.out.println("Perifericos eliminados exitosamente!");
                        }

                        break;

                        //Aqui esta el secreto o regalo como se quiera llamar he pensado usar Enum para practicarlos
                    case 6:
                        mostrarOpciones(opc);
                        System.out.println("¡Aviso muy Importante! No salgas todavia que te hemos preparado algo");

                        System.out.println("Digame un numero del 1 al 7 que indicara el dia de la semana");
                        int opcRegalos = sc.nextInt();
                        sc.nextLine();

                        switch (opcRegalos) {

                            case 1:
                                System.out.println(DaysAWeek.LUNES);
                                System.out.println("Felicidades! Te ganaste una Nintendo Switch");
                                break;
                            case 2:
                                System.out.println(DaysAWeek.MARTES);
                                System.out.println("Felicidades! Te ganaste una Play Station 4");
                                break;
                            case 3:
                                System.out.println(DaysAWeek.MIERCOLES);
                                System.out.println("Felicidades! Te ganaste una Xbox one S");
                                break;
                            case 4:
                                System.out.println(DaysAWeek.JUEVES);
                                System.out.println("Felicidades! Te ganaste una Play Station 5");
                                break;
                            case 5:
                                System.out.println(DaysAWeek.VIERNES);
                                System.out.println("Felicidades! Te ganaste un mando de la Play Station 4");
                                break;
                            case 6:
                                System.out.println(DaysAWeek.SABADO);
                                System.out.println("Felicidades! Te ganaste un mando de la Xbox One S");
                                break;
                            case 7:
                                System.out.println(DaysAWeek.DOMINGO);
                                System.out.println("Felicidades! Te ganaste el videojuego de Forza Horizon 5");
                                break;


                        }
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

            }

            sc.close();
        } catch (InputMismatchException | InterruptedException ignore) {
            ignore.printStackTrace();

        }
        System.out.println("Ha salido un error inesperado");
    }


    //Se abre la App y Carga la App
    public static void mostrarApp() throws InterruptedException {
        System.out.println("Abriendo App de Kintek Technology...");
        Thread.sleep(2500);
        System.out.println("Cargando la App...(Por favor espere)" + "\n\n\n");
        Thread.sleep(2800);
    }

    public static void mostrarMenu()  {
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


    public static int salirAppOpc(int opc) {
        boolean salir = false;
        if (opc == 7) {
            salir = true;
            System.out.println("Hasta pronto");
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
