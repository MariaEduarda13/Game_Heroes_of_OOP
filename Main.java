import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/* Classe responsável pela execução do programa. */

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, String> telaInicio = new HashMap<String, String>();
        Map<String, String> telaPersonagens = new HashMap<String, String>();
        Map<String, String[]> telaArmas = new HashMap<String, String[]>();

        telaInicio.put("0", "Iniciar Jogo");
        telaInicio.put("1", "Sair");

        telaPersonagens.put("0", "Guerreiro");
        telaPersonagens.put("1", "Mago");
        telaPersonagens.put("2", "Arqueiro");
        telaPersonagens.put("3", "Voltar");

        String[] armasGuerreiro = { "Espada", "Machado", "Voltar" };
        String[] armasMago = { "Varinha", "Cajado", "Voltar" };
        String[] armasArqueiro = { "Arco Longo", "Balestra", "Voltar" };

        telaArmas.put("Guerreiro", armasGuerreiro);
        telaArmas.put("Mago", armasMago);
        telaArmas.put("Arqueiro", armasArqueiro);

        Map<String, Map> telas = new HashMap<String, Map>();

        telas.put("0", telaInicio);
        telas.put("1", telaPersonagens);
        telas.put("2", telaArmas);

        String criarPersonagens = "S";
        String criarOutroPersonagem = "f";
        Menu menu = new Menu(telas);

        menu.iniciarMenu();

        ArrayList<Personagem> personagens = new ArrayList<>();
        int cont = 0;
        if (!menu.sairMenu()) {

            while (criarPersonagens.equals("S") || criarPersonagens.equals("s")) {
                if (menu.fecharMenu()) {
                    System.out.print("Informe o nome do personagem: ");
                    String nome = scan.next();
                    System.out.println();
                    ArrayList<String> opcoes = menu.pegarOpcoes();

                    Arma arma = criarArma(opcoes.get(2));
                    Personagem personagem = criaPersonagem(opcoes.get(1), nome, arma);

                    personagens.add(personagem);
                }

                if (cont < 2) {

                    do {
                        System.out.print("Deseja criar outro personagem? (S/N): ");

                        criarOutroPersonagem = scan.next();

                        if (criarOutroPersonagem.equals("S") || criarOutroPersonagem.equals("s")) {
                            menu.reiniciarMenu(1);
                            criarPersonagens = criarOutroPersonagem;
                            cont++;
                        } else if (criarOutroPersonagem.equals("N") || criarOutroPersonagem.equals("n")) {
                            criarPersonagens = criarOutroPersonagem;
                            cont++;

                        } else {
                            System.out.println("Resposta inválida!");
                        }
                    } while (!criarOutroPersonagem.equals("S") && !criarOutroPersonagem.equals("N")
                            && !criarOutroPersonagem.equals("s") && !criarOutroPersonagem.equals("n"));

                } else {
                    break;
                }
            }

            Personagem dragao = new Dragao("LazyProg");
            Partida partida = new Partida(personagens, dragao);
            partida.inicioPartida();
            scan.close();
        }
    }

    public static Arma criarArma(String arma) {
        Arma armaEscolhida;
        if (arma.equals("Machado")) {
            armaEscolhida = new Machado();
        } else if (arma.equals("Espada")) {
            armaEscolhida = new Espada();
        } else if (arma.equals("Varinha")) {
            armaEscolhida = new Varinha();
        } else if (arma.equals("Cajado")) {
            armaEscolhida = new Cajado();
        } else if (arma.equals("Arco Longo")) {
            armaEscolhida = new ArcoLongo();
        } else {
            armaEscolhida = new Balestra();
        }
        return armaEscolhida;
    }

    public static Personagem criaPersonagem(String personagem, String nome, Arma arma) {
        Personagem personagemEscolhido;
        if (personagem.equals("Guerreiro")) {
            personagemEscolhido = new Guerreiro(nome, arma);
        } else if (personagem.equals("Mago")) {
            personagemEscolhido = new Mago(nome, arma);
        } else {
            personagemEscolhido = new Arqueiro(nome, arma);
        }
        return personagemEscolhido;
    }

} // Fim da classe Main.