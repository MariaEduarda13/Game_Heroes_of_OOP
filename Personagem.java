/* Superclasse para definição dos métodos. */

public class Personagem {
    private String nome;
    private int ataque;
    private int defesa;
    private float bonusDefesa;
    private int pontosVida;
    private float dano;
    private Arma arma;
    
    // Construtor da superclasse (com arma).
    public Personagem(String nome, int ataque, int defesa, int pontosVida, Arma arma){
        this.nome = nome;
        this.defesa = defesa;
        this.ataque = ataque;
        this.pontosVida = pontosVida;
        this.arma = arma;
    }

    // Construtor de sobrecarga da superclasse (sem arma).
    public Personagem(String nome, int ataque, int defesa, int pontosVida){
        this.nome = nome;
        this.defesa = defesa;
        this.ataque = ataque;
        this.pontosVida = pontosVida;
    }

    // Métodos da superclasse.
    protected void receberDano(int dano){ // Encapsulamento implementado com o protected.
        this.pontosVida -= dano;
    }

    protected void adicionalAtaque(int ataque){
        this.ataque += ataque;
    }

    protected void adicionalDefesa(int defesa){
        this.defesa += defesa;
    }

    public void atacar(Personagem alvo){
        int dano = this.ataque - alvo.defesa;
        this.dano = dano;
        alvo.receberDano(dano);
    }

    public float getDano(){
        return this.dano;
    }

    public float getPontosVida(){
        return this.pontosVida;
    }

    public int getAtaque(){
        return this.ataque;
    }

    public float getBonusDefesa(){
        return this.bonusDefesa;
    }

    public int getDefesa(){
        return this.defesa;
    }

    public void defender(){
        float bonusDefesa = (this.defesa * 10) / 100;
        this.bonusDefesa = bonusDefesa;
        this.defesa += bonusDefesa;
    }

    public String getNome(){
        return this.nome;
    }

    public void reiniciarDefesa(){
        this.defesa -= this.bonusDefesa;
        this.bonusDefesa = 0;
    }

} // Fim da superclasse Personagem.
