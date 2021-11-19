import java.util.Scanner;
import java.util.ArrayList;

/* Classe para definição dos métodos e fazer o gerenciamento da partida. */

public class Partida {
    private ArrayList<Personagem> personagens;
    private Personagem dragao;
    private int turnos = 0;
    private boolean partida = true;

    public Partida(ArrayList<Personagem> personagens, Personagem dragao) {
        this.personagens = personagens;
        this.dragao = dragao;
    }

    private void passarTurno() {
        int length = this.personagens.size();
        int i = 0;

        for (; i < length; i++) {
            Personagem personagem = this.personagens.get(i);
            personagem.reiniciarDefesa();
        }

        this.turnos++;
        this.inicioPartida();
    }

    public void vitoria() {
        System.out.println("**** Vitória!!! Você derrotou o dragão LazyProg! ***");
        System.out.println();
        this.partida = false;
    }

    public void derrota() {
        System.out.println("*** Derrota!!! Seus personagens foram derrotados pelo dragão LazyProg! ***");
        System.out.println();
        this.partida = false;
    }

    public void inicioPartida() {
        Scanner scan = new Scanner(System.in);
        int length = this.personagens.size();
        int i = 0;
        if (this.dragao.getPontosVida() <= 0) {
            this.vitoria();
            return;
        } else {
            int mortes = 0;

            for (; i < length; i++) {
                Personagem personagem = this.personagens.get(i);
                if (personagem.getPontosVida() <= 0) {
                    mortes++;
                }
            }

            if (mortes == this.personagens.size()) {
                this.derrota();
                return;

            }
        }

        i = 0;
        for (; i < length; i++) {
            Personagem personagem = this.personagens.get(i);

            int opcao;

            System.out.println("Turno: " + this.turnos + ". Derrote o dragão " + this.dragao.getNome() + " (PVD: "
                    + this.dragao.getPontosVida() + ")");
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println();
            System.out
                    .println("Escolha uma opção com o(a): " + personagem.getNome() + " (ATQ: " + personagem.getAtaque()
                            + " | DEF: " + personagem.getDefesa() + " | PVD: " + personagem.getPontosVida() + ")");
            opcao = scan.nextInt();

            if (opcao == 1) {
                personagem.atacar(this.dragao);
                this.ataqueLog(personagem.getNome(), personagem.getDano(), this.dragao.getPontosVida());
            } else {
                personagem.defender();
                this.defesaLog(personagem.getNome(), personagem.getBonusDefesa(), personagem.getDefesa());
            }

        }
        /*
         * Método usando a bibilioteca Math.random para gerar um personagem aleatório
         * para o inimigo atacar na rodada.
         */
        
        int personagemAleatorio = (int) (Math.random() * (((this.personagens.size() - 1) - 0) + 1)) + 0;
        this.dragao.atacar(this.personagens.get(personagemAleatorio));
        this.dragaoLog("O dragão LazyProg ", this.dragao.getDano(), this.personagens.get(personagemAleatorio));
        this.passarTurno();
    }

    /*
     * Logs para verificar os atributos de ataque, defesa e pontos de vida dos
     * personagens.
     */

    public void defesaLog(String nome, float defesa, float defesaTotal) {
        System.out.println();
        System.out.println(nome + " ganhou " + defesa + " de defesa nessa rodada.");
        System.out.println("Sua defesa total é de " + defesaTotal);
        System.out.println();
    }

    public void ataqueLog(String nome, float dano, float dragaoPontosVida) {
        System.out.println();
        System.out.println(nome + " causou " + dano + " de dano nessa rodada.");
        System.out.println("Ainda restam " + dragaoPontosVida + " pontos de vida para o dragão LazyProg.");
    }

    public void dragaoLog(String nome, float dano, Personagem personagem) {
        System.out.println();
        System.out.println(nome + "causou " + dano + " de dano em " + personagem.getNome() + " nessa rodada.");
        System.out.println();
    }

} // Fim da classe Partida.
