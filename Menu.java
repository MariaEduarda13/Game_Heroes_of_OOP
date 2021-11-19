import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;

/* Classe para definição dos métodos e fazer o gerenciamento da tela menu. */

public class Menu {
    private int telaAtual = 0;
    private boolean fechar = false;
    private boolean sair = false;
    private Map<String, Map> telas; // O Map possui a estrutura de um objeto com uma chave e valor. 
    private ArrayList<String> opcoes = new ArrayList<String>();

    public Menu(Map<String, Map> telas) {
        this.telas = telas;
    }

    public void iniciarMenu() {
        this.fechar = false;

        if (this.telaAtual < this.telas.size()) {
            String opcaoSelecionada;

            if (this.telaAtual == 2) {
                Map<String, String[]> armas = this.telas.get("" + this.telaAtual);

                opcaoSelecionada = this.gerarMenuArray(armas.get(this.opcoes.get(this.opcoes.size() - 1)));
            } else {
                opcaoSelecionada = this.gerarMenuHash(this.telas.get("" + this.telaAtual));
            }

            if (opcaoSelecionada != "Sair" && opcaoSelecionada != "Voltar") {
                this.opcoes.add(opcaoSelecionada);
                this.telaAtual++;
                this.iniciarMenu();
            } else {
                if (opcaoSelecionada == "Voltar") {
                    this.telaAtual--;
                    this.iniciarMenu();
                } else {
                    System.out.println("Saindo...");
                    this.sair = true;
                }
            }
        } else {
            this.fechar = true;
        }
    }

    public boolean sairMenu() {
        return this.sair;
    }

    public boolean fecharMenu() {
        return this.fechar;
    }

    public void reiniciarMenu(int tela) {
        this.telaAtual = tela;
        this.iniciarMenu();
    }

    public ArrayList<String> pegarOpcoes() {
        return this.opcoes;
    }

    private String gerarMenuHash(Map<String, String> opcoes) {
        int length = opcoes.size();
        int i = 0;

        String opcaoSelecionada;

        Scanner scan = new Scanner(System.in);

        for (; i < length; i++) {
            int valorOpcao = i + 1;
            System.out.println(valorOpcao + ". " + opcoes.get("" + i));
        }

        boolean resposta = false;
        int opcao = 0;

        while (!resposta) {
            System.out.println();
            System.out.print("Selecione uma opção: ");

            opcao = scan.nextInt() - 1;
            resposta = opcao >= 0 && opcao < length;
            if (!resposta) {
                System.out.println("Opção inválida!");
            }
        }

        opcaoSelecionada = opcoes.get("" + opcao);
        return opcaoSelecionada;
    }

    private String gerarMenuArray(String[] opcoes) {
        int length = opcoes.length;
        int i = 0;
        String opcaoSelecionada;

        Scanner scan = new Scanner(System.in);

        for (; i < length; i++) {
            int valorOpcao = i + 1;
            System.out.println(valorOpcao + ". " + opcoes[i]);
        }

        boolean resposta = false;
        int opcao = 0;
        while (!resposta) {
            System.out.println();
            System.out.print("Selecione uma opção: ");
            opcao = scan.nextInt() - 1;
            resposta = opcao >= 0 && opcao < length;
            if (!resposta) {
                System.out.println("Opção inválida!");
            }
        }

        opcaoSelecionada = opcoes[opcao];
        return opcaoSelecionada;
    }

} // Fim da classe Menu.
