package classes_pecas;
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

    //IMprimindo o tabuleiro
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
	
	
	public void setPeca(int linha, int coluna, Pecas peca) { // "Encaixar" uma peça no tabuleiro
        matriz[linha][coluna].setPeca(peca); // Adicionando a Peça na casa
        matriz[linha][coluna].setStatusoocupados(1);//Setando o espaça como "ocupado"
    }

	
    
 
}

