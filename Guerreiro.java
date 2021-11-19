/* Subclasse para definição dos atributos do personagem Guerreiro. */

public class Guerreiro extends Personagem { //Herança implementada usando o extends.
    public Guerreiro(String nome, Arma arma) {
        super(nome, 30, 20, 180, arma);

        int armaAtaque = arma.getAtaque();
        int armaDefesa = arma.getDefesa();

        this.adicionalAtaque(armaAtaque);
        this.adicionalDefesa(armaDefesa);
    }

}// Fim da subclasse Guerreiro.
