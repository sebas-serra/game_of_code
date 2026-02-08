package clases;

public class mago extends personaje{
    private int mana;

    public mago() {
        super();
        this.vida = 100;
        this.vidaMax = 100;
        this.ataque = 10;
        this.defensa = 3;
        this.mana = 10;
        this.rol = rol.MAGO;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void descansar() {
        mana += 4;
        System.out.println("+4 de mana");
    }


    public void atacar(personaje p){

        if (mana > 0){
        System.out.println("rayitos a " + p.nombre);
        p.recibirDano(this, (ataque + mana));
        mana -= 2;
        System.out.println("-2 de mana");
        exp += 20;
        subirNivel();
        }else {
            System.out.println("No tienes mana");
            descansar();
        }
    }

    public void recibirDano(personaje p, int a){
        vida -= a - defensa;
        System.out.println(getNombre() + " ha recibido " +(a - defensa) + " de daño, le queda " + getVida() +" de vida");
    }

    @Override
    public void subirNivel() {
        if (exp >= (nivel * 100)){
        this.nivel += 1;
        this.defensa += 1;
        this.ataque += 5;
        this.mana += 5;
        this.vida += 20;
        this.vidaMax += 20;
            System.out.println(getNombre() + " subio de nivel");
        }
    }

    @Override
    public String toString() {
        return "mago{" +
                "mana=" + mana +
                ", nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", vida=" + vida +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", exp=" + exp +
                '}';
    }
}
