/* Superclasse para definição dos métodos. */

public class Arma {
    private int ataque; // Encapsulamento implementado com o private.
    private int defesa;

    // Construtor da superclasse.
    public Arma(int ataque, int defesa) {
        this.ataque = ataque;
        this.defesa = defesa;
    }

    // Métodos da superclasse.
    public int getAtaque() {
        return this.ataque;
    }

    public int getDefesa() {
        return this.defesa;
    }

} // Fim da superclasse Arma.
