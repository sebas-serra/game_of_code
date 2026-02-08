package clases;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class personaje implements cartas {
    protected String nombre;
    protected rol rol;
    protected int nivel;
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected int exp;
    protected Boolean envenenado;
    protected ArrayList<String> cartas;

    public personaje() {
        this.nombre = colocarNombre();
        this.nivel = 1;
        this.exp = 0;
        this.envenenado = false;
        this.rol = rol.PERSONAJE;
        this.cartas = new ArrayList<>();

    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public Boolean getEnvenenado() {
        return envenenado;
    }

    public int getExp() {
        return exp;
    }

    public rol getRol() {
        return rol;
    }

    

    public String colocarNombre() {
        ArrayList<String> nombres = new ArrayList<>(
                Arrays.asList(
                        "Goku",
                        "Sebas",
                        "Naruto",
                        "ElRubius",
                        "Riquelme",
                        "Messi",
                        "Paco",
                        "Ricardo",
                        "Esponjita",
                        "Patricio"
                                    )
        );
        int indice = (int) (Math.random() * nombres.size());
        return (nombres.get(indice));
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNivel(int nivel) {
        if (nivel <= this.nivel) {
        }
        else this.nivel = nivel;
    }

    public void setVida(int vida) {
        if (vida < 0) this.vida = 0;
        else this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setEnvenenado(Boolean envenenado) {
        this.envenenado = envenenado;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setRol(rol rol) {
        this.rol = rol;
    }

    

    public  boolean taMuerto(ArrayList<personaje> p){
            if (vida <= 0){
                System.out.println(getNombre() +" a muerto");
                p.remove(this);
                return true;
            }
            else return false;
        }


    public abstract void atacar(personaje personaje);
    public abstract void recibirDano(personaje personaje, int ataque);
    public abstract void subirNivel();
    public abstract void descansar();


    
    public void crearCartas() {
        ArrayList <String> lista = new ArrayList();
        lista.add("CURAR");
        lista.add("SUBIR ATAQUE");
        lista.add("SUBIR DEFENSA");
        lista.add("SUBIR EXP");

        for (int i = 0; i < 3 ; i++) {
        int num = (int)(Math.random() * (lista.size()));
        String carta = lista.get(num);
        cartas.add(carta);
        }
    }

    public void usarCarta(String carta, personaje p) {
        if (carta.equals("CURAR")) {
            vida += 40;
            System.out.println("+40 de vida\n");
        } else if (carta.equals("SUBIR ATAQUE")) {
            ataque += 3;
                        System.out.println("+3 de ataque\n");

        } else if (carta.equals("SUBIR DEFENSA")) {
            defensa += 2;
                        System.out.println("+2 de defensa\n");

        }else if (carta.equals("SUBIR EXP")) {
            exp += 20;
                        System.out.println("+20 de exp\n");

        }
    }


    public void mostrarCartas() {
    
        System.out.println("cartas:");
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println((i+1)+ ": "+ cartas.get(i));
            }
}
}
