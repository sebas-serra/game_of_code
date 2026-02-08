package clases;

public class monstruo extends personaje{
    private int ataques;

    public monstruo(){
        super();
        this.ataques = 0;
        this.vida = 80;
        this.ataque = 10;
        this.defensa = 1;
        this.rol = rol.MONSTRUO;
    }
    

    public int getAtaques() {
        return ataques;
    }

    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    @Override
    public void atacar(personaje p) {
        int cantidad = ((int)(Math.random() * 3) + 1) + ataques;
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Arañazo a " + p.nombre);
            p.recibirDano(p, ataque);
        }
        System.out.println(getNombre() + " dio "+ cantidad +" arañazos ");
        exp += 20;
        subirNivel();
    }
    @Override
    public void recibirDano(personaje p, int a) {
        vida -= a - defensa;
        System.out.println(getNombre() + " ha recibido " +(a - defensa) + " de daño, le queda " + getVida() +" de vida");
    }

    public void subirNivel() {
        if (exp >= (nivel * 100)) {

            this.nivel += 1;
            this.defensa += 1;
            this.ataque += 5;
            this.vida += 20;
            this.ataques += 1;
            System.out.println(getNombre() + " subio de nivel");

        }
    }

    @Override
    public void descansar() {
        ataque += 2;
        System.out.println("+2 de ataque");
    }

    
}
