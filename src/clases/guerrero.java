package clases;

public class guerrero extends personaje{
    private int resistencia;

    public guerrero() {
        super();
        this.resistencia = 10;
        this.vida = 100;
        this.vidaMax = 100;
        this.ataque = 20;
        this.defensa = 1;
        this.rol = rol.GUERRERO;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public void descansar() {
        resistencia += 4;
        System.out.println("+4 de resistencia");
    }

    public void atacar(personaje p){
        if (resistencia > 0){
            System.out.println("puñetazo a " + p.nombre);
            resistencia -= 2;
            p.recibirDano(this, ataque);
            System.out.println("-2 de resistencia");
            exp += 20;
            subirNivel();}
        else {
            System.out.println("No tienes resistencia");
            descansar();
        }
    }

    public void recibirDano(personaje p, int a) {
        if (resistencia > 0) {
            vida -= a - defensa - 1;
            resistencia -= 1;
            System.out.println(getNombre() + " ha recibido " + (a - defensa - 1) + " de daño, le queda " + getVida() +" de vida");
        }
        else {
            vida -= a - defensa;
            System.out.println(getNombre() + " ha recibido " + (a - defensa) + " de daño, le queda " + getVida() +" de vida");
        }
    }

    public void subirNivel() {
        if (exp >= (nivel * 100)){
            this.nivel += 1;
            this.defensa += 1;
            this.ataque += 5;
            this.resistencia += 10;
            this.vida += 20;
            this.vidaMax += 20;
            exp = 0;

            System.out.println(getNombre() + " subio de nivel");
        }
    }
}
