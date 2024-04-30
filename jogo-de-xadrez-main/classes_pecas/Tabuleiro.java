package classes_pecas;
import java.util.List;
import java.util.Scanner;




//Classe tabuleiro

public class Tabuleiro extends Casa{
	
	//Atributo adicional
	private Casa[][] matriz; 
	
	//Variáveis para mudar a cor do background
	final String ANSI_BLACK_BACKGROUND = "\u001B[40m"; // Código para setar o background preto
    final String ANSI_WHITE_BACKGROUND = "\u001B[47m"; // Código para setar o background preto
    final String ANSI_RESET = "\u001B[0m"; // Resetar o backgroud

    
    //Construtor criando os 64 espaços
    public Tabuleiro() { 
        this.matriz = new Casa[8][8]; 
    }
    
    
    //Inicializando o tabuleiro e setando as coordenadas
    public void inicializaTabuleiro() {
    	for (int i = 0 ; i < 8 ; i++){
    		for(int j = 0 ; j<8; j++) {
    			matriz[i][j] = new Casa();
    			matriz[i][j].setCoordenadaLinha(i);
    			matriz[i][j].setCoordenadaColuna(j);
    			matriz[i][j].setStatusoocupados(0);
    		}
    	}
    	System.out.println("Tabuleiro inicializado\n\n");
    }
    
    public void preencherTabuleiro(Jogador[] jogadores) {
        for (int i = 0; i < jogadores.length; i++) {
            Pecas[] pecasJogador = jogadores[i].getLista();
            int linhaInicial = i == 0 ? 0 : 6; // Primeira linha para o jogador 1, sexta linha para o jogador 2
            for (int j = 0; j < pecasJogador.length; j++) {
                int linha = linhaInicial + (i == 0 ? 0 : 1); // Incrementa a linha para o jogador 2
                int coluna = j % 8; // Garante que a coluna esteja dentro dos limites da matriz
                setPeca(linha, coluna, pecasJogador[j]);
            }
        }
    }

    //Imprimindo o tabuleiro
    public void imprimirTabuleiro() {
        

        int k = 8; // variavel auxiliar
        
        
        // Lógica de matriz bidimensional para imprimir o tabuleiro
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matriz[i][j].getStatusoocupados() == 0) {
                	
                if ((i+j) % 2 == 0) {
                        System.out.print(ANSI_WHITE_BACKGROUND + "     " + ANSI_RESET + "| ");
                    } else {
                        System.out.print(ANSI_BLACK_BACKGROUND + "     " + ANSI_RESET + "| ");
                    }
                } else {
                    System.out.print(matriz[i][j].getPeca() + " | ");
                }
            }
            
            System.out.println(k);
            k--;
            System.out.println("-------------------------------------------------------");
        }

        System.out.println("   A      B      C      D      E      F      G      H");
    }

    
  
    //Getters e Setters
	public Casa[][] getMatriz() {
		return matriz;
	}
	
	public void mudarCasa(int linhaFinal, int colunaFinal, Casa inicio) {
		Pecas peca = inicio.getPeca();
		inicio.setStatusoocupados(0);
		setPeca(linhaFinal,colunaFinal,peca);
	}
	
	
	public void setPeca(int linha, int coluna, Pecas peca) { // "Encaixar" uma peça no tabuleiro
        matriz[linha][coluna].setPeca(peca); // Adicionando a Peça na casa
        matriz[linha][coluna].setStatusoocupados(1);//Setando o espaça como "ocupado"
    }


	private String converterParaLetra(int coluna) {
        return String.valueOf((char) ('A' + coluna - 1));
    }

	public void Jogar() {
	    Scanner scanner = new Scanner(System.in);

	    int linha = 0, coluna = 0;
	    boolean casaValida = false;

	    while (!casaValida) {
	        // Solicitar ao jogador as coordenadas
	        System.out.println("Digite a coordenada da coluna (A a H):");
	        String inputColuna = scanner.next().toUpperCase(); // Converter para maiúsculas para tratar entradas em minúsculas
	        coluna = inputColuna.charAt(0) - 'A' + 1; // Converter de letra para número de coluna (A=1, B=2, etc.)

	        // Verificar se a coluna está dentro do intervalo válido
	        if (coluna >= 1 && coluna <= 8) {
	            System.out.println("Digite a coordenada da linha (1 a 8):");
	            linha = scanner.nextInt();

	            // Verificar se a linha está dentro do intervalo válido
	            if (linha >= 1 && linha <= 8) {
	                // Obter a casa do tabuleiro com base nas coordenadas
	                Casa casa = matriz[linha - 1][coluna - 1];
	                Pecas peca = casa.getPeca();
	                int bitOcupado = casa.getStatusoocupados();

	                // Verificar se há uma peça na casa
	                if (bitOcupado == 1) {
	                    // Se houver, imprimir a peça na casa
	                    System.out.println("A peça na casa selecionada é: " + peca);

	                    // Calcular e exibir as possibilidades de movimento da peça
	                    List<int[]> possibilidades = peca.calcularPossibilidades(coluna, linha);
	                    System.out.println("Possibilidades de movimento:");
	                    for (int i = 0; i < possibilidades.size(); i++) {
	                        int[] posicao = possibilidades.get(i);
	                        int colunaPossibilidade = posicao[1];
	                        // Verificar se a casa está vazia
	                        if (matriz[posicao[0]][posicao[1]].getStatusoocupados() == 0) {
	                            System.out.println((i + 1) + ". Linha: " + posicao[0] + ", Coluna: " + converterParaLetra(colunaPossibilidade));
	                        }
	                    }
	                    // Perguntar ao jogador qual item da lista ele quer selecionar
	                    System.out.println("Escolha uma das possibilidades de movimento (1 a " + possibilidades.size() + "):");
	                    int escolha = scanner.nextInt();

	                    // Verificar se a escolha está dentro dos limites da lista de possibilidades
	                    if (escolha >= 1 && escolha <= possibilidades.size()) {
	                    	
	                        // Armazenar a escolha do jogador nas variáveis linha e coluna
	                        linha = (possibilidades.get(escolha - 1)[0])-1;
	                        coluna = (possibilidades.get(escolha - 1)[1]-1);
	                        
	                        //movimentando a peça
	                	    mudarCasa(linha,coluna,casa);
	                        casaValida = true; // Gatilho para sair do loop
	                    } else {
	                        System.out.println("Escolha inválida. Por favor, escolha um número entre 1 e " + possibilidades.size() + ".");
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
	}
}

