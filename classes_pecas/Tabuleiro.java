package classes_pecas;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import funcoes_auxiliares.Arquivo;
import funcoes_auxiliares.sleep;

//Classe tabuleiro

public class Tabuleiro implements Arquivo{
	
	//Atributo adicional
	 private Casa[][] matriz;
	 private static int Q=0;
	 protected sleep sleep;

	    // Variáveis para mudar a cor do background
	    final String ANSI_BLACK_BACKGROUND = "\u001B[40m"; 
	    final String ANSI_WHITE_BACKGROUND = "\u001B[47m"; 
	    final String ANSI_BLACK_TEXT = "\u001B[30m"; 
	    final String ANSI_WHITE_TEXT = "\u001B[37m"; 
	    final String ANSI_RESET = "\u001B[0m"; 

	    // Construtor criando os 64 espaços
	    public Tabuleiro() throws IOException {
	        this.matriz = new Casa[8][8];
	        abreArquivo();
	    }

	    // Inicializando o tabuleiro e setando as coordenadas
	    public void inicializaTabuleiro() {
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 8; j++) {
	                matriz[i][j] = new Casa();
	                matriz[i][j].setCoordenadaLinha(i);
	                matriz[i][j].setCoordenadaColuna(j);
	                matriz[i][j].setStatusoocupados(0);
	            }
	        }
	        System.out.println("Tabuleiro inicializado\n\n");
	    }

	    // Preenchendo o tabuleiro com peças dos jogadores
	    public void preencherTabuleiro(Jogador[] jogadores) {
	        for (int i = 0; i < jogadores.length; i++) {
	            Pecas[] pecasJogador = jogadores[i].getLista();
	            int linhaInicial = i == 0 ? 0 : 7;
	            int linhaPawns = i == 0 ? 1 : 6;

	            // Posicionar peças principais
	            setPeca(linhaInicial, 0, pecasJogador[10]);
	            setPeca(linhaInicial, 1, pecasJogador[12]);
	            setPeca(linhaInicial, 2, pecasJogador[8]);
	            setPeca(linhaInicial, 3, pecasJogador[15]);
	            setPeca(linhaInicial, 4, pecasJogador[14]);
	            setPeca(linhaInicial, 5, pecasJogador[9]);
	            setPeca(linhaInicial, 6, pecasJogador[13]);
	            setPeca(linhaInicial, 7, pecasJogador[11]);

	            // Posicionar peões
	            for (int j = 0; j < 8; j++) {
	                setPeca(linhaPawns, j, pecasJogador[j]);
	            }
	        }
	    }

	    // Imprimindo o tabuleiro
	    public void imprimirTabuleiro() {
	        int k = 1; // variável auxiliar

	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 8; j++) {
	                String background = (i + j) % 2 == 0 ? ANSI_WHITE_BACKGROUND : ANSI_BLACK_BACKGROUND;
	                String textColor = (i + j) % 2 == 0 ? ANSI_BLACK_TEXT : ANSI_WHITE_TEXT;
	                if (matriz[i][j].getStatusoocupados() == 0) {
	                    System.out.print(background + "     " + ANSI_RESET + "| ");
	                } else {
	                    Pecas peca = matriz[i][j].getPeca();
	                    String nomePeca = peca != null ? peca.getTipo().substring(0, 3) : "     ";
	                    System.out.print(background + textColor + " " + nomePeca + " " + ANSI_RESET + "| ");
	                }
	            }
	            System.out.println(k);
	            k++;
	            System.out.println("-------------------------------------------------------");
	        }
	        System.out.println("   A      B      C      D      E      F      G      H\n");
	    }

	    // Getters e Setters
	    public Casa[][] getMatriz() {
	        return matriz;
	    }

	    public void mudarCasa(int linhaFinal, int colunaFinal, Casa inicio) {
	        Pecas peca = inicio.getPeca();
	        inicio.setStatusoocupados(0);
	        setPeca(linhaFinal, colunaFinal, peca);
	    }

	    public void setPeca(int linha, int coluna, Pecas peca) {
	        matriz[linha][coluna].setPeca(peca);
	        matriz[linha][coluna].setStatusoocupados(1);
	    }
	    
	    public boolean verificarCaminhoVazio(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
	        // Movimento na mesma linha (horizontal)
	        if (linhaOrigem == linhaDestino) {
	            int colInicio = Math.min(colunaOrigem, colunaDestino) + 1;
	            int colFim = Math.max(colunaOrigem, colunaDestino);
	            for (int col = colInicio; col < colFim; col++) {
	                if (matriz[linhaOrigem][col].getStatusoocupados() != 0) {
	                    return false; // Tem uma peça no caminho
	                }
	            }
	            return true; // Caminho vazio
	        }

	        // Movimento na mesma coluna (vertical)
	        if (colunaOrigem == colunaDestino) {
	            int linhaInicio = Math.min(linhaOrigem, linhaDestino) + 1;
	            int linhaFim = Math.max(linhaOrigem, linhaDestino);
	            for (int linha = linhaInicio; linha < linhaFim; linha++) {
	                if (matriz[linha][colunaOrigem].getStatusoocupados() != 0) {
	                    return false; // Tem uma peça no caminho
	                }
	            }
	            return true; // Caminho vazio
	        }

	        // Movimento na diagonal
	        if (Math.abs(linhaDestino - linhaOrigem) == Math.abs(colunaDestino - colunaOrigem)) {
	            int linhaInicio = linhaOrigem;
	            int colunaInicio = colunaOrigem;
	            int linhaFim = linhaDestino;
	            int colunaFim = colunaDestino;

	            // Direção do movimento na diagonal
	            int incrementoLinha = linhaOrigem < linhaDestino ? 1 : -1;
	            int incrementoColuna = colunaOrigem < colunaDestino ? 1 : -1;

	            linhaInicio += incrementoLinha;
	            colunaInicio += incrementoColuna;

	            // Verificar todas as casas na diagonal até o destino
	            while (linhaInicio != linhaFim || colunaInicio != colunaFim) {
	                if (matriz[linhaInicio][colunaInicio].getStatusoocupados() != 0) {
	                    return false; // Tem uma peça no caminho
	                }
	                linhaInicio += incrementoLinha;
	                colunaInicio += incrementoColuna;
	            }

	            return true; // Caminho vazio
	        }

	        // Movimento inválido 
	        return false;
	    }

	    public List<int[]> validarEListarPossibilidades(List<int[]> possibilidades, int linhaOrigem, int colunaOrigem, Pecas peca) {
	        List<int[]> posicoesValidas = new ArrayList<>();

	        for (int[] posicao : possibilidades) {
	            int linhaPossibilidade = posicao[0];
	            int colunaPossibilidade = posicao[1];

	            // se a peça é um cavalo
	            if (peca.getTipo().equalsIgnoreCase("cavalo")) {
	                if (matriz[linhaPossibilidade][colunaPossibilidade].getStatusoocupados() == 0) {
	                    posicoesValidas.add(posicao);
	                }
	            } else {
	                //se caminho vazio e casa final vazia
	                if (verificarCaminhoVazio(linhaOrigem, colunaOrigem, linhaPossibilidade, colunaPossibilidade) &&
	                        matriz[linhaPossibilidade][colunaPossibilidade].getStatusoocupados() == 0) {
	                    posicoesValidas.add(posicao);
	                }
	            }
	        }

	        return posicoesValidas;
	    }


	    public void Jogar(Jogador[] jogadores) throws IOException {
	        Scanner scanner = new Scanner(System.in);
	        int linha = 0, coluna = 0, novaLinha = 0, novaColuna = 0;
	        Pecas peca = null;
	        String j;
	        boolean casaValida = false;
	        Q++;
	        sleep.sleep_func(3000);
	        System.out.println("\n------------------------ RODADA " + Q + " ------------------------");
	        gravaRodadas(Q);

	        for (int i = 0; i < jogadores.length; i++) {
	            System.out.println("\nSua vez, " + jogadores[i].getNome() + "!");
	            j = jogadores[i].getNome();

	            while (!casaValida) {
	                // Solicitar ao jogador as coordenadas da coluna
	                System.out.println("\nDigite a coordenada da coluna que deseja (A a H):");
	                String inputColuna = scanner.next().toUpperCase();
	                coluna = inputColuna.charAt(0) - 'A';

	                if (coluna >= 0 && coluna <= 7) {
	                    // Solicitar ao jogador as coordenadas da linha
	                    System.out.println("Digite a coordenada da linha que deseja (1 a 8):");
	                    linha = scanner.nextInt() - 1;

	                    if (linha >= 0 && linha <= 7) {
	                        Casa casa = matriz[linha][coluna];
	                        peca = casa.getPeca();

	                        if (casa.getStatusoocupados() == 1) {
	                            System.out.println("A peça na casa selecionada é: " + peca);

	                            List<int[]> possibilidades = peca.calcularPossibilidades(coluna, linha);
	                            List<int[]> posicoesValidas = validarEListarPossibilidades(possibilidades, linha, coluna,peca);

	                            if (!posicoesValidas.isEmpty()) {
	                                System.out.println("Possibilidades de movimento:");
	                                int index = 1;
	                                for (int[] posicao : posicoesValidas) {
	                                    int linhaPossibilidade = posicao[0];
	                                    int colunaPossibilidade = posicao[1];
	                                    System.out.println(index + ". Linha: " + (linhaPossibilidade + 1) + ", Coluna: " + converterParaLetra(colunaPossibilidade));
	                                    index++;
	                                }

	                                System.out.println("Escolha uma das possibilidades de movimento (1 a " + posicoesValidas.size() + "):");
	                                int escolha = scanner.nextInt();

	                                if (escolha >= 1 && escolha <= posicoesValidas.size()) {
	                                    int[] posicaoEscolhida = posicoesValidas.get(escolha - 1);
	                                    novaLinha = posicaoEscolhida[0];
	                                    novaColuna = posicaoEscolhida[1];
	                                    moverPeca(linha, coluna, novaLinha, novaColuna);
	                                    casaValida = true;
	                                    sleep.sleep_func(3000);

	                                    imprimirTabuleiro();
	                                    System.out.println("Status da casa: " + matriz[1][1].getStatusoocupados()); // Função usada corretamente

	                                } else {
	                                    System.out.println("Escolha inválida. Por favor, escolha um número entre 1 e " + posicoesValidas.size() + ".");
	                                }
	                            } else {
	                                System.out.println("Não há movimentos possíveis para essa peça.");
	                            }
	                        } else {
	                            System.out.println("A casa selecionada está vazia. Por favor, escolha outra casa.");
	                        }
	                    } else {
	                        System.out.println("Coordenada da linha inválida. Por favor, insira um número entre 1 e 8.");
	                    }
	                } else {
	                    System.out.println("Coordenada da coluna inválida. Por favor, insira uma letra entre A e H.");
	                }
	            }
	            casaValida = false;
	            gravaJogadas(j, peca, linha + 1, coluna + 1, novaLinha + 1, novaColuna + 1);
	        }

	        System.out.println("-------------------------------------------------------");
	        System.out.println("RODADA ENCERRADA!!");
	        System.out.println("-------------------------------------------------------");
	        sleep.sleep_func(3000);
	    }

	    private String converterParaLetra(int coluna) {
	        return Character.toString((char) ('A' + coluna));
	    }

	    private void moverPeca(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
	        Casa casaOrigem = matriz[linhaOrigem][colunaOrigem];
	        Casa casaDestino = matriz[linhaDestino][colunaDestino];

	        casaDestino.setPeca(casaOrigem.getPeca());
	        casaOrigem.setPeca(null);
	        casaOrigem.setStatusoocupados(0);
	        casaDestino.setStatusoocupados(1);
	    }
        
	}