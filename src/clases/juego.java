package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class juego {

    public void juegoMaquina() {
        personaje warrior = new guerrero();
        personaje mage = new mago();
        personaje monster = new monstruo();

        ArrayList<personaje> personajes = new ArrayList<>();
        personajes.add(warrior);
        personajes.add(mage);
        personajes.add(monster);

        warrior.crearCartas();
        mage.crearCartas();
        monster.crearCartas();

        int i = (int) (Math.random() * personajes.size());
        int j = 1;

        while (personajes.size() > 1) {

            personaje atacante = personajes.get(i);

            int contra = (int) (Math.random() * personajes.size());
            while (contra == i) {
                contra = (int) (Math.random() * personajes.size());
            }

            if (atacante.getVida() > 0) {

                System.out.println("ataca: " + atacante.getNombre());

                if (atacante.cartas.size() > 0) {
                    int probCarta = (int) (Math.random() * 2);
                    if (probCarta == 1) {
                        atacante.usarCarta(atacante.cartas.get(0));
                        atacante.cartas.remove(0);
                    }
                }

                atacante.atacar(personajes.get(contra));
                atacante.taMuerto(personajes);
                System.out.println("ronda " + j + "\n");

            } else {
                atacante.taMuerto(personajes);
            }

            i++;
            if (i >= personajes.size()) i = 0;
            j++;
        }

        System.out.println("Juego terminado. Ganador: " +
                personajes.get(0).getNombre() + " en la ronda " + j);
    }


    public void juegoMulti() {
        Scanner sc = new Scanner(System.in);

        personaje warrior = new guerrero();
        personaje mage = new mago();
        personaje monster = new monstruo();

        warrior.crearCartas();
        mage.crearCartas();
        monster.crearCartas();

        ArrayList<personaje> personajes = new ArrayList<>();
        personajes.add(warrior);
        personajes.add(mage);
        personajes.add(monster);

        System.out.println("Elija quien quiere ser: \n" +
                "1: " + personajes.get(0).getNombre() + ": " + personajes.get(0).getRol() + "\n" +
                "2: " + personajes.get(1).getNombre() + ": " + personajes.get(1).getRol() + "\n" +
                "3: " + personajes.get(2).getNombre() + ": " + personajes.get(2).getRol());

        int jugador = -1;
        while (jugador < 0 || jugador >= personajes.size()) {
            while (!sc.hasNextInt()) {
                System.out.println("❌ Entrada inválida. Debe escribir un número (1, 2 o 3).");
                sc.next();
            }
            jugador = sc.nextInt() - 1;
            if (jugador < 0 || jugador >= personajes.size()) {
                System.out.println("❌ Opción incorrecta. Elija 1, 2 o 3.");
            }
        }

        int i = (int) (Math.random() * personajes.size());
        int j = 1;
        System.out.println("Empieza el jugador: " + (i + 1));

        while (personajes.size() > 1) {

            personaje atacante = personajes.get(i);

            if (i != jugador) {
                // ===== TURNO CPU =====
                int contra = (int) (Math.random() * personajes.size());
                while (contra == i) {
                    contra = (int) (Math.random() * personajes.size());
                }

                if (atacante.getVida() > 0) {

                    System.out.println("\nataca: " + atacante.getNombre());

                    if (atacante.cartas.size() > 0) {
                        int probCarta = (int) (Math.random() * 2);
                        if (probCarta == 1) {
                            atacante.usarCarta(atacante.cartas.get(0));
                            atacante.cartas.remove(0);
                        }
                    }

                    atacante.atacar(personajes.get(contra));
                    atacante.taMuerto(personajes);
                    System.out.println("ronda " + j + "\n");

                } else {
                    atacante.taMuerto(personajes);
                }

            } else {
                // ===== TURNO HUMANO =====

                if (atacante.getVida() <= 0) {
                    System.out.println("⚠️ Estás muerto, pierdes el turno.");
                    atacante.taMuerto(personajes);
                } else {

                    System.out.println("\nataca: " + atacante.getNombre());

                    // ---- usar carta ----
                    if (atacante.cartas.size() > 0) {
                        String opcionCarta = "";
                        while (!opcionCarta.equals("1") && !opcionCarta.equals("2")) {
                            System.out.println("¿Quiere usar una carta?\n1: sí\n2: no");
                            opcionCarta = sc.next();

                            if (!opcionCarta.equals("1") && !opcionCarta.equals("2")) {
                                System.out.println("❌ Opción inválida. Escriba 1 o 2.");
                            }
                        }

                        if (opcionCarta.equals("1")) {
                            int opcion2 = -1;
                            while (opcion2 < 0 || opcion2 >= atacante.cartas.size()) {
                                atacante.mostrarCartas();

                                while (!sc.hasNextInt()) {
                                    System.out.println("❌ Entrada inválida. Debe escribir un número.");
                                    sc.next();
                                }

                                opcion2 = sc.nextInt() - 1;

                                if (opcion2 < 0 || opcion2 >= atacante.cartas.size()) {
                                    System.out.println("❌ Carta inválida. Intente de nuevo.");
                                }
                            }

                            atacante.usarCarta(atacante.cartas.get(opcion2));
                            atacante.cartas.remove(opcion2);
                        }
                    }

                    // ---- acción ----
                    String accion = "";
                    while (!accion.equals("1") && !accion.equals("2")) {
                        System.out.println("¿Qué quiere hacer?");
                        System.out.println("1: atacar");
                        System.out.println("2: descansar");
                        accion = sc.next();

                        if (!accion.equals("1") && !accion.equals("2")) {
                            System.out.println("❌ Opción inválida. Elija 1 o 2.");
                        }
                    }

                    if (accion.equals("2")) {
                        atacante.descansar();
                    } else {
                        int contra = -1;
                        while (contra < 0 || contra >= personajes.size() || contra == jugador) {
                            System.out.println("¿A quién quiere atacar?");
                            for (int k = 0; k < personajes.size(); k++) {
                                if (k != jugador) {
                                    System.out.println((k + 1) + ": " + personajes.get(k).getNombre());
                                }
                            }

                            while (!sc.hasNextInt()) {
                                System.out.println("❌ Entrada inválida. Debe escribir un número.");
                                sc.next();
                            }

                            contra = sc.nextInt() - 1;

                            if (contra < 0 || contra >= personajes.size()) {
                                System.out.println("❌ Objetivo fuera de rango.");
                            } else if (contra == jugador) {
                                System.out.println("❌ No puede atacarse a sí mismo.");
                            }
                        }

                        atacante.atacar(personajes.get(contra));
                        personajes.get(contra).taMuerto(personajes);
                    }
                }
            }

            i++;
            if (i >= personajes.size()) i = 0;
            j++;
        }

        System.out.println("Juego terminado. Ganador: " + personajes.get(0).getNombre());
    }

}
