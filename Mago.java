/* Subclasse para definição dos atributos do personagem Mago. */

public class Mago extends Personagem { //Herança implementada usando o extends.
    public Mago(String nome, Arma arma) {
        super(nome, 20, 10, 200, arma);

        int armaAtaque = arma.getAtaque();
        int armaDefesa = arma.getDefesa();

        this.adicionalAtaque(armaAtaque);
        this.adicionalDefesa(armaDefesa);
    }

} // Fim da subclasse Mago.
