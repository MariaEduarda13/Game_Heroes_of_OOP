/* Subclasse para definição dos atributos do personagem Arqueiro. */

public class Arqueiro extends Personagem { //Herança implementada usando o extends.
    public Arqueiro(String nome, Arma arma) {
        super(nome, 20, 30, 160, arma);

        int armaAtaque = arma.getAtaque();
        int armaDefesa = arma.getDefesa();

        this.adicionalAtaque(armaAtaque);
        this.adicionalDefesa(armaDefesa);
    }

} // Fim da subclasse Arqueiro.
