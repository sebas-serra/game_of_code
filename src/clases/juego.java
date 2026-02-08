package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class juego{
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
        
        int i = (int)(Math.random() * (personajes.size()));
        int j = 1;
        while (personajes.size() > 1) {
            int contra = (int)(Math.random() * (personajes.size())) ;
            while (contra == i){
                contra = (int)(Math.random() * (personajes.size())) ;
            }



            if (personajes.get(i).getVida() > 0){

                System.out.println("ataca: " + personajes.get(i).getNombre());

                if (personajes.get(i).cartas.size() > 0){
                    personajes.get(i).mostrarCartas();
                    int probCarta = (int)(Math.random() * 2);
                    if (probCarta == 1){
                        personajes.get(i).usarCarta(personajes.get(i).cartas.get(0), personajes.get(contra));
                        personajes.get(i).cartas.remove(0);
                    }
                }
                
                personajes.get(i).atacar(personajes.get(contra));
                personajes.get(i).taMuerto(personajes);
                System.out.println("ronda " + j);
                System.out.println();

            }
            else {
                personajes.get(i).taMuerto(personajes);
                System.out.println();
            }




            i++;
            if (i >= personajes.size()) i = 0;

            j++;


        }

        System.out.println("Juego terminado. Ganador: " + personajes.get(0).getNombre()+" en la ronda " + j);
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
    int jugador = sc.nextInt() - 1;

    int i = (int) (Math.random() * (personajes.size()));
    int j = 1;
    System.out.println("Empieza el jugador: " + (i + 1));

    while (personajes.size() > 1) {

        if (i != jugador) {
             int contra = (int)(Math.random() * (personajes.size())) ;
            while (contra == i){
                contra = (int)(Math.random() * (personajes.size())) ;
            }

            if (personajes.get(i).getVida() > 0){

                System.out.println("\nataca: " + personajes.get(i).getNombre());

                if (personajes.get(i).cartas.size() > 0){
                    personajes.get(i).mostrarCartas();
                    int probCarta = (int)(Math.random() * 2);
                    if (probCarta == 1){
                        personajes.get(i).usarCarta(personajes.get(i).cartas.get(0), personajes.get(contra));
                        personajes.get(i).cartas.remove(0);
                    }
                }
                
                personajes.get(i).atacar(personajes.get(contra));
                personajes.get(i).taMuerto(personajes);
                System.out.println("ronda " + j);
                System.out.println();

            }
            else {
                personajes.get(i).taMuerto(personajes);
                System.out.println();
            }

        } else {
            boolean bien = false;

            while (!bien) {
                System.out.println("\nataca: " + personajes.get(i).getNombre());
                System.out.println("¿Qué quiere hacer?");
                System.out.println("1: atacar");
                System.out.println("2: descansar");
                String coso = sc.next();

                if (coso.equals("2")) {
                    personajes.get(jugador).descansar();
                    bien = true;

                } else if (coso.equals("1")) {
                    System.out.println("¿A quién quiere atacar?");
                    for (int k = 0; k < personajes.size(); k++) {
                        if (k != jugador) {
                            System.out.println((k + 1) + ": " + personajes.get(k).getNombre());
                        }
                    }

                    int contra = sc.nextInt() - 1;

                    if (contra >= 0 && contra < personajes.size() && contra != jugador) {
                        personajes.get(jugador).atacar(personajes.get(contra));
                        personajes.get(contra).taMuerto(personajes);
                        bien = true;
                    } else {
                        System.out.println("Objetivo inválido.");
                    }

                } else {
                    System.out.println("Opción incorrecta, intente de nuevo.");
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




